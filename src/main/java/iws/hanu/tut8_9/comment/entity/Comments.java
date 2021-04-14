package iws.hanu.tut8_9.comment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import iws.hanu.tut8_9.posts.entity.Post;



@Entity
public class Comments {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;
    private String content;

    // Many to One Có nhiều comments ở 1 post.
    @ManyToOne 
    @JoinColumn(name = "post_id", nullable = false) // thông qua khóa ngoại post_id
    @JsonIgnore
    private Post post;

    public Comments(Long id, String displayName, String content, Post post) {
        this.id = id;
        this.displayName = displayName;
        this.content = content;
        this.post = post;
    }

    public Comments(String displayName, String content, Post post) {
        this.displayName = displayName;
        this.content = content;
        this.post = post;
    }

    public Comments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    

}
