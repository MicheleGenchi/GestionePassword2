/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Tipo;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.Stateless;

/**
 *
 * @author JAVASE
 */
@Stateless
public class TipoFacade extends AbstractFacade<Tipo> {


    public TipoFacade() {
        super(Tipo.class);
    }
    
    public void convertInMap(List<Tipo> list, Map<String, String> map) {
        map=new TreeMap<>();
        for (Tipo tipo: list) {
            map.put(tipo.getIdTipo(), tipo.getDescrizione());
        }
    }
    
}
