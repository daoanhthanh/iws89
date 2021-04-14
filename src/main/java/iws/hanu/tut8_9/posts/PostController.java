package iws.hanu.tut8_9.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iws.hanu.tut8_9.posts.entity.Post;


@RestController
@RequestMapping("/iws_tut89")
public class PostController {

    @Autowired
    private PostRepo repo;
    
    @GetMapping("/posts")
    List<Post> all(){
        return repo.findAll();
    }

    @PostMapping("/post")
    Post newPost(@RequestBody Post newPost ){
        return repo.save(newPost);
    }

    // @PutMapping("/post/{id}")
    // Post replacePost(@RequestBody Post newPost, @PathVariable Long id){
    //     return repo.findById(id).map(
    //         Post -> {
    //             Post.set
    //         }
    //     )
    // }
    
}
