/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ParameterState;
import java.util.LinkedList;
import java.util.Queue;
import Controller.ParametersController;

/**
 *
 * @author Kenneth
 */
public class MessageQueue {
    Queue<Message> messages;
    
    
    public MessageQueue(){
        messages = new LinkedList<Message>();
    }
    
    Message getMyNextMessage(String destinationID){
        Message myMessage = null;
        
        for(Message message: messages){
            if (message.getDestinationID().equals(destinationID)){
                if(ParametersController.getQueueStrategy() == ParameterState.Queue_FIFO){
                    myMessage = message;
                    break;
                } else
                if(myMessage == null){
                    myMessage = message;
                } else
                if(myMessage.getPriority() < message.getPriority()){
                    myMessage = message;
                }
            }
        }
        
        if(myMessage != null){
            messages.remove(myMessage);
        }
        return myMessage;
    }
    
    Message getNextMessage(){
        Message myMessage = null;
        
        for(Message message: messages){
            if(ParametersController.getQueueStrategy() == ParameterState.Queue_FIFO){
                myMessage = message;
                break;
            } else
            if(myMessage == null){
                myMessage = message;
            } else
            if(myMessage.getPriority() < message.getPriority()){
                myMessage = message;
            }
        }
        
        if(myMessage != null){
            messages.remove(myMessage);
        }
        return myMessage;
    }
    
    public void addMessage(Message message){
        if (messages.size() < ParametersController.getQueueSize()){
            messages.add(message);
        } else {
            //LOG "QUEUE FULL"
        }
    }
    
    
}
