package com.casestudy.jatin.chander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.jatin.chander.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

