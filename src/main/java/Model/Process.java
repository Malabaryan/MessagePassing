/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ParameterState;
import Controller.ParametersController;
import Controller.MainController;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryan Hernandez
 */
public class Process {
    
    private Message currentMessage;
    private Mailbox mailboxAssociated;
    public  Queue<Message> messagessend;
    public  Queue<Message> messagesprereceive;
    public  Queue<Message> messagesreceive;
    public  boolean bloqueo;
    private String ID;

    public Process(String pid,Mailbox pMailbox) {
        ID = pid;
        mailboxAssociated = pMailbox;
        messagessend = new LinkedList<Message>();
        messagesprereceive = new LinkedList<Message>();
        messagesreceive = new LinkedList<Message>();
    }
    
    public void Syncronizacion_Send(){
        ParameterState estado = ParametersController.getInstance().getSyncronization_Send();
        if(null == estado){
            bloqueo = false;
        }
        else switch (estado) {
            case Sync_Send_NonBlocking:
                bloqueo = false;
                System.out.print("No Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " No Bloqueado.");
                break;
            case Sync_Send_Blocking:
                bloqueo = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " Bloqueado.");
                break;
            default:
                bloqueo = false;
                break;
        }
    }
    
    
    public void Syncronizacion_Receive(){
        ParameterState estado = ParametersController.getInstance().getSyncronization_Receive();
        if(null == estado){
            bloqueo = false;
        }
        else switch (estado) {
            case Sync_Receive_NonBlocking:
                bloqueo = false;
                System.out.print("No Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " No Bloqueado.");
                break;
            case Sync_Receive_Blocking:
                bloqueo = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " Bloqueado.");
                break;
            case Sync_Receive_ProofOfArrival:
                bloqueo = true;
                System.out.print("Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " Bloqueado.");
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
            if(ParametersController.getInstance().getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                process_send.desbloquear_Test_Arrival();
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",pMessage);
            }
            else{
                process_send.setBloqueo(false);
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",pMessage);
                }
        }
        if(pbloqueo_Receive == true){
            setBloqueo(false);
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
        process.Syncronizacion_Receive();
        process.messagesprereceive.add(pMessage);
    }
    
    public void sendMessage_Indirect(Message pMessage){
        Syncronizacion_Send();
        messagessend.add(pMessage);
        mailboxAssociated.addMessage(pMessage);
    }
    
    public void receiveMessage_Indirect(){
        Message mensaje = mailboxAssociated.messages.getNextMessage();
        Process process_send = MainController.getInstance().getProcess(mensaje.getSourceID());
        boolean pbloqueo_Send = process_send.getBloqueo();
        if(pbloqueo_Send == true){
            if(ParametersController.getInstance().getSyncronization_Receive()==ParameterState.Sync_Receive_ProofOfArrival){
                process_send.desbloquear_Test_Arrival();
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",mensaje);
            }
            else{
                process_send.setBloqueo(false);
                System.out.print("Desbloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " fue desbloqueado.",mensaje);
            }
        }
        boolean pbloqueo_Receive = getBloqueo();
        if(pbloqueo_Receive == true){
            setBloqueo(false);
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
        if(bloqueo == false){
            if(direccionamiento == ParameterState.Addr_Direct_Send){
                sendMessage_Direct(pMessage,ID);
            }
            else if(direccionamiento == ParameterState.Addr_Indirect_Static | direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                if(mailboxAssociated.findList_Send(this.ID)==true){
                    sendMessage_Indirect(pMessage); 
                }
                else{
                    System.out.print("Este Proceso no pertenece a esta mailBox");
                    MainController.getInstance().getUiController().getLogger().addLog("Send: " + this.ID + " no pertenece a esta mailBox",pMessage);
                }
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
        if(bloqueo==false){
            if(messagesprereceive.size()>1){
                    if(direccionamiento == ParameterState.Addr_Direct_Receive_Implicit){
                    receiveMessage_DirectImplicit(messagesprereceive.poll(),ID);
                        return null;
                }
                else if(direccionamiento == ParameterState.Addr_Direct_Receive_Explicit){
                    receiveMessage_DirectImplicit(messagesprereceive.poll(),ID);
                    return MainController.getInstance().getProcess(ID);
                    }
                else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                    if(mailboxAssociated.findList_Receive(ID)==true){
                        receiveMessage_Indirect(); 
                    }
                    else{
                        System.out.print("Este Proceso no pertenece a esta mailBox");
                        MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no pertenece a esta mailBox");
                    }
                    return null;
                }
            }
            else{
                System.out.print("No tiene mensajes para recibir");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no tiene mensajes");        
            }
        }
        else{
            if(messagesprereceive.size()>1){
                boolean destinatario = destinatariodemensaje(ID);
                if(destinatario == true){
                    if(direccionamiento == ParameterState.Addr_Direct_Receive_Implicit){
                        receiveMessage_DirectImplicit(messagesprereceive.poll(),ID);
                            return null;
                    }
                    else if(direccionamiento == ParameterState.Addr_Direct_Receive_Explicit){
                        receiveMessage_DirectImplicit(messagesprereceive.poll(),ID);
                        return MainController.getInstance().getProcess(ID);
                        }
                    else if(direccionamiento == ParameterState.Addr_Indirect_Static || direccionamiento == ParameterState.Addr_Indirect_Dynamic){
                        if(mailboxAssociated.findList_Receive(ID)==true){
                            receiveMessage_Indirect(); 
                        }
                        else{
                            System.out.print("Este Proceso no pertenece a esta mailBox o esta bloqueado");
                            MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no pertenece a esta mailBox o esta bloqueado");
                        }
                        return null;
                    }
                }
                else{
                    System.out.print("Este mensaje no corresponde al destinatario");
                    MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no corresponde al destinatario");
                        
                }
            }
            else{
                System.out.print("Este Proceso no puede recibir Mensajes esta Bloqueado");
                MainController.getInstance().getUiController().getLogger().addLog("Receive: " + this.ID + " no puede recibir Mensajes esta Bloqueado");
            }
        }
        return null;
    }
    
    public void desbloquear_Test_Arrival(){
        setBloqueo(false);
    }
    
    public boolean destinatariodemensaje(String ID){
        Message message = messagesprereceive.peek();
        if(message.getSourceID()==ID){
            return true;
        }
        return false;
    }
    
}
