package com.codeup.weekndr.repositories;
import com.codeup.weekndr.models.Place;
import org.springframework.data.repository.CrudRepository;


public interface PlaceRepository extends CrudRepository<Place, Long>{
    Place findById(long id);
}


