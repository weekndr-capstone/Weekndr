package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Comment;
import com.codeup.weekndr.models.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(long place_id);

    Iterable<Comment> findByPlaceAndParentCommentIsNull(Place place);

    Iterable<Comment> findByParentComment(Comment comment);
}
