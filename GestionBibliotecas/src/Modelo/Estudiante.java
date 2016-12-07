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
 * @author Juan
 */
public class Estudiante extends Usuario {

    private String numExp;
    private String nombre_biblioteca;
    private List<Prestamo> prestamos;
    private List<Reservado> reservas;

    public Estudiante(String dni, String nombre, String apellido, String sexo, String email, String password, String numExp, String nombre_biblioteca) {
        super(dni, nombre, apellido, sexo, email, password);
        this.numExp = numExp;
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public Estudiante(String dni, String nombre, String apellido, String sexo, String email, String password, String numExp, String nombre_biblioteca, List<Prestamo> prestamos, List<Reservado> reservas) {
        super(dni, nombre, apellido, sexo, email, password);
        this.numExp = numExp;
        this.nombre_biblioteca = nombre_biblioteca;
        this.prestamos = prestamos;
        this.reservas = reservas;
    }

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Reservado> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservado> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "DNI=" + super.getDni() + ", Nombre=" + super.getNombre() + ", Apellidos=" + super.getApellidos() + ", Sexo=" + super.getSexo() + ", email=" + super.getEmail() + ", password=" + super.getPassword() + ", numExp=" + numExp + ", nombre_biblioteca=" + nombre_biblioteca + ", prestamos=" + prestamos + ", reservas=" + reservas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.numExp);
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
        final Estudiante other = (Estudiante) obj;
        return Objects.equals(this.numExp, other.numExp);
    }

    @Override
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into usuario (dni,nombre,apellido,sexo,email,password) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());
            pstmt.setString(2, super.getNombre());
            pstmt.setString(3, super.getApellidos());
            pstmt.setString(4, super.getSexo());
            pstmt.setString(5, super.getEmail());
            pstmt.setString(6, super.getPassword());

            String consulta2 = "insert into estudiante values (?,?,?)";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, this.numExp);
            pstmt2.setString(2, super.getDni());
            pstmt2.setString(1, this.nombre_biblioteca);

            if (!comprobarEstudiante(super.getDni(), this.getNumExp())) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el estudiante");
            System.err.println(ex);
            return false;
        }
    }

    public boolean actualizar(Estudiante e) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update usuario set dni = ?, nombre = ?, apellido = ?, sexo = ?, email = ?, password = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());
            pstmt.setString(2, super.getNombre());
            pstmt.setString(3, super.getApellidos());
            pstmt.setString(4, super.getSexo());
            pstmt.setString(5, super.getEmail());
            pstmt.setString(6, super.getPassword());
            pstmt.setString(7, e.getDni());

            String consulta2 = "update estudiante set numexp = ?, dni = ?, nombre_bib= ? where numexp like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, this.numExp);
            pstmt2.setString(2, super.getDni());
            pstmt2.setString(3, this.nombre_biblioteca);
            pstmt2.setString(4, e.getNumExp());

            if (comprobarEstudiante(super.getDni(), this.numExp)) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el estudiante");
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from estudiante where dni like ? and numexp like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());
            pstmt.setString(2, this.numExp);

            String consulta2 = "delete from usuario where dni like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());

            if (comprobarEstudiante(super.getDni(), this.numExp)) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el estudiante");
            System.err.println(ex);
            return false;
        }
    }

    private boolean comprobarEstudiante(String dni, String num_exp) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select numexp, dni, nombre_bib from estudiante where dni like ? and numexp like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            pstmt.setString(2, num_exp);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el estudiante");
            System.err.println(ex);
            return false;
        }
    }

    public static List<Estudiante> getTodosEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select u.dni, u.nombre, u.apellido, u.sexo, u.email, u.password, e.numexp, e.nombre_bib from usuario u, estudiante e where u.dni like e.dni";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                String numExp = resultado.getString("numExp");
                String nombre_bib = resultado.getString("nombre_bib");
                Estudiante e = new Estudiante(dni, nombre, apellidos, sexo, email, password, numExp, nombre_bib);
                estudiantes.add(e);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los estudiantes");
            System.err.println(ex);
        }
        return estudiantes;
    }
}
