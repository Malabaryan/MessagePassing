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
    
    private ArrayList<Process> processes;
    private Mailbox mailbox;

    public MainController() {
        
        processes = new ArrayList();
        mailbox = new Mailbox(this);
    }
    
    public Mailbox getMailbox(){
        return mailbox;
    }

    public ArrayList getProcesses() {
        return processes;
    }
    
    public Process getProcess(String ID){
        for(Process process: processes){
            if(process.getID().equals(ID)){
                return process;
            }
        }
        return null;
    }
    
}
