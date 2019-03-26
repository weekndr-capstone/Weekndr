package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Photo;
import com.codeup.weekndr.models.Place;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    Photo findById(long id);
    Iterable <Photo> findAllByPlaceId(long id);
}
