package com.webproject.domain;

import javax.persistence.*;

/**
 * Created by Shaurav on 5/1/2017.
 */
@Entity
@Table(name = "tempteams")
public class TempTeams {
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private int userID;
    @Column(name = "tournamentID")
    private int tournamentID;


    private String managerName;
    private String email;

    private boolean registered = false;


    public TempTeams(int userID, int tournamentID, String name, String managerName, String email) {
        this.userID = userID;
        this.tournamentID = tournamentID;
        this.name = name;
        this.managerName = managerName;
        this.email = email;
    }

    public TempTeams() {
    }

    @Override
    public String toString() {
        return "TempTeams{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", userID=" + userID +
                ", tournamentID=" + tournamentID +
                ", managerName='" + managerName + '\'' +
                ", email='" + email + '\'' +
                ", registered=" + registered +
                '}';
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
