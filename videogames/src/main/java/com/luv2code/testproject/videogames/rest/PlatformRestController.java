package com.luv2code.testproject.videogames.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.testproject.videogames.dao.PlatformDAO;
import com.luv2code.testproject.videogames.entity.Platform;

@RestController
@RequestMapping("/api")
public class PlatformRestController {

	private PlatformDAO platformDAO;

	@Autowired
	public PlatformRestController(PlatformDAO thePlatformDAO) {
		platformDAO = thePlatformDAO;
	}

	// expose POST "/games" - add a new game
	@PostMapping("/platforms")
	public Platform addPlatform(@RequestBody Platform thePlatform) {

		thePlatform.setId(0);

		platformDAO.save(thePlatform);

		return thePlatform;
	}

	// expose PUT "/games" - add a new game
	@PutMapping("/platforms")
	public Platform updatePlatform(@RequestBody Platform thePlatform) {

		platformDAO.save(thePlatform);

		return thePlatform;
	}

}
