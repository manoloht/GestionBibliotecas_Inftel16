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
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Usuario implements BaseDatos<Usuario>{
    private String dni;
    private String nombre;
    private String apellido;
    private String sexo;
    private String email;
    private String password;

    public Usuario(){}
    
     public Usuario(String dni, String nombre, String apellido, String sexo, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public boolean insertar() {

        try {            
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "insert into usuario (dni,nombre,apellido,sexo,email,password) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.apellido);
            pstmt.setString(4, this.sexo);
            pstmt.setString(5, this.email);
            pstmt.setString(6, this.password);
            
            
            if (pstmt.execute()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("Error insertar usuario. " + ex);
            return false;
        }
    }

    @Override
    public boolean actualizar() {
        try {            
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "update usuario set nombre = ?, apellido = ?, sexo = ?, email = ?, password = ? where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(6, this.dni);
            pstmt.setString(1, this.nombre);
            pstmt.setString(2, this.apellido);
            pstmt.setString(3, this.sexo);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.password);
            
            
            if (pstmt.execute()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("Error insertar usuario. " + ex);
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
            
            if (pstmt.execute()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("Error borrar usuario. " + ex);
            return false;
        }
    }

    @Override
    public boolean comprobar() { 
                
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from usuario where dni like ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, this.dni);
            ResultSet resultado = pstmt.executeQuery();
            if(resultado.next())
            {
                return true;
            }else{
                return false;
            }

        } catch (Exception ex) {
           System.out.println("Error comprobar usuario. " + ex);
           return false;
        }

    }

    @Override
    public boolean buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
 }
