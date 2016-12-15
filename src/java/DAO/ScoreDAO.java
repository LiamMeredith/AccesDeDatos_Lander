/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithScore;
import java.util.List;



/**
 *
 * @author Liam-Portatil
 */
public interface ScoreDAO extends GenericDAO<LmeredithScore> {
    
    //top scores
    public List top10scores();
    
    //top viciats
    public List top10viciats();
    
}
