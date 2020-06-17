/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Logger;
import UI.Setup;
import UI.Window;
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
        this.controller.sendCommand(text);
    }

    public void updateTextField(JTextArea txt_selectedprocesses, String hola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getLogOf(String processID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateAll(JTextArea txt_allprocesses, JTextArea txt_process1, JTextArea txt_process2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
