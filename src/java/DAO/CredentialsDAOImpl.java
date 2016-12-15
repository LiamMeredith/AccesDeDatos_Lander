/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithCredentials;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Liam-Portatil
 */
public class CredentialsDAOImpl extends GenericDAOImpl<LmeredithCredentials> implements CredentialsDAO {
    
    @Override
    public List<LmeredithCredentials> findByName(String s) {
        Query queryByName = this.entityManager.createNamedQuery("LmeredithCredentials.findByCredentialName");
        queryByName.setParameter("credentialName", s);
        return queryByName.getResultList();
    }
    
    @Override
    public void changeBoolean(boolean b, LmeredithCredentials c) {
        this.entityManager.getTransaction().begin();
        c.setCredentialActive(b);
        this.entityManager.getTransaction().commit();
    }
    
}
