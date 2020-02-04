package com.luv2code.testproject.videogames.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	// expose GET "/games/{gameId}" - return a existing game
	@GetMapping("/games/{gameId}")
	public Game findById(@PathVariable int gameId) {

		try {
			Game theGame = gameDAO.findById(gameId);
			return theGame;
		} catch (Exception e) {
			throw new RuntimeException("Game id not found - " + gameId);
		}

	}
	
	// expose POST "/games" - add a new game
	@PostMapping("/games")
	public Game addGame(@RequestBody Game theGame) {
		
		theGame.setId(0);
		
		gameDAO.save(theGame);
		
		return theGame;
	}

	// expose PUT "/games" - add a new game
	@PutMapping("/games")
	public Game updateGame(@RequestBody Game theGame) {
				
		gameDAO.save(theGame);
		
		return theGame;
	}
	
	//expose DELETE "/games/{gameId}" - set enable = false on a existing game
	@DeleteMapping("/games/{gameId}")
	public String disableGame(@PathVariable int gameId) {
		
		try {
			gameDAO.deleteById(gameId);
			return "Game deleted by id - " + gameId;
		} catch (Exception e) {
			throw new RuntimeException("Game id not found - " + gameId);
		}
		
	}

}
