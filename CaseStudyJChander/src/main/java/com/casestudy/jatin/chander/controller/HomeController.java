package com.casestudy.jatin.chander.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.jatin.chander.model.Credential;
import com.casestudy.jatin.chander.repository.CredentialRepository;

//import com.sec.model.User;
//import com.sec.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	CredentialRepository uRep;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getLanding() {
		ModelAndView mav = new ModelAndView("landing");
		return mav;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView getAbout() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView getContact() {
		ModelAndView mav = new ModelAndView("contact");
		return mav;
	}
	
	@RequestMapping(value = "/saveContactForm", method = RequestMethod.POST)
	public ModelAndView getContactConfrimation() {
		ModelAndView mav = new ModelAndView("contactConfirmation");
		return mav;
	}
	
	@RequestMapping(value = "/comingsoon", method = RequestMethod.GET)
	public ModelAndView getComingSoon() {
		ModelAndView mav = new ModelAndView("comingsoon");
		return mav;
	}

	@RequestMapping(value = "/home")
	// Principal - Knows who's logged in
	public ModelAndView getHome(Principal principal) {
		ModelAndView mav = new ModelAndView("home");
		Credential user = uRep.findByUsername(principal.getName());
		mav.addObject("user", user);
		return mav;
	}
}