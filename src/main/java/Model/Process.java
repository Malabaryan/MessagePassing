/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ParameterState;
import Controller.ParametersController;
import Controller.MainController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryan Hernandez
 */
public class Process {
    
    private Message currentMessage;
    private Mailbox mailboxAssociated;
    public  ArrayList<Message> messagessend = new ArrayList<Message>();
    public  ArrayList<Message> messagesprereceive = new ArrayList<Message>();
    public  ArrayList<Message> messagesreceive = new ArrayList<Message>();
    public  boolean bloqueo_enviar;
    public  boolean bloqueo_recibir;
    private String ID;

    public Process(String pid,Mailbox pMailbox) {
        ID = pid;
        mailboxAssociated = pMailbox;
        currentMessage = new Message();
    }
    
    public void Syncronizacion_Send(){
        ParameterState estado = ParametersController.getInstance().getSyncronization_Send();
        if(null == estado){
            bloqueo_enviar = false;
        }
        else switch (estado) {
            case Sync_Send_NonBlocking:
                bloqueo_enviar = false;
                System.out.print("No Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " No Bloqueado.", new Message());
                break;
            case Sync_Send_Blocking:
                bloqueo_enviar = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " Bloqueado.", new Message());
                break;
            default:
                bloqueo_enviar = false;
                break;
        }
    }
    
    
    public void Syncronizacion_Receive(){
        ParameterState estado = ParametersController.getInstance().getSyncronization_Receive();
        if(null == estado){
            bloqueo_recibir = false;
        }
        else switch (estado) {
            case Sync_Receive_NonBlocking:
                bloqueo_recibir = false;
                System.out.print("No Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " No Bloqueado.", new Message());
                break;
            case Sync_Receive_Blocking:
                bloqueo_recibir = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " Bloqueado.", new Message());
                break;
            case Sync_Receive_ProofOfArrival:
                bloqueo_recibir = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " Bloqueado.", new Message());
                break;
            default:
                bloqueo_recibir = false;
                break;
        }
    }

    public void setBloqueo_enviar(boolean bloqueo_enviar) {
        this.bloqueo_enviar = bloqueo_enviar;
    }

    public void setBloqueo_recibir(boolean bloqueo_recibir) {
        this.bloqueo_recibir = bloqueo_recibir;
    }

    public String getID() {
        return ID;
    }

    public boolean getBloqueo_enviar() {
        return bloqueo_enviar;
    }

    public boolean getBloqueo_recibir() {
        return bloqueo_recibir;
    }
    
    
    public void receiveMessage_DirectImplicit(Message pMessage,String ID){
        Process process_send = MainController.getInstance().getProcess(ID);
        boolean pbloqueo_Send = process_send.getBloqueo_enviar();
        boolean pbloqueo_Receive = getBloqueo_recibir();
        if(pbloqueo_Send == true){
            if(ParametersController.getInstance().getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                process_send.desbloquear_Test_Arrival();
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",pMessage);
            }
            else{
                process_send.setBloqueo_enviar(false);
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",pMessage);
                }
        }
        if(pbloqueo_Receive == true){
            setBloqueo_recibir(false);
            System.out.print("Desbloqueado");
            MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",pMessage);
            messagesreceive.add(pMessage);
        }
        else{
            messagesreceive.add(pMessage);
        }
    }
    
    public void sendMessage_Direct(Message pMessage,String ID){
        Syncronizacion_Send();
        messagessend.add(pMessage);
        Process process = MainController.getInstance().getProcess(ID);
        process.currentMessage = pMessage;
        process.Syncronizacion_Receive();
    }
    
    public void sendMessage_Indirect(Message pMessage){
        Syncronizacion_Send();
        messagessend.add(pMessage);
        MainController.getInstance().getMailbox().addMessage(pMessage);
    }
    
    public void receiveMessage_Indirect(){
        Message mensaje = MainController.getInstance().getMailbox().messages.getNextMessage();
        if(mensaje==null){
            mensaje = new Message("2","1","hola");
        }
        Process process_send = MainController.getInstance().getProcess(mensaje.getSourceID());
        boolean pbloqueo_Send = process_send.getBloqueo_enviar();
        if(pbloqueo_Send == true){
            if(ParametersController.getInstance().getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                process_send.desbloquear_Test_Arrival();
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",mensaje);
            }
            else{
                process_send.setBloqueo_enviar(false);
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",mensaje);
            }
        }
        boolean pbloqueo_Receive = getBloqueo_recibir();
        if(pbloqueo_Receive == true){
            setBloqueo_enviar(false);
            System.out.print("Desbloqueado");
            MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",mensaje);
            messagesreceive.add(mensaje);
        }
        else{
            messagesreceive.add(mensaje);
        }
        mensaje.setDestinationID(ID);
    }
    
    public void sendMessage(Message pMessage,String ID){
        ParameterState direccionamiento = ParametersController.getInstance().getAddressing_Send();
        if(bloqueo_enviar == false){
            if(direccionamiento == ParameterState.Addr_Direct_Send){
                sendMessage_Direct(pMessage,ID);
            }
            else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                //if(MainController.getInstance().getMailbox().findList_Send(this.ID)==true){
                    sendMessage_Indirect(pMessage); 
                //}
                //else{
                //    System.out.print("Este Proceso no pertenece a esta mailBox");
                //    MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " no pertenece a esta mailBox",pMessage);
                //}
            }
            else{
                System.out.print(ParametersController.getInstance().getAddressing_Send().toString());
            }
        }
        else{
            System.out.print("Este Proceso esta bloqueado no puede enviar");
            MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " esta bloqueado no puede enviar",pMessage);
        }
    }
    
    public Process receiveMessage(String ID){
        ParameterState direccionamiento = ParametersController.getInstance().getAddressing_Receive();
        if(bloqueo_recibir==false){
            if(currentMessage!=null){
                if(direccionamiento == ParameterState.Addr_Direct_Receive_Implicit){
                    receiveMessage_DirectImplicit(currentMessage,ID);
                        return null;
                }
                else if(direccionamiento == ParameterState.Addr_Direct_Receive_Explicit){
                    receiveMessage_DirectImplicit(currentMessage,ID);
                    return MainController.getInstance().getProcess(ID);
                }
                else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                    //if(MainController.getInstance().getMailbox().findList_Receive(ID)==true){
                        receiveMessage_Indirect(); 
                    //}
                    //else{
                    //    System.out.print("Este Proceso no pertenece a esta mailBox");
                    //    MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no pertenece a esta mailBox",currentMessage);
                    //}
                    return null;
                }
            }
            else{
                System.out.print("No tiene mensajes para recibir");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no tiene mensajes",currentMessage);        
            }
        }
        else{
            if(messagesprereceive.size()>=1){
                boolean destinatario = destinatariodemensaje(ID);
                if(destinatario == true){
                    if(direccionamiento == ParameterState.Addr_Direct_Receive_Implicit){
                        receiveMessage_DirectImplicit(currentMessage,ID);
                            return null;
                    }
                    else if(direccionamiento == ParameterState.Addr_Direct_Receive_Explicit){
                        receiveMessage_DirectImplicit(currentMessage,ID);
                        return MainController.getInstance().getProcess(ID);
                        }
                    else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                        if(MainController.getInstance().getMailbox().findList_Receive(ID)==true){
                            receiveMessage_Indirect(); 
                        }
                        else{
                            System.out.print("Este Proceso no pertenece a esta mailBox o esta bloqueado");
                            MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no pertenece a esta mailBox o esta bloqueado",currentMessage);
                        }
                        return null;
                    }
                }
                else{
                    System.out.print("Este mensaje no corresponde al destinatario");
                    MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no corresponde al destinatario",currentMessage);
                        
                }
            }
            else{
                System.out.print("Este Proceso no puede recibir Mensajes esta Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no puede recibir Mensajes esta Bloqueado",currentMessage);
            }
        }
        return null;
    }
    
    public void desbloquear_Test_Arrival(){
        setBloqueo_enviar(false);
    }
    
    public boolean destinatariodemensaje(String ID){
        Message message = messagesprereceive.get(0);
        if(message.getSourceID().equals(ID)){
            return true;
        }
        return false;
    }
    
    public void agregarprereceive(Message mensaje){
        this.messagesprereceive.add(mensaje);
    }
    
    public Message poll(){
        Message mensaje = this.messagesprereceive.get(0);
        this.messagesprereceive.remove(0);
        
        return mensaje;
    }
}
