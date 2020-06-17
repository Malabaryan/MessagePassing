/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.Mailbox;
import Model.Process;

/**
 *
 * @author Bryan Hernandez
 */
public class MainController {
    
    private static MainController instance;
    
    private ArrayList<Process> processes;
    private Mailbox mailbox;
    private UiController uiController;

    private MainController() {
        
        processes = new ArrayList();
        mailbox = new Mailbox(this);
        uiController = new UiController(this);
    }
    
    public static MainController getInstance(){
        if(instance == null){
            instance = new MainController();
        }
        
        return instance;
    }
    
    public Mailbox getMailbox(){
        return mailbox;
    }

    public ArrayList getProcesses() {
        return processes;
    }
    
    public String[] getProcessesString() {
        String [] processList = new String [processes.size()];
        int cont = 0;
        for(Process process: processes){
            processList[cont] = process.getID();
            cont++;
        }
        return processList;
    }
    
    public Process getProcess(String ID){
        for(Process process: processes){
            if(process.getID().equals(ID)){
                return process;
            }
        }
        return null;
    }

    void sendCommand(String text) {
        
    }
    
    
}
