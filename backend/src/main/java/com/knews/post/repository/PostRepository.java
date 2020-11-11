package com.knews.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.knews.post.modal.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
