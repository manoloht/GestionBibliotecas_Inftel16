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
    
    // Libro
    public static int buscarId(String nombre_bib, String nombre_cat, String isbn){
        int id=0;
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_libro from libro where id_cat = ? and id_bib = ? and isbn like ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_cat);
            pstmt.setInt(2, id_bib);
            pstmt.setString(3, isbn);
            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               id = resultado.getInt("id_libro");
                
            }            
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Libro.");
            System.err.println(ex);
            return -1;
        }
    }
    
    
   
    
    
    
    
    public static void main(String[] args){
        
  
       
 /*       
        String categoria = "CategoriaXXXXXXXXX";
        String biblioteca= "PruebasManolo";
        
        Categoria c = new Categoria();
        c.setNombre_cat(categoria);
        c.setNombre_biblioteca(biblioteca);
 
 
    // Método buscar libro
        String isbn="isbn111";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaA";
 
        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setNombre_bib(nombre_bib);
        l.setNombre_categoria(nombre_cat); 
 
        System.out.println(l.toString());
        System.out.println(ControladorManolo.buscarId(nombre_bib, nombre_cat, isbn));
 */
        
        // Insertar
        String isbn="isbn999";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaB";
 
        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setNombre_bib(nombre_bib);
        l.setNombre_categoria(nombre_cat); 
        
        System.out.println(l.insertar());
        
        
    }
    
}
