/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
import Configuracion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author YUEMEI
 */
public class Libro implements BaseDatos<Libro> {

    private String isbn;  //clave
    private String titulo;
    private Date fecha_edi;
    private String nombre_editorial;
    private String nombre_categoria;//clave
    private String nombre_bib;  //clave
    private String pais;
    private String idioma;
    private List<Ejemplar> ejemplares;
    private List<Autor> autores;
    

    public Libro() {
    }

    public Libro(String isbn, String nombre_categoria, String nombre_bib) {
        this.isbn = isbn;            // constructor clave
        this.nombre_categoria = nombre_categoria;
        this.nombre_bib = nombre_bib;
    }

    public Libro(String isbn, String titulo, Date fecha_edi, String nombre_editorial, String nombre_categoria, String nombre_bib, String pais, String idioma) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha_edi = fecha_edi;
        this.nombre_editorial = nombre_editorial;
        this.nombre_categoria = nombre_categoria;
        this.nombre_bib = nombre_bib;
        this.pais = pais;
        this.idioma = idioma;
    }

    public Libro(String isbn, String titulo, Date fecha_edi, String nombre_editorial, String nombre_categoria, String nombre_bib, String pais, String idioma, List<Ejemplar> ejemplares, List<Autor> autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha_edi = fecha_edi;
        this.nombre_editorial = nombre_editorial;
        this.nombre_categoria = nombre_categoria;
        this.nombre_bib = nombre_bib;
        this.pais = pais;
        this.idioma = idioma;
        this.ejemplares = ejemplares;
        this.autores = autores;
    }

   

  
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha_edi() {
        return fecha_edi;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public String getEditorial() {
        return nombre_editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_edi(Date fecha_edi) {
        this.fecha_edi = fecha_edi;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setEditorial(String editorial) {
        this.nombre_editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", fecha_edi=" + fecha_edi + ", nombre_categoria=" + nombre_categoria + ", ejemplares=" + ejemplares + ", autores=" + autores + ", editorial=" + nombre_editorial + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.isbn);
        hash = 41 * hash + Objects.hashCode(this.nombre_categoria);
        hash = 41 * hash + Objects.hashCode(this.nombre_bib);
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
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.nombre_categoria, other.nombre_categoria)) {
            return false;
        }
        if (!Objects.equals(this.nombre_bib, other.nombre_bib)) {
            return false;
        }
        return true;
    }

      
    @Override //ACABAR
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into libro (isbn,titulo,fecha_edi,nombre_edit,nombre_cat,nombre_bib,pais,idioma) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.titulo);
            pstmt.setDate(3, this.fecha_edi);
            pstmt.setString(4, this.nombre_editorial);
            pstmt.setString(5, this.nombre_categoria);
            pstmt.setString(6, this.nombre_bib);
            pstmt.setString(7, this.pais);
            pstmt.setString(8, this.idioma);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean actualizar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update libro set titulo = ?, feche_edi= ?, nombre_edit = ?, pais = ?,idioma = ? where isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(6, this.isbn);
            pstmt.setString(7, this.nombre_categoria);
            pstmt.setString(8, this.nombre_bib);
            pstmt.setString(1, this.titulo);
            pstmt.setDate(2, this.fecha_edi);
            pstmt.setString(3, this.nombre_editorial);
            pstmt.setString(4, this.pais);
            pstmt.setString(5, this.idioma);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from libro where isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.nombre_categoria);
            pstmt.setString(3, this.nombre_bib);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el libro");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean comprobar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from libro where isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.nombre_categoria);
            pstmt.setString(3, this.nombre_bib);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean buscar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from libro where isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
           pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.nombre_categoria);
            pstmt.setString(3, this.nombre_bib);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                this.titulo = resultado.getString("titulo");
                this.fecha_edi = resultado.getDate("fecha_edi");
                this.nombre_editorial = resultado.getString("nombre_edit");
                this.pais = resultado.getString("pais");
                this.idioma = resultado.getString("idioma");
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar el libro. ");
            System.err.println(ex);
            return false;
        }
    }
    
    // ACABAR
    public static List<Libro> getTodos(){
         List<Libro> libros = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from libro";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String isbn= resultado.getString("isbn");
                String titulo= resultado.getString("titulo");
                Date fecha_edi= resultado.getDate("fecha_edi");
                String nombre_editorial= resultado.getString("nombre_edit");
                String nombre_categoria= resultado.getString("nombre_cat");
                String nombre_bib= resultado.getString("nombre_bib");
                String pais= resultado.getString("pais");
                String idioma= resultado.getString("idioma");
                
                Libro l = new Libro(isbn,titulo,fecha_edi,nombre_editorial, nombre_categoria,nombre_bib, pais,idioma);
                libros.add(l);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los libros.");
            System.err.println(ex);
        }
        return libros;
    }

}
