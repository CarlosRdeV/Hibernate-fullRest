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

	@Override
	@Transactional
	public Game findById(int theId) {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Game theGame = currentSession.get(Game.class, theId);
		
		// return list
		return theGame;
	}

	@Override
	@Transactional
	public void save(Game theGame) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		currentSession.saveOrUpdate(theGame);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query theQuery =
				currentSession.createQuery("delete from Game where id=:gameId");
		
		theQuery.setParameter("gameId", theId);
		
		// execute query and get the result list
		theQuery.executeUpdate();
	
	}

}
