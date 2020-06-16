/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bryan Hernandez
 */
public class Process {
    
    private Message currentMessage;
    private Mailbox mailboxAssociated;
    private String ID;

    public Process(Mailbox pMailbox) {
        mailboxAssociated = pMailbox;
    }
    
    public Message receiveMessage(Message pMessage){
        return null;
    }
    
    public void sendMessage(MessageType type, String destinationID, String sourceID, String controlInformation, String messageContent){
        sendMessage(new Message(type,destinationID,sourceID,controlInformation,messageContent));
    }
    
    public void sendMessage(Message pMessage){
        
    }

    public String getID() {
        return ID;
    }
    
    
    
}
