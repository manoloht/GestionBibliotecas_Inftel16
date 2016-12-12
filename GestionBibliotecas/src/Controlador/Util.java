/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Configuracion.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Random;

/**
 *
 * @author Manuel
 */
public class Util {

    public static String getCadenaAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
    
    
        
    public static Usuario buscarUsuario(int id){
        Usuario u = new Usuario();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from usuario where id_usuario = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);

            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               u.setDni(resultado.getString("dni"));
               u.setNombre(resultado.getString("nombre"));
               u.setApellidos(resultado.getString("apellido"));
               u.setSexo(resultado.getString("sexo"));
               u.setEmail(resultado.getString("email"));
               u.setPassword(resultado.getString("password"));
               u.setId_usuario(resultado.getInt("id_usuario"));
            }
            con.close();
            return u;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Usuario.");
            System.err.println(ex);
            return u;
        }
    
    }
    
    
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
               b.setDni_admin(Util.buscarUsuario(resultado.getInt("id_usuario")).getDni());               
               b.setNombre(resultado.getString("nombre"));
               b.setTelefono(resultado.getInt("telefono"));
               b.setLocalizacion(resultado.getString("localizacion"));
            }
            con.close();
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
               c.setNombre_biblioteca(Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());               
            }
            con.close();
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
            con.close();
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
               
               l.setNombre_categoria(Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat());
               l.setNombre_bib(Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
               l.setNombre_editorial(Util.buscarEditorial(resultado.getInt("id_edit")).getNombre_edit());
               
               l.setIsbn(resultado.getString("isbn"));
               l.setTitulo(resultado.getString("titulo"));
               l.setPais(resultado.getString("pais"));
               l.setIdioma(resultado.getString("idioma"));
               l.setFecha_edi(resultado.getString("fecha_edi"));               
            } 
            con.close();
            return l;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Libro.");
            System.err.println(ex);
            return l;
        }
    
    }
    
    
    public static Prestamo buscarPrestamo(int id){
        Prestamo p = new Prestamo();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from prestamo where id_prestamo = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               p.setId_prestamo(resultado.getInt("id_prestamo"));
               p.setId_ejem(resultado.getInt("id_ejem"));
               p.setFecha_ini(resultado.getString("fecha_ini"));
               p.setFecha_fin(resultado.getString("fecha_fin"));               
               p.setNombre_cat(Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat());
               p.setNombre_bib(Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
               p.setIsbn(Util.buscarLibro(resultado.getInt("id_libro")).getIsbn()); 
               p.setDni(Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni()); 
               
            }   
            con.close();
            return p;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Prestamo.");
            System.err.println(ex);
            return p;
        }
    
    }
    
    
    public static Reservado buscarReservado(int id){
        Reservado p = new Reservado();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from reservado where id_reservado = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);            
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
               p.setId_reservado(resultado.getInt("id_reservado"));
               p.setId_ejem(resultado.getInt("id_ejem"));
               p.setFecha_ini(resultado.getString("fecha_ini"));
               p.setFecha_fin(resultado.getString("fecha_fin"));               
               p.setNombre_cat(Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat());
               p.setNombre_bib(Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
               p.setIsbn(Util.buscarLibro(resultado.getInt("id_libro")).getIsbn()); 
               p.setDni(Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni()); 
               
            } 
            con.close();
            return p;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Reservado.");
            System.err.println(ex);
            return p;
        }
    
    }
    
     public static Penalizacion buscarPenalizacion(int id){
          Penalizacion penaliza=new Penalizacion();
           try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from penalizacion where id_usuario = ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id);            
            ResultSet resultado = pstmt.executeQuery();
             while(resultado.next()){
                 String fecha_inicio=resultado.getString("fecha_inicio");
                 penaliza.setfecha_inicio(fecha_inicio);
                 String fecha_fin=resultado.getString("fecha_fin");
                 penaliza.setfecha_fin(fecha_fin);                
                 
             }
                 con.close();
                 return penaliza;
           } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Reservado.");
            System.err.println(ex);
            return penaliza;
        }   
}
}
