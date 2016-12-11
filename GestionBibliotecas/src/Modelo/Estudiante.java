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

    public Estudiante(String dni, String numExp) {
        super(dni);
        this.numExp = numExp;
    }

    public Estudiante(String numexp, String dni, String nombre_bi) {
        super(dni);
        this.numExp = numexp;
        this.nombre_biblioteca = nombre_bi;
    }

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
            super.insertar();// insertar dato en table usuario
            //  buscar id(nextval) de usuario para insertar en tabla estudiante
            int id_estudiante = Usuario.buscarId(super.getDni());
               // buscar id de biblioteca que pertenece el estudiante para insertar en tabla estudiante
            int id_bib = Biblioteca.buscarId(this.nombre_biblioteca);          
            
            String consulta2 = "insert into estudiante (numexp,id_bib,id_usuario) values (?,?,?)";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, this.numExp);
            pstmt2.setInt(2, id_bib);
            pstmt2.setInt(3, id_estudiante);

            if (!comprobarEstudiante(id_estudiante)) {// tabla estudiante no existe el estudiante 
              
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
            int  id_estudiante = Usuario.buscarId(super.getDni());// buscar id en tabla usuario para probar existencia
            int id_bib = Biblioteca.buscarId(e.getNombre_biblioteca()); // bucar id_bib para actualizar           

            String consulta2 = "update estudiante set numexp = ?, id_bib = ? where id_usuario like ?";
            PreparedStatement pstmt2 = con.prepareStatement(consulta2);
            pstmt2.clearParameters();
            pstmt2.setString(1, e.getNumExp());
            pstmt2.setInt(2, id_bib);
            pstmt2.setInt(3,id_estudiante );
            

            if (comprobarEstudiante(id_estudiante)) { // existe id en tabla estudiante
                super.actualizar(e);   // actualizar dato persona de estudiante en tabla usuario
                pstmt2.executeUpdate(); // actualizar numex y sito de bibloteca que pertenece en tabla estudiante
                con.close();
            } else {
               
                con.close();
            }
            return true;

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
            int id_estudiante = Usuario.buscarId(super.getDni()); // buscar id de estudiante en tabla usuario
            String consulta = "delete from estudiante where id_usuario like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_estudiante);         


            if (comprobarEstudiante(id_estudiante)) {
                pstmt.executeUpdate();  // borrar en table estudiante
                super.borrar();   // borrar en table usuario   borrar cascate!!!!!
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

    private boolean comprobarEstudiante(int id_usuario) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from estudiante where id_usuario like ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);
           
            ResultSet resultado = pstmt.executeQuery();
            con.close();
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
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los estudiantes");
            System.err.println(ex);
        }
        
        return estudiantes;
    }

    public static List<Estudiante> getTodosEstudiantesBiblioteca(String nombre_bi) {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from estudiante where nombre_bib like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre_bi);
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                String numExp = resultado.getString("numExp");
                String dni = resultado.getString("dni");
                String nombre_bib = resultado.getString("nombre_bib");
                Estudiante e = new Estudiante(numExp, dni,  nombre_bib);
                estudiantes.add(e);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los estudiantes");
            System.err.println(ex);
        }
        return estudiantes;
    }
}
