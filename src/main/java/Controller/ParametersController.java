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
public  class ParametersController {
    private static ParameterState syncronization;
    private static ParameterState addressing;
    private static ParameterState format;
    private static ParameterState queueStrategy;

    public ParameterState getSyncronization() {
        if (syncronization == null)
            syncronization = ParameterState.Sync_Send_Blocking;
        return syncronization;
    }

    public ParameterState getAddressing() {
        if (addressing == null)
            addressing = ParameterState.Addr_Direct_Send;
        return addressing;
    }

    public ParameterState getFormat() {
        if (format == null)
            format = ParameterState.Form_Content;
        return format;
    }

    public ParameterState getQueueStrategy() {
        if (queueStrategy == null)
            queueStrategy = ParameterState.Queue_FIFO;
        return queueStrategy;
    }
    
    
}
