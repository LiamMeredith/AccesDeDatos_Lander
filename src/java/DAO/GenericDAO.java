/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public interface GenericDAO<T> {

    //inputs object
    void add(T t);

    //delets object
    void remove(int id);

    //returns object if exists
    T find(int id);

    //updates existing object
    void update(T t);
    
    //find all
    List<T> findAll();
}