
import Controller.MainController;
import Controller.UiController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan Hernandez
 */
public class MainFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainController maincontroller = MainController.getInstance();
        maincontroller.getUiController().showSetup();
    }
    
}
