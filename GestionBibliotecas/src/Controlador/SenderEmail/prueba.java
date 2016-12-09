/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.SenderEmail;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author YUEMEI
 */
public class prueba {
     public static void main(String[] args){
        String toAddress="yuemeijiang1991@163.com,manoloht09@gmail.com";   // lista de email de recipientes
        String subject="felicidad de la fiesta!";   // asunto
        String content="esto es una prueba.";   // contenido
         try {
             MailSender.sendMessage(toAddress, subject, content);
         } catch (MessagingException ex) {
             Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
     }
    
}
