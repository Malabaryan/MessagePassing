/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MainController;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryan Hernandez
 */
public class Mailbox {
    
    private MessageQueue messages;
    private MainController controller;

    public Mailbox(MainController pController) {
        messages = new MessageQueue();
        this.controller = pController;
    }
    
    public void addMessage(Message pMessage){
        messages.addMessage(pMessage);
    }
    
    public void sendMessage(){
        Message msg = this.messages.getNextMessage();
        this.controller.getProcess(msg.getDestinationID()).receiveMessage(msg);
    }
    
}
