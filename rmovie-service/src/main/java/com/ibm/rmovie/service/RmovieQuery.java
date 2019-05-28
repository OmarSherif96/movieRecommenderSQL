package com.ibm.rmovie.service;
import com.ibm.rmovie.entity.Genre;
import com.ibm.rmovie.entity.Movie;
import com.ibm.rmovie.entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Stateless
public class RmovieQuery {
    @PersistenceContext(name = "rmovie", unitName = "rmovie")
    private EntityManager em;

    public List<Movie> getMoviesByYear(Integer year){
        try{

            Query query = em.createNamedQuery("find movie by year");
            query.setParameter("year", year);
            List<Movie> result =  query.getResultList();
//            em.merge(result);
            return result;
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Movie> getMoviesByProducer(String producer){
        try{
            Query query = em.createNamedQuery("find movie by producer");
            query.setParameter("producer", producer);
            List<Movie> result =  query.getResultList();
//            em.merge(result);
            return result;
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Person> getPeople() {
        try {
            Query query = em.createNamedQuery("find people");
            List<Person> result = query.getResultList();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Genre> getGenre() {
        try {
            Query query = em.createNamedQuery("find genres");
            List<Genre> result = query.getResultList();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }
    public boolean deleteMovieByName(String movie){
        Query query = em.createNamedQuery("delete movie by name");
        query.setParameter("movie", movie);
        Movie result =(Movie) query.getSingleResult();
        em.remove(result);
        return true;
    }

    public List<Movie> getMoviesByActor(String actor){
        try{
            Query query = em.createNamedQuery("find movie by actor");
            query.setParameter("actor", String.valueOf(actor));
            List<Movie> result =  query.getResultList();
//            em.merge(result);
            return result;
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Movie> getMoviesByGenre(String genre){
        try{
            Query query = em.createNamedQuery("find movie by genre");
            query.setParameter("genre", genre);
            List<Movie> result =  query.getResultList();
//            em.merge(result);
            return result;
        }
        catch (NoResultException e) {
            return null;
        }
    }

//    public Person getMoviesByGenre(String genre){
//        try{
//            Query query = em.createNamedQuery("find movie by genre");
//            query.setParameter("genre", String.valueOf(genre));
//            Movie result = (Movie) query.getSingleResult();
//            em.merge(result);
//            return result;
//        }
//        catch (NoResultException e) {
//            return null;
//        }
//    }
}
