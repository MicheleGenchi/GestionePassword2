/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.controller;

import it.genchi.gestionepassword2.beans.EmailFacade;
import it.genchi.gestionepassword2.beans.LoginFacade;
import it.genchi.gestionepassword2.beans.SitoFacade;
import it.genchi.gestionepassword2.beans.TipoFacade;
import it.genchi.gestionepassword2.entities.Email;
import it.genchi.gestionepassword2.entities.Login;
import it.genchi.gestionepassword2.entities.Sito;
import it.genchi.gestionepassword2.entities.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.persistence.Query;


/**
 *
 * @author JAVASE
 */
public class Controller {

    @EJB
    private SitoFacade sitoFacade;

    @EJB
    private TipoFacade tipoFacade;

    @EJB
    private EmailFacade emailFacade;

    @EJB
    private LoginFacade loginFacade;

    private  Login login;
    private  Email email;
    private Tipo tipo;
    private Sito sito;
    private List<Email> listEmail;
    private List<Tipo> listTipo;

            
    private boolean exist = true;

    @PostConstruct
    public void init() {
        login = new Login();
        email = new Email();
        listEmail=login.getEmailList();
        listTipo=new ArrayList<>();
    }

    public String validate() {
        int count = loginFacade.count(getLogin().getUtente(), getLogin().getPassword());
        if (count >= 1) {
            return "entra";
        } 
        return "index";
    }

    public String add() {
        loginFacade.create(getLogin());
        getEmail().setUtente(getLogin());
        emailFacade.edit(getEmail());
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
        Query q=emailFacade.getEntityManager().createNamedQuery("Email.findByUtente", Email.class).setParameter("utente", getLogin());
        return q.getResultList();
    }

    /**
     * @param listEmail the listEmail to set
     */
    public void setListEmail(List<Email> listEmail) {
        this.listEmail = listEmail;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the sito
     */
    public Sito getSito() {
        return sito;
    }

    /**
     * @param sito the sito to set
     */
    public void setSito(Sito sito) {
        this.sito = sito;
    }

    /**
     * @param listTipo the listTipo to set
     */
    public void setListTipo(List<Tipo> listTipo) {
        this.listTipo = listTipo;
    }

    /**
     * @return the mapTipo
     */
    public List<Tipo> getListTipo() {
        return tipoFacade.findAll();
    }

}
