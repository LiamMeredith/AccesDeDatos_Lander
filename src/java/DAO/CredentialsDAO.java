/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.LmeredithCredentials;
import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public interface CredentialsDAO extends GenericDAO<LmeredithCredentials> {

    //Find by name
    List findByName(String s);
    
    //Modify boolean
    void changeBoolean(boolean b, LmeredithCredentials c);
}
