package com.codeup.weekndr.repositories;
import com.codeup.weekndr.models.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
    Trip findById(long id);
}

