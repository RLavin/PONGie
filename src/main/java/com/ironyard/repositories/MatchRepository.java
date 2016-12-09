package com.ironyard.repositories;

import com.ironyard.data.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Raul on 11/10/16.
 */
public interface MatchRepository extends PagingAndSortingRepository<Match, Long> {


}
