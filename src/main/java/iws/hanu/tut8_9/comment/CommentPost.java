package iws.hanu.tut8_9.comment;

public class CommentPost {
    private Long id;

    private String displayName;
    private String content;

    private long post_id;

    public CommentPost(Long id, String displayName, String content, long post_id) {
        this.id = id;
        this.displayName = displayName;
        this.content = content;
        this.post_id = post_id;
    }

    public CommentPost(String displayName, String content, long post_id) {
        this.displayName = displayName;
        this.content = content;
        this.post_id = post_id;
    }

    public CommentPost() {
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

    public long getPost_id() {
        return post_id;
    }

    public void setPost(long post_id) {
        this.post_id = post_id;
    }
    

}


/**
 * This part is for testing the pushing on git branch
 */
