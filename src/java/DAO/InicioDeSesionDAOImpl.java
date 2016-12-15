/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithInicioDeSesion;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Liam-Portatil
 */
public class InicioDeSesionDAOImpl extends GenericDAOImpl<LmeredithInicioDeSesion> implements InicioDeSesionDAO {

    @Override
    public List LoggedLast60min() {
        Query q = this.entityManager.createQuery("SELECT i FROM LmeredithInicioDeSesion i WHERE i.inicioDeSesionTimestamp >= :time").setParameter("time", new Timestamp(System.currentTimeMillis() - (60*1000*60))).setMaxResults(5);
        return q.getResultList();
    }

    @Override
    public String findName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
