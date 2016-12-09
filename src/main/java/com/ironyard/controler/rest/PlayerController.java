package com.ironyard.controler.rest;

import com.ironyard.data.Player;
import com.ironyard.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by Raul on 11/9/16.
 */
@RestController
@RequestMapping(path = "/rest/player")
public class PlayerController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Save a player to the datebase
     * And auto-generates an Id
     * @param aPlayer
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    public Player save(@RequestBody Player aPlayer){
        playerRepository.save(aPlayer);
        log.info(" Saved player: "+ aPlayer);

        return playerRepository.findOne(aPlayer.getId());
    }

    /**
     * Updates player by Id
     * @param aPlayer
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Player update(@RequestBody Player aPlayer){
        playerRepository.save(aPlayer);
        log.info("Updated player:"+ aPlayer);

        return playerRepository.findOne(aPlayer.getId());
    }

    /**
     * Finds player by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Player show(@PathVariable Long id){
        log.info("Player id:"+ id);
        return playerRepository.findOne(id);
    }


    /**
     * Delete player by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Player delete(@PathVariable Long id){
        Player deleted = playerRepository.findOne(id);
        playerRepository.delete(id);
        log.info("Deleted player id:"+ id);

        return deleted;
    }

    /**
     * Finds and list all players and filters them by page, size, direction and sortby name.
     * @param page
     * @param size
     * @param sortby
     * @param direction
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Iterable<Player> list (@RequestParam(value ="page", required = false)Integer page,
                                  @RequestParam(value = "size", required = false)Integer size,
                                  @RequestParam(value = "sortby", required = false) String sortby,
                                  @RequestParam(value = "dir", required = false) Sort.Direction direction){

        log.debug(String.format("Begin listAll (page:%s, size:%s, sortby:%s, dir:%s):",page,size,sortby,direction));
        if (page == null){
            page = 0;
        }
        if (size == null){
            size = 100;
        }
        // DEFAULT Sort property
        if (sortby == null) {
            sortby = "name";
        }

        // DEFAULT Sort direction
        if (direction == null) {
            direction = Sort.Direction.DESC;
        }
        Sort s = new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        Iterable<Player> found =  playerRepository.findAll(pr);
        log.debug(String.format("End listAll: %s", found));

        return found;

    }


    /**
     * Handles Exceptions
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable e){
        e.printStackTrace();
        return "Something Bad Went Wrong!!!";
    }

}
