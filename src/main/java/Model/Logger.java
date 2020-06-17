/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bryan Hernandez
 */
public class Logger {
    
    private ArrayList<Log> logger;  

    public Logger() {
        logger = new ArrayList();
    }
    
    public void addLog(Log log){
        logger.add(log);
    }
    
    public void addLog(Message msg, Date date){
        logger.add(new Log(msg,date));
    }

    public void addLog(String msg, Date date){
        logger.add(new Log(new Message(msg),date));
    }
    
    public void addLog(String msg){
        logger.add(new Log(new Message(msg), new Date()));
    }
    
}
