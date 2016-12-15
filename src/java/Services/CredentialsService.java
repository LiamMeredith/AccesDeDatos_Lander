/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.CredentialsDAOImpl;
import entities.LmeredithCredentials;
import java.util.List;

/**
 *
 * @author Liam-Portatil
 */
public class CredentialsService {

    private CredentialsDAOImpl dao = new CredentialsDAOImpl();

    public LmeredithCredentials find(int id) {
        LmeredithCredentials aux = dao.find(id);
        try {
            if (aux == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException ex) {
            System.out.println("Credentials no existe");
            return new LmeredithCredentials();
        }
        return aux;
    }

    public boolean Exists(int id) {
        return dao.find(id) != null;
    }

    public boolean Exists(LmeredithCredentials c) {
        List<LmeredithCredentials> aux = dao.findByName(c.getCredentialName());
        if (aux.isEmpty()) {
            return false;
        }
        LmeredithCredentials caux;
        for (int con = 0; con < aux.size(); con++) {
            caux = aux.get(con);
            if (caux.getCredentialName().equals(c.getCredentialName()) && caux.getCredentialPass().equals(c.getCredentialPass())) {
                return true;
            }
        }
        return false;
    }

    public List find(String name) {
        return dao.findByName(name);
    }



    public LmeredithCredentials findEspecific(LmeredithCredentials c) {
        List<LmeredithCredentials> aux = dao.findByName(c.getCredentialName());
        if (aux.isEmpty()) {
            return null;
        }
        LmeredithCredentials caux;
        for (int con = 0; con < aux.size(); con++) {
            caux = aux.get(con);
            if (caux.getCredentialName().equals(c.getCredentialName()) && caux.getCredentialPass().equals(c.getCredentialPass())) {
                return caux;
            }
        }
        return null;
    }

    public void update(boolean b, LmeredithCredentials c) {
        dao.changeBoolean(b, c);
    }

    public void insert(String name, String pass, String email) {
        dao.add(new LmeredithCredentials(name, pass, email, false));
    }

}
