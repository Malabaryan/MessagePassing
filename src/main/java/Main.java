import Model.Message;
import Model.Process;
import Controller.ParametersController;
import Controller.MainController;
import Controller.ParameterState;

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
        ParameterState estado_Send = Controller.ParameterState.Sync_Send_Blocking;
        ParameterState estado_Receive = Controller.ParameterState.Sync_Receive_NonBlocking;
        ParameterState adressingReceive = Controller.ParameterState.Addr_Indirect_Static;
        ParameterState adressingSend = Controller.ParameterState.Addr_Indirect_Static;
        
        parametros.setSyncronization_Send(estado_Send);
        parametros.setSyncronization_Receive(estado_Receive);
        parametros.setAddressing_Send(adressingSend);
        parametros.setAddressing_Receive(adressingReceive);
        
        MainController maincontroller = MainController.getInstance();
        Process nuevo1 = new Model.Process("1",maincontroller.getMailbox());
        Process nuevo2 = new Model.Process("2",maincontroller.getMailbox());
        Process nuevo3 = new Model.Process("3",maincontroller.getMailbox());
        maincontroller.AddProcess(nuevo1);
        maincontroller.AddProcess(nuevo2);
        maincontroller.AddProcess(nuevo3);
        
        maincontroller.getMailbox().addListSend(nuevo1);
        maincontroller.getMailbox().addListReceive(nuevo3);
        maincontroller.getMailbox().addListReceive(nuevo2);
        
        System.out.print(ParametersController.getSyncronization_Send().toString());
        Message mensaje = new Message();
        nuevo1.sendMessage(mensaje, "2");
        for(int i = 0; i<=50; i++){
            nuevo3.sendMessage(mensaje, "2");
            System.out.print(i+"\n");
        }

    }
    
}