package com.casestudy.jatin.chander.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.casestudy.jatin.chander.model.Post;
import com.casestudy.jatin.chander.repository.PostRepository;

@Transactional
@Service
public class PostService {

	@Autowired
	PostRepository postRepo;
	
	public Optional<Post> getPostById(long id) {
		return postRepo.findById(id);
	}
	
	public void savePost(Post post) {
		postRepo.save(post);
	}
	
	public List<Post> getAllPosts() {
		List<Post> postList = new ArrayList<Post>();
		  postRepo.findAll().forEach(
				  (e) -> {postList.add(e);
				  });
		  return postList;
	}	
}
