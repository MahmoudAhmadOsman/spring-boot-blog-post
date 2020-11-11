package com.knews.post.controller;

import com.knews.post.exception.ResourceNotFoundException;
import com.knews.post.modal.Post;
import com.knews.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){

        return postRepository.findAll();
    }



    //@CREATE METHOD OR POST METHOD
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);

    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A post with this id does not exist:" + id));
        return  ResponseEntity.ok(post);
    }














}
