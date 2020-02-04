package com.luv2code.testproject.videogames.dao;

import java.util.List;

import com.luv2code.testproject.videogames.entity.Game;

public interface GameDAO {
	
	public List<Game> findAll();
	
	public Game findById(int theId);
	
	public void save(Game theGame);
	
	public void deleteById(int theId);
	
	public void addGenre(int gameId, int genreId);
	
	public void addPlatform(int gameId, int platformId);
	
}
