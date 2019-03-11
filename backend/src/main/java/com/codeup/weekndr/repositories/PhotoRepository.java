package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, String> {
}