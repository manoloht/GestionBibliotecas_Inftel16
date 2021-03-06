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
public class Categoria implements BaseDatos<Categoria> {

    private String nombre_bib;
    private String nombre_cat;
    private List<Libro> libros;
    int id_cat;

    public Categoria() {
    }
    
      public Categoria(String nombre_bib) {
          this.nombre_bib = nombre_bib;
    }


    public Categoria(String nombre_bib, String nombre_cat) {
        this.nombre_bib = nombre_bib;
        this.nombre_cat = nombre_cat;
    }

    public Categoria(String nombre_bib, String nombre_cat, List<Libro> libros) {
        this.nombre_bib = nombre_bib;
        this.nombre_cat = nombre_cat;
        this.libros = libros;
    }

    public String getNombre_biblioteca() {
        return nombre_bib;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setNombre_biblioteca(String nombre_bib) {
        this.nombre_bib = nombre_bib;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    
    
    @Override
    public String toString() {
        return "Categoria{" + "nombre_bib=" + nombre_bib + ", nombre_cat=" + nombre_cat + ", libros=" + libros + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre_bib);
        hash = 29 * hash + Objects.hashCode(this.nombre_cat);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.nombre_bib, other.nombre_bib)) {
            return false;
        }
        return Objects.equals(this.nombre_cat, other.nombre_cat);
    }

    @Override //ACABAR------>HECHO
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into categoria (id_cat, nombre_cat,id_bib) values (seq_id_cat.nextval,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre_cat);
            pstmt.setInt(2, Biblioteca.buscarId(this.nombre_bib));

            if (!comprobarCategoria(this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar la categoria. ");
            System.err.println(ex);
            return false;
        }

    }

    @Override //ACABAR----HECHO
    public boolean actualizar(Categoria c) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update categoria set nombre_cat = ?, nombre_bib = ? where nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();

            pstmt.setString(2, this.nombre_bib);
            pstmt.setString(1, this.nombre_cat);
            pstmt.setString(3, c.nombre_cat);
            pstmt.setString(4, c.nombre_bib);

            if (comprobarCategoria(this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar la categoria");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from categoria where nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre_cat);
            pstmt.setString(2, this.nombre_bib);

            if (comprobarCategoria(this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar la categoria.");
            System.err.println(ex);
            return false;
        }
    }
// HECHO COMPROBAR

    private boolean comprobarCategoria(String nombre_cat, String nombre_bib) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from categoria where nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre_cat);
            pstmt.setString(2, nombre_bib);
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar la categoria.");
            System.err.println(ex);
            return false;
        }
    }

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
            con.close();
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Biblioteca.");
            System.err.println(ex);
            return 0;
        }
    }
    
    public static List<Categoria> getTodosCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from categoria";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String nombre_cat = resultado.getString("nombre_cat");
                String nombre_bib = resultado.getString("nombre_bib");
                Categoria c = new Categoria(nombre_bib, nombre_cat);
                categorias.add(c);
            }
                con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todas las categorias.");
            System.err.println(ex);
        }
        return categorias;
    }
    
     public static List<Categoria> getTodosCategorias(String nombre_bib) {
        List<Categoria> categorias = new ArrayList<>();
        // 

        try {
            int id_bib = Biblioteca.buscarId(nombre_bib);
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select nombre_cat from categoria where id_bib like ?";
            PreparedStatement ptmt = con.prepareStatement(consulta);
            ptmt.setInt(1, id_bib);
            ResultSet resultado = ptmt.executeQuery();

            while (resultado.next()) {
                String nombre_cat = resultado.getString("nombre_cat");
                Categoria c = new Categoria(nombre_cat);
                categorias.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todas las categorias por nombre de biblioteca.");
            System.err.println(ex);
        }
        return categorias;
    }

}
