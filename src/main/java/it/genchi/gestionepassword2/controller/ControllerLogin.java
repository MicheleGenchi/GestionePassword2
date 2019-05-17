/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.controller;

import it.genchi.gestionepassword2.beans.EmailFacade;
import it.genchi.gestionepassword2.beans.LoginFacade;
import it.genchi.gestionepassword2.entities.Email;
import it.genchi.gestionepassword2.entities.Login;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.persistence.Query;

/**
 *
 * @author JAVASE
 */
public class ControllerLogin implements Serializable {

    @EJB
    private EmailFacade emailFacade;

    @EJB
    private LoginFacade loginFacade;

    private Login login;

    private List<Email> listEmail;

    private boolean exist = true;

    @PostConstruct
    public void init() {
        login = new Login();
        listEmail = new ArrayList<>();
    }

   public String validate() {
        int count = loginFacade.count(login.getUtente(), login.getPassword());
        if (count >= 1) {
            exist=true;
            return "entra";
        }
        exist=false;
        return "index";
    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return the exist
     */
    public boolean isExist() {
        return exist;
    }

    /**
     * @param exist the exist to set
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

    /**
     * @return the listEmail
     */
    public List<Email> getListEmail() {
        Query q = emailFacade.getEntityManager().createNamedQuery("Email.findByUtente", Email.class).setParameter("utente", login);
        return q.getResultList();
    }

    /**
     * @param listEmail the listEmail to set
     */
    public void setListEmail(List<Email> listEmail) {
        this.listEmail = listEmail;
    }
}
