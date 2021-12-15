package com.cg.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.cg.springsecurityjwt.Util.JwtUtil;
import com.cg.springsecurityjwt.model.AuthenticationRequest;
import com.cg.springsecurityjwt.model.AuthenticationResponce;
import com.cg.springsecurityjwt.service.MyUserDetailService;

@RestController
public class TestController {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private MyUserDetailService userDetail;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/greet")
	public String getGreet() {
		return "Hello World..!";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponce> getAuthenticate(@RequestBody AuthenticationRequest request)
			throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Invalid user name " + request.getUsername(), ex);
		}
		final UserDetails userInfo = userDetail.loadUserByUsername(request.getUsername());

		String generateToken = jwtUtil.generateToken(userInfo);

		return new ResponseEntity<AuthenticationResponce>(new AuthenticationResponce(generateToken), HttpStatus.OK);
	}
}
