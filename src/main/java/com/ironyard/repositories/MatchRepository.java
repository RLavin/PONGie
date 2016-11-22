package com.ironyard.repositories;

import com.ironyard.data.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Raul on 11/10/16.
 */
public interface MatchRepository extends PagingAndSortingRepository<Match, Long> {


/*    @Query("SELECT COUNT (*) FROM DtoMatch m WHERE (m.playerOne= ?1 and m.playerOneScore > m.playerTwoScore) OR (m.playerTwo =?1 and m.playerTwoScore>m.playerOneScore)")
    int countWinsForPlayer(String playername);
*/
}
