/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithScore;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Liam-Portatil
 */
public class ScoreDAOImpl extends GenericDAOImpl<LmeredithScore> implements ScoreDAO {

    @Override
    public List top10scores() {
        Query q = this.entityManager.createQuery("SELECT i FROM LmeredithScore i order by i.scoreValue asc").setMaxResults(10);
        return q.getResultList();
    }

    @Override
    public List top10viciats() {
        Query q = this.entityManager.createQuery("SELECT i.credentialId, count(i.credentialId) c FROM LmeredithScore i group by i.credentialId order by c desc").setMaxResults(10);
        return q.getResultList();
    }

}
