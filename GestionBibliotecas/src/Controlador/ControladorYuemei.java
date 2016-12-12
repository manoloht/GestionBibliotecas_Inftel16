/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;

//import gestionbibliotecas.VentanaYuemei;
import Configuracion.*;
import Controlador.*;
import Modelo.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class ControladorYuemei {

    // METODO PARA EDITAR UN ESTUDIANTE, DEVOLVER TRUE EN CASO DE INSERTAR, FALSE EN CASO DE FALLO DE INSERCIÓN
    public static boolean editarEstudiante(String dni, String dni_nuevo, String nombre, String apellido, String sexo, String email, String biblioteca, String numExp) {
        boolean exito;
        Estudiante u1 = new Estudiante(dni);
        Estudiante u2 = new Estudiante(dni_nuevo);
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

    public static boolean editarUsuario(String dni, String dni_nuevo, String nombre, String apellido, String sexo, String email) {
        boolean exito;
        Usuario u1 = new Usuario(dni);
        Usuario u2 = new Usuario(dni_nuevo);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return true;
    }

    public static boolean editarAdministrador(String dni, String dni_nuevo, String nombre, String apellido, String sexo, String email) {
        boolean exito;
        Admin u1 = new Admin(dni);
        Admin u2 = new Admin(dni_nuevo);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return exito;
    }

    public static boolean editarBibliotecario(String dni, String dni_nuevo, String nombre, String apellido, String sexo, String email, String nombre_bib) {
        boolean exito;
        Bibliotecario u1 = new Bibliotecario(dni);
        Bibliotecario u2 = new Bibliotecario(dni_nuevo);
        u2.setApellidos(apellido);
        u2.setNombre(nombre);
        u2.setEmail(email);
        u2.setSexo(sexo);
        exito = u1.actualizar(u2);
        return exito;
    }

    public static void CrearLibro(String isbn, String titulo, String fecha_edi, String nombre_editorial, String nombre_categoria, String nombre_bib, String pais, String idioma, String nombre_autor, String apellido_autor) {
//        boolean insertarlibro,insertarEjemplar,insertarautor,insertarlibroautor;
        Libro libro = new Libro(isbn, titulo, fecha_edi, nombre_editorial, nombre_categoria, nombre_bib, pais, idioma);
        Ejemplar ejem = new Ejemplar(isbn, nombre_categoria, nombre_bib);
        Autor autor = new Autor(nombre_autor, apellido_autor);
        libro_autor libaut = new libro_autor(nombre_autor, apellido_autor, isbn, nombre_bib, nombre_categoria);
        if (libro.insertar()) {

            autor.insertar();
            libaut.InsertarLibroAutor();

            ejem.insertar();

        } else {
            ejem.insertar();
        }

    }

    public static void main(String[] args) throws ParseException {

        String isbn = "isbn666";
        String titulo = "Fisica";
        String fecha_edi = "1998";
        String editorial = "Editorial A ";
        String categoria = "CategoriaA";
        String biblioteca = "PruebasManolo";
        String pais = "chino";
        String idioma = "chino";
        String nombre_autor = "juan";
        String nombre_apellido = "jose";

        ControladorYuemei.CrearLibro(isbn, titulo, fecha_edi, editorial, categoria, biblioteca, pais, idioma, nombre_autor, nombre_apellido);

//        Calendar hoy = Calendar.getInstance();
//        hoy.clear();
//        hoy.setTime(new Date());
//        boolean pasado;
//        pasado = hoy.after(fecha_finn);
//        System.out.println("ha pasado fecha_fin?" + pasado);
//        int dia_retraso;
//        dia_retraso = CalcularDiaRetraso(fecha,hoy);
//        System.out.println("dia_retraso:" + dia_retraso);
//        
//       SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd" );  
//        boolean exito;
//        libro_autor a = new libro_autor("juan", "jose", "isbn111", "informatica", "fisica");
//        libro_autor b = new libro_autor("pepe", "jose", "isbn222", "informatica", "mate");
//        libro_autor c = new libro_autor("mario", "jose", "isbn333", "derecho", "dibujo");
//        exito = c.borrarLibroAutor();
//        exito=a.borrarLibroAutor();
//        libro_autor d= new libro_autor("juan","jose","isbn111","informatica","fisica");
//        System.out.println(exito);
//        Autor a= new Autor("juan","jose");
//        Autor a1= new Autor("mario","jose");
//        Autor a2= new Autor("pepe","jose");
//        Autor a3= new Autor("kaka","jose");
//        Autor a4= new Autor("dada","jose");
//        
//        exito= a3.actualizar(a1);
//        
//         Penalizacion p = new Penalizacion("11/12/2016","25/12/2016","e99g");
//         Penalizacion nuevop = new Penalizacion("01/12/2016","20/12/2016","e99g");
//         Penalizacion p1 = new Penalizacion("22/12/2016","25/12/2016","e99b");
//         Penalizacion p2 = new Penalizacion("10/12/2016","25/12/2016","e99c");
//         Penalizacion p3 = new Penalizacion("11/12/2016","25/12/2016","e99e");
//         
////          exito= p3.insertar();// funcion
//          exito=p2.borrar(); // function
//             exito=p.actualizar(nuevop);
//          exito= p1.insertar();
//        Estudiante a = new Estudiante("e99a", "valen", "petro", "M", "hotmail22", "899","e991", "Turismo");
//        Estudiante b = new Estudiante("e99b", "valen", "petro", "M", "hotmail22", "899","e9912", "derecho");
//        Estudiante c = new Estudiante("e99c", "valen", "petro", "M", "hotmail22", "899","e9913", "informatica");
//        Estudiante d = new Estudiante("e99d", "valen", "petro", "M", "hotmail22", "899","e9914", "derecho");
//        Estudiante e = new Estudiante("e99e", "valen", "petro", "M", "hotmail22", "899","e9915", "informatica");
//        Estudiante f = new Estudiante("e99f", "valen", "petro", "M", "hotmail22", "899","e9916", "Turismo");
//        Estudiante g = new Estudiante("e99g", "yuemei", "petro", "M", "hotmail22", "899","e9917", "informatica");
////        exito=c.insertar();  // funciona
////       exito= d.borrar(); // funciona
//           exito= a.actualizar(g); // funciona
////        e.insertar();
//        Bibliotecario a = new Bibliotecario("w99", "valen", "petro", "M", "hotmail22", "899", "Turismo");
//        Bibliotecario b = new Bibliotecario("w10", "valen", "petro", "M", "hotmail22", "899", "derecho");
//        Bibliotecario c = new Bibliotecario("w11", "valen", "petro", "M", "hotmail22", "899", "Turismo");
//        Bibliotecario d = new Bibliotecario("w12", "valen", "petro", "M", "hotmail22", "899", "derecho");
//        Bibliotecario e = new Bibliotecario("w13", "valen", "petro", "M", "hotmail22", "899", "Turismo");
//        Bibliotecario f = new Bibliotecario("w14", "valencia", "petro", "M", "hotmail22", "899", "informatica");
//        Bibliotecario g = new Bibliotecario("w15", "valen", "petro", "M", "hotmail22", "899", "Turismo");
//
////               exito=d.insertar();//funciona
////               exito=c.borrar();//funciona
//        exito = d.actualizar(f);
//
//        System.out.println(exito);
//         Admin a=new Admin("y66","val","petro","M","hotmail22","899");
//         Admin b=new Admin("w77","hum","petro","M","hotmail22","899");
//         Admin c= new Admin("w88","mama","petro","M","hotmail22","899");
//         Admin d=new Admin("w99","valen","petro","M","hotmail22","899");
//         exito=d.borrar();
//          exito= c.actualizar(d);
//         Admin borr= new Admin("w77");
//         exito=  borr.borrar();  // funciona
//         exito=a.insertar();
//           exito=c.insertar();
//          int telefono=689756;
//        Biblioteca b1= new Biblioteca("informatica","cordoba",telefono,"555");
//         Biblioteca b2= new Biblioteca("derecho","cordoba",telefono,"123");
//         Biblioteca b3= new Biblioteca("Turismo","servilla",telefono,"123");
//          Biblioteca nuevob1= new Biblioteca("informa","malaga",telefono,"123");
//         exito=b3.insertar();// funciona
//         exito=b3.borrar();  // funciona
//          exito=b1.actualizar(nuevob1);
//          exito=nuevob1.actualizar(b1);
//        exito=b1.insertar();
//         System.out.println(exito);
//        String dni="y55";
//        String nombre="valencia";
//        String apellidos="pepe";
//        String sexo="M";
//        String email="hotmail22";
//        String password="899";
//        boolean exito;
//         Usuario u = new Usuario( dni, nombre, apellidos,  sexo,  email,  password);
//         Usuario viejoU=new Usuario("y55","valen","petro","M","hotmail22","899");
//         Usuario nueovoU=new Usuario("w55557","valen","petro","M","hotmail22","899");
//         exito=u.insertar();   // funciona!
//          exito=u.borrar();  // funciona!
//            exito=viejoU.actualizar(nueovoU); // funciona!
//         System.out.println(exito);
//        System.out.println("dni=123 su id es"+ControladorYuemei.buscarId("123"));
    }

//     public static void main(String[] args) {
//          VentanaYuemei v= new VentanaYuemei();
//          v.setVisible(true);
//      }
}
