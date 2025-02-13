package com.sellzee.authService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sellzee.authService.jwt.EntryPointJwt;
import com.sellzee.authService.jwt.TokenFilter;
import com.sellzee.authService.service.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuriryConfig {
	@Autowired
	private EntryPointJwt entryPointJwt;
	@Autowired
	private TokenFilter tokenFilter;
	@Autowired
	private UserDetailsServiceImpl serviceImpl;
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(serviceImpl);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain doFilter(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(entryPointJwt)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.requestMatchers("/public/**","/user/registerUser").permitAll()
		.requestMatchers("/user/**").authenticated()
		.requestMatchers("/admin/**").authenticated();
		
		http.authenticationProvider(daoAuthenticationProvider());
		http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
