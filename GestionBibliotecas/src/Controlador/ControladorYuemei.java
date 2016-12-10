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
        
        int telefono=689756;
         boolean exito;
        Biblioteca b1= new Biblioteca("informatica","cordoba",telefono,"555");
         Biblioteca b2= new Biblioteca("derecho","cordoba",telefono,"123");
         Biblioteca b3= new Biblioteca("Turismo","servilla",telefono,"123");
          Biblioteca nuevob1= new Biblioteca("informa","malaga",telefono,"123");
         
//         exito=b3.insertar();// funciona
//         exito=b3.borrar();  // funciona
//          exito=b1.actualizar(nuevob1);
          exito=nuevob1.actualizar(b1);
//        exito=b1.insertar();

         System.out.println(exito);
         
        
        
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
