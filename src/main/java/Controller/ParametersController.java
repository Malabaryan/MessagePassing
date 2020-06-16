/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Bryan Hernandez
 */
public class ParametersController {
    private static ParameterState syncronization_Send;
    private static ParameterState syncronization_Receive;
    private static ParameterState addressing;
    private static ParameterState format;
    private static ParameterState queueStrategy;
    
    
 
    public ParameterState getSyncronization_Send() {
        if (syncronization_Send == null)
            syncronization_Send = ParameterState.Sync_Send_Blocking;
        return syncronization_Send;
    }
    
    public ParameterState getSyncronization_Receive() {
        if (syncronization_Receive == null)
            syncronization_Receive = ParameterState.Sync_Receive_Blocking;
        return syncronization_Receive;


    public static ParameterState getSyncronization() {
        if (syncronization == null)
            syncronization = ParameterState.Sync_Send_Blocking;
        return syncronization;
    }

    public static ParameterState getAddressing() {
        if (addressing == null)
            addressing = ParameterState.Addr_Direct_Send;
        return addressing;
    }

    public static ParameterState getFormat() {
        if (format == null)
            format = ParameterState.Form_Content;
        return format;
    }

    public static ParameterState getQueueStrategy() {
        if (queueStrategy == null)
            queueStrategy = ParameterState.Queue_FIFO;
        return queueStrategy;
    }

    public static void setSyncronization_Send(ParameterState syncronization_Send) {
        ParametersController.syncronization_Send = syncronization_Send;
    }

    public static void setSyncronization_Receive(ParameterState syncronization_Receive) {
        ParametersController.syncronization_Receive = syncronization_Receive;
    }
    

    public static void setAddressing(ParameterState addressing) {
        ParametersController.addressing = addressing;
    }

    public static void setFormat(ParameterState format) {
        ParametersController.format = format;
    }

    public static void setQueueStrategy(ParameterState queueStrategy) {
        ParametersController.queueStrategy = queueStrategy;
    }
    
    
    
    
}
