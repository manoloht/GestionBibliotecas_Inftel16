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
import Controlador.*;

/**
 *
 * @author Juan
 */
public class Biblioteca implements BaseDatos<Biblioteca> {

    int id_bib;
    int id_admin;
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

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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

    public int getId_bibl() {
        return id_bib;
    }

    public void setId_bib(int id_biblioteca) {
        this.id_bib = id_biblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "id_bib=" + id_bib + ", nombre=" + nombre + ", localizacion=" + localizacion + ", telefono=" + telefono + ", categorias=" + categorias + ", dni_admin=" + dni_admin + ", bibliotecarios=" + bibliotecarios + ", estudiantes=" + estudiantes + '}';
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

            String consulta = "insert into biblioteca (id_bib,nombre,localizacion,telefono,id_usuario) values (seq_id_bib.nextval,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(4, Usuario.buscarId(this.getDni_admin()));
            pstmt.setString(1, this.nombre);
            pstmt.setString(2, this.localizacion);
            pstmt.setInt(3, this.telefono);

            if (!comprobarBiblioteca(this.nombre)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar el biblioteca");
            System.err.println(ex);
            return false;
        }

    }

    @Override //ACABAR------> HECHO
    public boolean actualizar(Biblioteca b) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
//             int id=Usuario.buscarId(b.getDni_admin());
            String consulta = "update biblioteca set nombre = ?, telefono = ?, localizacion = ?,id_usuario = ? where nombre like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, b.getNombre());
            pstmt.setInt(2, b.getTelefono());
            pstmt.setString(3, b.getLocalizacion());
//             pstmt.setInt(4, 1);
            pstmt.setInt(4, Usuario.buscarId(b.getDni_admin()));
            pstmt.setString(5, this.nombre);
//           
            System.out.println("new nombre:" + b.getNombre());
            System.out.println("old nombre:" + this.nombre);
            System.out.println("new telefono:" + b.getTelefono());
            System.out.println("new localizacion:" + b.getLocalizacion());
           System.out.println("existe es biblioteca old name?"+comprobarBiblioteca(this.nombre));
            if (comprobarBiblioteca(this.nombre)) {
                 System.out.println("existe es biblioteca");
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

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

            if (comprobarBiblioteca(this.nombre)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar el biblioteca");
            System.err.println(ex);
            return false;
        }
    }

    private boolean comprobarBiblioteca(String nombre) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from biblioteca where nombre like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();

            pstmt.setString(1, nombre);
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar la biblioteca");
            System.err.println(ex);
            return false;
        }
    }

    public static int buscarId(String nombre) {
        int id = 0;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_bib from biblioteca where nombre like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                id = resultado.getInt("id_bib");

            }
            con.close();
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Biblioteca.");
            System.err.println(ex);
            return -1;
        }
    }

    public static List<Biblioteca> getTodosBibliotecas() {

        List<Biblioteca> bibliotecas = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from biblioteca";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                int id_bib = resultado.getInt("id_bib");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                String localizacion = resultado.getString("localizacion");
                String dni_admin = (Util.buscarBiblioteca(id_bib)).getDni_admin();
                Biblioteca b = new Biblioteca(nombre, localizacion, telefono, dni_admin);
                b.setId_bib(id_bib);
                bibliotecas.add(b);
                
            }
            con.close();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos las bibliotecas");
            System.err.println(ex);
        }
        return bibliotecas;
    }
}
