/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Liam-Portatil
 */
public class MailService {

    private String user = "lander.supp1";
    private String pass = "lander1234";
    private String asunto;
    private String cuerpo;
    private String destino;

    public MailService(String asunto, String cuerpo, String destino) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.destino = destino;

        // Establece las propiedades de la conexión.
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Se conecta a la cuenta de emisión del correo.
        Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // Prepara el correo con los datos establecidos.
        MimeMessage mail = new MimeMessage(session);
        MimeBodyPart mailBody = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();

        try {
            mail.setFrom(new InternetAddress(user));

            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));

            mail.setSubject(asunto);

            // Con el cuerpo del correo generado así, permite formatearlo mediante
            // código html, como insertar links, etc.
            mailBody.setText(cuerpo, "UTF-8", "html");

            multipart.addBodyPart(mailBody);

            mail.setContent(multipart);

            // Envía el correo
            Transport.send(mail);
        } catch (MessagingException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
