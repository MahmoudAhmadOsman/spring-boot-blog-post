package com.knews.service;

import com.knews.beans.Post;
import com.knews.exception.BusinessException;
import com.knews.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {
    @Autowired
    public PostRepository postRepository;


    //Get all post
    public List<Post> getPostList(){
        try{
            return postRepository.findAll();
        }catch (IllegalArgumentException e) {
            throw new BusinessException("601", "No posts found!" + e.getMessage());
        }
        catch (Exception e){
            throw  new BusinessException("602", "Something went wrong in service layer" + e.getMessage());
        }
    }


//Add new post
    public Post addPost(Post post){
        try{
            return postRepository.save(post);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("603", "Unable to save post!" + e.getMessage());
        }
        catch (Exception e){
            throw  new BusinessException("604", "Something went wrong in service layer" + e.getMessage());
        }
    }


    //Get post by id
    public Post findPostById(Long id){
        try{
            return postRepository.findById(id).get();
        }catch (IllegalArgumentException e) {
            throw new BusinessException("603", "Can't find post with this id!" + e.getMessage());
        }
        catch (Exception e){
            throw  new BusinessException("604", "Something went wrong in service layer" + e.getMessage());
        }
    }


    //Update post
    public Post updatePost(Long id){
        try {
            //if (postRepository.findById(id).isPresent()){
                return postRepository.findById(id).get();
           // }
        }catch (IllegalArgumentException e){
            throw new BusinessException("605", "Can't update this post!" + e.getMessage());
        }catch (Exception e){
            throw  new BusinessException("606", "Something went wrong in service layer" + e.getMessage());
        }
    }



    //Delete post
    public void deletePost(Long id){
        try{
             postRepository.deleteById(id);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("607", "Can't delete this post!" + e.getMessage());
        }catch (Exception e){
            throw  new BusinessException("608", "Something went wrong in service layer" + e.getMessage());
        }

    }




}
