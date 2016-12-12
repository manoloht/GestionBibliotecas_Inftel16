/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
import Configuracion.*;
import Controlador.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author YUEMEI
 */
public class Libro implements BaseDatos<Libro> {

    int id_libro;
    private String isbn;  //clave
    private String titulo;
    private String fecha_edi;
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

    public Libro(String isbn, String titulo, String fecha_edi, String nombre_editorial, String nombre_categoria, String nombre_bib, String pais, String idioma) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha_edi = fecha_edi;
        this.nombre_editorial = nombre_editorial;
        this.nombre_categoria = nombre_categoria;
        this.nombre_bib = nombre_bib;
        this.pais = pais;
        this.idioma = idioma;
    }

    public Libro(String isbn, String titulo, String fecha_edi, String nombre_editorial, String nombre_categoria, String nombre_bib, String pais, String idioma, List<Ejemplar> ejemplares, List<Autor> autores) {
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_edi() {
        return fecha_edi;
    }

    public void setFecha_edi(String fecha_edi) {
        this.fecha_edi = fecha_edi;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_bib() {
        return nombre_bib;
    }

    public void setNombre_bib(String nombre_bib) {
        this.nombre_bib = nombre_bib;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", isbn=" + isbn + ", titulo=" + titulo + ", fecha_edi=" + fecha_edi + ", nombre_editorial=" + nombre_editorial + ", nombre_categoria=" + nombre_categoria + ", nombre_bib=" + nombre_bib + ", pais=" + pais + ", idioma=" + idioma + ", ejemplares=" + ejemplares + ", autores=" + autores + '}';
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

    @Override
    public boolean insertar() {

        int id_cat = Categoria.buscarId(this.getNombre_bib(), this.getNombre_categoria());
        int id_bib = Biblioteca.buscarId(this.getNombre_bib());
        int id_edit = Editorial.buscarId(this.getNombre_editorial());

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into libro (id_libro, id_cat, id_bib, isbn, titulo, fecha_edi, id_edit, pais,idioma) values (seq_id_libro.nextval,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_cat);
            pstmt.setInt(2, id_bib);
            pstmt.setString(3, this.isbn);
            pstmt.setString(4, this.titulo);
            pstmt.setString(5, this.fecha_edi);
            pstmt.setInt(6, id_edit);
            pstmt.setString(7, this.pais);
            pstmt.setString(8, this.idioma);

            if (!comprobarLibro(this.isbn, this.nombre_categoria, this.nombre_bib)) {

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

    @Override //ACABAR
    public boolean actualizar(Libro lib) {
        int id_cat = Categoria.buscarId(nombre_bib, nombre_categoria);
        int id_bib = Biblioteca.buscarId(nombre_bib);

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update libro set isbn = ?, titulo = ?, fecha_edi= ?, pais = ?,idioma = ? where isbn like ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, lib.isbn);
            pstmt.setString(2, lib.titulo);
            pstmt.setString(3, lib.fecha_edi);
            pstmt.setString(4, lib.pais);
            pstmt.setString(5, lib.idioma);

            pstmt.setString(6, this.getIsbn());
            pstmt.setInt(7, id_cat);
            pstmt.setInt(8, id_bib);

            if (comprobarLibro(this.isbn, this.nombre_categoria, this.nombre_bib) && !comprobarLibro(lib.isbn, lib.nombre_categoria, lib.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean borrar() {
        int id_cat = Categoria.buscarId(nombre_bib, nombre_categoria);
        int id_bib = Biblioteca.buscarId(nombre_bib);

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from libro where isbn like ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.isbn);
            pstmt.setInt(2, id_cat);
            pstmt.setInt(3, id_bib);

            if (comprobarLibro(this.isbn, this.nombre_categoria, this.nombre_bib)) {
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

    private boolean comprobarLibro(String isbn, String nombre_categoria, String nombre_bib) {
        int id_cat = Categoria.buscarId(nombre_bib, nombre_categoria);
        int id_bib = Biblioteca.buscarId(nombre_bib);

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from libro where isbn like ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, isbn);
            pstmt.setInt(2, id_cat);
            pstmt.setInt(3, id_bib);

            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el libro. ");
            System.err.println(ex);
            return false;
        }
    }

    public static int buscarId(String nombre_bib, String nombre_cat, String isbn) {
        int id = 0;
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

            while (resultado.next()) {
                id = resultado.getInt("id_libro");

            }
            con.close();
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Libro.");
            System.err.println(ex);
            return -1;
        }
    }

    // ACABAR
    public static List<Libro> getTodosLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from libro";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String isbn = resultado.getString("isbn");
                String titulo = resultado.getString("titulo");
                String fecha_edi = resultado.getString("fecha_edi");
                String nombre_editorial = resultado.getString("nombre_edit");
                String nombre_categoria = resultado.getString("nombre_cat");
                String nombre_bib = resultado.getString("nombre_bib");
                String pais = resultado.getString("pais");
                String idioma = resultado.getString("idioma");

                Libro l = new Libro(isbn, titulo, fecha_edi, nombre_editorial, nombre_categoria, nombre_bib, pais, idioma);
                libros.add(l);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los libros.");
            System.err.println(ex);
        }
        return libros;
    }

    public static List<Libro> getTodosLibros(String nombre_bib, String nombre_cat) {
        List<Libro> libros = new ArrayList<>();
        try {
            int id_bib = Biblioteca.buscarId(nombre_bib);
            int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);

            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from libro where id_bib = ? and id_cat = ? ";

            PreparedStatement ptmt = con.prepareStatement(consulta);
            ptmt.clearParameters();

            ptmt.setInt(1, id_bib);
            ptmt.setInt(2, id_cat);
            ResultSet resultado = ptmt.executeQuery();
            while (resultado.next()) {
                String isbn = resultado.getString("isbn");
                String titulo = resultado.getString("titulo");
                String fecha_edi = resultado.getString("fecha_edi");
                String pais = resultado.getString("pais");
                String idioma = resultado.getString("idioma");

                String nombre_editorial = Util.buscarEditorial(resultado.getInt("id_edit")).getNombre_edit();

                Libro l = new Libro(isbn, titulo, fecha_edi, nombre_editorial, nombre_cat, nombre_bib, pais, idioma);
                l.setId_libro(resultado.getInt("id_libro"));
                libros.add(l);

            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los libros por biblioteca y categoria.");
            System.err.println(ex);
        }
        return libros;
    }

}
