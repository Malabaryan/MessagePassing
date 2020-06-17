/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Logger;
import Model.Log;
import Model.Process;
import UI.Setup;
import UI.Window;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bryan Hernandez
 */
public class UiController {
    
    private Setup setup;
    private Window mainWindow;
    private MainController controller;
    private Logger logger;

    public UiController(MainController controller) {
        this.controller = controller;
        setup = new Setup(this);
        mainWindow = new Window(this);
        logger = new Logger();
    }

    public Setup getSetup() {
        return setup;
    }

    public Window getMainWindow() {
        return mainWindow;
    }
    
    public void showSetup() {
        this.setup.setVisible(true);
    }

    public void showMainWindow() {
        this.mainWindow.setVisible(true);
    }

    public MainController getController() {
        return controller;
    }
    
    public Logger getLogger() {
        return logger;
    }

    public void sendCommand(String text) {
        this.controller.executeCommand(text);
    }

    public void updateTextField(JTextArea txt_selectedprocesses, String ID) {
        txt_selectedprocesses.setText(this.getLogOf(ID).toString());
    }

    
    public ArrayList<String> getLogOf(String processID) {
        ArrayList<String> logs = new ArrayList();
        for(Log log: this.logger.getLogger()){
            if(log.getMsg().getDestinationID().equals(processID)){
                if(log.getMsg().getDestinationID()  == null || log.getMsg().getSourceID()  == null){
                    logs.add(log.getMsg().getMessageContent());
                }
                else{
                    logs.add(log.getMsg().getMessageContent() + " - " + log.getMsg().getSourceID() + " to " + log.getMsg().getDestinationID());
                }
            }
        }
        return logs;
    }

    public void updateAll(JTextArea txt_allprocesses, JTextArea txt_process1, JTextArea txt_process2) {
        txt_allprocesses.setText(logger.getLogger().toString());
        
    }

    public void startSimulation(int formatSize, int noProcesses, int spin_maxQueueLenght) {
        for(int i = 0; i < noProcesses;i++){
            this.controller.AddProcess(new Process(Integer.toString(i),this.controller.getMailbox()));
        }
        ParametersController.setQueueSize(spin_maxQueueLenght);
        ParametersController.setMessageLength(formatSize);
     }
    
}
