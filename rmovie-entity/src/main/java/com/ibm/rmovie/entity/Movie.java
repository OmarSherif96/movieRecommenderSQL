package com.ibm.rmovie.entity;
import com.sun.tools.javac.jvm.Gen;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "movie")
@Access(AccessType.FIELD)
@NamedQueries(value={
@NamedQuery(query = "select a from Movie a where a.movieYear = :year", name = "find movie by year"),
@NamedQuery(query = "select a from Movie a where a.movie = :movie", name = "delete movie by name"),
@NamedQuery(query = "select a from Movie a where a.producer.name = :producer", name = "find movie by producer"),
@NamedQuery(query = "select a,n from Movie a JOIN a.actors n where n.name  = :actor", name = "find movie by actor"),
@NamedQuery(query = "select a,g from Movie a JOIN a.genres g where g.genreName  = :genre", name = "find movie by genre")
})
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "pk")
    private BigInteger pk;


    @Column(name = "movie")
    private String movie;

    @Column(name = "movieYear")
    private Integer movieYear;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name="producerfk")
    private Person producer;


    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name="MOVIE_GENRE",
            joinColumns = { @JoinColumn(name= "moviefk")},
            inverseJoinColumns = {@JoinColumn(name="genrefk")}
    )
    private Set<Genre> genres = new HashSet<Genre>();




    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name="MOVIE_ACTOR",
            joinColumns = { @JoinColumn(name= "moviefk")},
            inverseJoinColumns = {@JoinColumn(name="actorfk")}
    )
    private Set<Person> actors = new HashSet<Person>();

    public Movie() {
    }



    public Movie(String movie, Integer movieYear, Person producer,Set<Genre> genres, Set<Person> actors) {
        this.movie = movie;
        this.movieYear = movieYear;
        this.producer = producer;
        this.genres = genres;
        this.actors = actors;
    }

    public BigInteger getPk() {
        return pk;
    }

    public void setPk(BigInteger pk) {
        this.pk = pk;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public Person getProducer() {
        return producer;
    }

    public void setProducer(Person producer) {
        this.producer = producer;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
}
}

