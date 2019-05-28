package com.ibm.rmovie.service;

import com.ibm.rmovie.entity.Genre;
import com.ibm.rmovie.entity.Movie;
import com.ibm.rmovie.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RmovieStore{

    //    private static final Logger LOG = LoggerFactory.getILoggerFactory(RmovieStoreService.class);
    @PersistenceContext(name = "rmovie", unitName = "rmovie")
    private EntityManager em;
//    private static final Logger LOG = LoggerFactory.getLogger(RmovieStore.class);
    public boolean createMovie(Movie movie) {
        em.persist(movie);
        return true;
    }

    public boolean createPerson(Person person){
        em.persist(person);
        return true;
    }

    public boolean createGenre(Genre genre){
        em.persist(genre);
        return true;
    }
}