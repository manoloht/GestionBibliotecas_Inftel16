/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.*;
import java.util.*;


/**
 *
 * @author YUEMEI
 */
public class Reservado implements BaseDatos<Reservado> {

    private Date fecha_ini;
    private Date fecha_fin;
    //private String numExp;
    private int id_ejem;    
    private String isbn; // yuemei
    private String dni;  // yuemei  clave primaria de tabla estudiante
    private String nombre_cat;// yuemei
    private String nombre_bib;//yuemei
    public Reservado() {

    }

    public Reservado(int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib) {
        this.id_ejem = id_ejem;  // constructor para clave primaria
        this.isbn = isbn;
        this.dni = dni;
        this.nombre_cat = nombre_cat;
        this.nombre_bib = nombre_bib;
    }

    public Reservado(Date fecha_ini, Date fecha_fin, int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib) {
        this.fecha_ini = fecha_ini; // constructor para todos atributos
        this.fecha_fin = fecha_fin;
        this.id_ejem = id_ejem;
        this.isbn = isbn;
        this.dni = dni;
        this.nombre_cat = nombre_cat;
        this.nombre_bib = nombre_bib;
    }

   

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        return "Reservado{" + "fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", id_ejem=" + id_ejem + ", isbn=" + isbn + ", dni=" + dni + ", nombre_cat=" + nombre_cat + ", nombre_bib=" + nombre_bib + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.fecha_ini);
        hash = 37 * hash + Objects.hashCode(this.fecha_fin);
        hash = 37 * hash + this.id_ejem;
        hash = 37 * hash + Objects.hashCode(this.isbn);
        hash = 37 * hash + Objects.hashCode(this.dni);
        hash = 37 * hash + Objects.hashCode(this.nombre_cat);
        hash = 37 * hash + Objects.hashCode(this.nombre_bib);
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
        final Reservado other = (Reservado) obj;
        if (this.id_ejem != other.id_ejem) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre_cat, other.nombre_cat)) {
            return false;
        }
        if (!Objects.equals(this.nombre_bib, other.nombre_bib)) {
            return false;
        }
        if (!Objects.equals(this.fecha_ini, other.fecha_ini)) {
            return false;
        }
        if (!Objects.equals(this.fecha_fin, other.fecha_fin)) {
            return false;
        }
        return true;
    }

    @Override //ACABAR
    public boolean insertar() {
       try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into reservado (fecha_ini,fecha_fin,dni,id_ejem,isbn,nombre_cat,nombre_bib) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setDate(1, this.fecha_ini);
            pstmt.setDate(2, this.fecha_fin);
            pstmt.setString(3, this.dni);
            pstmt.setInt(4, this.id_ejem);
            pstmt.setString(5, this.isbn);
            pstmt.setString(6, this.nombre_cat);
            pstmt.setString(7, this.nombre_bib);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el reservado.");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean actualizar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update reservado set fecha_ini = ?,fecha_fin = ? where dni like ? and id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
             pstmt.setDate(1, this.fecha_ini);
            pstmt.setDate(2, this.fecha_fin);
            pstmt.setString(3, this.dni);
            pstmt.setInt(4, this.id_ejem);
            pstmt.setString(5, this.isbn);
            pstmt.setString(6, this.nombre_cat);
            pstmt.setString(7, this.nombre_bib);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el reservado. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from reservado where dni like ? and id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            pstmt.setInt(2, this.id_ejem);
            pstmt.setString(3, this.isbn);
            pstmt.setString(4, this.nombre_cat);
            pstmt.setString(5, this.nombre_bib);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el reservado. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean comprobar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from reservado where dni like ? and id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            pstmt.setInt(2, this.id_ejem);
            pstmt.setString(3, this.isbn);
            pstmt.setString(4, this.nombre_cat);
            pstmt.setString(5, this.nombre_bib);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el reservado.");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean buscar() {
       try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from reservado where dni like ? and id_ejem like ? and isbn like ? and nombre_cat like ? and nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
             pstmt.setString(1, this.dni);
            pstmt.setInt(2, this.id_ejem);
            pstmt.setString(3, this.isbn);
            pstmt.setString(4, this.nombre_cat);
            pstmt.setString(5, this.nombre_bib);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                this.fecha_ini = resultado.getDate("fecha_ini");
                this.fecha_fin= resultado.getDate("fecha_fin");               
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar el reservado.");
            System.err.println(ex);
            return false;
        
    }
    }

    //ACABAR
    public static List<Reservado> getTodas() {
        List<Reservado> reservados = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from reservado";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                Date fecha_ini =resultado.getDate("fecha_ini");
                Date fecha_fin =resultado.getDate("fecha_fin");
                String dni = resultado.getString("dni");
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = resultado.getString("isbn");
                String nombre_cat = resultado.getString("nombre_cat");
                String nombre_bib = resultado.getString("nombre_bib");                
                Reservado r = new Reservado (fecha_ini,fecha_fin,id_ejem,isbn,dni,nombre_cat,nombre_bib);
                reservados.add(r);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los prestamos");
            System.err.println(ex);
        }
        return reservados;
    }

}
