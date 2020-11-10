package com.knews.post.modal;

import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "post_image")
    private String postImage;
    @Column(name = "post_content")
    private String content;
    @Column(name = "create_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public Post() {
    }

    public Post(String title, String author, String postImage, String content, Date createdAt, Date updatedAt) {
        this.title = title;
        this.author = author;
        this.postImage = postImage;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
