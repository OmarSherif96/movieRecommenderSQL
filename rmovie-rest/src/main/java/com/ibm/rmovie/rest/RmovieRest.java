package com.ibm.rmovie.rest;
import com.ibm.rmovie.entity.Genre;
import com.ibm.rmovie.entity.Movie;
import javax.ejb.EJB;
import com.ibm.rmovie.*;
import com.ibm.rmovie.entity.Person;
import com.ibm.rmovie.service.RmovieQuery;
import com.ibm.rmovie.service.RmovieStore;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.sun.tools.javac.jvm.Gen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/rmovie")
@RequestScoped
public class RmovieRest{

@EJB
private RmovieStore storeService;

@EJB
private RmovieQuery queryService;

    @POST
    @Path("createMovie")
    @Consumes("application/json")
    public Response createMovie(Movie movie){
        return storeService.createMovie(movie) ? Response.ok(true).build()
                : Response.ok(false).build();
    }

    @POST
    @Path("createPerson")
    @Consumes("application/json")
    public Response createPerson(Person person){
        return storeService.createPerson(person) ? Response.ok(true).build()
                : Response.ok(false).build();
    }


    @POST
    @Path("createGenre")
    @Consumes("application/json")
    public Response createPerson(Genre genre){
        return storeService.createGenre(genre) ? Response.ok(true).build()
                : Response.ok(false).build();
    }

    @GET
    @Path("findMovieByYear/{year}")
    @Produces("application/json")
    public Response getMoviesByYear(@PathParam("year") int year){
        return Response.ok(queryService.getMoviesByYear(year)).build();
    }

    @GET
    @Path("findMovieByGenre/{genre}")
    @Produces("application/json")
    public Response getMoviesByGenre(@PathParam("genre") String genre){
        return Response.ok(queryService.getMoviesByGenre(genre)).build();
    }

    @GET
    @Path("findPeople")
    @Produces("application/json")
    public Response getPeople(){
        return Response.ok(queryService.getPeople()).build();
    }

    @GET
    @Path("findGenres")
    @Produces("application/json")
    public Response getGenres(){
        return Response.ok(queryService.getGenre()).build();
    }

    @GET
    @Path("findMovieByActor/{actor}")
    @Produces("application/json")
    public Response getMoviesByActor(@PathParam("actor") String actor){
        return Response.ok(queryService.getMoviesByActor(actor)).build();
    }


    @GET
    @Path("findMovieByProducer/{producer}")
    @Produces("application/json")
    public Response getMoviesByProducer(@PathParam("producer") String producer){
        return Response.ok(queryService.getMoviesByProducer(producer)).build();
    }


    @DELETE
    @Path("deleteMovie/{movie}")
    @Produces("application/json")
    public Response deleteMovie(@PathParam("movie") String movie){
        return Response.ok(queryService.deleteMovieByName(movie)).build();
    }





}
