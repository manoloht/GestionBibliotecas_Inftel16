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

    public Admin(String dni) {
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
            super.insertar();  // insertar en tabla de usuario                  
            int id_admin = Usuario.buscarId(super.getDni()); // buscar id de usuario para intertar en tabla admin
            String consulta = "insert into admin (id_usuario) values (?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_admin);

            if (!comprobarAdmin(id_admin)) {           
                pstmt.executeUpdate();
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
             int id_admin = Usuario.buscarId(super.getDni());//           
            if (comprobarAdmin(id_admin)) { // en la tabla admin existe este id_admin
                super.actualizar(a);
                con.close();
                return true;
            } else {             
                con.close();
                return false;
            }
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
            int id_admin = Usuario.buscarId(super.getDni()); // buscar id de admin en tabla usuario
            String consulta = "delete from admin where id_usuario like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_admin);       

            if (comprobarAdmin(id_admin)) {  // existe id en tabla admin
                pstmt.executeUpdate();  // boorrar en tabla admin
                super.borrar();    // borrar en tabla usuario
//                pstmt2.executeUpdate();
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

    public static boolean comprobarAdmin(int id_admin) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select id_usuario from admin where id_usuario like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_admin);
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
