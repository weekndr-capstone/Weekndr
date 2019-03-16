package com.codeup.weekndr.repositories;
import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> {
    Trip findById(long id);
}

