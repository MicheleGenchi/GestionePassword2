/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Email;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author JAVASE
 */
@Stateless
public class EmailFacade extends AbstractFacade<Email> {

    public EntityManager getEntityManager() {
        return em;
    }

    public EmailFacade() {
        super(Email.class);
    }
    

}
