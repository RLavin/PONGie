package com.ironyard;

import com.ironyard.data.Match;
import com.ironyard.data.Player;
import com.ironyard.repositories.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Raul on 11/11/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testSavePlayer() throws Exception{

        // create new player
        Player player =  playerRepository.save(new Player("Raul","The destroyer"));

        // player should there
        Assert.assertNotNull(playerRepository.findOne(player.getId()));

    }
}
