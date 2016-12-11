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
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.*;
import java.util.*;


/**
 *
 * @author YUEMEI
 */
public class Prestamo implements BaseDatos<Prestamo> {
    int id_prestamo;
    private String fecha_ini;
    private String fecha_fin;
   // private String numExp;  // hace falta????
    private int id_ejem;
    private String isbn; // yuemei
    private String dni;  // yuemei  clave primaria de tabla estudiante
    private String nombre_cat;// yuemei
    private String nombre_bib;//yuemei

    public Prestamo() {

    }


    public Prestamo(int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib) {
        this.id_ejem = id_ejem;    // constructor para clave primaria
        this.isbn = isbn;
        this.dni = dni;
        this.nombre_cat = nombre_cat;
        this.nombre_bib = nombre_bib;
    }

    public Prestamo(String fecha_ini, String fecha_fin, int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib) {
        this.fecha_ini = fecha_ini; // constructor para todos atributos
        this.fecha_fin = fecha_fin;
       // this.numExp = numExp;
        this.id_ejem = id_ejem;
        this.isbn = isbn;
        this.dni = dni;
        this.nombre_cat = nombre_cat;
        this.nombre_bib = nombre_bib;
    }
    

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
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

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", id_ejem=" + id_ejem + ", isbn=" + isbn + ", dni=" + dni + ", nombre_cat=" + nombre_cat + ", nombre_bib=" + nombre_bib + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Prestamo other = (Prestamo) obj;
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

   
    //ACABAR
    public static List<Prestamo> getTodosPrestamos() {
          List<Prestamo> prestamos = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from prestamo";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String fecha_ini =resultado.getString("fecha_ini");
                String fecha_fin =resultado.getString("fecha_fin");
                String dni = resultado.getString("dni");
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = resultado.getString("isbn");
                String nombre_cat = resultado.getString("nombre_cat");
                String nombre_bib = resultado.getString("nombre_bib");                
                Prestamo p = new Prestamo (fecha_ini,fecha_fin,id_ejem,isbn,dni,nombre_cat,nombre_bib);
                prestamos.add(p);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los prestamos.");
            System.err.println(ex);
        }
        return prestamos;
    }
    
    private boolean comprobarPrestamo(String dni, int id_ejem, String isbn, String nombre_cat, String nombre_bib) {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Admin.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from prestamo where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
            pstmt.setInt(2, id_ejem);
            pstmt.setInt(3, id_libro);
            pstmt.setInt(4, id_cat);
            pstmt.setInt(5, id_bib);
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el prestamo");
            System.err.println(ex);
            return false;
        }
    }
    

    @Override  
    public boolean insertar() {
        
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Usuario.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into prestamo (id_prestamo,fecha_ini,fecha_fin,id_usuario,id_ejem,id_libro,id_cat,id_bib) values (seq_id_prestamo.nextval,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.fecha_ini);
            pstmt.setString(2, this.fecha_fin);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, this.id_ejem);
            pstmt.setInt(5, id_libro);
            pstmt.setInt(6, id_cat);
            pstmt.setInt(7, id_bib);

            if (!comprobarPrestamo(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el prestamo.");
            System.err.println(ex);
            return false;
        }
    }

    @Override 
    public boolean actualizar(Prestamo p) {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Admin.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update prestamo set fecha_ini = ?,fecha_fin = ? where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, p.fecha_ini);
            pstmt.setString(2, p.fecha_fin);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, id_ejem);
            pstmt.setInt(5, id_libro);
            pstmt.setInt(6, id_cat);
            pstmt.setInt(7, id_bib);
            

            if (comprobarPrestamo(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el prestamo. ");
            System.err.println(ex);
            return false;
        }
    }

    @Override 
    public boolean borrar() {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Admin.buscarId(dni);
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from prestamo where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
            pstmt.setInt(2, this.id_ejem);
            pstmt.setInt(3, id_libro);
            pstmt.setInt(4, id_cat);
            pstmt.setInt(5, id_bib);

            if (comprobarPrestamo(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el prestamo. ");
            System.err.println(ex);
            return false;
        }
    }

    
    
}
