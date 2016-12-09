/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;

//import gestionbibliotecas.VentanaYuemei;

import Configuracion.*;
import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Manuel
 */




public class ControladorYuemei {
    
     public static int buscarId(String dni){
          int id=10;
            try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_usuario from usuario where dni like ? ";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);            
            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               id = resultado.getInt("id_usuario");
               
                System.out.println("hola yuemei");
            }            
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id usuario.");
            System.err.println(ex);
            return -1;
        }               
        
     }
    
     public static void main(String[] args){
        
  
        System.out.println(ControladorYuemei.buscarId("123"));

    }
    
    
    
    
    
    
    
//     public static void main(String[] args) {
//          VentanaYuemei v= new VentanaYuemei();
//          v.setVisible(true);
//      }
}
