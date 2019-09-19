package com.formation.app.dao;

import com.formation.app.entity.Message;

import java.util.List;

public interface MessageDao {


    void createMessage(Message message);


    void update (Message message);

   Message findById (Long id);

    List<Message> findAll();

    void delete (Message message);

}
