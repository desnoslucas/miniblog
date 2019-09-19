package com.formation.app.bean;

import com.formation.app.entity.Message;
import com.formation.app.service.MessageService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped

public class MessageBean implements Serializable {


    private String content;
    private String date;
    private MessageService messageService;
    private List<Message> messageList;

    public MessageBean() {
        Date dt = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(dt);
        this.messageService = new MessageService();
        this.messageList = messageService.getMessageFromDb();
    }

    public void postMessage() {
        messageService.postMessage(this);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
