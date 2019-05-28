package com.ibm.rmovie.ejb;

import javax.ejb.Stateless;

@Stateless
public class RmovieStoreService {
    public String version(){
        return "1.0";
    }
}
