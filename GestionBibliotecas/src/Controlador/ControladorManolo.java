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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Manuel
 */
public class ControladorManolo {
    
    // Ejemplar
 /*   public static int buscarId(String nombre_bib, String nombre_cat, String isbn){
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
System.err.println("Prueba1");
            while(resultado.next()){
               id = resultado.getInt("id_libro");
                System.err.println("Prueba2");
            }            
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Libro.");
            System.err.println(ex);
            return -1;
        }
    }*/
    
    
    public static Biblioteca buscarBiblioteca(int id){
        Biblioteca b = new Biblioteca();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from biblioteca where id_bib = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);

            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               b.setId_bib(resultado.getInt("id_bib"));
               b.setDni_admin("id:"+resultado.getInt("id_usuario"));
               b.setNombre(resultado.getString("nombre"));
               b.setTelefono(resultado.getInt("telefono"));
               b.setLocalizacion(resultado.getString("localizacion"));
            }            
            return b;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Biblioteca.");
            System.err.println(ex);
            return b;
        }
    
    }
    
    
    public static Categoria buscarCategoria(int id){
        Categoria c = new Categoria();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from categoria where id_cat = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);

            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               c.setId_cat(resultado.getInt("id_cat"));
               c.setNombre_cat(resultado.getString("nombre_cat"));
               c.setNombre_biblioteca(ControladorManolo.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());               
            }            
            return c;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Categoria.");
            System.err.println(ex);
            return c;
        }
    
    }
    
 
    public static Editorial buscarEditorial(int id){
        Editorial e = new Editorial();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from editorial where id_edit = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);

            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               e.setId_edit(resultado.getInt("id_edit"));
               e.setNombre_edit(resultado.getString("nombre_edit"));
            }            
            return e;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Editorial.");
            System.err.println(ex);
            return e;
        }
    }
    
    public static Libro buscarLibro(int id){
        Libro l = new Libro();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from libro where id_libro = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               l.setId_libro(resultado.getInt("id_libro"));
               
               l.setNombre_categoria(ControladorManolo.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat());
               l.setNombre_bib(ControladorManolo.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
               l.setNombre_editorial(ControladorManolo.buscarEditorial(resultado.getInt("id_edit")).getNombre_edit());
               
               l.setIsbn(resultado.getString("isbn"));
               l.setTitulo(resultado.getString("titulo"));
               l.setPais(resultado.getString("pais"));
               l.setIdioma(resultado.getString("idioma"));
               l.setFecha_edi(resultado.getString("fecha_edi"));               
            }            
            return l;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Libro.");
            System.err.println(ex);
            return l;
        }
    
    }
    
    
    
    
    public static void main(String[] args){
/*
  **** MODIFICACIONES NECESARIAS ****
        - Todos los actualizar necesitan cambiar la comprobacion de la sentencia if
        - La entidad ejemplar no debe de contemplar el actualizar, solo insertar y borrar
        - Entidad Editorial faltan getter y setter de id_edit
        - Borrar => Comprobar y Actualizar en la Clase Ejemplar, no sirven para nada
        - Crear en todas las clases  public static Clase buscarObjeto(int id); y buscarId(PK)
            - Biblioteca => cambiar dniAdmin
            - Categoria ?? Comprobar todo
            - Libro 
            - Editorial
            - Reservado - Comprobado
            - Prestamo - Comprobado
        
*/              
  
       
 /*     //////////////////////////////////////// USUARIO 
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setApellidos("de los rios");
        u.setEmail("pepe@gmail.com");
        u.setDni("123456");
        u.setPassword("abcabc");
        System.out.println("Usuario Borrar: "+ u.borrar());
        System.out.println("Usuario Insertar: "+ u.insertar());
        
        //////////////////////////////////////// Categoria (sin probar, solo buscar id)
        String categoria = "CategoriaXXXXXXXXX";
        String biblioteca= "PruebasManolo";
        
        Categoria c = new Categoria();
        c.setNombre_cat(categoria);
        c.setNombre_biblioteca(biblioteca);
        
        ////////////////////////////////////////  LIBRO
        String isbn="isbn555";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaA";
        String titulo ="LibroPepito";
        String fecha_edi ="01/01/2000";
        String nombre_edit ="EdiPepe";
        String pais ="España";
        String idioma ="Español";        

        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setNombre_bib(nombre_bib);
        l.setNombre_categoria(nombre_cat);
        l.setTitulo(titulo);
        l.setFecha_edi(fecha_edi);
        l.setNombre_editorial(nombre_edit);
        l.setPais(pais);
        l.setIdioma(idioma);
        
        Libro l2 = new Libro();
        l2.setIsbn("xxx990");
        l2.setNombre_bib(nombre_bib);
        l2.setNombre_categoria(nombre_cat);
        
        System.out.println("Libro borrar: "+ l.borrar());
        System.out.println("Libro Insertar: "+ l.insertar());        
        System.out.println("Libro Actualizar: "+ l.actualizar(l2));


        //////////////////////////////////////// Editorial
        Editorial e = new Editorial("Editorial C");
        System.out.println("Editorial Borrar: "+ e.borrar());
        System.out.println("Editorial Insertar: "+ e.insertar());
        Editorial e2 = new Editorial("Editorial D");
        System.out.println("Editorial Actualizar: "+ e.actualizar(e2));


        //////////////////////////////////////// Ejemplar
        String isbn="isbn111";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaA";
        
        Ejemplar e = new Ejemplar();
        e.setIsbn(isbn);
        e.setNombre_bib(nombre_bib);
        e.setNombre_cat(nombre_cat);
        e.setId_ejem(1);
        
        System.out.println(e.toString());
        System.out.println("Ejemplar borrar: "+ e.borrar());
        System.out.println("Ejemplar Insertar: "+ e.insertar());


        //////////////////////////////////////// Prestamo
        Prestamo p = new Prestamo(4000, "isbn111", "00111111X", "CategoriaA", "PruebasManolo");
        p.setFecha_ini("01/01/2000");
        p.setFecha_fin("10/01/2000");
        
        System.out.println(p.toString());
        System.out.println(p.borrar());
        System.out.println(p.insertar());
        
        Prestamo p2 = new Prestamo();
        p2.setFecha_ini("01/01/2000");
        p2.setFecha_fin("10/01/2000");
        System.out.println(p.actualizar(p2));


        //////////////////////////////////////// Reservado
        Reservado p = new Reservado(5000, "isbn222", "00111111X", "CategoriaA", "PruebasManolo");
        p.setFecha_ini("01/01/2000");
        p.setFecha_fin("10/01/2000");
        
        System.out.println(p.toString());
        System.out.println(p.borrar());
        System.out.println(p.insertar());
        
        Reservado p2 = new Reservado();
        p2.setFecha_ini("01/01/2000");
        p2.setFecha_fin("15/01/2000");
        System.out.println(p.actualizar(p2));
 
        




        ///////////////////////////////// METODOS buscarObjeto
        Biblioteca b = ControladorManolo.buscarBiblioteca(1000);
        System.out.println(b.toString());
        
        Categoria c = ControladorManolo.buscarCategoria(2000);
        System.out.println(c.toString());   


        Editorial ed = ControladorManolo.buscarEditorial(6001);
        System.out.println(ed.toString()); 
        
        Libro l = ControladorManolo.buscarLibro(3000);
        System.out.println(l.toString()); 


        ///////////////////////////////// Comprobaciones BuscarID
        System.out.println(Biblioteca.buscarId("PruebasManolo"));
        System.out.println(Categoria.buscarId("PruebasManolo","CategoriaA"));
        System.out.println(ControladorManolo.buscarId("PruebasManolo","CategoriaA","isbn111"));
        System.out.println(ControladorManolo.buscarId("Editorial B"));


 */
 
 // ----- Prestamo ----------
        
 

    
                
        

        

        
   

        
    }
    
    
    
    
}
