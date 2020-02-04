package com.luv2code.testproject.videogames.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.testproject.videogames.entity.Platform;

@Repository
public class PlatformDAOImpl implements PlatformDAO {

	private EntityManager entityManager;

	@Autowired
	public PlatformDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Platform thePlatform) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = null;

		if (thePlatform.getId() == 0) {

			// create a query
			theQuery = currentSession.createSQLQuery("INSERT INTO PLATAFORMA (PLATAFORMA) VALUES (:plataforma)");

			// set parameters
			theQuery.setParameter("plataforma", thePlatform.getPlataforma());

		} else {

			theQuery = currentSession.createSQLQuery("UPDATE PLATAFORMA SET PLATAFORMA=:plataforma where id=:plataformaId");

			theQuery.setParameter("plataformaId", thePlatform.getId());
			theQuery.setParameter("plataforma", thePlatform.getPlataforma());
		}

		// execute query
		theQuery.executeUpdate();

	}

}
