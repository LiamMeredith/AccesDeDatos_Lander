/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogIn;

import Services.CredentialsService;
import Services.InicioDeSesionService;
import entities.LmeredithCredentials;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;

/**
 *
 * @author Liam-Portatil
 */
public class LogInServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] info = new String[2];
        info[0] = request.getParameter("name");
        info[1] = request.getParameter("pass");

        JSONObject jObj = new JSONObject();
        if (info[0] == null || info[1] == null) {
            jObj.put("boolean", "false");
        } else {
            boolean aux = credentialsVerification(info[0], info[1]);
            LmeredithCredentials cr = (LmeredithCredentials) new CredentialsService().find(info[0]).get(0);
            aux = aux && cr.getCredentialActive();
            jObj.put("boolean", String.valueOf(aux));
        }
        jObj.put("name", info[0]);
        jObj.put("pass", info[1]);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jObj);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] a = retriveData(request);
        a[1] = DigestUtils.md5Hex(a[1]);

        JSONObject jObj = new JSONObject();
        boolean exito = credentialsVerification(a[0], a[1]);
        LmeredithCredentials cr = (LmeredithCredentials) new CredentialsService().find(a[0]).get(0);
        exito = exito && cr.getCredentialActive();
        jObj.put("boolean", String.valueOf(exito));
        jObj.put("name", a[0]);
        jObj.put("pass", a[1]);

        if (exito) {
            CredentialsService usuario = new CredentialsService();
            List lis = usuario.find(a[0]);
            LmeredithCredentials c = null;
            if (lis.size() == 1) {
                c = (LmeredithCredentials) lis.get(0);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                new InicioDeSesionService().insert(c.getCredentialId(), timestamp);
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jObj);
    }

    private String[] retriveData(HttpServletRequest request) {
        //Gets selected value from options POST
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = request.getReader();
        } catch (IOException ex) {
            Logger.getLogger(LogInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = "";
        try {
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        str = sb.toString();
        str = str.replaceAll("\"", "");
        str = str.replaceAll("\\{", "");
        str = str.replaceAll("\\}", "");
        String[] array = str.split(",");
        for (int con = 0; con < array.length; con++) {
            array[con] = array[con].split(":")[1];
        }
        return array;
    }

    private boolean credentialsVerification(String name, String pass) {
        return new CredentialsService().Exists(new LmeredithCredentials(name.toLowerCase(), pass));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
