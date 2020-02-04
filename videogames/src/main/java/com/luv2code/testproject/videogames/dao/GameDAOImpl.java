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
		Query<Game> theQuery =
				currentSession.createSQLQuery("SELECT * FROM JUEGO WHERE id=:gameId");
		//"from Game where id=:gameId", Game.class
		//currentSession.createQuery("select g from Game g where g.id=:gameId", Game.class);
		
		theQuery.setParameter("gameId", theId);

		Game theGame = theQuery.getSingleResult();

		//Game theGame = currentSession.get(Game.class, theId);
		
		// return list
		return theGame;
	}

	@Override
	@Transactional
	public void save(Game theGame) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = null;
		
		if(theGame.getId()==0) {
			
			// create a query
			theQuery = currentSession.createSQLQuery(
					"INSERT INTO JUEGO (NOMBRE, GAME_YEAR, ESRB, COMPANY, ENABLE) VALUES "
					+ "(:nombre, :gameYear, :esrb, :company, :enable )");
			
			// set parameters
			theQuery.setParameter("nombre", theGame.getName());
			theQuery.setParameter("gameYear", theGame.getGameYear());
			theQuery.setParameter("esrb", theGame.getEsrb());
			theQuery.setParameter("company", theGame.getCompany());
			theQuery.setParameter("enable", true);
			
		}else {
			
			theQuery =
					currentSession.createSQLQuery(
						"UPDATE JUEGO SET NOMBRE=:nombre, GAME_YEAR=:gameYear, ESRB=:esrb, "
						+ "COMPANY=:company where id=:gameId");
			
			theQuery.setParameter("gameId", theGame.getId());
			theQuery.setParameter("nombre", theGame.getName());
			theQuery.setParameter("gameYear", theGame.getGameYear());
			theQuery.setParameter("esrb", theGame.getEsrb());
			theQuery.setParameter("company", theGame.getCompany());
			
		}

		// execute query
		theQuery.executeUpdate();

		
	}
	
	

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query theQuery =
				currentSession.createSQLQuery("UPDATE JUEGO SET ENABLE = FALSE where id=:gameId");
		
		theQuery.setParameter("gameId", theId);
		
		// execute query and get the result list
		theQuery.executeUpdate();
	
	}

	@Override
	@Transactional
	public void addGenre(int gameId, int genreId) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
		Query theQuery = currentSession.createSQLQuery(
					"INSERT INTO JUEGO_GENERO (JUEGO_ID, GENERO_ID) VALUES "
					+ "(:juegoId, :generoId)");
			
			// set parameters
			theQuery.setParameter("juegoId", gameId);
			theQuery.setParameter("generoId", genreId);
			
			theQuery.executeUpdate();

		
	}

	@Override
	@Transactional
	public void addPlatform(int gameId, int platformId) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
		Query theQuery = currentSession.createSQLQuery(
					"INSERT INTO JUEGO_PLATAFORMA (JUEGO_ID, PLATAFORMA_ID) VALUES "
					+ "(:juegoId, :plataformaId)");
			
			// set parameters
			theQuery.setParameter("juegoId", gameId);
			theQuery.setParameter("plataformaId", platformId);
			
			theQuery.executeUpdate();
	}

}
