package com.ironyard.data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Raul on 11/9/16.
 */
@Entity
public class Player {
    private String name;
    private String nickname;
    @OneToMany(mappedBy = "winner", fetch = FetchType.EAGER)
    private Set<Match> wins;
    @OneToMany(mappedBy = "loser", fetch = FetchType.EAGER)
    private Set<Match> losses;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    public Player(String raul, String s) {

    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Match> getWins() {
        return wins;
    }

    public void setWins(Set<Match> wins) {
        this.wins = wins;
    }

    public Set<Match> getLosses() {
        return losses;
    }

    public void setLosses(Set<Match> losses) {
        this.losses = losses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
