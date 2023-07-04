package com.example.pw2;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

@WebServlet(name = "inviaMailServlet", value = "/inviaMail")

public class inviaMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Dentro inviaMail");

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop);

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("tum4world@nessunonoluogonoesiste.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("emailContatto")));
            message.setSubject("Mail da " + request.getParameter("nomeCognome") + ", relativa a " + request.getParameter("motiviDiContatto"));



            String msg = "Dettagli: " + request.getParameter("dettagliRichiesta");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            //Transport.send(message);  //L'invio non deve avvenire veramente, come richiesto dalla consegna


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Faccio il redirect");

        response.sendRedirect("confermaInvioMail.jsp");
    }
}
