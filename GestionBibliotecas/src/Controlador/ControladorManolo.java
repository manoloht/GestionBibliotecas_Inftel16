/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;
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
public class ControladorManolo {
    
    // Categoria
    public static int buscarId(String nombre, String nombre_cat){
        int id=0;
        int id_bib = Biblioteca.buscarId(nombre);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_cat from categoria where nombre_cat like ? and id_bib = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre_cat);
            pstmt.setInt(2, id_bib);
            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               id = resultado.getInt("id_cat");
                
            }            
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Biblioteca.");
            System.err.println(ex);
            return 0;
        }
    }
    
    
    
    
    
    
    
    public static void main(String[] args){
        
  
        System.out.println(ControladorManolo.buscarId("PruebasManolo","CategoriaAAA"));

    }
    
}
