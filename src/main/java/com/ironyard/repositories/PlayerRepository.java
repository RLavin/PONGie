package com.ironyard.repositories;

import com.ironyard.data.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Raul on 11/10/16.
 */
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
    Player findByName(String name);
    Player findById(Long id);


}
