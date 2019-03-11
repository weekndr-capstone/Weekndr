package com.codeup.weekndr.repositories;

import com.codeup.weekndr.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {
}
