package com.webproject.repository;

import com.webproject.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shaurav on 4/27/2017.
 */

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
      User findByUsername (String username);
}
