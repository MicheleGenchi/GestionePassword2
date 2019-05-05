/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAVASE
 */
public class ErrMsg {
    private List<String> msgs;

    public ErrMsg() {
        this.msgs = new ArrayList<>();
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
    }
    
     public List<String> getMsgs() {
        return msgs;
    }

    public void aggiungi(String msg) {
        msgs.add(msg);
    }
    
    public void aggiungi(Errors msg) {
        msgs.add(msg.getDescrizione());
    }
    
    public boolean isErr() {
        return !msgs.isEmpty();
    }
    
    public void clear() {
        msgs.clear();
    }
}

