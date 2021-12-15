package com.cg.springsecurityjwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.springsecurityjwt.dao.UserRepo;
import com.cg.springsecurityjwt.model.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService {

	  @Autowired 
	  private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Optional<com.cg.springsecurityjwt.model.User> user = userRepo.findByUsername(username);
			user.orElseThrow(() -> new UsernameNotFoundException("user name not found"));
			return user.map(MyUserDetails::new).get();
		
	}

}
