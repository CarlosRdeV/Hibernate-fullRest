package com.luv2code.testproject.videogames.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.testproject.videogames.entity.Game;

@Repository
public class GameDAOImpl implements GameDAO {

	//define field for EntityManager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public GameDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Game> findAll() {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Game> theQuery =
				currentSession.createQuery("from Game", Game.class);
		// execute query and get the result list
		List<Game> theGames = theQuery.getResultList();
		
		// return list
		return theGames;
	}

}
