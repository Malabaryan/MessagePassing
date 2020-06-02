/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryan Hernandez
 */
class Mailbox {
    
    private Queue<Message> messages;

    public Mailbox() {
        messages = new LinkedList<Message>();
    }
    
    public Message getMyNextMessage(String pDestinationID){
        for(Message message: messages){
            if(message.getDestinationID() == pDestinationID){
                return message;
            }
        }
        return null;
    }
    
    public void addMessage(Message pMessage){
        messages.add(pMessage);
    }
    
}
