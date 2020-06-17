/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ParameterState;
import Controller.ParametersController;
import Controller.MainController;

/**
 *
 * @author Bryan Hernandez
 */
public class Process {
    
    private Message currentMessage;
    private Mailbox mailboxAssociated;
    public  boolean bloqueo;
    private String ID;

    public Process(String pid,Mailbox pMailbox) {
        ID = pid;
        mailboxAssociated = pMailbox;
    }
    
    public void Syncronizacion_Send(){
        ParameterState estado = ParametersController.getSyncronization_Send();
        if(null == estado){
            bloqueo = false;
        }
        else switch (estado) {
            case Sync_Send_NonBlocking:
                bloqueo = false;
                System.out.print("No Bloqueado");
                break;
            case Sync_Send_Blocking:
                bloqueo = true;
                System.out.print("Bloqueado");
                break;
            default:
                bloqueo = false;
                break;
        }
    }
    
    
    public void Syncronizacion_Receive(){
        ParameterState estado = ParametersController.getSyncronization_Receive();
        if(null == estado){
            bloqueo = false;
        }
        else switch (estado) {
            case Sync_Receive_NonBlocking:
                bloqueo = false;
                System.out.print("No Bloqueado");
                break;
            case Sync_Receive_Blocking:
                bloqueo = true;
                System.out.print("Bloqueado");
                break;
            case Sync_Receive_ProofOfArrival:
                bloqueo = true;
                System.out.print("Bloqueado");
                break;
            default:
                bloqueo = false;
                break;
        }
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public String getID() {
        return ID;
    }
    
    public boolean getBloqueo() {
        return bloqueo;
    }
    
    public void receiveMessage_DirectImplicit(Message pMessage,String ID){
        Process process_send = MainController.getInstance().getProcess(ID);
        boolean pbloqueo_Send = process_send.getBloqueo();
        boolean pbloqueo_Receive = getBloqueo();
        if(pbloqueo_Send == true){
            if(ParametersController.getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                process_send.desbloquear_Test_Arrival();
                System.out.print("Desbloqueado");
            }
            else{
                process_send.setBloqueo(false);
                System.out.print("Desbloqueado");
                }
            }
        if(pbloqueo_Receive == true){
            setBloqueo(false);
            System.out.print("Desbloqueado");
        }
    }
    
    public void sendMessage_Direct(Message pMessage,String ID){
        Syncronizacion_Send();
        Process process = MainController.getInstance().getProcess(ID);
        process.Syncronizacion_Receive();
    }
    
    public void sendMessage_Indirect(Message pMessage){
        Syncronizacion_Send();
        mailboxAssociated.addMessage(pMessage);
    }
    
    public void receiveMessage_Indirect(Message pMessage){
        currentMessage = mailboxAssociated.messages.getNextMessage();
        Process process = mailboxAssociated.select_Received();
        if(process != null){
            Process process_send = MainController.getInstance().getProcess(currentMessage.getSourceID());
            boolean pbloqueo_Send = process_send.getBloqueo();
            if(pbloqueo_Send == true){
                if(ParametersController.getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                    desbloquear_Test_Arrival();
                    System.out.print("Desbloqueado");
                }
                else{
                    process.setBloqueo(false);
                    System.out.print("Desbloqueado");
                }
            }
            boolean pbloqueo_Receive = getBloqueo();
            if(pbloqueo_Receive == true){
                process.setBloqueo(false);
                System.out.print("Desbloqueado");
            }
            pMessage.setDestinationID(process.ID);
        }
        else{
            System.out.print("No se pruede recibir el mensaje");
        }
    }
    
    public void sendMessage(Message pMessage,String ID){
        ParameterState direccionamiento = ParametersController.getAddressing_Send();
        if(direccionamiento == ParameterState.Addr_Direct_Send){
            sendMessage_Direct(pMessage,ID);
        }
        else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
            if(mailboxAssociated.findList_Send(this.ID)==true){
                sendMessage_Indirect(pMessage); 
            }
            else{
                System.out.print("Este Proceso no pertenece a esta mailBox");
            }
        }
    }
    
    public Process receiveMessage(Message pMessage,String ID){
        ParameterState direccionamiento = ParametersController.getAddressing_Receive();
        if(direccionamiento == ParameterState.Addr_Direct_Receive_Implicit){
            receiveMessage_DirectImplicit(pMessage,ID);
            return null;
        }
        else if(direccionamiento == ParameterState.Addr_Direct_Receive_Explicit){
            receiveMessage_DirectImplicit(pMessage,ID);
            return MainController.getInstance().getProcess(ID);
        }
        else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
            if(mailboxAssociated.findList_Receive(ID)==true){
                receiveMessage_Indirect(pMessage); 
            }
            else{
                System.out.print("Este Proceso no pertenece a esta mailBox");
            }
            return null;
        }
        return null;
    }
    
    public void desbloquear_Test_Arrival(){
        setBloqueo(false);
    }
    
}
