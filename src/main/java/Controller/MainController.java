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

    public void sendCommand(String text) {
        
    }
    
    public void startSimulation(ParameterState syncSend, ParameterState syncReceive, ParameterState addressing, ParameterState formatLenght, ParameterState queue, int noProcess, int maxQueueLenght){
        startSimulation(syncSend, syncReceive, addressing,formatLenght, 0,queue, noProcess,maxQueueLenght);
    }
    
    public void startSimulation(ParameterState syncSend, ParameterState syncReceive, ParameterState addressing, ParameterState formatLenght, int fixedValue, ParameterState queue, int noProcess, int maxQueueLenght){
        ParametersController.setAddressing(addressing);
        ParametersController.setMessageLength(fixedValue);
        ParametersController.setQueueStrategy(queue);
        ParametersController.setSyncronization_Send(syncSend);
        ParametersController.setSyncronization_Receive(syncReceive);
    }
    
}
