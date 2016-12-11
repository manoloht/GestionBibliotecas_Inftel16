/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author YUEMEI
 */
public class Autor implements BaseDatos<Autor>{

    private int id_autor;
    private String nombre;
    private String apellido;
    private List<Libro> libros;

    public Autor() {
    }


    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Autor(int id_autor, String nombre, String apellido) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Autor(int id_autor, String nombre, String apellido, List<Libro> libros) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.libros = libros;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", apellido=" + apellido + ", libros=" + libros + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_autor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        return this.id_autor == other.id_autor;
    }

   
    @Override //ACABAR
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into autor (id_autor,nombre,apellido) values (seq_id_autor.nextval,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
           
            pstmt.setString(1, this.nombre);
            pstmt.setString(2, this.apellido);
              
            if (!comprobarAutor(this.nombre,this.apellido)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }
            

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el autor. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean actualizar(Autor a) {
          try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            int id=Autor.buscarId(this.nombre, this.apellido);
            String consulta = "update autor set nombre = ?, apellido = ?  where id_autor = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(3, id);
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getApellido());
            
            
              if (comprobarAutor(this.nombre, this.apellido)) {
                pstmt.executeUpdate();
                con.close();               
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el autor. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean borrar() {
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from autor where nombre = ? and apellido = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre);
            pstmt.setString(2, this.apellido);
          
           if (comprobarAutor(this.nombre,this.apellido)) {
                pstmt.executeUpdate();
                con.close();               
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el autor. ");
            System.err.println(ex);
            return false;
        }
    }

   // @Override //ACABAR
    public static boolean comprobarAutor(String nombre,String apellido) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
          
            String consulta = "select * from autor where nombre = ? and apellido like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre);
             pstmt.setString(2, apellido);
            
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el autor.");
            System.err.println(ex);
            return false;
        }
    }

    public  static int buscarId(String nombre,String apellido) {
              int id=-1;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from autor where nombre like ? and apellido like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            
            ResultSet resultado = pstmt.executeQuery();
             while (resultado.next()) {
                  id= resultado.getInt("id_autor");
            
             }
             con.close();
              return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el autor.");
            System.err.println(ex);
            return -1;
        }
    }
    
//        public boolean buscar() {
//         try {
//            Conexion conexion = new Conexion();
//            Connection con = conexion.getConnection();
//
//            String consulta = "select * from autor where id_autor = ?";
//            PreparedStatement pstmt = con.prepareStatement(consulta);
//            pstmt.clearParameters();
//            pstmt.setInt(1, this.id_autor);
//            ResultSet resultado = pstmt.executeQuery();
//
//            if (resultado.next()) {
//                this.nombre = resultado.getString("nombre");
//                this.apellido = resultado.getString("apellido");                
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            System.err.println("Excepcion SQL: Error al buscar el autor.");
//            System.err.println(ex);
//            return false;
//        }
//    }
//    
    //ACABAR
    public static List<Autor> getTodosAutores(){
         List<Autor> autores = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from autor";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                int id_autor = resultado.getInt("id_autor");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");                
                Autor a = new Autor(nombre, apellido);
                autores.add(a);
            }
            con.close();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los autores");
            System.err.println(ex);
        }
        return autores;
    }
     
    
    
}
