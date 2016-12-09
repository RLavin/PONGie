package com.ironyard.controler.mvc;

import com.ironyard.data.Match;
import com.ironyard.data.Player;
import com.ironyard.dto.DtoMatch;
import com.ironyard.repositories.MatchRepository;
import com.ironyard.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Raul on 11/14/16.
 */
@RequestMapping(path = "/mvc")
@Controller
public class PongController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository playerRepository = null;
    @Autowired
    MatchRepository matchRepository = null;

    /**
     * Gets all players from the database
     *
     * @param model saves all players to allplayers attribute
     * @return homepage of players
     */
    @RequestMapping(value = "allplayers", method = RequestMethod.GET)
    public String allPlayers(Model model) {

        // get all players
        Iterable<Player> allPlayers = playerRepository.findAll();

        log.info("Display all players: "+ allPlayers);


        // put them in a model
        model.addAttribute("all_players", allPlayers);

        // send them to the home page
        return "/home";
    }

    /**
     * Gets all matches from the database
     * @param model saves all matches to a model attribute
     * @return homepage of matches
     */
    @RequestMapping(value = "allmatches", method = RequestMethod.GET)
    public String allMatches(Model model) {


        // get all matches
        Iterable<Match> allMatches = matchRepository.findAll();

        log.info("Display all matches: "+ allMatches);

        // put them in a model
        model.addAttribute("all_matches", allMatches);

        // send them to the home page
        return "/matches";
    }

    /**
     * Deletes match by id
     * @param id
     * @return homepage of matches
     */
    @RequestMapping(value = "match/delete", method = RequestMethod.GET)
    public String deleteMatch(@RequestParam("id") Long id) {

        // re fetch match from db
        Match fetchmatch = matchRepository.findOne(id);


        if (fetchmatch != null) {
            matchRepository.delete(fetchmatch);
        }
        log.info("Match that has been deletec: "+ fetchmatch);

        // send them back to the home match page
        return "redirect:/mvc/allmatches";
    }

    /**
     * Deletes player by id if player doesn't have matches,
     * Must delete player's matches to delete player
     *
     * @param id
     * @param model
     * @return homepage of players
     */
    @RequestMapping(value = "player/delete", method = RequestMethod.GET)
    public String deletePlayer(@RequestParam("id") Long id, Model model) {

        // re fetch player from db
        Player fetchedplayer = playerRepository.findOne(id);



        if ((fetchedplayer.getWins() != null && fetchedplayer.getWins().size()>0 )
                ||(fetchedplayer.getLosses() != null && fetchedplayer.getLosses().size()>0)) {

            // handle error?
            model.addAttribute("delete_error_message", "Must delete player's matches before deleting player!");
        }
        else if(fetchedplayer != null){

            playerRepository.delete(fetchedplayer);
        } else {

            model.addAttribute("delete_error_message", "Player not found!");

        }
          log.debug("Player that is being deleted: "+ fetchedplayer);
        // send them back to the home player page
        return "forward:/mvc/allplayers";
    }

    /**
     * Saves a player to the database
     * @param aPlayer
     * @return homepage of players
     */

    @RequestMapping(value = "player/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addPlayer(Player aPlayer) {

        playerRepository.save(aPlayer);
        log.debug("Added player: "+ aPlayer);

        // send them back to the home player page
        return "redirect:/mvc/allplayers";
    }

    /**
     * Saves a match to the database
     * Also checks if the match already has and Id, if so update match
     * @param aMatch
     * @return homepage of matches
     */
    @RequestMapping(value = "match/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addMatch(DtoMatch aMatch) {
        Match match = null;
       if(aMatch.getId()!=0){
           //edit
           match = matchRepository.findOne(aMatch.getId());
        }else {
           //new
            match = new Match();
           Player playerLoser = playerRepository.findById(aMatch.getLoserId());
           Player playerWinner = playerRepository.findById(aMatch.getWinnerId());
           log.debug("winner:" + playerWinner);
           log.debug("loser:" + playerLoser);
           match.setLoser(playerLoser);
           match.setWinner(playerWinner);
       }
           log.debug("Match Add called...");


           log.debug("loserName:" + aMatch.getLoserId());
           log.debug("winnerName:" + aMatch.getWinnerId());


           match.setWinningScore(aMatch.getWinningScore());
           match.setLosingScore(aMatch.getLosingScore());
           match.setDates(aMatch.getDates());



        matchRepository.save(match);

        log.debug("Match Add complete.");
            // send them back to the home match page
        return "redirect:/mvc/allmatches";
    }

    /**
     * Selects player by id and saves it to an attribute
     * @param id
     * @param model myEdit
     * @return edit_player.jsp
     */
    @RequestMapping(value = "player/select", method = RequestMethod.GET)
    public String selectPlayer(@RequestParam("id") Long id, Model model) {
        String destination = "/edit_player";
        // re fetch player by id from db
        Player playerEdit = playerRepository.findOne(id);
        log.info("Display player edit: "+ playerEdit);
        // put them in a model
        model.addAttribute("myEdit", playerEdit);

        // send them back to the home player page
        return destination;
    }

    /**
     * Selects a match by id and saves it to an attribute
     * @param id
     * @param model myEdit
     * @return edit_match.jsp
     */
    @RequestMapping(value = "match/select", method = RequestMethod.GET)
    public String selectMatch(@RequestParam("id") Long id, Model model) {
        String destination = "/edit_match";
        // re fetch player by id from db
        Match matchEdit = matchRepository.findOne(id);

        log.info("Display match edit: "+ matchEdit);

        // put them in a model
        model.addAttribute("myEdit", matchEdit);

        // send them to the match edit page
        return destination;
    }

    /**
     * Gets all players from the database
     * @param model saves all players to allPlayersId attribute
     * @return to Log a match page
     */
    @RequestMapping(value = "player/selectId", method = RequestMethod.GET)
    public String selectPlayerId( Model model) {
        String destination = "/add_match";
        // re fetch player by id from db
        Iterable<Player> playersbyId = playerRepository.findAll();

        log.info("Display all players: "+ playersbyId);

        // put them in a model
        model.addAttribute("allPlayersId", playersbyId);

        // send them to the Log a match page
        return destination;

    }

}
