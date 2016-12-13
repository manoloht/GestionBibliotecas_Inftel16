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
import java.text.ParseException;
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
                        Prestamo.insertarPrestamo(ControladorManolo.getFechaInicio(), ControladorManolo.getFechaFin(), id_usuario, e.getId_ejem(), id_libro, id_cat, id_bib);
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
    
    
    static String getFechaInicio(){
        Calendar hoy = Calendar.getInstance();
        hoy.clear();
        hoy.setTime(new java.util.Date()); // establece feche de hoy;
        String fecha_hoy = (new SimpleDateFormat("dd/MM/yyyy")).format(hoy.getTime());
    
        return fecha_hoy;    
    }
    
    
        static String getFechaFin(){
        Calendar hoy = Calendar.getInstance();
        hoy.clear();
        hoy.setTime(new java.util.Date()); // establece feche de hoy;
        Calendar fecha = (Calendar) hoy.clone();
        fecha.add(Calendar.DATE, 7);
        String fecha_fin = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha.getTime());
    
        return fecha_fin;
    
        }
        
    

  
    
    
    
    
    
    
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
    System.err.println(getFechaInicio());
    System.err.println(getFechaFin());
    
 int i = crearPrestamo(9997, "isbn111", "PruebasManolo","CategoriaA");
      System.err.println(i);

   // System.err.println(ControladorManolo.crearPrestamo(9995, 0));

  /*  List<Libro> libros = new ArrayList<>();       
        libros = CTRUsuario.buscarLibros("todas", "isbn", "isbn111");
        
        System.out.println(libros.size());
        
        for(Libro u : libros){
            System.out.println(u.toString());
        }

*/

  
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
