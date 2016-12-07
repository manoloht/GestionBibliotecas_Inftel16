/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


/**
 *
 * @author Juan
 */
public class Biblioteca implements BaseDatos<Biblioteca> {

    private String nombre;
    private String localizacion;
    private int telefono;
    private List<Categoria> categorias;
    private String dni_admin;
    private List<Bibliotecario> bibliotecarios;
    private List<Estudiante> estudiantes;

    public Biblioteca() {
    
    }

    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public Biblioteca(String nombre, String localizacion, int telefono, String dni_admin) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.telefono = telefono;
        this.dni_admin = dni_admin;
    }

    public Biblioteca(String nombre, String localizacion, int telefono, List<Categoria> cat, String dni_admin, List<Bibliotecario> bibliotecarios, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.telefono = telefono;
        this.categorias = cat;
        this.dni_admin = dni_admin;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public String getDni_admin() {
        return dni_admin;
    }

    public List<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(List<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public void setDni_admin(String dni_admin) {
        this.dni_admin = dni_admin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "nombre=" + nombre + ", localizacion=" + localizacion + ", telefono=" + telefono + ", categorias=" + categorias + ", dni_admin=" + dni_admin + ", bibliotecarios=" + bibliotecarios + ", estudiantes=" + estudiantes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
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
        final Biblioteca other = (Biblioteca) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override //ACABAR----> HECHO
    public boolean insertar() {
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into biblioteca (dni_admin,nombre,localizacion,telefono) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni_admin);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.localizacion);
            pstmt.setInt(4, this.telefono);
           
            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el biblioteca");
            System.err.println(ex);
            return false;
        }
       
    }

    public static void main(String[] args){
        Biblioteca b = new Biblioteca("Biblioteca Fisica","malaga",954367695,"123123");
        //b.insertar();
       
        System.out.println(b.toString());
        System.out.println(b.actualizar());
        
    }
    
    
    @Override //ACABAR------> HECHO
    public boolean actualizar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update biblioteca set nombre = ?, telefono = ?, localizacion = ?, dni_admin = ? where nombre like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
           
            pstmt.setString(1, this.nombre);
            pstmt.setInt(2, this.telefono);
            pstmt.setString(3, this.localizacion);
            pstmt.setString(4, this.dni_admin);
           

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar la biblioteca");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR---->HECHO
    public boolean borrar() {
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from biblioteca where nombre like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre);

            return pstmt.execute();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el biblioteca");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean comprobar() {
        return false;
    }

    @Override //ACABAR
    public boolean buscar() {
        return false;
    }

    //ACABAR
    public static List<Biblioteca> getTodas() {
        return null;
    }
}
