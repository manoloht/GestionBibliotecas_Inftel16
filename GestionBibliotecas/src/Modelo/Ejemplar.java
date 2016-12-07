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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author YUEMEI
 */
public class Ejemplar implements BaseDatos<Ejemplar> {

    private int id_ejem;
    private String isbn;
    private String nombre_cat;
    private String nombre_bib;

    public Ejemplar() {
    }

    public Ejemplar(int id_ejem) {
        this.id_ejem = id_ejem;
    }

    public Ejemplar(int id_ejem, String isbn, String nombre_cat, String nombre_bib) {
        this.id_ejem = id_ejem;  // constructor clave
        this.isbn = isbn;
        this.nombre_cat = nombre_cat;
        this.nombre_bib = nombre_bib;
    }

    public int getId_ejem() {
        return id_ejem;
    }

    public void setId_ejem(int id_ejem) {
        this.id_ejem = id_ejem;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public String getNombre_bib() {
        return nombre_bib;
    }

    public void setNombre_bib(String nombre_bib) {
        this.nombre_bib = nombre_bib;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "id_ejem=" + id_ejem + ", isbn=" + isbn + ", nombre_cat=" + nombre_cat + ", nombre_bib=" + nombre_bib + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_ejem;
        hash = 97 * hash + Objects.hashCode(this.isbn);
        hash = 97 * hash + Objects.hashCode(this.nombre_cat);
        hash = 97 * hash + Objects.hashCode(this.nombre_bib);
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
        final Ejemplar other = (Ejemplar) obj;
        if (this.id_ejem != other.id_ejem) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.nombre_cat, other.nombre_cat)) {
            return false;
        }
        if (!Objects.equals(this.nombre_bib, other.nombre_bib)) {
            return false;
        }
        return true;
    }

    @Override // ACABAR
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into ejemplar (id_ejem,isbn,nombre_cat,nombre_bib) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, this.id_ejem);
            pstmt.setString(2, this.isbn);
            pstmt.setString(3, this.nombre_cat);
            pstmt.setString(4, this.nombre_bib);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el ejemplar");
            System.err.println(ex);
            return false;
        }
    }

    @Override // ACABAR
    public boolean actualizar() {
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update usuario set isbn = ?, nombre_cat = ?, nombre_bib = ? where id_ejem like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(4, this.id_ejem);
            pstmt.setString(1, this.isbn);
            pstmt.setString(2, this.nombre_cat);
            pstmt.setString(3, this.nombre_bib);           

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el ejemplar");
            System.err.println(ex);
            return false;
        }
    }

    @Override // ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            //String consulta = "delete from ejemplar where id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
            String consulta = "delete from ejemplar where id_ejem like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, this.id_ejem);
//            pstmt.setString(2, this.isbn);
//            pstmt.setString(3, this.nombre_cat);
//            pstmt.setString(4, this.nombre_bib);
            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el ejemplar ");
            System.err.println(ex);
            return false;
        }
    }

    @Override // ACABAR
    public boolean comprobar() {
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

           // String consulta = "select * from ejemplar where id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
           String consulta = "select * from ejemplar where id_ejem like ?"; 
           PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, this.id_ejem);
//            pstmt.setString(2, this.isbn);
//            pstmt.setString(3, this.nombre_cat);
//            pstmt.setString(4, this.nombre_bib);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el usuario");
            System.err.println(ex);
            return false;
        }
    }

    @Override // ACABAR
    public boolean buscar() {
      try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from ejemplar where id_ejem like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, this.id_ejem);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                this.isbn = resultado.getString("isbn");
                this.nombre_cat = resultado.getString("nombre_cat");
                this.nombre_bib = resultado.getString("nombre_bib");                
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar el ejempar");
            System.err.println(ex);
            return false;
        }
    }

    // ACABAR
    public static List<Ejemplar> getTodos() {
         List<Ejemplar> ejemplares = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from usuario";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = resultado.getString("isbn");
                String nombre_cat = resultado.getString("nombre_cat");
                String nombre_bib = resultado.getString("nombre_bib");                
                Ejemplar ej = new Ejemplar(id_ejem, isbn, nombre_cat, nombre_bib);
                ejemplares.add(ej);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los ejemplares");
            System.err.println(ex);
        }
        return ejemplares;
    }

}
