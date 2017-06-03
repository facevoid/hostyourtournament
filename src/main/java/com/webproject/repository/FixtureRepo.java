package com.webproject.repository;

import com.webproject.domain.Fixture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shaurav on 5/2/2017.
 */
@Repository
public interface FixtureRepo extends CrudRepository<Fixture,Integer> {
    List<Fixture> findByTournamentID(int id);
    Fixture findByMatchNo(int id);
}
