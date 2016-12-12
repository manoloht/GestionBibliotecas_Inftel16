/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Configuracion.Conexion;
import Modelo.Penalizacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author YUEMEI
 */
public class ModificaPenalizacion {

    public static Calendar ToCalendar(String fecha) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = df.parse(fecha);
        Calendar fecha_fin = Calendar.getInstance();
        fecha_fin.clear();
        fecha_fin.setTime(fechaDate);

        return fecha_fin;

    }

    public static String CalcularFechaPenalizada(Calendar fecha_fin, Calendar hoy) throws ParseException {

        // transformar a milsegundos
        long sl = fecha_fin.getTimeInMillis();
        long el = hoy.getTimeInMillis();
        // calcular diferencia;
        long ei = el - sl;
        int dia_retraso = (int) (ei / (1000 * 60 * 60 * 24));
        System.out.println("dia_retraso: "+dia_retraso);
        int dia_penaliza = 2 * dia_retraso;
//        System.out.println("dia_penaliza: "+dia_penaliza);
        //CalcularFechaPenalizada
        Calendar Fecha_penalizada = (Calendar) hoy.clone();
        Fecha_penalizada.add(Calendar.DATE, dia_penaliza);
        String Fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(Fecha_penalizada.getTime());
        return Fecha;
    }

    public static void InsertarPenalizacion() throws ParseException {
        Calendar hoy = Calendar.getInstance();
        hoy.clear();
        hoy.setTime(new Date()); // establece feche de hoy;
        String fecha_hoy = (new SimpleDateFormat("dd/MM/yyyy")).format(hoy.getTime());
        System.out.println("fecha_hoy" + fecha_hoy);
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
                System.out.println("id_usuario:" + id_usuario + "fecha_fin:" + fecha_fin_devolucion);


                Calendar fecha_fin_devolve = ToCalendar(fecha_fin_devolucion); // transforma String a Calendar

                if (hoy.after(fecha_fin_devolve)) { // cuando existe retraso
                    System.out.println("existe retraso");
                    p.setId_estudiante(id_usuario);
                    p.setfecha_inicio(fecha_hoy); // establece hoy como fecha inicio de penalizacion

                    Fecha_penalizada = CalcularFechaPenalizada(fecha_fin_devolve, hoy); // calcula fecha penalizada     
                    System.out.println("Fecha_penalizada" + Fecha_penalizada);

                    p.setfecha_fin(Fecha_penalizada); // establece fecha fin de penalizacion
                    // comprobar si existe penalizacion
                    String consulta2 = "select * from penalizacion where id_usuario like ?";
                    PreparedStatement pstmt = con.prepareStatement(consulta2);
                    pstmt.clearParameters();
                    pstmt.setInt(1, id_usuario);
                    ResultSet resultado2 = pstmt.executeQuery();

                    if (resultado2.next()) {
//                        System.out.println("existe penalizacion, va a actualizar");
                        String consulta3 = "update penalizacion set  fecha_fin = ? where id_usuario like ?";// solo actualiza fecha_fin
                        PreparedStatement pstmt3 = con.prepareStatement(consulta3);
                        pstmt3.clearParameters();
                        pstmt3.setString(1,Fecha_penalizada );
                        pstmt3.setInt(2, id_usuario);
                        pstmt3.executeUpdate();   // si ya existe penalizacion, actualizar
                     
                    } else {
//                        System.out.println("no existe penalizacion, va a insertar");
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
        System.out.println("fecha_hoy "+fecha_hoy);
        Penalizacion p = new Penalizacion();
        p.setfecha_fin(fecha_hoy);
        p.borrar(); // borra todas las penalizacion que la fecha fin sea hoy en tabla de penalizacion

    }

    public static void main(String[] args) throws ParseException {
        InsertarPenalizacion();
        BorrarPenalizacion();
    }
}
