/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.SenderEmail;
import Configuracion.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
/**
 *
 * @author YUEMEI
 */
public class Mensaje {
    
    public static void RegistrarUsuario(Usuario u){
        
        String toAddress ;//email de recipientes
        String subject="¡Bienvenido!";   // asunto
        String nombre;
        String contenido;
        String password;
        toAddress=u.getEmail();
        password=u.getPassword();
        nombre=u.getNombre();
        
        contenido="Hola "+nombre+":"+"informamos que ha creado una cuenta en nuestro sistema."
                + "Estos son sus datos de acceso:"+"Dirección email:"+toAddress+"Contraseña:"+password;
       
        try {
            MailSender.sendMessage(toAddress, subject, contenido);
        } catch (MessagingException ex) {
            Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public static void RecuperarPassword(String email){
        
        
        String subject="¡Recuperar contraseña!";   // asunto
        String nombre = null;
        String contenido;
        String password = null;
        
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from usuario where email like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();

            pstmt.setString(1, email);            
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()){
                nombre = resultado.getString("nombre");
                password = resultado.getString("password");
            }
            
         
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar usuario por email");
            System.err.println(ex);
           
        }
//        
        
        contenido="Hola "+nombre+":" + "Estos son sus datos de acceso:"+"Dirección email:"+email+"Contraseña:"+password;
       
        try {
            MailSender.sendMessage(email, subject, contenido);
        } catch (MessagingException ex) {
            Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
        }    
      
    }
      public static void InformacionPrestamo(Prestamo p){
        String subject="¡Informe de prestamo!";   // asunto
        String nombre = null;
        String titulo_libro;
        String bibliteca;
        String categoria;
        String contenido;
        String fecha_devolucion;
        
//        int id_libro=p.();
//        int id_bib=p.getId_bib();
//        int id_cat=p.getId_cat();
        
       
            
        }
}

