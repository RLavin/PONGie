package com.ironyard.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * Created by Raul on 11/9/16.
 */
@Entity
public class Match {
    @JsonIgnoreProperties({"wins", "losses"})
    @ManyToOne
    @JoinColumn(name = "winning_player_id_fk")
    private Player winner;

    @JsonIgnoreProperties({"wins", "losses"})
    @ManyToOne
    @JoinColumn(name = "losing_player_id_fk")
    private Player loser;
    private int winningScore;
    private int losingScore;
    private String dates;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Match() {
    }

    public Match(Player winner, Player loser, int winningScore, int losingScore, String dates) {
        this.winner = winner;
        this.loser = loser;
        this.winningScore = winningScore;
        this.losingScore = losingScore;
        this.dates = dates;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public int getLosingScore() {
        return losingScore;
    }

    public void setLosingScore(int losingScore) {
        this.losingScore = losingScore;
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
