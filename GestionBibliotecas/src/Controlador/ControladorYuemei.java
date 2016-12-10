/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;

//import gestionbibliotecas.VentanaYuemei;
import Configuracion.*;
import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Manuel
 */
public class ControladorYuemei {

//    public static int buscarId(String dni) {
//        int id = 10;
//        try {
//            Conexion conexion = new Conexion();
//            Connection con = conexion.getConnection();
//
//            String consulta = "select id_usuario from usuario where dni like ? ";
//
//            PreparedStatement pstmt = con.prepareStatement(consulta);
//            pstmt.clearParameters();
//            pstmt.setString(1, dni);
//
//            ResultSet resultado = pstmt.executeQuery();
//
//            while (resultado.next()) {
//                id = resultado.getInt("id_usuario");
//
//                System.out.println("hola yuemei");
//            }
//            return id;
//
//        } catch (SQLException ex) {
//            System.err.println("Excepcion SQL: Error al buscar id usuario.");
//            System.err.println(ex);
//            return -1;
//        }
//
//    }
    public static void main(String[] args) {

        boolean exito;
        Autor a= new Autor("juan","jose");
        Autor a1= new Autor("mario","jose");
        Autor a2= new Autor("pepe","jose");
        Autor a3= new Autor("kaka","jose");
        Autor a4= new Autor("dada","jose");
        
        exito= a3.actualizar(a1);
        
        
        
        
        
       
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
       
           System.out.println(exito);
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
