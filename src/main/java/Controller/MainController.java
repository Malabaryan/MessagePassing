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
        ParametersController.getInstance();
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

    public UiController getUiController() {
        return uiController;
    }
    
    
    
    public void AddProcess(Process pProcess){
        processes.add(pProcess);
    }
    
    public ArrayList<String> getProcessesStringArrayList() {
        ArrayList<String> processList = new ArrayList();// [processes.size()];
        for(Process process: processes){
            processList.add(process.getID());
        }
        return processList;
    }
    
    public String[] getProcessesString() {
        String[] processList = getProcessesStringArrayList().toArray(new String[0]);
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

    public void executeCommand(String text) {
        String[] commands = text.split("\n");
        
        for(String str : commands) {
            String[] subString = str.split("[()]");
            String[] parameters = subString[1].split(",");
            if (subString[0].equals("create")){
                //CREATE COMMAND
            } else if (subString[0].equals("send")){
                //SEND COMMAND
            } else if (subString[0].equals("recieve")){
                //RECIEVE COMMAND
            } else {
                //INVALID COMMAND
            }
            
        }
    }
    
    
    
    
}
