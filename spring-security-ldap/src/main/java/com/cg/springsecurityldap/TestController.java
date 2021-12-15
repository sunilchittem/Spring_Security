package com.cg.springsecurityldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/greet")
	public String getGreeting() {
		return ("<h1>Hello World..!</h1>");
	}
}
