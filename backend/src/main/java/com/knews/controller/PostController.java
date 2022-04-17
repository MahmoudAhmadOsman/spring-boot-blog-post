package com.knews.controller;
import com.knews.beans.Post;
import com.knews.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class PostController {
    @Autowired
    private PostService postService;


    //@GET ALL POSTS METHOD
    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> coursesList(){
        try{
            List<Post> courses = postService.getPostList();
            return new ResponseEntity<List<Post>>(courses, HttpStatus.OK);
        }catch (Exception e){
            throw  new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }

    }





    //@CREATE METHOD OR POST METHOD
//    @PostMapping("/posts/add")
//    public Post createPost(@RequestBody Post post) {
//        return postRepository.save(post);
//
//    }
    //@GET BY IF METHOD
//    @GetMapping("/posts/{id}")
//    public ResponseEntity<Post> getPostById(@PathVariable Long id){
//        Post post = postRepository.findById(id);
//
//        return  ResponseEntity.ok(post);
//    }


    //@DELETE METHOD
//    @DeleteMapping("/posts/{id}")
//    public ResponseEntity<Map<String, Boolean>> deletePost(@PathVariable Long id){
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new BusinessException("Posts with this id does not exist: " + id));
//
//        postRepository.delete(post);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Post has been deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }


    

}

