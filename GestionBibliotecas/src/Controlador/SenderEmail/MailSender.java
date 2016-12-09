/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.SenderEmail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author YUEMEI
 */
public class MailSender {

    private static String mailServerHost = "smtp.gmail.com"; // servidor de smtp
    private static String mailServerPort = "587";  // para protocolo TLS
    private static String fromAddress = "yuemeijiang1970@gmail.com";  //  email de remitente
    private static String userName =  "yuemeijiang1970@gmail.com"; ;  // usuario de email de remitente
    private static String password ="NO1carlos";  // contraseña de email de remitente
//    private String toAddress;   // email de recipiente
//    private String subject;   // asunto
//    private String content;   // contenido
    
//    
//    public MailSender(String toAddress, String subject, String content) {
//        this.toAddress = toAddress;
//        this.subject = subject;
//        this.content = content;
//    }

    public static void sendMessage(String toAddress,String subject, String content) throws AddressException, MessagingException {
        
         // Step 1:  Configure the mail session
        Properties props = new Properties();       
        props.put("mail.smtp.host",mailServerHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.user", fromAddress);
        props.put("mail.password", password);
        props.put("mail.smtp.starttls.enable",true);
        props.put("mail.smtp.port", mailServerPort);
        
         Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        // Step 2:  Construct the message
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
       // InternetAddress to = new InternetAddress(toAddress);
       // message.setRecipient(Message.RecipientType.TO, to);
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
        message.setSubject(subject);
        
        message.setText(content);
        Transport.send(message);
         System.out.println("Sent message successfully....from uma.cc");
    }

    
    

    public static String getMailServerHost() {
        return mailServerHost;
    }

    public static void setMailServerHost(String mailServerHost) {
        MailSender.mailServerHost = mailServerHost;
    }

    public static String getMailServerPort() {
        return mailServerPort;
    }

    public static void setMailServerPort(String mailServerPort) {
        MailSender.mailServerPort = mailServerPort;
    }

    public static String getFromAddress() {
        return fromAddress;
    }

    public static void setFromAddress(String fromAddress) {
        MailSender.fromAddress = fromAddress;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        MailSender.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MailSender.password = password;
    }

  
    
}
