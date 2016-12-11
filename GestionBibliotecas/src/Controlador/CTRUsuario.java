/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.util.*;

/**
 *
 * @author albertocheca
 */
public class CTRUsuario {

    // DEVOLVER LISTA DE USUARIOS POR ROL, PALABRA CLAVE Y VALOR PALABRA CLAVE 
    // rol PUEDE SER Todos, Administrador, Biliotecario, Estudiante);
    // palabra_clave PUEDE SER Dni, Nombre, Apellidos, Email
    // valor PUEDE SER cualquiera que introduzca el usuario
    public static List<Usuario> buscarUsuarios(String rol, String palabra_clave, String valor_pal_clave) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        if (rol.equals("rol")) {
            for (int i = 0; i < 76; i++) {
                Usuario u = new Usuario(rol + i, palabra_clave + i, valor_pal_clave + i, "V", "email" + i, "pass" + i);
                listaUsuarios.add(u);
            }
        }

        for (int i = 0; i < 45; i++) {
            Usuario u = new Usuario(rol + i, palabra_clave + i, valor_pal_clave + i, "H", "email" + i, "pass" + i);
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }

    // DEVOLVER LISTA DE USUARIOS POR ROL
    // rol PUEDE SER Todos, Administrador, Biliotecario, Estudiante);
    public static List<Usuario> buscarUsuariosRol(String rol) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        if (rol.equals("Todos")) {
            listaUsuarios = CTRUsuario.getTodosUsuarios();
        } else{
            
        }
        return listaUsuarios;
    }

    // OBTENER TODOS LOS USUARIOS DE LA TABLA USUARIOS
    public static List<Usuario> getTodosUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            Usuario u = new Usuario("usuario" + i, "usuario" + i, "usuario" + i, "V", "usuario" + i, "usuario" + i);
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }
    
    // METODO PARA COMPROBAR SI EXISTE UN ADMINISTRADOR, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarAdministrador(String dni){
        if(dni.equals("1")){
            return true;
        }else{
            return false;
        }
    }
    
     // METODO PARA INSERTAR UN ADMINISTRADOR, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarAdministrador(String dni, String nombre, String apellido, String sexo, String email, String biblioteca){
        if(dni.equals("2")){
            return true;
        }else{
            return false;
        }
    }
    
     // METODO PARA COMPROBAR SI EXISTE UN BIBLIOTECARIO, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarBibliotecario(String dni){
        if(dni.equals("1")){
            return true;
        }else{
            return false;
        }
    }
    
    // METODO PARA INSERTAR UN BIBLIOTECARIO, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarBibliotecario(String dni, String nombre, String apellido, String sexo, String email, String biblioteca){
        if(dni.equals("2")){
            return true;
        }else{
            return false;
        }
    }
    
     // METODO PARA COMPROBAR SI EXISTE UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarEstudiante(String dni){
        if(dni.equals("1")){
            return true;
        }else{
            return false;
        }
    }
    
    // METODO PARA INSERTAR UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarEstudiante(String dni, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp){
        if(dni.equals("estudiante")){
            return true;
        }else{
            return false;
        }
    }
}
