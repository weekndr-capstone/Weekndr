package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findById(long id);
}
