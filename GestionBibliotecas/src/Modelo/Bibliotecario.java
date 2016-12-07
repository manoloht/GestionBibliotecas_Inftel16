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
public class Bibliotecario extends Usuario {

    private String nombre_biblioteca;

    public Bibliotecario(String dni, String nombre, String apellido, String sexo, String email, String password) {
        super(dni, nombre, apellido, sexo, email, password);
    }

    public Bibliotecario(String dni, String nombre, String apellido, String sexo, String email, String password, String nombre_biblioteca) {
        super(dni, nombre, apellido, sexo, email, password);
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "DNI=" + super.getDni() + ", Nombre=" + super.getNombre() + ", Apellidos=" + super.getApellidos() + ", Sexo=" + super.getSexo() + ", email=" + super.getEmail() + ", password=" + super.getPassword() + ", biblioteca=" + this.nombre_biblioteca + '}';
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

            String consulta2 = "insert into bibliotecario values (?, ?)";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());
            pstmt2.setString(2, this.nombre_biblioteca);

            if (!comprobarBibliotecario(super.getDni())) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el administrador");
            System.err.println(ex);
            return false;
        }
    }

    public boolean actualizar(Bibliotecario b) {
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
            pstmt.setString(7, b.getDni());

            String consulta2 = "update bibliotecario set dni = ? where dni like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());
            pstmt2.setString(2, b.getDni());

            if (comprobarBibliotecario(super.getDni())) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el bibliotecario");
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from bibliotecario where dni like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());

            String consulta2 = "delete from usuario where dni like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());

            if (comprobarBibliotecario(super.getDni())) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el bibliotecario");
            System.err.println(ex);
            return false;
        }
    }

    private boolean comprobarBibliotecario(String dni) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select dni from bibliotecario where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el bibliotecario");
            System.err.println(ex);
            return false;
        }
    }

    public static List<Bibliotecario> getTodosBibliotecarios() {
        List<Bibliotecario> bibliot = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select u.dni, u.nombre, u.apellido, u.sexo, u.email, u.password, b.nombre_bib from usuario u, bibliotecario b where u.dni like b.dni";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                String nombre_biblioteca = resultado.getString("nombre_bib");
                Bibliotecario b = new Bibliotecario(dni, nombre, apellidos, sexo, email, password, nombre_biblioteca);
                bibliot.add(b);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los bibliotecarios");
            System.err.println(ex);
        }
        return bibliot;
    }

}
