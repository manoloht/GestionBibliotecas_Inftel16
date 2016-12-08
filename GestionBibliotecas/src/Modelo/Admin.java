/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Juan
 */
public class Admin extends Usuario {

    private List<Biblioteca> bibliotecas;
    
    public Admin(String dni){
        super(dni);
    }

    public Admin(String dni, String nombre, String apellido, String sexo, String email, String password) {
        super(dni, nombre, apellido, sexo, email, password);
    }

    public Admin(String dni, String nombre, String apellido, String sexo, String email, String password, List<Biblioteca> bibliotecas) {
        super(dni, nombre, apellido, sexo, email, password);
        this.bibliotecas = bibliotecas;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    @Override
    public String toString() {
        return "Admin{" + "DNI=" + super.getDni() + ", Nombre=" + super.getNombre() + ", Apellidos=" + super.getApellidos() + ", Sexo=" + super.getSexo() + ", email=" + super.getEmail() + ", password=" + super.getPassword() + ", bibliotecas=" + this.bibliotecas + '}';
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

            String consulta2 = "insert into admin values (?)";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());

            if (!comprobarAdmin(super.getDni())) {
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

    public boolean actualizar(Admin a) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update usuario set dni = ?, nombre = ?, apellido = ?, sexo = ?, email = ?, password = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());
            pstmt.setString(2, a.getNombre());
            pstmt.setString(3, a.getApellidos());
            pstmt.setString(4, a.getSexo());
            pstmt.setString(5, a.getEmail());
            pstmt.setString(6, a.getPassword());
            pstmt.setString(7, super.getDni());

            String consulta2 = "update admin set dni = ? where dni like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());
            pstmt2.setString(2, super.getDni());
            
            if (comprobarAdmin(a.getDni())) {
                pstmt.executeUpdate();
                con.close();
            } else {
                a.insertar();
                this.borrar();
                con.close(); 
            }
            return true;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el administrador");
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from admin where dni like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, super.getDni());

            String consulta2 = "delete from usuario where dni like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, super.getDni());

            if (comprobarAdmin(super.getDni())) {
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el administrador");
            System.err.println(ex);
            return false;
        }
    }

    public boolean comprobarAdmin(String dni) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select dni from admin where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery();

            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el administrador");
            System.err.println(ex);
            return false;
        }
    }

    public static List<Admin> getTodosAdmin() {
        List<Admin> admins = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select u.dni, u.nombre, u.apellido, u.sexo, u.email, u.password from usuario u, admin a where u.dni like a.dni";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                Admin a = new Admin(dni, nombre, apellidos, sexo, email, password);
                admins.add(a);
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los administradores");
            System.err.println(ex);
        }
        return admins;
    }
}
