package com.casestudy.jatin.chander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.jatin.chander.model.Authorities;
import com.casestudy.jatin.chander.model.Credential;
import com.casestudy.jatin.chander.model.UserProfile;
import com.casestudy.jatin.chander.repository.CredentialRepository;

@Controller
public class RegistrationController {

	// Needed to save user to database
	@Autowired
	CredentialRepository credentialRepo;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("userRegistrationObj", new Credential());
		return mav;
	}

	@RequestMapping(value = "processUserCredentials", method = RequestMethod.POST)
	public ModelAndView getRegistrationForm(@ModelAttribute("userRegistrationObj") Credential credential,
			BindingResult br, @RequestParam("confPassword") String confirmPassword, RedirectAttributes redirect) {
		ModelAndView mav = null;
		Credential registerCredential = credential;

		if (br.hasErrors() || credential == null) {
			mav = new ModelAndView("register");
			mav.addObject("message", "There was an error registering your account");
		} else {
			if (credential.getPassword().equals(confirmPassword)) {
				// Grab user from credential object
				UserProfile user = credential.getUserProfile();

				// Authority
				Authorities authority = new Authorities();
				// Everyone besides me will automatically be a user
				authority.setAuthority("ROLE_USER");

				String securePassword = new BCryptPasswordEncoder().encode(credential.getPassword());
				registerCredential.setUsername(credential.getUsername());
				registerCredential.setPassword(securePassword);
				registerCredential.setUserProfile(user);
				registerCredential.getAuthorities().add(authority);
				authority.setUser(registerCredential);

				credentialRepo.save(registerCredential);
				mav = new ModelAndView("redirect:/login");
				redirect.addFlashAttribute("message",
						"Successfully registered account.\nYou can login using the account.");

			} else {

				mav = new ModelAndView("redirect:/register");
			}
		}

		return mav;
	}
}
