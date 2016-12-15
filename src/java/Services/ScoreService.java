/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ScoreDAOImpl;
import entities.LmeredithCredentials;
import entities.LmeredithScore;
import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public class ScoreService {

    private ScoreDAOImpl dao = new ScoreDAOImpl();

    public void insert(int userid, double score) {
        dao.add(new LmeredithScore(new LmeredithCredentials(userid), score));
    }

    public List getScores() {
        return dao.top10scores();
    }
    
    public List getViciats(){
        return dao.top10viciats();
    }
}
