/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogIn;

import Services.CredentialsService;
import Services.MailService;
import entities.LmeredithCredentials;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Liam-Portatil
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

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
        processRequest(request, response);
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
        array[1] = DigestUtils.md5Hex(array[1]);
        boolean exist = credentialsVerification(array[0], array[1]);
        if (!exist) {
            new CredentialsService().insert(array[0], array[1], array[2]);
            String cuerpo = "http://localhost:8080/AccesoDeDatos_Lander/activacion.html?user=";
            
            new MailService("Registro", cuerpo + array[0], array[2]);

//            CredentialsService usuario = new CredentialsService();
//            List lis = usuario.find(array[0]);
//            LmeredithCredentials c = null;
//            if (lis.size() == 1) {
//                c = (LmeredithCredentials) lis.get(0);
//                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//                new InicioDeSesionService().insert(c.getCredentialId(), timestamp);
//            }
        }

//        JSONObject jObj = new JSONObject();
//        jObj.put("boolean", String.valueOf(!exist));
//        jObj.put("name", array[0]);
//        jObj.put("pass", array[1]);
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().print(jObj);
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
