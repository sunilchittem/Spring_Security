package com.cg.springsecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.springsecurity.entity.UserDetailDemo;
import com.cg.springsecurity.entity.UserRepo;
import com.cg.springsecurity.entity.Users;

@Service
public class UserDetailsServiceDemo implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// UserDetailDemo userDetailDemo = new UserDetailDemo(username);
		// return userDetailDemo;
		Optional<Users> findByUserName = userRepo.findByUserName(username);
		System.out.println(findByUserName.get().getPassword());
		findByUserName.orElseThrow(() -> new UsernameNotFoundException("Not found " + findByUserName));
		return findByUserName.map(UserDetailDemo::new).get();
	}

}
