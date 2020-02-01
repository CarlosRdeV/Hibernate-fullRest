package com.luv2code.testproject.videogames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameRestController {

	@GetMapping("/")
	public String welcome() {
		return "hola mundo!";
	}
	
}
