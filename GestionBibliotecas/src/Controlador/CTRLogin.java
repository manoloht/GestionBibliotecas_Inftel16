/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Configuracion.Conexion;
import Controlador.SenderEmail.MailSender;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author alberto carrion leiva
 */
public class CTRLogin {
    // COMPROBAR SI EXISTE EMAIL Y PASS EN BD, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarLogin(String email, String password){
        boolean comprueba;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from usuario where email like ? and password like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultado = pstmt.executeQuery();
            comprueba = resultado.next();
            con.close();
            return comprueba;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el Login. CTRLogin.comprobarLogin");
            System.err.println(ex);
            return false;
        }
    }
    
    // OBTENER EL TIPO DE USUARIO, DEVOLVER 0, 1 , 2 (0 - ADMIN, 1 - BIBLIOTECARIO, 2 - ESTUDIANTE) 
    public static int getTipoUsuario(String email, String password) {
        int tipoUsuario = -1;
        boolean comprueba;
        boolean comprueba2;
        boolean comprueba3;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            
            String consulta = "select * from usuario u where EXISTS (select id_usuario from admin e where u.id_usuario = e.id_usuario) and dni like '" + email + "'";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            comprueba = resultado.next();
            
            String consulta2 = "select * from usuario u where EXISTS (select id_usuario from bibliotecario e where u.id_usuario = e.id_usuario) and dni like '" + email + "'";
            Statement stmt2 = con.createStatement();
            ResultSet resultado2 = stmt2.executeQuery(consulta2);
            comprueba2 = resultado2.next();
            
            String consulta3 = "select * from usuario u where EXISTS (select id_usuario from estudiante e where u.id_usuario = e.id_usuario) and dni like '" + email + "'";
            Statement stmt3 = con.createStatement();
            ResultSet resultado3 = stmt3.executeQuery(consulta3);
            comprueba3 = resultado3.next();
            
            if(comprueba){
                tipoUsuario = 0;
            }else if(comprueba2){
                tipoUsuario = 1;
            }else if(comprueba3){
                tipoUsuario = 2;
            }

            con.close();
            return tipoUsuario;
        }
        catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el Login. CTRLogin.comprobarLogin");
            System.err.println(ex);
            return -1;
        }
}
    
    // FUNCION PARA ENVIAR EMAIL DE RECORDAR CONTRASEÑA, DEVOLVER TRUE EN CASO DE ENVIARLO, FALSE EN OTRO CASO
    public static boolean enviarMensaje(String email)  {
            String Asunto="¡Recordar contraseña!";    
            Usuario u=Util.buscarUsuario(email);
            String password=u.getPassword();
            String nombre=u.getNombre();
            String contenido="Hola "+nombre+":\n" + "Estos son sus datos de acceso:"+"Dirección email:"+email+"Contraseña:"+password;
            
        try {
            MailSender.sendMessage(email, Asunto,contenido);
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(CTRLogin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
 
}}
