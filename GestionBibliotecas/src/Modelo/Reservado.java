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
import java.util.*;


/**
 *
 * @author YUEMEI
 */
public class Reservado implements BaseDatos<Reservado> {
    int id_reservado;
    private String fecha_ini;
    private String fecha_fin;
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

    public Reservado(String fecha_ini, String fecha_fin, int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib) {
        this.fecha_ini = fecha_ini; // constructor para todos atributos
        this.fecha_fin = fecha_fin;
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

    public int getId_reservado() {
        return id_reservado;
    }

    public void setId_reservado(int id_reservado) {
        this.id_reservado = id_reservado;
    }

    @Override
    public String toString() {
        return "Reservado{" + "id_reservado=" + id_reservado + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", id_ejem=" + id_ejem + ", isbn=" + isbn + ", dni=" + dni + ", nombre_cat=" + nombre_cat + ", nombre_bib=" + nombre_bib + '}';
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

    @Override 
    public boolean insertar() {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Usuario.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into reservado (id_reservado,fecha_ini,fecha_fin,id_usuario,id_ejem,id_libro,id_cat,id_bib) values (seq_id_reservado.nextval,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.fecha_ini);
            pstmt.setString(2, this.fecha_fin);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, this.id_ejem);
            pstmt.setInt(5, id_libro);
            pstmt.setInt(6, id_cat);
            pstmt.setInt(7, id_bib);

            if (!comprobarReservado(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el reservado.");
            System.err.println(ex);
            return false;
        }
    }

    @Override 
    public boolean actualizar(Reservado r) {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Admin.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update reservado set fecha_ini = ?,fecha_fin = ? where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, r.fecha_ini);
            pstmt.setString(2, r.fecha_fin);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, id_ejem);
            pstmt.setInt(5, id_libro);
            pstmt.setInt(6, id_cat);
            pstmt.setInt(7, id_bib);

            if (comprobarReservado(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el reservado. ");
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

            String consulta = "delete from reservado where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
            pstmt.setInt(2, this.id_ejem);
            pstmt.setInt(3, id_libro);
            pstmt.setInt(4, id_cat);
            pstmt.setInt(5, id_bib);


            if (comprobarReservado(this.dni, this.id_ejem, this.isbn, this.nombre_cat, this.nombre_bib)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el reservado. ");
            System.err.println(ex);
            return false;
        }
    }


    private boolean comprobarReservado(String dni, int id_ejem, String isbn, String nombre_cat, String nombre_bib) {
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_usuario = Admin.buscarId(dni);
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from reservado where id_usuario = ? and id_ejem = ? and id_libro = ? and id_cat = ? and id_bib = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
            pstmt.setInt(2, id_ejem);
            pstmt.setInt(3, id_libro);
            pstmt.setInt(4, id_cat);
            pstmt.setInt(5, id_bib);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el reservado.");
            System.err.println(ex);
            return false;
        }
    }

/*
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
                this.fecha_ini = resultado.getString("fecha_ini");
                this.fecha_fin= resultado.getString("fecha_fin");               
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
*/
    
    //ACABAR
    public static List<Reservado> getTodosReservados() {
        List<Reservado> reservados = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from reservado";
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
