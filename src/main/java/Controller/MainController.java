/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.Mailbox;
import Model.Message;
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

    void executeCommand(String text,String Source, String Destination) {
        String[] commands = text.split("\n");
        for(String str : commands) {
            String[] subString = str.split("[()]");
            String[] parameters = subString[1].split(",");
            if (subString[0].equals("create")){
                //CREATE COMMAND
                Process process = new Process(parameters[0],mailbox);
                getMailbox().addListSend(process);
                getMailbox().addListReceive(process);
                AddProcess(process);
            } else if (subString[0].equals("send")){
                //SEND COMMAND
                Message mensaje = new Message(Destination, Source, parameters[0]);
                Process process = getProcess(parameters[0]);
                process.sendMessage(mensaje,Destination);
            } else if (subString[0].equals("recieve")){
                //RECIEVE COMMAND
                Process process = getProcess(parameters[0]);
                process.receiveMessage(Source);
            } else {
                //INVALID COMMAND
            }
            
        }
    }
    
    
    
    
}
