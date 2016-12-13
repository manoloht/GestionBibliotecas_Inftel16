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
    public static boolean comprobarAdministrador(String dni) {
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
    public static boolean insertarAdministrador(String dni, String nombre, String apellido, String sexo, String email) {

        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Admin(dni, nombre, apellido, sexo, email, password);
        if (u.insertar()) {
            return true;
        } else {
            return false;
        }
    }

    // METODO PARA COMPROBAR SI EXISTE UN BIBLIOTECARIO, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarBibliotecario(String dni) {
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
    public static boolean insertarBibliotecario(String dni, String nombre, String apellido, String sexo, String email, String biblioteca) {
        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Bibliotecario(dni, nombre, apellido, sexo, email, password, biblioteca);
        if (u.insertar()) {
            return true;
        } else {
            return false;
        }
    }

    // METODO PARA COMPROBAR SI EXISTE UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarEstudiante(String dni) {
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
    public static boolean insertarEstudiante(String dni, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp) {

        String password = Util.getCadenaAleatoria(8);
        Usuario u = new Estudiante(dni, nombre, apellido, sexo, email, password, numExp, biblioteca);
        if (u.insertar()) {
            return true;
        } else {
            return false;
        }
    }

  // METODO PARA EDITAR UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean editarEstudiante(String dni, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp) {
        boolean exito;
        Estudiante u1 = new Estudiante(dni);
        Estudiante u2 = new Estudiante(dni);
        u2.setNombre(nombre);
        u2.setApellidos(apellido);
        u2.setSexo(sexo);
        u2.setEmail(email);
        u2.setNombre_biblioteca(biblioteca);
        u2.setNumExp(numExp);
        exito = u1.actualizar(u2);

        return exito;
    }
    // METODO PARA EDITAR UN USUARIO, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN

    public static boolean editarUsuario(String dni, String nombre, String apellido, String sexo, String email) {
        boolean exito;
        Usuario u1 = new Usuario(dni);
        Usuario u2 = new Usuario(dni);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return exito;
    }

    public static boolean editarAdministrador(String dni, String nombre, String apellido, String sexo, String email) {
        boolean exito;
        Admin u1 = new Admin(dni);
        Admin u2 = new Admin(dni);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return exito;
    }

    public static boolean editarBibliotecario(String dni, String nombre, String apellido, String sexo, String email, String nombre_bib) {
        boolean exito;
        Bibliotecario u1 = new Bibliotecario(dni);
        Bibliotecario u2 = new Bibliotecario(dni);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return exito;
    }

    //////////////////////////////
    // Estudiante - Mostrar prestamos
    //
    // List<Prestamo> prestamosByEstudiante(id_usuario)
    //////////////////////////////
    public static List<Prestamo> prestamosByEstudiante(int id_usuario) {

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
                String fecha_ini = resultado.getString("fecha_ini");
                String fecha_fin = resultado.getString("fecha_fin");
                String dni = Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni();
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = Util.buscarLibro(resultado.getInt("id_libro")).getIsbn();
                String nombre_cat = Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat();
                String nombre_bib = Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre();

                Prestamo p = new Prestamo(fecha_ini, fecha_fin, id_ejem, isbn, dni, nombre_cat, nombre_bib);
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
    public static List<Reservado> reservadosByEstudiante(int id_usuario) {

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
                String fecha_ini = resultado.getString("fecha_ini");
                String fecha_fin = resultado.getString("fecha_fin");
                String dni = Util.buscarUsuario(resultado.getInt("id_Usuario")).getDni();
                int id_ejem = resultado.getInt("id_ejem");
                String isbn = Util.buscarLibro(resultado.getInt("id_libro")).getIsbn();
                String nombre_cat = Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat();
                String nombre_bib = Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre();

                Reservado p = new Reservado(fecha_ini, fecha_fin, id_ejem, isbn, dni, nombre_cat, nombre_bib);
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
    public static Biblioteca bibliotecaByUsuario(String dni) {
        /* select * from biblioteca b where  EXISTS (select id_bib from estudiante e where b.id_bib = e.id_bib and id_usuario = 9990) or
	EXISTS (select id_bib from bibliotecario e where b.id_bib = e.id_bib and id_usuario = 9990) */

        int id_usuario = Usuario.buscarId(dni);
        Biblioteca b = new Biblioteca();
        Usuario u = Util.buscarUsuario(id_usuario);

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from biblioteca b where  EXISTS (select id_bib from estudiante e where b.id_bib = e.id_bib and id_usuario = " + id_usuario + ") or EXISTS (select id_bib from bibliotecario e where b.id_bib = e.id_bib and id_usuario = " + id_usuario + ")";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
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
        return u.comprobarUsuario(dni);
    }

    public static boolean borrarUsuario(String dni) {
        Usuario u = new Usuario(dni);
        return u.borrar();
    }
    
        
       
     
    
    //////////////////////////////
    // Estudiante - Buscar libros
    //
    // List<Libro> buscarLibros(String biblioteca, String categoria, String palabra_clave, String palabra_valor)
    //////////////////////////////
    public static List<Libro> buscarLibros(String biblioteca, String palabra_clave, String palabra_valor)
    {
       List<Libro> libros = new ArrayList<>();
      
        int id_bib = Biblioteca.buscarId(biblioteca);
        String cad_biblioteca = "";

       if(!(biblioteca.equals("Todas") || biblioteca.equals("todas") || biblioteca.equals("TODAS"))){
           cad_biblioteca= " id_bib = " + id_bib + " and ";
           
       } 
       
       String consulta = "select * from libro where  "+cad_biblioteca+" "+ palabra_clave +" like '"+ palabra_valor +"'";

       try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                String isbn = resultado.getString("isbn");
                String titulo = resultado.getString("titulo");
                String fecha_edi = resultado.getString("fecha_edi");
                String pais = resultado.getString("pais");
                String idioma = resultado.getString("idioma");
                
                String nombre_editorial = Util.buscarEditorial(resultado.getInt("id_edit")).getNombre_edit();
                String nombre_categoria = Util.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat();
                String nombre_bib = Util.buscarBiblioteca(resultado.getInt("id_bib")).getNombre();

                Libro l = new Libro(isbn, titulo, fecha_edi, nombre_editorial, nombre_categoria, nombre_bib, pais, idioma);
                l.setId_libro(resultado.getInt("id_libro"));
 
                libros.add(l); 
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los libros.");
            System.err.println(ex);
        }
        return libros;
    }
    
    
    
       
    //////////////////////////////
    // Estudiante - Prestar Libro
    //
    // int prestarCrear(int id_usuario, int isbn)
    // Devuelve:
    //      -1 => Si el usuario está penalizado
    //      0  => Si no hay ejemplares disponibles
    //      1 => Si se ha hecho el préstamo
    //////////////////////////////
    public static int crearPrestamo(int id_usuario, String isbn, String nombre_bib,String nombre_cat ){
        int comprueba_prestamo = 0;
        int id_libro = Libro.buscarId(nombre_bib, nombre_cat, isbn);
        int id_bib = Biblioteca.buscarId(nombre_bib);
        int id_cat = Categoria.buscarId(nombre_bib, nombre_cat);
        
        if(Penalizacion.comprobarPenalizacion(id_usuario)){
            return  -1;
        }
        
        List<Ejemplar> ejemplares = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select * from ejemplar where id_libro = "+id_libro+" and id_cat ="+id_cat+"and id_bib="+id_bib;
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
                int id_ejem = resultado.getInt("id_ejem");
                Ejemplar ej = new Ejemplar();
                ej.setId_ejem(id_ejem);
                ejemplares.add(ej);
            }
                con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los ejemplares");
            System.err.println(ex);
        }
        
        for(Ejemplar e : ejemplares){
            try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();

            String consulta = "select * from prestamo where id_ejem = ? ";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.clearParameters();
            pstmt.setInt(1, e.getId_ejem());
            ResultSet resultado = pstmt.executeQuery();
            if(resultado.next()){
                con.close();
                return 0;
            }else {
                try {
                    consulta = "select * from reservado where id_ejem = ? ";
                    pstmt = con.prepareStatement(consulta);
                    pstmt.clearParameters();
                    pstmt.setInt(1, e.getId_ejem());
                    resultado = pstmt.executeQuery();
                    if (resultado.next()) {
                        con.close();
                        return 0;
                    } else {
                        con.close();
                        Prestamo.insertarPrestamo(Util.getFechaInicio(), Util.getFechaFin(), id_usuario, e.getId_ejem(), id_libro, id_cat, id_bib);
                        return 1;
                    }

                } catch (SQLException ex) {
                    System.err.println("Excepcion SQL: Error al comprobar el prestamo");
                    System.err.println(ex);
                    return -1;
                }
                
            }        
            
            } catch (SQLException ex) {
                System.err.println("Excepcion SQL: Error al comprobar el prestamo");
                System.err.println(ex);
                return -1;
            }
        }
        
        return comprueba_prestamo;
    }
    
    
    
}
