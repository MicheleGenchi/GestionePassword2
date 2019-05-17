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
    private LoginFacade loginFacade;

    @EJB
    private EmailFacade emailFacade;
    

    private Tipo tipo;
    private Sito sito;
    private Email email;
    private List<Sito> listSiti;
             
    @PostConstruct
    public void init() {
        tipo=new Tipo();
        tipo.setIdTipo("AQ");
        tipo.setDescrizione("ACQUISTO");
        email=new Email();
        listSiti=new ArrayList<>();
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
     * @return the mapTipo
     */
    public List<Tipo> getListTipo() {
        return tipoFacade.findAll();
    }

    
       
    /**
     * @param login
     * @param tipo
     * @return the listSiti
     */
    public List<Sito> getListSiti(Login login) {
           Query q=sitoFacade.getEntityManager().createNamedQuery("Siti.findByTipo", Sito.class).setParameter("login", login).setParameter("idTipo", tipo);
        return q.getResultList();
    }

}
