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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping(value = "allplayers", method = RequestMethod.GET)
    public String allPlayers(Model model) {

        // get all players
        Iterable<Player> allPlayers = playerRepository.findAll();


        // put them in a model
        model.addAttribute("all_players", allPlayers);

        // send them to the home page
        return "/home";
    }

    @RequestMapping(value = "allmatches", method = RequestMethod.GET)
    public String allMatches(Model model) {


        // get all matches
        Iterable<Match> allMatches = matchRepository.findAll();


        // put them in a model
        model.addAttribute("all_matches", allMatches);

        // send them to the home page
        return "/matches";
    }

    @RequestMapping(value = "match/delete", method = RequestMethod.GET)
    public String deleteMatch(@RequestParam("id") Long id) {

        // refetch match from db
        Match fetchmatch = matchRepository.findOne(id);


        if (fetchmatch != null) {
            matchRepository.delete(fetchmatch);
        }

        // send them back to the home match page
        return "redirect:/mvc/allmatches";
    }

    @RequestMapping(value = "player/delete", method = RequestMethod.GET)
    public String deletePlayer(@RequestParam("id") Long id) {

        // refetch match from db
        Player fetchplayer = playerRepository.findOne(id);


        if (fetchplayer != null) {
            playerRepository.delete(fetchplayer);
        }

        // send them back to the home player page
        return "redirect:/mvc/allplayers";
    }

    @RequestMapping(value = "player/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addPlayer(Player aPlayer) {
        playerRepository.save(aPlayer);

        // send them back to the home player page
        return "redirect:/mvc/allplayers";
    }

    @RequestMapping(value = "match/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addMatch(DtoMatch aMatch) {
        log.debug("Match Add called...");
        Match match = new Match();
        Player playerLoser = playerRepository.findByName(aMatch.getLoser());
        Player playerWinner = playerRepository.findByName(aMatch.getWinner());
        log.debug("loserName:"+aMatch.getLoser());
        log.debug("loser:"+playerLoser);
        log.debug("winnerName:"+aMatch.getWinner());
        log.debug("winner:"+playerWinner);

        match.setWinningScore(aMatch.getWinningScore());
        match.setLoosingScore(aMatch.getLoosingScore());
        match.setDates(aMatch.getDates());
        match.setLoser(playerLoser);
        match.setWinner(playerWinner);

        matchRepository.save(match);

        log.debug("Match Add complete.");
            // send them back to the home match page
        return "redirect:/mvc/allmatches";
    }

    @RequestMapping(value = "player/select", method = RequestMethod.GET)
    public String selectPlayer(@RequestParam("id") Long id, Model model) {
        String destination = "/edit_player";
        // re fetch player by id from db
        Player playerEdit = playerRepository.findOne(id);
        //playerEdit.setWins(matchRepository.countWinsForPlayer(playerEdit.getName()));

        // put them in a model
        model.addAttribute("myEdit", playerEdit);

        // send them back to the home player page
        return destination;
    }

    @RequestMapping(value = "match/select", method = RequestMethod.GET)
    public String selectMatch(@RequestParam("id") Long id, Model model) {
        String destination = "/edit_match";
        // re fetch player by id from db
        Match matchEdit = matchRepository.findOne(id);

        // put them in a model
        model.addAttribute("myEdit", matchEdit);

        // send them to the match edit page
        return destination;
    }


}
