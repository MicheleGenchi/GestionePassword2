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
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;


/**
 *
 * @author JAVASE
 */
public class Controller {

    @EJB
    private EmailFacade emailFacade;

    @EJB
    private LoginFacade loginFacade;

    private  Login login;
    private  Email email;
    private List<Email> listEmail;
    private boolean exist = true;

    public Controller() {
        login = new Login();
        email = new Email();
        listEmail=login.getEmailList();
    }

    public String validate() {
        int count = loginFacade.count(getLogin().getUtente(), getLogin().getPassword());
        if (count >= 1) {
            return "entra";
        } 
        return "index";
    }

    public String add() {
        loginFacade.create(login);
        email.setUtente(login);
        emailFacade.edit(email);
        return "index.xhtml";
    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
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
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * @return the listEmail
     */
    public List<Email> getListEmail() {
        Query q=emailFacade.getEntityManager().createNamedQuery("Email.findByUtente", Email.class).setParameter("utente", login);
        return q.getResultList();
    }

    /**
     * @param listEmail the listEmail to set
     */
    public void setListEmail(List<Email> listEmail) {
        this.listEmail = listEmail;
    }
}
