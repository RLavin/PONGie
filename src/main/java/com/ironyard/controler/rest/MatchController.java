package com.ironyard.controler.rest;

import com.ironyard.data.Match;
import com.ironyard.data.Player;
import com.ironyard.dto.DtoMatch;
import com.ironyard.repositories.MatchRepository;
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
@RequestMapping(path = "/rest/match")
public class MatchController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MatchRepository matchRepository ;

    /** saves a new match to the database
     * and auto-generates an Id
     *
     * @param aMatch
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    public Match save(@RequestBody Match aMatch){
        matchRepository.save(aMatch);
        log.info(" Saved match: "+ aMatch);
        return matchRepository.findOne(aMatch.getId());
    }

    /**
     * Updates a match by Id
     * @param aMatch
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Match update(@RequestBody Match aMatch){
        matchRepository.save(aMatch);
        log.info("Updated Match:"+ aMatch);
        return matchRepository.findOne(aMatch.getId());
    }

    /**
     * Finds a match by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Match show(@PathVariable Long id){
        log.info("Match id:"+ id);
        return matchRepository.findOne(id);
    }


    /**
     * Delete match by id
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Match delete(@PathVariable Long id){
        Match deleted = matchRepository.findOne(id);
        matchRepository.delete(id);
        log.info("Deleted matched id:"+ id);

        return deleted;
    }

    /**
     * List all matches and filters by page,size, direction and sortby id.
     * @param page
     * @param size
     * @param sortby
     * @param direction
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Iterable<Match> list (@RequestParam(value ="page", required = false)Integer page,
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
            sortby = "id";
        }

        // DEFAULT Sort direction
        if (direction == null) {
            direction = Sort.Direction.DESC;
        }
        Sort s = new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        Iterable<Match> found =  matchRepository.findAll(pr);
        log.debug(String.format("End listAll: %s", found));

        return found;

    }


    /**
     * Handles exceptions
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable e){
        e.printStackTrace();
        return "Something Went Wrong!!!";
    }
}
