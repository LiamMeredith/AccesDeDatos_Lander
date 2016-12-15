/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithInicioDeSesion;
import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public interface InicioDeSesionDAO extends GenericDAO<LmeredithInicioDeSesion> {

    //Get if under 60 min
    List LoggedLast60min();
    
    //find name
    String findName();
}
