/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogIn;

import Services.CredentialsService;
import Services.InicioDeSesionService;
import Services.MailService;
import Services.ScoreService;
import entities.LmeredithCredentials;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContextEvent;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Liam-Portatil
 */
public class prueba {

    public static void main(String[] args) {
//        boolean a = new CredentialsService().Exists(new Credential("liam", "1234"));
//System.out.print(a);
//        new CredentialsService().insert("m", "a", "e");
//String cuerpo = "http://localhost:8080/AccesoDeDatos_Lander/activacion.html?user=";
//MailService mail = new MailService("holi", "Este es el cuerpo", "liam.meredith.clarke@gmail.com");

//        CredentialsService s = new CredentialsService();
//        LmeredithCredentials c = new LmeredithCredentials("liam", "");
//        s.Exists(c);
//        LmeredithCredentials c =  s.find(new LmeredithCredentials());
//        c.setCredentialActive(true);
//        s.update(true, c);
//        List listado = new ScoreService().getViciats();
//        Object[] o = (Object[]) listado.get(0);
//        LmeredithCredentials c = (LmeredithCredentials) o[0];
//        Long num = (Long) o[1];
//        System.out.print("");
//        em.getTransaction().begin();
//        em.persist(new IniciosDeSesion(1,new Timestamp(System.currentTimeMillis())));
//        em.getTransaction().commit();
//            Calendar cal_1 = Calendar.getInstance();
//    cal_1.add(Calendar.YEAR, -18);
//    Date a = cal_1.getTime();
//    Calendar cal_2 = Calendar.getInstance();
//    cal_2.add(Calendar.YEAR, -25);
//    Date b = cal_2.getTime();
//    query.setParameter("a", a);
//    query.setParameter("b", b);
//
//    SELECT users FROM Users users WHERE users.eventsDate BETWEEN :a AND :b
//        
//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//System.out.print(timestamp + "\n" + new Timestamp(System.currentTimeMillis() - (60*1000*600)));
//        Query q = em.createQuery("SELECT p FROM inicios de sesion p JOIN FETCH p.Us").setParameter("time", new Timestamp(System.currentTimeMillis() - (60*1000*60)));
//        List o = q.getResultList();
//        for(int con = 0; con < o.size(); con++){
//            System.out.println(((IniciosDeSesion) o.get(con)).toString());
//        }
//////        Query query = em.createQuery("SELECT e FROM Credential e");
////        System.out.print(query.toString());
//        em.createNamedQuery("Credential.findAll", Credential.class);
//         System.out.print(new CredentialsService().find(1).toString());
//         System.out.print(new CredentialsService().findEspecific("Admin", "1234").toString());
//   
//    Query queryByName = em.createNamedQuery("Credential.findAll");
//    List l = queryByName.getResultList();
//        System.out.print(l);
//        String texto = "123gfd";
//        String encriptMD5 = DigestUtils.md5Hex(texto);
//        System.out.println("md5:" + encriptMD5);
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDeDatos_LanderPU");
//   
//    EntityManager entityManager = emf.createEntityManager();
//        String sql = "CREATE TABLE public.lmc_user"
//                + "("
//                + "    user_id integer NOT NULL,"
//                + "    user_name text NOT NULL,"
//                + "    user_pass text NOT NULL,"
////                + "    user_email text NOT NULL,"
//                + "    PRIMARY KEY (user_id)\n"
//                + ")"
//                + "WITH ("
//                + "    OIDS = FALSE"
//                + ")"
//                + "TABLESPACE pg_default;"
//                + ""
//                + "ALTER TABLE public.lmc_user"
//                + "    OWNER to postgres;";
//        em.createQuery(sql);
//    Calendar calendar = Calendar.getInstance();
//calendar.set(Calendar.YEAR, 1990);
//calendar.set(Calendar.DAY_OF_MONTH, 1);
//calendar.set(Calendar.MONTH, 4); // Assuming you wanted May 1st
//
//java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
//            System.out.println(LocalDateTime.now());
//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp1);
//        System.out.println(timestamp2);
//        System.out.println(timestamp2.getTime() - timestamp1.getTime());
//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
//        new InicioDeSesionService().insert(3, timestamp);
//CredentialsService usuario = new CredentialsService();
//            List a = usuario.find("liam");
//            System.out.print("");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDeDatos_LanderPU");
        EntityManager entityManager = emf.createEntityManager();

        LmeredithCredentials c = entityManager.find(LmeredithCredentials.class, 1);
        entityManager.getTransaction().begin();
        c.setCredentialActive(true);
        entityManager.getTransaction().commit();

    }
}
