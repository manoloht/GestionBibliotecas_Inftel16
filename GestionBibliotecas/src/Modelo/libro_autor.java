/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author YUEMEI
 */
public class libro_autor {

    String nombre_autor;
    String apellido_autor;
    String isbn;
    String biblioteca;
    String categoria;

    public libro_autor() {
    }

    
    public libro_autor(String nombre_autor, String apellido_autor, String isbn, String biblioteca, String categoria) {
        this.nombre_autor = nombre_autor;
        this.apellido_autor = apellido_autor;
        this.isbn = isbn;
        this.biblioteca = biblioteca;
        this.categoria = categoria;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean InsertarLibroAutor() {
        
        
        int id_autor = Autor.buscarId(this.nombre_autor, this.apellido_autor);
        int id_bib = Biblioteca.buscarId(this.biblioteca);
        int id_cat = Categoria.buscarId( this.biblioteca,this.categoria);
       
        int id_libro = Libro.buscarId(this.biblioteca, this.categoria, this.isbn);
         System.out.println("id_autor+id_libro+id_bib+id_cat:"+id_autor+id_libro+id_bib+id_cat);
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into libro_autor (id_libro, id_cat, id_bib, id_autor) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_libro);
            pstmt.setInt(2, id_cat);
            pstmt.setInt(3, id_bib);
            pstmt.setInt(4, id_autor);
           
            if (!comprobarLibroAutor(id_autor, id_libro, id_cat, id_bib)) {

                pstmt.executeUpdate();
                con.close();
                return true;
            } else {

                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    public boolean borrarLibroAutor() {
        int id_autor = Autor.buscarId(this.nombre_autor, this.apellido_autor);
        int id_bib = Biblioteca.buscarId(this.biblioteca);
        int id_cat = Categoria.buscarId(this.biblioteca,this.categoria);
        int id_libro = Libro.buscarId(this.biblioteca, this.categoria, this.isbn);
          System.out.println("id_autor+id_libro+id_bib+id_cat:"+id_autor+id_libro+id_bib+id_cat);
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "delete from libro_autor where id_libro like ? and id_cat like ? and id_bib like ? and id_autor like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_libro);
            pstmt.setInt(2, id_cat);
            pstmt.setInt(3, id_bib);
            pstmt.setInt(4, id_autor);
            if (comprobarLibroAutor(id_autor, id_libro, id_cat, id_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el libro");
            System.err.println(ex);
            return false;
        }

    }

    public static boolean comprobarLibroAutor(int id_autor, int id_libro, int id_cat, int id_bib) {
            boolean comprobar;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from libro_autor where id_autor like ? and id_libro like ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_autor);
            pstmt.setInt(2, id_libro);
            pstmt.setInt(3, id_cat);
            pstmt.setInt(4, id_bib);

            ResultSet resultado = pstmt.executeQuery();
            comprobar=resultado.next(); 
            con.close();
            return comprobar;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

}
