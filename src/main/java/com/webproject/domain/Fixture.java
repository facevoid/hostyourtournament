package com.webproject.domain;

import javax.persistence.*;

/**
 * Created by Shaurav on 5/2/2017.
 */
@Entity
@Table(name="fixture")
public class Fixture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "match_no")
    private int matchNo;
    private int tournamentID;
    private int userID;
    private String team1;
    private String team2;

    private Integer team1Score;

    private Integer team2Score;
    private String winner;

    public Fixture(int matchNo, int tournamentID, int userID, String team1, String team2) {
        this.matchNo = matchNo;
        this.tournamentID = tournamentID;
        this.userID = userID;
        this.team1 = team1;
        this.team2 = team2;
    }

    public Fixture() {
    }

    public Fixture(int matchNo, int tournamentID, int userID, String team1, String team2, int team1Score, int team2Score, String winner) {
        this.matchNo = matchNo;
        this.tournamentID = tournamentID;
        this.userID = userID;
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.winner = winner;
    }

    public int getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(int matchNo) {
        this.matchNo = matchNo;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "matchNo=" + matchNo +
                ", tournamentID=" + tournamentID +
                ", userID=" + userID +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", winner='" + winner + '\'' +
                '}';
    }
}
