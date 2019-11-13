package com.casestudy.jatin.chander.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.casestudy.jatin.chander")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private UserDetailsService userDeatilsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDeatilsService).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication()
//		.withUser("kun").password("kunkun").roles("ADMIN")
//		.and()
//		.withUser("nonkun").password("notkunkun").roles("USER");
	}
	
	public void configure(WebSecurity web){
		web.ignoring().antMatchers("/js/**", "/images/**", "/css/**", "/resource/**", "/scripts/**");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/about").permitAll()
			.antMatchers("/contact").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/home").hasRole("USER")
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/subscriber/**").hasRole("USER")
//			.antMatchers("/all/**").hasAnyRole("ADMIN", "USER")
//			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").loginProcessingUrl("/loginAction").defaultSuccessUrl("/home", true).permitAll()
			.and()
			.logout().logoutSuccessUrl("/login").permitAll()
			.and()
//			.exceptionHandling().accessDeniedPage("/403")
//			.and()
			.csrf().disable();
	}
}
