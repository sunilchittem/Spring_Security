package com.cg.springsecurity.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailDemo implements UserDetails {

	private String userName;
	private String password;
	private List<GrantedAuthority> authority;
	private boolean enabled;

	public UserDetailDemo(Users user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.authority = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		this.enabled = user.isActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
