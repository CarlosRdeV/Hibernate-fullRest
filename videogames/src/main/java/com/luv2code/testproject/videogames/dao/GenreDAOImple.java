package com.luv2code.testproject.videogames.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.testproject.videogames.entity.Genre;

@Repository
public class GenreDAOImple implements GenreDAO {

	private EntityManager entityManager;

	@Autowired
	public GenreDAOImple(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Genre theGenre) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = null;

		if (theGenre.getId() == 0) {

			// create a query
			theQuery = currentSession.createSQLQuery("INSERT INTO GENERO (GENERO) VALUES (:genero)");

			// set parameters
			theQuery.setParameter("genero", theGenre.getGenero());

		} else {

			theQuery = currentSession.createSQLQuery("UPDATE GENERO SET GENERO=:genero where id=:genreId");

			theQuery.setParameter("genreId", theGenre.getId());
			theQuery.setParameter("genero", theGenre.getGenero());
		}

		// execute query
		theQuery.executeUpdate();

	}

}
