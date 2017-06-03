package com.webproject.controller;

import com.webproject.domain.Fixture;
import com.webproject.domain.TempTeams;
import com.webproject.domain.Tournament;
import com.webproject.repository.FixtureRepo;
import com.webproject.repository.TempTeamsRepo;
import com.webproject.repository.TournamentRepo;
import com.webproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Shaurav on 5/2/2017.
 */
@Controller
public class TournamentController {

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



    @RequestMapping("/generateTournament")
    public String generateFixture(@RequestParam("id") int id, Model model){
        Tournament tournament = tournamentRepo.findById(id);
        System.out.println(id);
        List<TempTeams> tempTeamsList = tempTeamsRepo.findByTournamentID(id);
        if(!tournament.isOngoing()){
            Fixture fixture;
            fixture = new Fixture(1,id,tempTeamsList.get(1).getUserID(),tempTeamsList.get(1).getName(),tempTeamsList.get(2).getName());
            fixtureRepo.save(fixture);
            fixture = new Fixture(2,id,tempTeamsList.get(1).getUserID(),tempTeamsList.get(3).getName(),tempTeamsList.get(4).getName());
            fixtureRepo.save(fixture);
            fixture = new Fixture(3,id,tempTeamsList.get(1).getUserID(),tempTeamsList.get(5).getName(),tempTeamsList.get(6).getName());
            fixtureRepo.save(fixture);
            fixture = new Fixture(4,id,tempTeamsList.get(1).getUserID(),tempTeamsList.get(7).getName(),tempTeamsList.get(0).getName());
            fixtureRepo.save(fixture);
        }
        tournament.setOngoing(true);
        tournamentRepo.save(tournament);
        model.addAttribute("teams",tempTeamsList);
        model.addAttribute("name",tournament.getName());
        List<Fixture> fixtures = fixtureRepo.findByTournamentID(tournament.getId());
        model.addAttribute("fixtures",fixtures);
        model.addAttribute("fixture",new Fixture());



        return "fixture";

    }
    @RequestMapping("/updateResult")
    public String updateResult(@ModelAttribute Fixture fixture, RedirectAttributes redirectAttributes){
        System.out.println("this is from result update "+fixture.getId());
        System.out.println("this is from result update "+fixture.getMatchNo());
        Fixture fixture1 = fixtureRepo.findByMatchNo(fixture.getMatchNo());
        System.out.println(fixture1);
        fixture1.setTeam1Score(fixture.getTeam1Score());
        fixture1.setTeam2Score(fixture.getTeam2Score());

        if (fixture.getTeam1Score() > fixture.getTeam2Score()){
            fixture1.setWinner(fixture.getTeam1());
            fixtureRepo.save(fixture1);
        }
        else {
            fixture1.setWinner(fixture.getTeam2());

            fixtureRepo.save(fixture1);
        }
        System.out.println(fixture);
        redirectAttributes.addAttribute("id",fixture.getTournamentID());
        return "redirect:/generateTournament";
    }

}
