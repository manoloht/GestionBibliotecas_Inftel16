/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;
import Configuracion.*;
import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Manuel
 */
public class ControladorManolo {
    
    
    //////////////////////////////
    // Estudiante - Prestar Libro
    //
    // void prestarEjemplar(id_usuario, id_ejemplar)
    //////////////////////////////
    public static boolean prestarEjemplar(int id_usuario, int id_ejemplar){
        /*
            1 - Comprobar que el estudiante no tiene penalizacion
            2 - Comprobar que el ejemplar no está prestado
        */
        return true;
    }
    
    
    //////////////////////////////
    // Estudiante - Reservar Libro
    //
    // void reservarEjemplar(id_usuario, id_ejemplar)
    //////////////////////////////
    
    
    //////////////////////////////
    // Bibliotecario - Devolver Libro
    //
    // void devolverEjemplar(id_usuario, id_ejemplar)
    //////////////////////////////
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args){
/*
  **** MODIFICACIONES NECESARIAS ****
        - Todos los actualizar necesitan cambiar la comprobacion de la sentencia if
        - La entidad ejemplar no debe de contemplar el actualizar, solo insertar y borrar
            - Borrar => Comprobar y Actualizar en la Clase Ejemplar, no sirven para nada
        - Insertar Usuario -> Método que compruebe que no existe ese dni en el sistema.
                El problema es que hay de clave unica el dni.
        
*/    

// ----- Pruebas MAIN ----------
 /*       
    List<Libro> libros = new ArrayList<>();
    libros = CTRUsuario.buscarLibros("PruebasManolo3", "isbn", "isbn111");
    
       
        System.out.println(libros.size());
        
        for(Libro u : libros){
            System.out.println(u.toString());
        }

*/        

Session session = new Session(1234);
Session.setId_usuario(555);
System.err.println(Session.getId_usuario());

  
////////////////////////////////////////////////////////////////////////////////

 /*


    // Comprobaciones CTRLogin
    System.err.println(CTRLogin.comprobarLogin("estudiante2@gmail.com", "abc123abc"));

    // Comprobaciones CTRUsuario
    
//System.out.println(CTRUsuario.insertarAdministrador("RR88888A", "Paquito", "El Chocolatero", "H", "paquito@gmail.com", "--"));
    //System.err.println(CTRUsuario.comprobarAdministrador("RR88888A"));
    
    //System.out.println(CTRUsuario.insertarBibliotecario("BBB55555K", "Toñete", "El Romantico", "H", "tonito@gmail.com", "PruebasManolo"));
    //System.err.println(CTRUsuario.comprobarBibliotecario("BBB55555K"));
    
    //System.out.println(CTRUsuario.insertarEstudiante("JJJ4444V", "Maria", "La Cantaora", "M", "maripepi@gmail.com", "PruebasManolo", "Exp1111A"));
    //System.err.println(CTRUsuario.comprobarEstudiante("JJJ4444V"));
   //Estudiante e = new Estudiante("JJJ4444V", "Maria", "La Cantaora", "M", "maripepi@gmail.com","asdfasdf","Exp1111A", "PruebasManolo");
   //Estudiante e2 = new Estudiante("GGG2222W", "Ramona", "Pechugona", "M", "lapechu@gmail.com","asdfasdf","Exp2222A", "PruebasManolo");
   
   //System.err.println(e.insertar());
   //System.err.println(e2.insertar());



// DEVOLVER LISTA DE USUARIOS POR ROL
    // rol PUEDE SER Todos, Administrador, Biliotecario, Estudiante);
 
        String rol = "bibliotecario";
        
        List<Usuario> usuarios = new ArrayList<>();       
        usuarios = CTRUsuario.buscarUsuariosRol(rol);
        
        System.out.println(usuarios.size());
        
        for(Usuario u : usuarios){
            System.out.println(u.toString());
        }



// DEVOLVER LISTA DE USUARIOS POR ROL, PALABRA CLAVE Y VALOR PALABRA CLAVE 
    // rol PUEDE SER Todos, Administrador, Biliotecario, Estudiante);
    // palabra_clave PUEDE SER Dni, Nombre, Apellidos, Email
    // valor PUEDE SER cualquiera que introduzca el usuario

        String rol = "todos";
        String palabra_clave = "seXo";
        String valor_pal_clave = "H";
        
        List<Usuario> usuarios = new ArrayList<>();       
        usuarios = CTRUsuario.buscarUsuarios(rol, palabra_clave, valor_pal_clave);
        
        System.out.println(usuarios.size());
        
        for(Usuario u : usuarios){
            System.out.println(u.toString());
        }



     //////////////////////////////////////// USUARIO 
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setApellidos("de los rios");
        u.setEmail("pepe@gmail.com");
        u.setDni("123456");
        u.setPassword("abcabc");
        System.out.println("Usuario Borrar: "+ u.borrar());
        System.out.println("Usuario Insertar: "+ u.insertar());
        
        //////////////////////////////////////// Categoria (sin probar, solo buscar id)
        String categoria = "CategoriaXXXXXXXXX";
        String biblioteca= "PruebasManolo";
        
        Categoria c = new Categoria();
        c.setNombre_cat(categoria);
        c.setNombre_biblioteca(biblioteca);
        
        ////////////////////////////////////////  LIBRO
        String isbn="isbn555";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaA";
        String titulo ="LibroPepito";
        String fecha_edi ="01/01/2000";
        String nombre_edit ="EdiPepe";
        String pais ="España";
        String idioma ="Español";        

        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setNombre_bib(nombre_bib);
        l.setNombre_categoria(nombre_cat);
        l.setTitulo(titulo);
        l.setFecha_edi(fecha_edi);
        l.setNombre_editorial(nombre_edit);
        l.setPais(pais);
        l.setIdioma(idioma);
        
        Libro l2 = new Libro();
        l2.setIsbn("xxx990");
        l2.setNombre_bib(nombre_bib);
        l2.setNombre_categoria(nombre_cat);
        
        System.out.println("Libro borrar: "+ l.borrar());
        System.out.println("Libro Insertar: "+ l.insertar());        
        System.out.println("Libro Actualizar: "+ l.actualizar(l2));


        //////////////////////////////////////// Editorial
        Editorial e = new Editorial("Editorial C");
        System.out.println("Editorial Borrar: "+ e.borrar());
        System.out.println("Editorial Insertar: "+ e.insertar());
        Editorial e2 = new Editorial("Editorial D");
        System.out.println("Editorial Actualizar: "+ e.actualizar(e2));


        //////////////////////////////////////// Ejemplar
        String isbn="isbn111";
        String nombre_bib="PruebasManolo";
        String nombre_cat="CategoriaA";
        
        Ejemplar e = new Ejemplar();
        e.setIsbn(isbn);
        e.setNombre_bib(nombre_bib);
        e.setNombre_cat(nombre_cat);
        e.setId_ejem(1);
        
        System.out.println(e.toString());
        System.out.println("Ejemplar borrar: "+ e.borrar());
        System.out.println("Ejemplar Insertar: "+ e.insertar());


        //////////////////////////////////////// Prestamo
        Prestamo p = new Prestamo(4000, "isbn111", "00111111X", "CategoriaA", "PruebasManolo");
        p.setFecha_ini("01/01/2000");
        p.setFecha_fin("10/01/2000");
        
        System.out.println(p.toString());
        System.out.println(p.borrar());
        System.out.println(p.insertar());
        
        Prestamo p2 = new Prestamo();
        p2.setFecha_ini("01/01/2000");
        p2.setFecha_fin("10/01/2000");
        System.out.println(p.actualizar(p2));


        //////////////////////////////////////// Reservado
        Reservado p = new Reservado(5000, "isbn222", "00111111X", "CategoriaA", "PruebasManolo");
        p.setFecha_ini("01/01/2000");
        p.setFecha_fin("10/01/2000");
        
        System.out.println(p.toString());
        System.out.println(p.borrar());
        System.out.println(p.insertar());
        
        Reservado p2 = new Reservado();
        p2.setFecha_ini("01/01/2000");
        p2.setFecha_fin("15/01/2000");
        System.out.println(p.actualizar(p2));
 
        




        ///////////////////////////////// METODOS buscarObjeto
        Biblioteca b = ControladorManolo.buscarBiblioteca(1000);
        System.out.println(b.toString());
        
        Categoria c = ControladorManolo.buscarCategoria(2000);
        System.out.println(c.toString());   


        Editorial ed = ControladorManolo.buscarEditorial(6001);
        System.out.println(ed.toString()); 
        
        Libro l = ControladorManolo.buscarLibro(3000);
        System.out.println(l.toString()); 

         Prestamo l = ControladorManolo.buscarPrestamo(16);
        System.out.println(l.toString()); 
        
        Usuario u = ControladorManolo.buscarUsuario(9998);
        System.out.println(u.toString());

    
  Reservado r = ControladorManolo.buscarReservado(18);
        System.out.println(r.toString()); 


        ///////////////////////////////// Comprobaciones BuscarID
        System.out.println(Biblioteca.buscarId("PruebasManolo"));
        System.out.println(Categoria.buscarId("PruebasManolo","CategoriaA"));
        System.out.println(ControladorManolo.buscarId("PruebasManolo","CategoriaA","isbn111"));
        System.out.println(ControladorManolo.buscarId("Editorial B"));


        ///////////////////////////////// PrestamosByEstudiante(id)
        List<Prestamo> prestamos;       
        prestamos = ControladorManolo.prestamosByEstudiante(9998);
        
        System.out.println(prestamos.size());
        
        for(Prestamo p : prestamos){
            System.out.println(p.toString());
            System.out.println(p.getId_prestamo());
        }
        
        
        ///////////////////////////////// ReservadosByEstudiante(id)
        List<Reservado> reservados;       
        reservados = ControladorManolo.reservadosByEstudiante(9998);
        
        System.out.println(reservados.size());
        
        for(Reservado r : reservados){
            System.out.println(r.toString());
            System.out.println(r.getId_reservado());
        }


 */
 
 
 

        
    }   
    
}
