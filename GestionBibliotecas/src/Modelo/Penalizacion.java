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

    private Date fecha_inicio;
    private Date fecha_fin;
    private String dni;

    public Penalizacion() {

    }

    public Penalizacion(Date fecha_inicio, Date fecha_fin, String dni) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dni = dni;
    }

    public Date getfecha_inicio() {
        return fecha_inicio;
    }

    public Date getfecha_fin() {
        return fecha_fin;
    }

    public String getDni() {
        return dni;
    }

    public void setfecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setfecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", dni=" + dni + '}';
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

            String consulta = "insert into penalizacion (fecha_inicio, fecha_fin, dni) values (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setDate(1, (java.sql.Date) this.fecha_inicio);
            pstmt.setDate(2, (java.sql.Date) this.fecha_fin);
            pstmt.setString(3, this.dni);

            if (!comprobarPenalizacion(this.dni)) {
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
    public static void main(String[] args){
        Penalizacion p = new Penalizacion(null,null,"pepe232");
        p.insertar();
        System.out.println(p.insertar());
    }

    @Override // ACABAR--->HECHO
    public boolean actualizar(Penalizacion p) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update penalizacion set fecha_inicio = ?, fecha_fin = ?, dni = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();

            pstmt.setDate(1, (java.sql.Date) this.fecha_inicio);
            pstmt.setDate(2, (java.sql.Date) this.fecha_fin);
            pstmt.setString(3, this.dni);
            pstmt.setString(4, p.getDni());

            if (!comprobarPenalizacion(this.dni)) {
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

            String consulta = "delete from penalizacion where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
                    
            if (!comprobarPenalizacion(this.dni)) {
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

    private boolean comprobarPenalizacion(String dni) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from penalizacion where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery();

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
                Date fecha_inicio = resultado.getDate("fecha_inicio");
                Date fecha_fin = resultado.getDate("fecha_fin");
                String dni = resultado.getString("dni");
                Penalizacion p = new Penalizacion(fecha_inicio, fecha_fin, dni);
                penalizaciones.add(p);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todas las penalizaciones");
            System.err.println(ex);
        }
        return penalizaciones;
    }
}
