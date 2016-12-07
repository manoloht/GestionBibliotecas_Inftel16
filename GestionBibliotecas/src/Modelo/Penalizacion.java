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

    private Date Fecha_inicio;
    private Date Fecha_fin;
    private String dni;

    public Penalizacion() {
    
    }

    public Penalizacion(Date Fecha_inicio, Date Fecha_fin, String dni) {
        this.Fecha_inicio = Fecha_inicio;
        this.Fecha_fin = Fecha_fin;
        this.dni = dni;
    }

    public Date getFecha_inicio() {
        return Fecha_inicio;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public String getDni() {
        return dni;
    }

    public void setFecha_inicio(Date Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public void setFecha_fin(Date Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "Fecha_inicio=" + Fecha_inicio + ", Fecha_fin=" + Fecha_fin + ", dni=" + dni + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.Fecha_inicio);
        hash = 59 * hash + Objects.hashCode(this.Fecha_fin);
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
        if (!Objects.equals(this.Fecha_inicio, other.Fecha_inicio)) {
            return false;
        }
        return Objects.equals(this.Fecha_fin, other.Fecha_fin);
    }

    @Override // ACABAR---->HECHO
    public boolean insertar() {
       try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into biblioteca (fecha_inicio,fecha_fin,dni) values (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setDate(1, (java.sql.Date) this.Fecha_inicio);
            pstmt.setDate(2, (java.sql.Date) this.Fecha_fin);
            pstmt.setString(3, this.dni);
            return pstmt.execute();

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

            String consulta = "update penalizacion set Fecha_inicio = ?, Fecha_fin = ?, dni = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
           
            pstmt.setDate(1, (java.sql.Date) this.Fecha_inicio);
            pstmt.setDate(2, (java.sql.Date) this.Fecha_fin);
            pstmt.setString(3, this.dni);
            pstmt.setString(4, p.getDni());
            
            return pstmt.execute();

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

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar la penalizacion");
            System.err.println(ex);
            return false;
        }
    }

       public boolean comprobarPenalizacion(String dni) {
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
                Date Fecha_inicio = resultado.getDate("Fecha_inicio");
                Date Fecha_fin = resultado.getDate("Fecha_fin");
                String dni = resultado.getString("dni");
                Penalizacion p = new Penalizacion(Fecha_inicio,Fecha_fin, dni);
                penalizaciones.add(p);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todas las penalizaciones");
            System.err.println(ex);
        }
        return penalizaciones;
    }
}
