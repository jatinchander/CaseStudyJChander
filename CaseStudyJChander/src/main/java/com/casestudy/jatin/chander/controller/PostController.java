package com.casestudy.jatin.chander.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.jatin.chander.model.Categories;
import com.casestudy.jatin.chander.model.Credential;
import com.casestudy.jatin.chander.model.Post;
import com.casestudy.jatin.chander.model.UserProfile;
import com.casestudy.jatin.chander.repository.CategoriesRepository;
import com.casestudy.jatin.chander.repository.CredentialRepository;
import com.casestudy.jatin.chander.repository.PostRepository;
import com.casestudy.jatin.chander.service.CategoriesService;
import com.casestudy.jatin.chander.service.CredentialService;
import com.casestudy.jatin.chander.service.PostService;
import com.sun.xml.bind.v2.TODO;

@Controller
public class PostController {

	@Autowired
	PostRepository postRepo;

	@Autowired
	PostService postService;

	@Autowired
	CategoriesRepository categoriesRepo;

	@Autowired
	CategoriesService categoriesService;

	@Autowired
	CredentialRepository credentialRepo;

	@Autowired
	CredentialService credentialService;

	@RequestMapping(value = "/postForm", method = RequestMethod.GET)
	public ModelAndView getPostForm() {
		ModelAndView mav = new ModelAndView("postForm");
		mav.addObject("postFormObj", new Post());
//		mav.addObject("action", "add");
		return mav;
	}

	@RequestMapping(value = "/savePostForm", method = RequestMethod.POST)
	public ModelAndView savePostForm(Principal principal, @ModelAttribute("postFormObj") Post post, BindingResult br,
			@RequestParam("postTitle") String postTitle, @RequestParam("postDescription") String postDescription,
			@RequestParam(value = "happy", required = false) String happy,
			@RequestParam(value = "motivational", required = false) String motivational,
			@RequestParam(value = "inspirational", required = false) String inspirational,
			@RequestParam(value = "feel-good", required = false) String feelGood,
			@RequestParam(value = "positive", required = false) String positive, RedirectAttributes redirect) {

		// TODO
		// Add user to post
		
		ModelAndView mav = null;
		Post newPost = post;
		Set<Categories> categories = new HashSet<>();
		Credential currentUser = credentialRepo.findByUsername(principal.getName());
		UserProfile user = currentUser.getUserProfile();

		// Returns username
		System.out.println("----------------------------------------------");
		System.out.println("Name: " + principal.getName());
		System.out.println("----------------------------------------------");
		System.out.println("Current user: " + currentUser.toString());
		System.out.println("----------------------------------------------");
		System.out.println("Current userProfile: " + currentUser.getUserProfile().toString());
		
		if (br.hasErrors() || post == null) {
			mav = new ModelAndView("postForm");
		} else {
			newPost.setPostTitle(postTitle);
			newPost.setPostDescription(postDescription);
	//		newPost.setUser(currentUser.getUserProfile());
			if (happy != null) {
				Categories cat1 = new Categories();
				cat1.setCategory("happy");
				categories.add(cat1);
			}
			if (motivational != null) {
				Categories cat2 = new Categories();
				cat2.setCategory("motivational");
				categories.add(cat2);
			}
			if (inspirational != null) {
				Categories cat3 = new Categories();
				cat3.setCategory("inspirational");
				categories.add(cat3);
			}
			if (feelGood != null) {
				Categories cat4 = new Categories();
				cat4.setCategory("feel-good");
				categories.add(cat4);
			}
			if (positive != null) {
				Categories cat5 = new Categories();
				cat5.setCategory("positive");
				categories.add(cat5);
			}
			
//			newPost.setUser(currentUser.getUserProfile());
			newPost.setCategories(categories);
			user.getPosts().add(newPost);
// Null pointer
//			categories.forEach(c ->{
//				c.getPost().setUser(currentUser.getUserProfile());;
//			});
			
			newPost.setUser(user);
			
			categories.forEach(c ->{
				c.setPost(newPost);
			});
	
//			categories.forEach(c ->{
//				c.getPost().setUser(currentUser.getUserProfile());;
//			});
			
			categories.forEach(c ->{
		//		c.getPost().setUser(currentUser.getUserProfile());
				categoriesService.saveCategory(c);
			});
			
			mav = new ModelAndView("redirect:/posts");
		}

		return mav;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getAllPosts() {
		ModelAndView mav = new ModelAndView("postFile");
		mav.addObject("allPosts", postService.getAllPosts());
		return mav;
	}
}
