package com.cg.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@GetMapping("/")
	private String test() {
		return ("<h1> Welcom..! </h1>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1> Welcme User </h1>");
	}

	@GetMapping("/admin")
	public String admin() {
		return ("<h1> Welcome Admin </h1>");
	}
}
