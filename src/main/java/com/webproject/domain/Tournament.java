package com.webproject.domain;


import javax.persistence.*;

/**
 * Created by Shaurav on 4/26/2017.
 */

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @Column(name = "tournament_id")
    private int id;
    @Column(name = "tournament_name")
    private String name;
    @Column
    private String tournament_type;
    @Column
    private String dept;
    @Column
    private int year;
    private String game_type;
    private int registeredTeams;
//    @ManyToOne
//    @JoinTable(name = "users", joinColumns = @JoinColumn(name = "users_user_id", referencedColumnName = "user_id"))
    @Column(name = "user_id")
    private int userId;

    private int teams;
    private boolean ongoing = false;


    public Tournament(int id, String name, String tournament_type, String dept, int year, String game_type, int registeredTeams, int userId, int teams, boolean ongoing) {
        this.id = id;
        this.name = name;
        this.tournament_type = tournament_type;
        this.dept = dept;
        this.year = year;
        this.game_type = game_type;
        this.registeredTeams = registeredTeams;
        this.userId = userId;
        this.teams = teams;
        this.ongoing = ongoing;
    }

    public int getRegisteredTeams() {
        return registeredTeams;
    }

    public void setRegisteredTeams(int registeredTeams) {
        this.registeredTeams = registeredTeams;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTournament_type() {
        return tournament_type;
    }

    public void setTournament_type(String tournament_type) {
        this.tournament_type = tournament_type;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }


    public int getTeams() {
        return teams;
    }

    public void setTeams(int teams) {
        this.teams = teams;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public Tournament() {

    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tournament_type='" + tournament_type + '\'' +
                ", dept='" + dept + '\'' +
                ", year=" + year +
                ", game_type='" + game_type + '\'' +
                ", registeredTeams=" + registeredTeams +
                ", userId=" + userId +
                ", teams=" + teams +
                ", ongoing=" + ongoing +
                '}';
    }
}
