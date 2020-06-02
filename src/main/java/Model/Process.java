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

    public Process() {
        mailboxAssociated = new Mailbox();
    }
    
    public Message receiveMessage(){
        return null;
    }
    
    public void sendMessage(MessageType type, String destinationID, String sourceID, String controlInformation, String messageContent){
        sendMessage(new Message(type,destinationID,sourceID,controlInformation,messageContent));
    }
    
    public void sendMessage(Message pMessage){
        
    }
    
    
    
}
