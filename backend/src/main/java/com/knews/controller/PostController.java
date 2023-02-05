package com.knews.controller;
import com.knews.beans.Post;
import com.knews.exception.BusinessException;
import com.knews.exception.ControllerException;
import com.knews.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class PostController {
    @Autowired
    private PostService postService;


    //@ get list of posts
    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> coursesList(){
        try{
            List<Post> posts = postService.getPostList();
            return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    //@ add new post
    @PostMapping(value = "/posts/add")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            Post savePost = postService.addPost(post);
            return  new ResponseEntity<Post>(savePost, HttpStatus.CREATED);
            //return new ResponseEntity<>("Post has been deleted!", HttpStatus.ACCEPTED);
        }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException ce = new ControllerException("611", "Something went wrong in the controller !");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }


    }


    //@get Post by id
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id){
        try{
            Post post = postService.getPostById(id);
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("612", "Something went wrong in the controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }



    //@ update post
    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post post) {
        try {
//            Post updatedPost = postService.updatePost(id);
            Post updatedPost = postService.updatePost(id);
            return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
        }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("613", "Something went wrong in the controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

    }



    //@ delete post
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        try{
            postService.deletePost(id);
            return new ResponseEntity<>("Post has been deleted!", HttpStatus.ACCEPTED);
        }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("614", "Something went wrong in the controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

    }


    

}

