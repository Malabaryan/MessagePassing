/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import UI.Setup;
import UI.Window;

/**
 *
 * @author Bryan Hernandez
 */
public class UiController {
    
    private Setup setup;
    private Window mainWindow;
    private MainController controller;

    public UiController(MainController controller) {
        this.controller = controller;
        setup = new Setup(this);
        mainWindow = new Window(this);
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
    
}
