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

    public Bibliotecario(String dni) {
        super(dni);
    }

    public Bibliotecario(String nombre_biblioteca, String dni) {
        super(dni);
        this.nombre_biblioteca = nombre_biblioteca;
    }

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
            super.insertar();  // insertar dato en tabla de usuario  
            //  buscar id(nextval) de usuario para insertar en tabla bibliotecario
            int id_bibliotecario = Usuario.buscarId(super.getDni());
            // buscar id de biblioteca que trabaja para insertar en tabla bibliotecario
            int id_bib = Biblioteca.buscarId(this.nombre_biblioteca);

            String consulta2 = "insert into bibliotecario(id_usuario,id_bib) values (?, ?)";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setInt(1, id_bibliotecario);
            pstmt2.setInt(2, id_bib);

            if (!comprobarBibliotecario(id_bibliotecario)) {
//             
                pstmt2.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el bibliotecario");
            System.err.println(ex);
            return false;
        }
    }

    public boolean actualizar(Bibliotecario b) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            int id_bibliotecario = Usuario.buscarId(super.getDni());// buscar id en tabla usuario para probar existencia
            int id_bib = Biblioteca.buscarId(b.getNombre_biblioteca()); // bucar id_bib para actualizar
//        
            String consulta2 = "update bibliotecario set id_bib = ? where id_usuario like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setInt(1, id_bib);
            pstmt2.setInt(2, id_bibliotecario);

            if (comprobarBibliotecario(id_bibliotecario)) { // existe en tabla bibliotecario
                super.actualizar(b); // actualizar dato personal en tabla usuario
                pstmt2.executeUpdate(); // actualizar sito que trabajo
                con.close();
            } else {
                b.insertar();
                this.borrar();
                con.close();
            }
            return true;

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
            int id_bibliotecario = Usuario.buscarId(super.getDni()); // buscar id de bibliotecario en tabla usuario
            String consulta = "delete from bibliotecario where id_usuario like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_bibliotecario);

            if (comprobarBibliotecario(id_bibliotecario)) { // existe id en tabla biliotecario
                pstmt.executeUpdate(); // borrar en tabla bibliotecario
                super.borrar();  // borrar en tabla usuario, por cascade borrar en tabla bibliotecario ojo !!!
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

    private boolean comprobarBibliotecario(int id_usuario) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_usuario from bibliotecario where id_usuario like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
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
