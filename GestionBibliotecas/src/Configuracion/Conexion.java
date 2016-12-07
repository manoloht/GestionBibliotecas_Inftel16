/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel y Alberto
 */
public class Conexion {

    public Conexion() {
    }

    public Connection getConnection() {

        Connection con = null;

        try {
            /*Properties pr = new Properties();
            //InputStream config = ClassLoader.getSystemResourceAsStream(Conexion.class.getPackage().getName() + "/bd.properties");
            pr.load(config);
            config.close();

            // Leemos el fichero properties
            String driver = pr.getProperty("driver");
            String subprotocolo = pr.getProperty("subprotocolo");
            String usuario = pr.getProperty("usuario");
            String password = pr.getProperty("password");
            String url = pr.getProperty("url");
            int puerto = Integer.parseInt(pr.getProperty("puerto"));
            String sid = pr.getProperty("sid");*/

            // Cargamos el driver
            //Class.forName(driver);
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Preparamos la conexion
            //String cadConexion = subprotocolo + ":" + usuario + "/" + password + "@" + url + ":" + puerto + ":" + sid;
            String cadConexion = "jdbc:oracle:thin:inftel16_11/inftel@olimpia.lcc.uma.es:1521:edgar";
            con = DriverManager.getConnection(cadConexion);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
