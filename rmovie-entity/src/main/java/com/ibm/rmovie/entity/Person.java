package com.ibm.rmovie.entity;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.*;

@Entity(name="person")
@Table(name="person")
@Access(AccessType.FIELD)
@NamedQuery(query = "select a from person a",name= "find people")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "pk")
    private BigInteger pk;

    @Column(name = "name")
    private String name;

    @Column(name = "job")
    private String job;




//    @ManyToMany(mappedBy = "actors")
//    private Collection<Movie> movie;

    public Person(){

    }
    public Person(String name,String job){
        this.name=name;
        this.job=job;

    }

    public BigInteger getPk() {
        return pk;
    }

    public void setPk(BigInteger pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
