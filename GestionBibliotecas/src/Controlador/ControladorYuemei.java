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

//     public static Libro buscarLibro(int id){
//        Libro l = new Libro();
//        
//        try {
//            Conexion conexion = new Conexion();
//            Connection con = conexion.getConnection();
//
////            String consulta = "select * from libro where id_libro = ?";
//            String consulta = "select libro.isbn,libro.titulo,libro.fecha_ed, biblioteca.nombre,"+
//                             "categoria.nombre_cat, editorial.nombre_edit"+
//                              " from libro,categoria,biblioteca,editorial"+
//                              "where libro.id_bib=biblioteca.id_bib"+
//                              "and libro.id_cat=categoria.id_cat"+ 
//                              " and libro.id_edit=editorial.id_edit"+
//                               " and id_libro=?";
//            PreparedStatement pstmt = con.prepareStatement(consulta);
//            pstmt.clearParameters();
//            pstmt.setInt(1, id);            
//            ResultSet resultado = pstmt.executeQuery();
//
//            while(resultado.next()){
//               l.setId_libro(resultado.getInt("id_libro"));
//                l.setNombre_categoria(resultado.getString("nombre_cat"));
//               l.setNombre_bib(resultado.getString("nombre"));
//               l.setNombre_editorial(resultado.getString("nombre_edit"));
////               l.setNombre_categoria(ControladorManolo.buscarCategoria(resultado.getInt("id_cat")).getNombre_cat());
////               l.setNombre_bib(ControladorManolo.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
////               l.setNombre_editorial(ControladorManolo.buscarEditorial(resultado.getInt("id_edit")).getNombre_edit());
//               
//               l.setIsbn(resultado.getString("isbn"));
//               l.setTitulo(resultado.getString("titulo"));
//               l.setPais(resultado.getString("pais"));
//               l.setIdioma(resultado.getString("idioma"));
//               l.setFecha_edi(resultado.getString("fecha_edi"));               
//            }            
//            return l;
//
//        } catch (SQLException ex) {
//            System.err.println("Excepcion SQL: Error al buscar Objeto Libro.");
//            System.err.println(ex);
//            return l;
//        }
//    
//    }
//    public static Categoria buscarCategoria(int id) {
//        Categoria c = new Categoria();
//
//        try {
//            Conexion conexion = new Conexion();
//            Connection con = conexion.getConnection();
////            String consulta = "select * from categoria where id_cat = ?";
//            String consulta = "select categoria.nombre_cat,biblioteca.nombre from categoria,"
//                    + "biblioteca where categoria.id_bib= biblioteca.id_bib and id_cat= ?";
//
//            PreparedStatement pstmt = con.prepareStatement(consulta);
//            pstmt.clearParameters();
//            pstmt.setInt(1, id);
//
//            ResultSet resultado = pstmt.executeQuery();
//
//            while (resultado.next()) {
//                c.setId_cat(resultado.getInt("id_cat"));
//                c.setNombre_cat(resultado.getString("nombre_cat"));
//                //  c.setNombre_biblioteca(ControladorManolo.buscarBiblioteca(resultado.getInt("id_bib")).getNombre());
//                c.setNombre_biblioteca(resultado.getString("nombre"));
//            }
//            return c;
//
//        } catch (SQLException ex) {
//            System.err.println("Excepcion SQL: Error al buscar Objeto Categoria.");
//            System.err.println(ex);
//            return c;
//        }
//
//    }
    public static Calendar ToCalendar( String fecha) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = df.parse(fecha);
        Calendar fecha_fin = Calendar.getInstance();
        fecha_fin.clear();
        fecha_fin.setTime(fechaDate);
        
        return fecha_fin;     
        
    }
    
    public  static String CalcularFechaPenalizada(Calendar fecha_fin, Calendar hoy) throws ParseException {
        
        // transformar a milsegundos
        long sl = fecha_fin.getTimeInMillis();
        long el = hoy.getTimeInMillis();
         // calcular diferencia;
        long ei = el - sl;
        int dia_retraso = (int) (ei / (1000 * 60 * 60 * 24));
        int dia_penaliza=2*dia_retraso;
        //CalcularFechaPenalizada
        Calendar Fecha_penalizada = (Calendar) hoy.clone();
        Fecha_penalizada.add(Calendar.DATE, dia_penaliza);
        String Fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(Fecha_penalizada.getTime());
        return Fecha;
    }
    
         
    public  static void InsertarPenalizacion() throws ParseException{
        Calendar hoy = Calendar.getInstance();
        hoy.clear();              
        hoy.setTime(new Date()); // establece feche de hoy;
        String Fecha_penalizada;     
        int dia_retraso;
        int dia_penaliza;
        Penalizacion p=new Penalizacion();
       
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select id_usuario,fecha_fin from prestamo";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {
             
                String fecha =resultado.getString("fecha_fin");               
                int id_usuario = resultado.getInt("id_usuario");  
                
                Calendar fecha_fin=ToCalendar(fecha); // transforma String a Calendar
                if (hoy.after(fecha_fin)){ // cuando existe retraso
                Fecha_penalizada=CalcularFechaPenalizada(fecha_fin,hoy); // calcula fecha penalizada
                p.setId_estudiante(id_usuario);
                p.setfecha_inicio(fecha);
                p.setfecha_fin(Fecha_penalizada);
                
                
                p.insertar();
                
                
                
                }
               
                              
               
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al obtener todos los prestamos.");
            System.err.println(ex);
        }
      
        
        
    }
    public static void main(String[] args) throws ParseException {

        String fecha = "09/12/2016";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_fin = df.parse(fecha);

        System.out.println("fecha_fin es：" + fecha_fin);
        System.out.println("现在时间是：" + new Date());

        Calendar fecha_finn = Calendar.getInstance();
        fecha_finn.clear();
        fecha_finn.setTime(fecha_fin);

//        Calendar hoy = Calendar.getInstance();
//        hoy.clear();
//        hoy.setTime(new Date());

        boolean pasado;
        pasado = hoy.after(fecha_finn);
        System.out.println("ha pasado fecha_fin?" + pasado);

        int dia_retraso;
        dia_retraso = CalcularDiaRetraso(fecha,hoy);
        
        System.out.println("dia_retraso:" + dia_retraso);
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
