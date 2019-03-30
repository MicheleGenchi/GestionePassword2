/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Sito;
import javax.ejb.Stateless;

/**
 *
 * @author JAVASE
 */
@Stateless
public class SitoFacade extends AbstractFacade<Sito> {

    public SitoFacade() {
        super(Sito.class);
    }
    
}
