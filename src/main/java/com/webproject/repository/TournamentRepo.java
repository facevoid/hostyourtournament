package com.webproject.repository;

import com.webproject.domain.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shaurav on 4/28/2017.
 */
@Repository
public interface TournamentRepo extends CrudRepository<Tournament,Integer> {
    Tournament findByName(String name);

    List<Tournament> findByUserId(int user_id);
    Tournament findById(int id);
}
