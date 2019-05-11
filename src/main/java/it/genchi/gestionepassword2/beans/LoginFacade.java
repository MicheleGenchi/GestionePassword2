/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Login;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author JAVASE
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    public LoginFacade() {
        super(Login.class);
    }

    
    public int count(String user, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("utente", user);
        map.put("password", password);
        return super.count(map);
    }    
    
    public int count(String user) {
        Map<String, String> map = new HashMap<>();
        map.put("utente", user);
        return super.count(map);
    }

}
