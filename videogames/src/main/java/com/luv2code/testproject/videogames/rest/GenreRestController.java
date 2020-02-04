package com.luv2code.testproject.videogames.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.testproject.videogames.dao.GenreDAO;
import com.luv2code.testproject.videogames.entity.Genre;

@RestController
@RequestMapping("/api")
public class GenreRestController {

	private GenreDAO genreDAO;

	@Autowired
	public GenreRestController(GenreDAO theGenreDAO) {
		genreDAO = theGenreDAO;
	}

	// expose POST "/games" - add a new game
	@PostMapping("/genres")
	public Genre addGenre(@RequestBody Genre theGenre) {

		theGenre.setId(0);

		genreDAO.save(theGenre);

		return theGenre;
	}

	// expose PUT "/games" - add a new game
	@PutMapping("/genres")
	public Genre updateGenre(@RequestBody Genre theGenre) {

		genreDAO.save(theGenre);

		return theGenre;
	}
}
