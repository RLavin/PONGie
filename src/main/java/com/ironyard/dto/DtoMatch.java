package com.ironyard.dto;

/**
 * Created by Raul on 11/22/16.
 */
public class DtoMatch {
    private String winner;
    private String loser;
    private int winningScore;
    private int loosingScore;
    private String dates;
    private long id;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public int getLoosingScore() {
        return loosingScore;
    }

    public void setLoosingScore(int loosingScore) {
        this.loosingScore = loosingScore;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
