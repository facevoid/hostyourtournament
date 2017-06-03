package com.webproject.controller;

import com.webproject.domain.Fixture;
import com.webproject.domain.TempTeams;
import com.webproject.domain.Tournament;
import com.webproject.domain.User;
import com.webproject.repository.FixtureRepo;
import com.webproject.repository.TempTeamsRepo;
import com.webproject.repository.TournamentRepo;
import com.webproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by void on 12/4/16.
 */
@Controller
public class HomeController {
//

    @Autowired
    private FixtureRepo fixtureRepo;
    private void setFixtureRepo(FixtureRepo fixtureRepo){
        this.fixtureRepo = fixtureRepo;
    }
    @Autowired
    private UserRepo userRepo;
    private void setUserRepo(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Autowired
    private TournamentRepo tournamentRepo;
    public void setTournamentRepo(TournamentRepo tournamentRepo){
        this.tournamentRepo = tournamentRepo;
    }

    @Autowired
    private TempTeamsRepo tempTeamsRepo;
    private void setTempTeams(TempTeamsRepo tempTeams){
        this.tempTeamsRepo = tempTeams;
    }

    @RequestMapping("/")
    public String showHome(){
        return "redirect:/dashboard";
    }
    private String username;

    @RequestMapping("/dashboard")
    public String showDashBoard(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        System.out.println(auth.toString());
        System.out.println(userRepo.findOne(1));
        System.out.println(userRepo.findByUsername(username));
        model.addAttribute("username",username);

//        System.out.println(userRepo.findUser(userName));
        System.out.println(username);
        return "dashboard";
    }
    @RequestMapping("/newtournament")
    public String showNewTournament(@ModelAttribute("tournament")Tournament tournament,Model model){
        User user = userRepo.findByUsername(username);
        tournament.setDept(username);
        tournament.setUserId(user.getUser_id());
        System.out.println(tournament);
        List<TempTeams> tempTeamsList = tempTeamsRepo.findById(tournament.getId());
        model.addAttribute("teamList",tempTeamsList);
        tournamentRepo.save(tournament);

        model.addAttribute("username",username);
        model.addAttribute("title",tournament.getName());
        return "redirect:/currenttournament";
    }


    @RequestMapping("/createtournament")
    public String showCreateNewTournament(Model model){
        Tournament tournament = new Tournament();
        model.addAttribute("tournament",tournament);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username",username);
        return "createtournament";
    }

    @RequestMapping("/currenttournament")
    public String showCurrentTournament(Model model){
        User user = userRepo.findByUsername(username);
        model.addAttribute("tournamentList",tournamentRepo.findByUserId(user.getUser_id()));
        System.out.println("this is from ongoing tournament");
        System.out.println(tournamentRepo.findByUserId(user.getUser_id()));
        return "ongoingTournament";
    }
    @RequestMapping("/previoustournament")
    public String showPreviousTournament(Model model){
        return "previoustournament";
    }

    @RequestMapping("/searchTournament")
    public String showSearch(@ModelAttribute("tournament")Tournament tournament, BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){
        Tournament tournament1 = tournamentRepo.findByName(tournament.getName());
        /*if (tournament1 == null)
        {
            bindingResult.rejectValue("name","duplicateuserkey.tournament.name","this tournament doesn't exists");
            return "login";
        }*/
        System.out.println(tournament1);
        if(tournament1 == null) return "login";
        TempTeams tempTeams = new TempTeams();

        System.out.println(tournament.getName());
        System.out.println(tournament1);
        model.addAttribute("name",tournament1.getName());
        model.addAttribute("dept",tournament1.getDept());
        model.addAttribute("tempTeams",tempTeams);
        redirectAttributes.addFlashAttribute("id",tournament1.getId());
        model.addAttribute("tournament",tournament1);
        System.out.println(redirectAttributes);
        if(tournament1.isOngoing())
        {
            List<Fixture> fixtures = fixtureRepo.findByTournamentID(tournament1.getId());
            System.out.println("this is from open "+fixtures);
            model.addAttribute("fixtures",fixtures);

            return "openFixture";
        }
        return "openTournament";
    }
    @RequestMapping("/addTempTeams")
    public String showAddTempTeams(@ModelAttribute TempTeams tempTeams,Model model){
        System.out.println(tempTeams);
        model.addAttribute("teamName",tempTeams.getName());
        Tournament tournament = tournamentRepo.findById(tempTeams.getTournamentID());
        model.addAttribute("name",tournament.getName());
        model.addAttribute("dept",tournament.getDept());
        tempTeamsRepo.save(tempTeams);
        return "registrationCompleted";


    }
    @RequestMapping("/detail")
    public String detail(@RequestParam int id,Model model,RedirectAttributes redirectAttributes){
        System.out.println(id);
        Tournament tournament = tournamentRepo.findById(id);
        if(tournament.isOngoing()){
            redirectAttributes.addAttribute("id",tournament.getId());
            return "redirect:/generateTournament";
        }
        System.out.println(id);
        List<TempTeams> tempTeamsList = tempTeamsRepo.findByTournamentID(tournament.getId());
        System.out.println(tempTeamsList);
        model.addAttribute("tournament",tournament);
        model.addAttribute("id",id);
        model.addAttribute("left",tournament.getTeams() - tournament.getRegisteredTeams());
        model.addAttribute("tempTeamsList",tempTeamsList);
        return "addTeams";
    }
    @RequestMapping("/approve")
    public String approve(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        System.out.println(id);
        TempTeams tempTeams = tempTeamsRepo.findOne(id);
        tempTeams.setRegistered(true);
        tempTeamsRepo.save(tempTeams);
        redirectAttributes.addAttribute("id",tempTeams.getTournamentID());
        Tournament tournament = tournamentRepo.findById(tempTeams.getTournamentID());
        tournament.setRegisteredTeams(tournament.getRegisteredTeams()+1);
        tournamentRepo.save(tournament);

        System.out.println(tempTeams);

        return "redirect:/detail";
    }


}
