/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekti.entities.Account;
import projekti.entities.Message;
import projekti.repositories.MessageRepository;

/**
 *
 * @author hajajaim
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRep;

    public List<Message> listAll() {
        return messageRep.findAll();
    }

    public List<Message> listByAccount(Account account) {
        return messageRep.findByAccount(account);
    }

    public void saveMessage(Message message) {
        messageRep.save(message);
    }
}
