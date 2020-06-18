/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Bryan Hernandez
 */
public class Logger {
    
    private ArrayList<Log> logger;  
    private HashMap<String,Log> logHash;

    public Logger() {
        logger = new ArrayList();
    }
    
    public void addLog(Log log){
        logger.add(log);
        logHash.put(log.getMsg().getSourceID(), log);
    }
    
    public void addLog(Message msg, Date date){
        logger.add(new Log(msg,date));
    }

    public void addLog(String msg){
        logger.add(new Log(new Message(msg), new Date()));
    }
    
    public void addLog(String txt, Message msg){
        logger.add(new Log(msg, txt));
    }

    public ArrayList<Log> getLogger() {
        return logger;
    }
    
    
    
}
