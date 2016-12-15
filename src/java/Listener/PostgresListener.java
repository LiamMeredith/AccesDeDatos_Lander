/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Liam-Portatil
 */
public class PostgresListener implements ServletContextListener {

    private static EntityManagerFactory emf;
    @PersistenceContext
    private static EntityManager entityManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("AccesoDeDatos_LanderPU");
        entityManager = emf.createEntityManager();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        emf.close();
        entityManager.close();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
