/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MainController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import Model.Process;

/**
 *
 * @author Bryan Hernandez
 */
public class Mailbox {
    
    public ArrayList<Process> sendprocesses;
    public ArrayList<Process> receiveprocesses;
    public MessageQueue messages;
    private MainController controller;

    public Mailbox(MainController pController) {
        messages = new MessageQueue();
        this.controller = pController;
    }
    
    public void addMessage(Message pMessage){
        messages.addMessage(pMessage);
    }
    
    public boolean findList_Send(String ID){
        for(int largo=0; largo < sendprocesses.size();largo++){
            if(sendprocesses.get(largo).getID()==ID){
                return true;
            }
        }
        return false;
    }
    
    public boolean findList_Receive(String ID){
        for(int largo=0; largo < receiveprocesses.size();largo++){
            if(receiveprocesses.get(largo).getID()==ID){
                return true;
            }
        }
        return false;
    }
    
    public Process select_Received(){
        for(int largo=0; largo < receiveprocesses.size();largo++){
            if(receiveprocesses.get(largo).getBloqueo()==false){
                return receiveprocesses.get(largo);
            }
        }
        return null;
    }
}
