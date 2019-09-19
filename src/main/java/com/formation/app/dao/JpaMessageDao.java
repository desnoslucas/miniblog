package com.formation.app.dao;

import com.formation.app.entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaMessageDao implements MessageDao {


    private EntityManagerFactory emf;


    public JpaMessageDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public JpaMessageDao() {
    }


    @Override
    public void createMessage(Message message) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(message);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Message message) {

    }

    @Override
    public Message findById(Long id) {

        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Message message = em.find(Message.class, id);
        em.getTransaction().commit();
        em.close();
        return message;
    }


    @Override
    public List<Message> findAll() {

        EntityManager em = this.emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        TypedQuery<Message> query =
                em.createQuery("SELECT m FROM Message m", Message.class);

        et.commit();
        List<Message> messages = query.getResultList();
        em.close();
        return messages;
    }

    @Override
    public void delete(Message message) {


    }
}