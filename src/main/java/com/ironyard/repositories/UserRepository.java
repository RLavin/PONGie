package com.ironyard.repositories;

import com.ironyard.data.PongUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Raul on 11/14/16.
 */
public interface UserRepository extends CrudRepository<PongUser, Long> {
    PongUser findByUsernameAndPassword(String username, String password);
}

