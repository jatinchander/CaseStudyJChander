package com.casestudy.jatin.chander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.jatin.chander.model.Credential;
import com.casestudy.jatin.chander.repository.CredentialRepository;

@Service("userDetailsService")
public class CredentialService implements UserDetailsService {
	
	@Autowired
	CredentialRepository userRepository;
	
	public void saveUser(Credential user) {
		userRepository.save(user);
	//	return userRepository.findByUsername(user.getUsername());
	}

	//Spring Security Specific
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// From DB
		Credential user = userRepository.findByUsername(username);
		
		// To comply Spring Sec User (Built-in)
		UserBuilder builder = null;
		
		if(user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
//			builder.disabled(!user.isEnabled());
			String [] authorities = user.getAuthorities().stream().map(
							a -> a.getAuthority()).toArray(String[]::new);
							
							builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User Not Found!");
		}
		
		return builder.build();
	}
}

