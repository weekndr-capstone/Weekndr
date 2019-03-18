package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Comment;
import org.springframework.data.repository.CrudRepository;
import java.sql.PreparedStatement;



public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(long id);
    Iterable<Comment> findByPlaceId(long place_id);
}
