package com.ibm.rmovie.entity;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="genre")
@Access(AccessType.FIELD)
@NamedQuery(query = "select a from Genre a",name= "find genres")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name = "pk")
    private BigInteger pk;

    @Column(name = "genreName")
    private String genreName;




    public Genre() {

    }

    public Genre(String genreName) {
        this.genreName = genreName;

    }

    public BigInteger getPk() {
        return pk;
    }

    public void setPk(BigInteger pk) {
        this.pk = pk;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }


}
