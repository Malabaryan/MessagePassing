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
public class Message {
    private MessageType type;
    private String destinationID;
    private String sourceID;
    private int messageLenght;
    private String controlInformation;
    private String messageContent;
    private int priority;

    public Message() {
    }
    
    
    public Message(MessageType type, String destinationID, String sourceID, String controlInformation, String messageContent) {
        this.type = type;
        this.destinationID = destinationID;
        this.sourceID = sourceID;
        this.controlInformation = controlInformation;
        this.messageContent = messageContent;
        this.priority = 0;
    }
    
    public Message(MessageType type, String destinationID, String sourceID, String controlInformation, String messageContent, int priority) {
        this.type = type;
        this.destinationID = destinationID;
        this.sourceID = sourceID;
        this.controlInformation = controlInformation;
        this.messageContent = messageContent;
        this.priority = priority;
    }

    public String getDestinationID() {
        return destinationID;
    }

    public String getSourceID() {
        return sourceID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public int getPriority() {
        return priority;
    }
    
    
}
