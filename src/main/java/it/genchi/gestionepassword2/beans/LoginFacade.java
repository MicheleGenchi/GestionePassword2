/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Login;
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
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Login> rt = cq.from(Login.class);
        cq.where(
                em.getCriteriaBuilder().equal(rt.get("utente"), user),
                em.getCriteriaBuilder().equal(rt.get("password"), password)
        );
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

        public int count(String utente) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Login> rt = cq.from(Login.class);
        cq.where(
                em.getCriteriaBuilder().equal(rt.get("utente"), utente)
        );
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
