/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Juan
 */
public class Penalizacion implements BaseDatos<Penalizacion> {
    private int id_estudiante;
    private String fecha_inicio;
    private String fecha_fin;
    private String dni;

    public Penalizacion() {

    }

    public Penalizacion(int id_estudiante, String fecha_fin) {
        this.id_estudiante = id_estudiante;
        this.fecha_fin = fecha_fin;
    }

    public Penalizacion(String fecha_inicio, String fecha_fin, String dni) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dni = dni;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getfecha_inicio() {
        return fecha_inicio;
    }

    public String getfecha_fin() {
        return fecha_fin;
    }

    public String getDni() {
        return dni;
    }

    public void setfecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setfecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "id_estudiante=" + id_estudiante + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", dni=" + dni + '}';
    }

   

   

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 59 * hash + Objects.hashCode(this.fecha_fin);
        hash = 59 * hash + Objects.hashCode(this.dni);
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
        final Penalizacion other = (Penalizacion) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.fecha_inicio, other.fecha_inicio)) {
            return false;
        }
        return Objects.equals(this.fecha_fin, other.fecha_fin);
    }

    @Override // ACABAR---->HECHO
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            id_estudiante=Estudiante.buscarId(this.dni);
            
            String consulta = "insert into penalizacion (id_usuario,fecha_inicio, fecha_fin) values (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_estudiante);
            pstmt.setString(2, this.fecha_inicio);
            pstmt.setString(3, this.fecha_fin);
          

            if (!comprobarPenalizacion( id_estudiante)) {  // no existe penalizacion, un estudiante solo permite una penalizacion
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar penalizado");
            System.err.println(ex);
            return false;
        }
    }
 
    @Override // ACABAR--->HECHO
    public boolean actualizar(Penalizacion p) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            id_estudiante=Estudiante.buscarId(this.dni);
            String consulta = "update penalizacion set fecha_inicio = ?, fecha_fin = ? where id_usuario like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            
            pstmt.setString(1,  p.getfecha_inicio());
            pstmt.setString(2,  p.getfecha_fin());
            pstmt.setInt(3, id_estudiante);
           

            if (comprobarPenalizacion(id_estudiante)) {  // existe penalizacion para este estudiante
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar la penalizaion");
            System.err.println(ex);
            return false;
        }
    }

    @Override // ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            id_estudiante=Estudiante.buscarId(this.dni);
            System.out.println(id_estudiante);
            String consulta = "delete from penalizacion where id_usuario like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_estudiante);
                    
            if (comprobarPenalizacion(id_estudiante)) {  // existe la penalizacion
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar la penalizacion");
            System.err.println(ex);
            return false;
        }
    }

    private boolean comprobarPenalizacion(int id_estudiante) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from penalizacion where id_usuario like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_estudiante);
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar la penalizacion");
            System.err.println(ex);
            return false;
        }
    }

    // ACABAR-----> HECHO
    public static List<Penalizacion> getTodosPenalizacion() {

        List<Penalizacion> penalizaciones = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from penalizacion";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String fecha_inicio = resultado.getString("fecha_inicio");
                String fecha_fin = resultado.getString("fecha_fin");
                String dni = resultado.getString("dni");
                Penalizacion p = new Penalizacion(fecha_inicio, fecha_fin, dni);
                penalizaciones.add(p);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todas las penalizaciones");
            System.err.println(ex);
        }
        return penalizaciones;
    }
}
