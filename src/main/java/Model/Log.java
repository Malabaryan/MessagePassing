/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Bryan Hernandez
 */
class Log {
    
    private Message msg;
    private Date timeStamp;

    public Log(Message msg, Date timeStamp) {
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Log(Message msg) {
        this.msg = msg;
        timeStamp = new Date();
    }

    public String getTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");   
        return formatter.format(timeStamp);
    }

    public Message getMsg() {
        return msg;
    }
    
}
