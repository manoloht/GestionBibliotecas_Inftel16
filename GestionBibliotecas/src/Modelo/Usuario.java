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
public class Usuario implements BaseDatos<Usuario> {

    private String dni;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(String dni) {
        this.dni = dni;
    }

    public Usuario(String dni, String nombre, String apellidos, String sexo, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.email = email;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo + ", email=" + email + ", password=" + password + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.dni);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public boolean insertar() {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into usuario (dni,nombre,apellido,sexo,email,password) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.apellidos);
            pstmt.setString(4, this.sexo);
            pstmt.setString(5, this.email);
            pstmt.setString(6, this.password);

            if (!comprobarUsuario(this.dni)) {
                pstmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el usuario");
            System.err.println(ex);
            return false;
        }
    }

    public boolean actualizar(String clave) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update usuario set dni = ?, nombre = ?, apellido = ?, sexo = ?, email = ?, password = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.apellidos);
            pstmt.setString(4, this.sexo);
            pstmt.setString(5, this.email);
            pstmt.setString(6, this.password);
            pstmt.setString(7, clave);

            if (!comprobarUsuario(this.dni)) {
                pstmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el usuario");
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from usuario where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);

            if (!comprobarUsuario(this.dni)) {
                pstmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el usuario");
            System.err.println(ex);
            return false;
        }
    }

    private boolean comprobarUsuario(String dni) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from usuario where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el usuario");
            System.err.println(ex);
            return false;
        }
    }

    public static List<Usuario> getTodosUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from usuario";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                Usuario u = new Usuario(dni, nombre, apellidos, sexo, email, password);
                usuarios.add(u);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los usuarios");
            System.err.println(ex);
        }
        return usuarios;
    }
}
