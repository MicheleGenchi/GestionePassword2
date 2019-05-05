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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author JAVASE
 */
public class ControllerRegistrazione {

    @EJB
    private EmailFacade emailFacade;
    @EJB
    private LoginFacade loginFacade;

    private Login login;
    private Email email;

    @PostConstruct
    private void init() {
        login = new Login();
        email = new Email();
    }

    public String add(Login login) {
        if (!exist()) {
            loginFacade.create(login);
            email.setUtente(login);
            emailFacade.edit(email);
            return "index.xhtml";
        } else {
            return "error.xhtml?messaggio=Utente già registrato";
        }
    }

    private boolean exist() {
        int count = loginFacade.count(login.getUtente());
        return (count >= 1);
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
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Email email) {
        this.email = email;
    }

}
