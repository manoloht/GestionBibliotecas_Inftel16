/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Configuracion.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
        List<Usuario> usuarios = new ArrayList<>();
        String consulta;
        
        switch (rol) {
            case "Todos":
            case "todos":
            case "TODOS":
                consulta = "select * from usuario where " + palabra_clave + " like '" + valor_pal_clave + "'";
                break;
                
            case "Administrador":
            case "administrador":
            case "ADMINISTRADOR":
                consulta = "select * from usuario u where EXISTS (select id_usuario from admin e where u.id_usuario = e.id_usuario) and " + palabra_clave + " like '" + valor_pal_clave + "'";
                break;
                
            case "Estudiante":
            case "estudiante":
            case "ESTUDIANTE":
                consulta = "select * from usuario u where EXISTS (select id_usuario from estudiante e where u.id_usuario = e.id_usuario) and " + palabra_clave + " like '" + valor_pal_clave + "'";
                break;
                
            case "Bibliotecario":
            case "bibliotecario":
            case "BIBLIOTECARIO":
                consulta = "select * from usuario u where EXISTS (select id_usuario from bibliotecario e where u.id_usuario = e.id_usuario) and " + palabra_clave + " like '" + valor_pal_clave + "'";
                break;
                
            default:
                return usuarios;
        }
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();               
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            
            while (resultado.next()) {
                int id_usuario = resultado.getInt("id_usuario");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                Usuario u = new Usuario(dni, nombre, apellidos, sexo, email, password);
                u.setId_usuario(id_usuario);
                usuarios.add(u);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los usuarios. CTRUsuario.buscarUsuarios");
            System.err.println(ex);
        }
        return usuarios;
    }

    // DEVOLVER LISTA DE USUARIOS POR ROL
    // rol PUEDE SER Todos, Administrador, Biliotecario, Estudiante);
    public static List<Usuario> buscarUsuariosRol(String rol) {
        List<Usuario> usuarios = new ArrayList<>();
        String consulta;
        
        switch (rol) {
            case "Todos":
            case "todos":
            case "TODOS":
                consulta = "select * from usuario";
                break;
                
            case "Administrador":
            case "administrador":
            case "ADMINISTRADOR":
                consulta = "select * from usuario u where EXISTS (select id_usuario from admin e where u.id_usuario = e.id_usuario)";
                break;
                
            case "Estudiante":
            case "estudiante":
            case "ESTUDIANTE":
                consulta = "select * from usuario u where EXISTS (select id_usuario from estudiante e where u.id_usuario = e.id_usuario)";
                break;
                
            case "Bibliotecario":
            case "bibliotecario":
            case "BIBLIOTECARIO":
                consulta = "select * from usuario u where EXISTS (select id_usuario from bibliotecario e where u.id_usuario = e.id_usuario)";
                break;
                
            default:
                return usuarios;
        }
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();               
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);
            
            while (resultado.next()) {
                int id_usuario = resultado.getInt("id_usuario");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                Usuario u = new Usuario(dni, nombre, apellidos, sexo, email, password);
                u.setId_usuario(id_usuario);
                usuarios.add(u);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los usuarios. CTRUsuario.buscarUsuariosRol");
            System.err.println(ex);
        }
        return usuarios;
    }

    // OBTENER TODOS LOS USUARIOS DE LA TABLA USUARIOS
    public static List<Usuario> getTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from usuario";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                int id_usuario = resultado.getInt("id_usuario");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellido");
                String sexo = resultado.getString("sexo");
                String email = resultado.getString("email");
                String password = resultado.getString("password");
                Usuario u = new Usuario(dni, nombre, apellidos, sexo, email, password);
                u.setId_usuario(id_usuario);
                usuarios.add(u);
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los usuarios");
            System.err.println(ex);
        }
        return usuarios;
    }
    
    // METODO PARA COMPROBAR SI EXISTE UN ADMINISTRADOR, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarAdministrador(String dni){
        boolean comprueba;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
       
            String consulta = "select * from usuario u where dni like ? and EXISTS (select id_usuario from admin e where u.id_usuario = e.id_usuario)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery(); 
            comprueba = resultado.next();
            con.close();
            
            return comprueba;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el administrador. CTRUsuario.comprobarAdministrador");
            System.err.println(ex);
            return false;
        }
    }
    
     // METODO PARA INSERTAR UN ADMINISTRADOR, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarAdministrador(String dni, String nombre, String apellido, String sexo, String email){
        
        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Admin(dni, nombre, apellido, sexo, email, password);
        if(u.insertar() ){
            return true;
        }else{
            return false;
        }
    }
    
     // METODO PARA COMPROBAR SI EXISTE UN BIBLIOTECARIO, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarBibliotecario(String dni){
        boolean comprueba;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
       
            String consulta = "select * from usuario u where dni like ? and EXISTS (select id_usuario from bibliotecario e where u.id_usuario = e.id_usuario)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery(); 
            comprueba = resultado.next();
            con.close();
            
            return comprueba;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el bibliotecario. CTRUsuario.comprobarBibliotecario");
            System.err.println(ex);
            return false;
        }
    }
    
    // METODO PARA INSERTAR UN BIBLIOTECARIO, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarBibliotecario(String dni, String nombre, String apellido, String sexo, String email, String biblioteca){
        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Bibliotecario(dni, nombre, apellido, sexo, email, password, biblioteca);
        if(u.insertar()){
            return true;
        }else{
            return false;
        }
    }
    
     // METODO PARA COMPROBAR SI EXISTE UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarEstudiante(String dni){
        boolean comprueba;
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
       
            String consulta = "select * from usuario u where dni like ? and EXISTS (select id_usuario from estudiante e where u.id_usuario = e.id_usuario)";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setString(1, dni);
            ResultSet resultado = pstmt.executeQuery(); 
            comprueba = resultado.next();
            con.close();
            
            return comprueba;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al comprobar el estudiante. CTRUsuario.comprobarEstudiante");
            System.err.println(ex);
            return false;
        }
    }
    
    // METODO PARA INSERTAR UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean insertarEstudiante(String dni, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp){

        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Estudiante(dni, nombre, apellido, sexo, email, password, numExp, biblioteca);
        if(u.insertar() ){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean comprobarUsuario(String dni){
        return false;
    }
    
    // METODO PARA EDITAR UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean editarEstudiante(String dni, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp){
        return true;
    }
    
    // METODO PARA EDITAR UN USUARIO, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean editarUsuario(String dni, String nombre, String apellido, String sexo, String email){
        return true;
    }


    public static String obtenerBiblioteca(String dni) {
        return "Probando";
    }

    public static boolean borrarUsuario(String dni) {
        return true;
    }
    
    public static boolean editarAdministrador(String dni, String nombre, String apellido, String sexo, String email){
        return true;
    }
    
    public static boolean editarBibliotecario(String dni, String nombre, String apellido, String sexo, String email, String nombre_bib){
        return true;
    }
}
    //////////////////////////////
    // Estudiante - Mostrar prestamos
    //
    // List<Prestamo> prestamosByEstudiante(id_usuario)
    //////////////////////////////
    public static List<Prestamo> prestamosByEstudiante(int id_usuario){
        
        List<Prestamo> prestamos = new ArrayList<>();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from prestamo where id_usuario = ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);            
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                int id_prestamo = resultado.getInt("id_prestamo");
                String fecha_ini =resultado.getString("fecha_ini");
                String fecha_fin =resultado.getString("fecha_fin");
                String dni = Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni();
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = Util.buscarLibro(resultado.getInt("id_libro")).getIsbn();
                String nombre_cat = Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat();
                String nombre_bib = Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre();                
                
                Prestamo p = new Prestamo (fecha_ini,fecha_fin,id_ejem,isbn,dni,nombre_cat,nombre_bib);
                p.setId_prestamo(id_prestamo);
                prestamos.add(p);
            }

            con.close();
            
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener los prestamos por usuario.");
            System.err.println(ex);
        }
                
        return prestamos;
    }
    
    
    
    //////////////////////////////
    // Estudiante - Mostrar reservaos
    //
    // List<Reservado> reservadosByEstudiante(id_usuario)
    //////////////////////////////
    public static List<Reservado> reservadosByEstudiante(int id_usuario){
        
        List<Reservado> reservados = new ArrayList<>();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from reservado where id_usuario = ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, id_usuario);            
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id_reservado = resultado.getInt("id_reservado");
                String fecha_ini =resultado.getString("fecha_ini");
                String fecha_fin =resultado.getString("fecha_fin");
                String dni = Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni();
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = Util.buscarLibro(resultado.getInt("id_libro")).getIsbn();
                String nombre_cat = Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat();
                String nombre_bib = Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre();                
                
                Reservado p = new Reservado (fecha_ini,fecha_fin,id_ejem,isbn,dni,nombre_cat,nombre_bib);
                p.setId_reservado(id_reservado);
                reservados.add(p);
            }
            con.close();

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener los reservados por usuario.");
            System.err.println(ex);
        }
        return reservados;
    }


    
    
    
    //////////////////////////////
    // Biblioteca - Devuelve la biblioteca para un usuario por su dni
    //
    // Biblioteca bibliotecaByUsuario(String dni)
    //////////////////////////////
    public static Biblioteca bibliotecaByUsuario(String dni)
    {
        /* select * from biblioteca b where  EXISTS (select id_bib from estudiante e where b.id_bib = e.id_bib and id_usuario = 9990) or
	EXISTS (select id_bib from bibliotecario e where b.id_bib = e.id_bib and id_usuario = 9990) */
        
        int id_usuario = Usuario.buscarId(dni);
        Biblioteca b = new Biblioteca();
        Usuario u = Util.buscarUsuario(id_usuario);
 
         try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from biblioteca b where  EXISTS (select id_bib from estudiante e where b.id_bib = e.id_bib and id_usuario = "+ id_usuario +") or EXISTS (select id_bib from bibliotecario e where b.id_bib = e.id_bib and id_usuario = "+ id_usuario +")";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while(resultado.next()){
               b.setId_bib(resultado.getInt("id_bib"));
               b.setDni_admin(Util.buscarUsuario(resultado.getInt("id_usuario")).getDni());               
               b.setNombre(resultado.getString("nombre"));
               b.setTelefono(resultado.getInt("telefono"));
               b.setLocalizacion(resultado.getString("localizacion"));
            }
            con.close();
            return b;

        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al buscar Objeto Biblioteca.");
            System.err.println(ex);
            return b;
        }
         
    }
     public static boolean comprobarUsuario(String dni) {
        Usuario u = new Usuario();
        if (u.comprobarUsuario(dni)) {
            return true;
        } else {
            return false;
        }
     }
        public static boolean borrarUsuario(String dni) {
        Usuario u = new Usuario(dni);
        // int id_usuario = Usuario.buscarId(dni);

        if (u.borrar()) {
            return true;
        } else {
            return false;
        }
    }
    

    
   
    
    
    
    
}



