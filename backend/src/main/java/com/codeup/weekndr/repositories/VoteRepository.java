package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Place;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.models.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findById(long id);

    @Query(value="SELECT * FROM votes WHERE place_id = :placeId", nativeQuery=true)
    List<Vote> findVotesByPlaceId(@Param("placeId")Place placeId);

    @Query(value = "SELECT * FROM votes WHERE user_id = :userId AND place_id = :placeId", nativeQuery = true)
    Vote findByUserAndPlace(@Param("userId") User userId, @Param("placeId") Place placeId);

}
