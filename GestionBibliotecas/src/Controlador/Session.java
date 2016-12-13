/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Manuel
 */
public class Session {
    static int id_usuario;
    static String nombre;
    static String apellidos;
    static String email;
    static String sexo;
    static String dni;
    static String password;

    
    public Session() {
    }
    
    public Session(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public static int getId_usuario() {
        return id_usuario;
    }

    public static void setId_usuario(int id_usuario) {
        Session.id_usuario = id_usuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static void setNombre(String nombre) {
        Session.nombre = nombre;
    }

    public static void setApellidos(String apellidos) {
        Session.apellidos = apellidos;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Session.email = email;
    }

    public static String getSexo() {
        return sexo;
    }

    public static void setSexo(String sexo) {
        Session.sexo = sexo;
    }

    public static String getDni() {
        return dni;
    }

    public static void setDni(String dni) {
        Session.dni = dni;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Session.password = password;
    }
    
}
