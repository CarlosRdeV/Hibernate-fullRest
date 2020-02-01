package com.luv2code.testproject.videogames.dao;

import java.util.List;

import com.luv2code.testproject.videogames.entity.Game;

public interface GameDAO {
	
	public List<Game> findAll();
	
}
