package service;

import dao.DAOMessage;
import entity.Message;

public class MessageService {
    private final DAOMessage daoMessage;

    public MessageService(DAOMessage daoMessage) {
        this.daoMessage = daoMessage;
    }

    public void addMessage(Message message) {
        daoMessage.addMessage(message);
    }
}
