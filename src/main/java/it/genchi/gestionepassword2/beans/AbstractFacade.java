/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import it.genchi.gestionepassword2.entities.Login;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 *
 * @author JAVASE
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    @PersistenceContext(unitName = "pu")
    protected EntityManager em;

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public synchronized void create(T entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
           // em.clear();
        } 
    }

    @Transactional
    public synchronized void edit(T entity) {
        try {
            em.merge(entity);
        } catch (Exception e) {
            em.clear();
        }
    }

    @Transactional
    public synchronized void remove(T entity) {
        try {
            em.remove(em.merge(entity));
        } catch (Exception e) {
            em.clear();
        } finally {
            em.close();
        }
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int count(Map<String, String> map) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Login> rt = cq.from(Login.class);
        for (Map.Entry e : map.entrySet()) {
            cq.where(
                    em.getCriteriaBuilder().equal(rt.get(e.getKey().toString()), e.getValue())
            );
        }
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
