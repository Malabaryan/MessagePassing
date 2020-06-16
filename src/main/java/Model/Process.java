/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ParameterState;
import Controller.ParametersController;

/**
 *
 * @author Bryan Hernandez
 */
public class Process {
    
    private Message currentMessage;
    private Mailbox mailboxAssociated;
    public  boolean bloqueo;
    public  ParametersController parametros;
    private String ID;

    public Process(Mailbox pMailbox) {
        mailboxAssociated = pMailbox;
    }
    
    public void Syncronizacion_Send(){
        ParameterState estado = parametros.getSyncronization_Send();
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
        ParameterState estado = parametros.getSyncronization_Receive();
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
        //aun no lo se
            case Sync_Receive_ProofOfArrival:
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
    
    public void receiveMessage(Message pMessage,Process pProceso){
        boolean pbloqueo_Send = pProceso.getBloqueo();
        boolean pbloqueo_Receive = getBloqueo();
        if(pbloqueo_Send == true){
            pProceso.setBloqueo(false);
            System.out.print("Desbloqueado");
        }
        if(pbloqueo_Receive == true){
            setBloqueo(false);
            System.out.print("Desbloqueado");
        }
   
    }
    
    public void sendMessage(Message pMessage,Process pProceso){
        Syncronizacion_Send();
        pProceso.Syncronizacion_Receive();
    }
}
