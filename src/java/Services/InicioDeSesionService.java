/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.InicioDeSesionDAOImpl;
import entities.LmeredithCredentials;
import entities.LmeredithInicioDeSesion;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public class InicioDeSesionService {

    private InicioDeSesionDAOImpl dao = new InicioDeSesionDAOImpl();

    public void insert(int userid, Timestamp timestamp) {
        dao.add(new LmeredithInicioDeSesion(new LmeredithCredentials(userid), timestamp));
    }

    public List<LmeredithInicioDeSesion> lastLoggeIn() {
        return dao.LoggedLast60min();
    }

}
