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
        sendprocesses = new ArrayList<Process>();
        receiveprocesses = new ArrayList<Process>();
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
            if(receiveprocesses.get(largo).getID()==ID && receiveprocesses.get(largo).bloqueo_recibir==false){
                return true;
            }
        }
        return false;
    }
    
    public Process select_Received(){
        for(int largo=0; largo < receiveprocesses.size();largo++){
            if(receiveprocesses.get(largo).getBloqueo_recibir()==false){
                return receiveprocesses.get(largo);
            }
        }
        return null;
    }
    
    public void addListSend(Process pProcess){
        sendprocesses.add(pProcess);
    }
    
    public void addListReceive(Process pProcess){
        receiveprocesses.add(pProcess);
    }
}
