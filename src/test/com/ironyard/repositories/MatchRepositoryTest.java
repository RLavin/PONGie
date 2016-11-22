package com.ironyard.repositories;

import com.ironyard.data.Match;
import com.ironyard.data.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Raul on 11/21/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MatchRepositoryTest {

    @Autowired
    PlayerRepository pRep;
    @Autowired
    MatchRepository mRep;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPlayerMatchWins() throws  Exception {
        Iterable<Player> players = pRep.findAll();
        Assert.assertNotNull(players);

        for(Player p: players){
            System.out.println("Player " + p.getName()+ " loses:"+p.getLosses().size());
            System.out.println("Player " + p.getName()+ " wins:"+p.getWins().size());
        }


    }

    @Test
    public void testCreatePlayer() throws Exception{

        Player player =  pRep.save(new Player("Matthew","The destroyer"));
        Player player2 =  pRep.save(new Player("Sam","The destroyer"));

        // player should there
        Assert.assertNotNull(pRep.findAll());


    }
    @Test
    public void testCreateMatch() throws Exception{
        //

        Player winner =  pRep.save(new Player("Matthew","The destroyer"));
        Player looser =  pRep.save(new Player("Sam","The Machine"));

        Match match = mRep.save(new Match(winner,looser,23,21,"10-23-16"));

        Assert.assertNotNull(mRep.findAll());

        pRep.findOne(looser.getId());
    }
}