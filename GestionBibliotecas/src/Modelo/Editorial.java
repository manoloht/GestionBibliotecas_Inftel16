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
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.*;
import java.util.*;


/**
 *
 * @author YUEMEI
 */
public class Editorial implements BaseDatos<Editorial> {
    int id_edit;
    private String nombre_edit;
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(String nombre_edit) {
        this.nombre_edit = nombre_edit;    // constructor de clave
    }

    public Editorial(String nombre_edit, List<Libro> libros) {
        this.nombre_edit = nombre_edit;
        this.libros = libros;
    }

    public int getId_edit() {
        return id_edit;
    }

    public void setId_edit(int id_edit) {
        this.id_edit = id_edit;
    }    
    
    public String getNombre_edit() {
        return nombre_edit;
    }

    public void setNombre_edit(String nombre_edit) {
        this.nombre_edit = nombre_edit;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id_edit=" + id_edit + ", nombre_edit=" + nombre_edit + ", libros=" + libros + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nombre_edit);
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
        final Editorial other = (Editorial) obj;
        return Objects.equals(this.nombre_edit, other.nombre_edit);
    }

    @Override //ACABAR
    public boolean insertar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into editorial (id_edit,nombre_edit) values (seq_id_edit.nextval,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre_edit);            

            if (!comprobarEditorial(this.nombre_edit)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al insertar la editorial.");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean actualizar(Editorial ed) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update editorial set nombre_edit = ? where nombre_edit like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, ed.nombre_edit);
            pstmt.setString(2, this.nombre_edit);
           
               if (comprobarEditorial(this.nombre_edit) && !comprobarEditorial(ed.nombre_edit)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al actualizar el editorial");
            System.err.println(ex);
            return false;
        }
    }

    @Override //ACABAR
    public boolean borrar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "delete from editorial where nombre_edit like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.nombre_edit);

          if (comprobarEditorial(this.nombre_edit)) {
                pstmt.executeUpdate();
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al borrar la editorial.");
            System.err.println(ex);
            return false;
        }
    }

    //@Override 
    public boolean comprobarEditorial(String nombre_edit) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from editorial where nombre_edit like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1,nombre_edit);
            ResultSet resultado = pstmt.executeQuery();
            con.close();
            return resultado.next();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar la editorial.");
            System.err.println(ex);
            return false;
        }
    }


    public static int buscarId(String nombre_edit){
        int id=0;
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select id_edit from editorial where nombre_edit like ?";

            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, nombre_edit);
            
            ResultSet resultado = pstmt.executeQuery();
            while(resultado.next()){
               id = resultado.getInt("id_edit");
            }      
            con.close();
            return id;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar id Libro.");
            System.err.println(ex);
            return -1;
        }
    }
    
    
    // ACABAR
    public static List<Editorial> getTodasEditoriales() {
         List<Editorial> editoriales = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from editorial";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {               
                String nombre = resultado.getString("nombre_edit");                
                Editorial ed = new Editorial(nombre);
                editoriales.add(ed);
            }
              con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos las editoriales");
            System.err.println(ex);
        }
        return editoriales;
    }
public static void main(String[] args) {
       
        boolean exito=false;
//          Editorial y = new Editorial("SUR");
//          exito=y.insertar();
//            Editorial x = new Editorial("ANAYA");
//            exito=x.insertar();
//        Editorial x = new Editorial("ANAYA");
//        exito=x.borrar();      
// Editorial y = new Editorial("SUR");
  Editorial x = new Editorial("nana");
   Editorial z = new Editorial("anaya");
  exito= x.actualizar(z);
  System.out.println(exito);
        List<Editorial> editoriales = new ArrayList<>();
        editoriales=Editorial.getTodasEditoriales();  // exito
        System.out.println(editoriales);
        
    }

   
}
