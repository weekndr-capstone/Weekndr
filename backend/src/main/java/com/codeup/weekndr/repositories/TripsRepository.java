package com.codeup.weekndr.repositories;
import com.codeup.weekndr.models.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripsRepository extends CrudRepository<Trip, Long> {
}

