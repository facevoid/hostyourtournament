package com.webproject.repository;

import com.webproject.domain.TempTeams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shaurav on 5/1/2017.
 */
@Repository
public interface TempTeamsRepo extends CrudRepository<TempTeams,Integer> {



    List<TempTeams> findById(int id);

    List<TempTeams> findByTournamentID(int id);
}
