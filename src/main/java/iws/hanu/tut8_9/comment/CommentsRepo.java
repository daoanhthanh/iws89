package iws.hanu.tut8_9.comment;


import org.springframework.data.jpa.repository.JpaRepository;

import iws.hanu.tut8_9.comment.entity.Comments;

public interface CommentsRepo extends JpaRepository<Comments, Long> {
    
}
