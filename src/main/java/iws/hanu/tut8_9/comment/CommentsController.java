package iws.hanu.tut8_9.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iws.hanu.tut8_9.comment.entity.Comments;
import iws.hanu.tut8_9.posts.PostRepo;
import iws.hanu.tut8_9.posts.entity.Post;


@RestController
@RequestMapping("/iws_tut89")
public class CommentsController {

    @Autowired
    private CommentsRepo repo;
    @Autowired
    private PostRepo postRepo;
    
    @GetMapping("/comments")
    List<Comments> all(){
        return repo.findAll();
    }

    @PostMapping("/comments")
    Comments newComments(@RequestBody CommentPost newCommentsPost ){
        Comments com = new Comments();
        Optional<Post> post = postRepo.findById(newCommentsPost.getPost_id());
        if(!post.isPresent()){
            return null;
        }

        com.setContent(newCommentsPost.getContent());
        com.setDisplayName(newCommentsPost.getDisplayName());
        com.setPost(post.get());
        
        return repo.save(com);
    }

    @PutMapping("/comments/{id}")
    Comments replaceComments(@RequestBody Comments newComments, @PathVariable Long id){
        return repo.findById(id)
        .map(
            Comments -> {
                Comments.setContent(newComments.getContent());
                Comments.setDisplayName(newComments.getContent());
                return repo.save(Comments);
            }
        ).orElseGet(() ->{
            newComments.setId(id);
            return repo.save(newComments);
        });
    }

    @DeleteMapping("/comments/{id}")
    void deleteComments(@PathVariable Long id){
        repo.deleteById(id);
    }
    
}
