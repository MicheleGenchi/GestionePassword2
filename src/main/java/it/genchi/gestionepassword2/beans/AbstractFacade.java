/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.beans;

import java.util.List;
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

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public synchronized boolean create(T entity) {
        boolean success = false;
             try {
                em.persist(entity);
                success = true;
                return success;
            } catch (Exception e) {
                em.clear();
            } finally {
                em.close();
                return success;
            }
    }
 
    @Transactional
    public synchronized void edit(T entity) {
        try { 
            em.merge(entity);
        } catch (Exception e) {
            em.clear();
        } finally {
           em.close();
        }
    }

    @Transactional
    public synchronized void remove(T entity) {
        try {
        em.remove(em.merge(entity));
        } 
        catch (Exception e) {
           em.clear();
        } finally  {
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

}
