
import Model.Message;
import Model.Process;
import Controller.ParametersController;
import Controller.MainController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ariel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ParametersController parametros = ParametersController.getInstance();
        Controller.ParameterState estado_Send = Controller.ParameterState.Sync_Send_Blocking;
        Controller.ParameterState estado_Receive = Controller.ParameterState.Sync_Receive_Blocking;
        parametros.setSyncronization_Send(estado_Send);
        parametros.setSyncronization_Receive(estado_Receive);
        MainController maincontroller = new MainController();
        Process nuevo1 = new Model.Process(maincontroller.getMailbox());
        Process nuevo2 = new Model.Process(maincontroller.getMailbox());
        Process nuevo3 = new Model.Process(maincontroller.getMailbox());
        Message mensaje = new Message();
        nuevo1.parametros = parametros;
        nuevo2.parametros = parametros;
        nuevo3.parametros = parametros;
        nuevo1.sendMessage(mensaje, nuevo2);
        for(int i = 0; i<=50; i++){
            nuevo3.sendMessage(mensaje, nuevo2);
            System.out.print(i);
        }
        nuevo2.receiveMessage(mensaje, nuevo1);
        
    }
    
}
