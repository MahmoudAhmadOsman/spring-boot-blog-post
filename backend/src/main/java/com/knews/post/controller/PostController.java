package com.knews.post.controller;

import com.knews.post.exception.ResourceNotFoundException;
import com.knews.post.model.Post;
import com.knews.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PostController {
    @Autowired
    private PostRepository postRepository;


    //@GET ALL POSTS METHOD
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }


    //@CREATE METHOD OR POST METHOD
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);

    }
    //@GET BY IF METHOD
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with this id does not exist: " + id));
        return  ResponseEntity.ok(post);
    }

    //@EDIT OR UPDATE METHOD
    @PutMapping("/books/{id}")
    public ResponseEntity<Post> updateBook(@PathVariable Long id, @RequestBody Post postDetails){

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with this id does not exist: " + id));

        post.setTitle(postDetails.getTitle());
        post.setAuthor(postDetails.getTitle());
        post.setPostImage(postDetails.getPostImage());
        post.setContent(postDetails.getContent());
        post.setCreatedAt(postDetails.getCreatedAt());
        post.setUpdatedAt(postDetails.getUpdatedAt());
        Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }


    //@DELETE METHOD
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePost(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Posts with this id does not exist: " + id));

        postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Post has been deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    

}

