package com.cg.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	@GetMapping("/")
	public String show() {
		return "Welcome All..!";
	}

	@GetMapping("/user")
	public String user() {
		return "Welcome User..!";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin..!";
	}
}
