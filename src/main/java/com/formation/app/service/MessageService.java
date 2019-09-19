package com.formation.app.service;

import com.formation.app.bean.MessageBean;
import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.MessageDao;
import com.formation.app.entity.Message;

import java.util.List;

public class MessageService {

    private MessageDao jpaMessageDao;

    public MessageService() {
        this.jpaMessageDao = DaoFactory.getMessageDao();
    }


    public void postMessage(MessageBean messageBean) {
        Message message = new Message(messageBean.getContent(), messageBean.getDate());
        jpaMessageDao.createMessage(message);
    }

    public List<Message> getMessageFromDb() {
        List<Message> messageList = jpaMessageDao.findAll();
        return messageList;
    }
}