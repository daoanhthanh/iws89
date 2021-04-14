package iws.hanu.tut8_9.posts;


import org.springframework.data.jpa.repository.JpaRepository;

import iws.hanu.tut8_9.posts.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
    
}
