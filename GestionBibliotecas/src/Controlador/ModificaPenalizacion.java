/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Configuracion.Conexion;
//import Controlador.SenderEmail.MailSender;
import Controlador.SenderEmail.prueba;
import Modelo.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;


/**
 *
 * @author YUEMEI
 */
/*public class ModificaPenalizacion {

    public static Calendar ToCalendar(String fecha) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = df.parse(fecha);
        Calendar fecha_fin = Calendar.getInstance();
        fecha_fin.clear();
        fecha_fin.setTime(fechaDate);

        return fecha_fin;

    }

    public static String ToString(Calendar fecha) throws ParseException {
        String Fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha.getTime());

        return Fecha;

    }

    public static int CalcularIntervaloDeDia(Calendar fecha_menor, Calendar fecha_mayor) throws ParseException {

        // transformar a milsegundos
        long sl = fecha_menor.getTimeInMillis();
        long el = fecha_mayor.getTimeInMillis();
        // calcular diferencia;
        long ei = el - sl;
        int dia_diferencia = (int) (ei / (1000 * 60 * 60 * 24));
        return dia_diferencia;
    }

    public static String SumaDia(Calendar fecha_para_sumar, int dia) throws ParseException {

        Calendar fecha_resul = (Calendar) fecha_para_sumar.clone(); // si no hace clone, se modifiaca valor fecha_para_sumar que esto pasa por referencia
        fecha_resul.add(Calendar.DATE, dia);
        String Fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(fecha_resul.getTime());
        return Fecha;
    }

    public static void InsertarPenalizacion() throws ParseException {
        Calendar hoy = Calendar.getInstance();
        hoy.clear();
        hoy.setTime(new Date()); // establece feche de hoy;
        String fecha_hoy = (new SimpleDateFormat("dd/MM/yyyy")).format(hoy.getTime());
//////////////////        System.out.println("fecha_hoy" + fecha_hoy);
        String Fecha_penalizada;

        Penalizacion p = new Penalizacion();

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select id_usuario,fecha_fin from prestamo";
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta);

            while (resultado.next()) {

                String fecha_fin_devolucion = resultado.getString("fecha_fin");  // resultado de tabla prestamo
                int id_usuario = resultado.getInt("id_usuario");
////////////                System.out.println("id_usuario:" + id_usuario + "fecha_fin_devolucion:" + fecha_fin_devolucion);

                Calendar fecha_fin_devolve = ToCalendar(fecha_fin_devolucion); // transforma String a Calendar

                if (hoy.after(fecha_fin_devolve)) { // cuando existe retraso en tabla prestamo
//////////////                    System.out.println("existe retraso");
                    String fecha_ini_penalizacion = SumaDia(fecha_fin_devolve, 1); // es siguiente dia de fecha_fin_devolve
//////////////                    System.out.println("fecha_ini_penalizacion: "+fecha_ini_penalizacion);
                    p.setId_estudiante(id_usuario);
                    p.setfecha_inicio(fecha_ini_penalizacion); // establece fecha inicio de penalizacion
                    // calcula dia_penaliza segun tabla prestamo "hoy - fecha_fin_devolve"
                    int dia_retraso = CalcularIntervaloDeDia(fecha_fin_devolve, hoy);
////////////////                    System.out.println("dia retraso calculado por tabla prestamo: "+dia_retraso+"dias");
                    int dia_penaliza = dia_retraso * 2;//  dos dia penaliza por cada dia retraso             
////////////////                    System.out.println("dia penalizada calculado por tabla prestamo: "+dia_penaliza+"dias");                
                    Fecha_penalizada = SumaDia(fecha_fin_devolve, dia_penaliza);
////////////////                    System.out.println("Fecha_penalizada calculado por tabla prestamo:" + Fecha_penalizada);

                    // comprobar si existe penalizacion
                    String consulta2 = "select * from penalizacion where id_usuario like ?";
                    PreparedStatement pstmt = con.prepareStatement(consulta2);
                    pstmt.clearParameters();
                    pstmt.setInt(1, id_usuario);
                    ResultSet resultado2 = pstmt.executeQuery();

                    if (resultado2.next()) {
//////////////                        System.out.println("existe penalizacion, va a actualizar");
                        String antiguo_fecha_ini_penalizacion = resultado2.getString("fecha_inicio");
//////////////                         System.out.println("ya existe penalizacion con fecha inicio a: "+antiguo_fecha_ini_penalizacion);
                        String antiguo_fecha_penalizacion = resultado2.getString("fecha_fin");
////////////////                        System.out.println("ya existe penalizacion con fecha fin a: "+antiguo_fecha_penalizacion);
                        Calendar inicio = ToCalendar(antiguo_fecha_ini_penalizacion);
                        Calendar fin = ToCalendar(antiguo_fecha_penalizacion);
                        // dia penalizada en tabla penalizacion
                        int dia_penalizada_antiguo = CalcularIntervaloDeDia(inicio, fin);
////////////////                        System.out.println("ya existe penalizacion con dia penalizacion igual a: "+dia_penalizada_antiguo+"dias");
                        // dia penalizacion acumulada
                        int total_dia_penalizada = dia_penaliza + dia_penalizada_antiguo;
////////////////                        System.out.println("el nuevo dia penalizacion acumalada es : "+total_dia_penalizada);

                        String nuevo_Fecha_Fin_Penaliza = SumaDia(inicio, total_dia_penalizada);
////////////////                         System.out.println("el nuevo fecha penalizacion acumalada es : "+nuevo_Fecha_Fin_Penaliza);
                        // actualizar penalizacion
                        String consulta3 = "update penalizacion set  fecha_fin = ? where id_usuario like ?";// solo actualiza fecha_fin
                        PreparedStatement pstmt3 = con.prepareStatement(consulta3);
                        pstmt3.clearParameters();
                        pstmt3.setString(1, nuevo_Fecha_Fin_Penaliza);
                        pstmt3.setInt(2, id_usuario);
                        pstmt3.executeUpdate();   // si ya existe penalizacion, actualizar

                    } else {
//////////////////                        System.out.println("no existe penalizacion, va a insertar");                  
                        p.setfecha_fin(Fecha_penalizada); // establece fecha fin de penalizacion
                        p.insertar(); // si no existe penalizacion, insertar

                    }
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al InsertarPenalizacion.");
            System.err.println(ex);
        }

    }

    public static void BorrarPenalizacion() {
        Calendar hoy = Calendar.getInstance();
        hoy.clear();
        hoy.setTime(new Date()); // establece feche de hoy;
        String fecha_hoy = (new SimpleDateFormat("dd/MM/yyyy")).format(hoy.getTime());
        System.out.println("fecha_hoy " + fecha_hoy);
        Penalizacion p = new Penalizacion();
        p.setfecha_fin(fecha_hoy);
        p.borrar(); // borra todas las penalizacion que la fecha fin sea hoy en tabla de penalizacion

    }

    public static TreeSet<Integer> ListDePenalizacion_que_NODevolveLibro() {// devolve list id_usuario que esta penalizada y 
        TreeSet<Integer> conjunto = new TreeSet<>();                      //   pendiente de devolve libro
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            String consulta = "select prestamo.id_usuario from prestamo,penalizacion where prestamo.id_usuario=penalizacion.id_usuario";
            Statement stmt = con.createStatement();//          
            ResultSet resultado = stmt.executeQuery(consulta);
            while (resultado.next()) {
                int id_usuario = resultado.getInt("id_usuario");
                conjunto.add(id_usuario);
            }

            con.close();
        } catch (SQLException ex) {
            System.err.println("Excepcion SQL: Error al AvisoPenalizacionNODevolveLibro");
            System.err.println(ex);

        }
        return conjunto;
    }

    public static void AvisoPenalizacion(){
        String Asunto="¡Aviso de penalizacion!";
          TreeSet<Integer> conjunto = ListDePenalizacion_que_NODevolveLibro();
          System.out.println("lista de estudiante existe penalizacion y pendiente de devulver libro");
            for(Integer id:conjunto){
               Usuario u=Util.buscarUsuario(id);
               Penalizacion p=Util.buscarPenalizacion(id);
               String fecha_inicio=p.getfecha_inicio();
               String fecha_fin=p.getfecha_fin();
               String nombre=u.getNombre();
               String email=u.getEmail();
               String contenido="Hola "+nombre+":\n"+"Le informamos que usted está pendiente de devolver libros prestados. Queda penalizado desde el dia "
                + fecha_inicio+" hasta el "+fecha_fin;
                try {
             MailSender.sendMessage(email,Asunto,contenido);
         } catch (MessagingException ex) { 
             Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
         }
               System.out.println(contenido);
     }}
    

     
  public static void main(String[] args) throws ParseException{
       InsertarPenalizacion();
       BorrarPenalizacion();
        AvisoPenalizacion();
        
     }
}
*/