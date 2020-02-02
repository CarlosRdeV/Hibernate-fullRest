package com.luv2code.testproject.videogames.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.testproject.videogames.dao.GameDAO;
import com.luv2code.testproject.videogames.entity.Game;

@RestController
@RequestMapping("/api")
public class GameRestController {

	private GameDAO gameDAO;
	
	// inject DAO directly
	@Autowired
	public GameRestController(GameDAO theGameDAO) {
		gameDAO = theGameDAO;
	}
	
	// expose GET "/games" - return list of games
	@GetMapping("/games") 
	public List<Game> findAll(){
		return gameDAO.findAll();
	}
	
	
}
