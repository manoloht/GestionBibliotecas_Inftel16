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
        return "Estudiante{"+"DNI=" + super.getDni() + ", Nombre="+ super.getNombre()+ ", Apellidos=" + super.getApellidos()+ ", Sexo="+ super.getSexo()+ ", email=" + super.getEmail()+ ", password=" + super.getPassword()+ ", numExp=" + numExp + ", nombre_biblioteca=" + nombre_biblioteca + ", prestamos=" + prestamos + ", reservas=" + reservas + '}';
    }

    //ACABAR
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
