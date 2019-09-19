package com.formation.app.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {


    private static EntityManagerFactory SINGLETON_INSTANCE;


    private PersistenceManager (){
        //singleton
    }

    public static EntityManagerFactory getEntityManagerFactory (){
        if (SINGLETON_INSTANCE ==null){
            SINGLETON_INSTANCE= Persistence.createEntityManagerFactory("PU");
        }
        return SINGLETON_INSTANCE;
    }

    public static void close(){
        if (SINGLETON_INSTANCE != null && SINGLETON_INSTANCE.isOpen()){
            SINGLETON_INSTANCE.close();
        }
    }
}

