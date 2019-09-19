package com.formation.app.dao;

import com.formation.app.util.PersistenceManager;

import javax.persistence.EntityManagerFactory;

public class DaoFactory {

    public DaoFactory() {
    }



    public static MessageDao getMessageDao() {

        //avec get on appelle la seule et unique connection EntityManagerFactory
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        return new JpaMessageDao(emf);
    }


   // public static UserDao getUserDao() {

        //avec get on appelle la seule et unique connection EntityManagerFactory
       // EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
       // return new JpaUserDao(emf);
        //return new JpaUserDao (emf);

   // }
}