package com.casestudy.jatin.chander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.jatin.chander.model.UserProfile;
import com.casestudy.jatin.chander.model.Authorities;
import com.casestudy.jatin.chander.model.Credential;
import com.casestudy.jatin.chander.repository.CredentialRepository;
import com.casestudy.jatin.chander.service.CredentialService;

//import com.sec.model.Authorities;
//import com.sec.model.User;
//import com.sec.repository.UserRepository;
//import com.sec.service.UserService;

@Controller
@Transactional
public class InitAdminIfNotExist {

	@Autowired
	CredentialService userService;

	@Autowired
	CredentialRepository userRepository;

//	public InitUser(UserRepository userRepository) {
//		// TODO Auto-generated constructor stub
//		this.userRepository = userRepository;
//	}

	@RequestMapping("/login")
	public void initAdmin() {

		Credential user = userRepository.findByUsername("jc08");

		if (user == null) {
			System.out.println("Creating admin...");
			Credential adminUser = new Credential();
//			adminUser.setName("Jatin");
			adminUser.setUsername("jc08");
			String encoded = new BCryptPasswordEncoder().encode("123456");
			adminUser.setPassword(encoded);
//			adminUser.setEnabled(true);
			
			UserProfile userProfile = new UserProfile();
			userProfile.setFirstName("Jatin");
			userProfile.setLastName("Chander");
			userProfile.setEmail("jc@qc.cuny.edu");
			
			adminUser.setUserProfile(userProfile);

			Authorities role = new Authorities();
			role.setUser(adminUser);
			role.setAuthority("ROLE_ADMIN");

			adminUser.getAuthorities().add(role);

			userService.saveUser(adminUser);
		}
	}
}
