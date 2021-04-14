package iws.hanu.tut8_9.posts.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iws.hanu.tut8_9.comment.entity.Comments;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (post) (1 post có nhiều comments)
    // MapopedBy trỏ tới tên biến Post ở trong comments.
    private Collection<Comments> comments;

    public Post(Long id, String title, String content, Collection<Comments> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public Post(String title, String content, Collection<Comments> comments) {
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public Post(String title, String content ) {
        this.title = title;
        this.content = content;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection<Comments> getComments() {
        return comments;
    }

    public void setComments(Collection<Comments> comments) {
        this.comments = comments;
    }

    

}
