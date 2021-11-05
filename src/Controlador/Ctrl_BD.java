/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Ctrl_BD {

    Connection con;
    DatabaseMetaData metaData;

    ResultSet rs;

    BufferedReader br;
    FileReader fr;
    File f;
    String servidor, puerto, id, usuario, password;

    public Ctrl_BD() {
    }

    public boolean conectarBD() {
        conectarFichero();
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + id, usuario, password);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return false;
        }
    }

    public void conectarMetaData() {
        try {
            metaData = con.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void conectarFichero() {
        f = new File("./src/CredencialesBD/CredencialesBD.txt");
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            servidor = br.readLine();
            puerto = br.readLine();
            id = br.readLine();
            usuario = br.readLine();
            password = br.readLine();
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int fichar(String dni) {
        try {
            Statement s = con.createStatement();
            dni = dni.toUpperCase();
            ResultSet rs = s.executeQuery("SELECT * FROM EMPLEADOS WHERE DNI = " + dni);
            int total = 0;
            while (rs.next()) {
                total++;
            }
            if (total == 1) {
                Statement s1 = con.createStatement();
                ResultSet rs1 = s.executeQuery("SELECT * FROM FICHAJES WHERE DNI = " + dni + " AND FECHORAFIN IS NULL");
                int total1 = 0;
                while (rs1.next()) {
                    total1++;
                }
                if (total1==1) {
                    Statement s2 = con.createStatement();
                    s.executeUpdate("UPDATE FICHAJES SET FECHORAFIN = SYSDATE WHERE FECHORAFIN IS NULL AND DNI = " + dni);
                    return 2;
                } else if(total1==0){
                    Statement s2 = con.createStatement();
                    ResultSet rs2 = s2.executeQuery("SELECT (MAX(IDFICHAJE)+1) AS ID FROM FICHAJES");
                    rs2.next();
                    int id = rs2.getInt("ID");
                    Statement s3 = con.createStatement();
                    s.executeUpdate("INSERT INTO FICHAJES (IDFICHAJE,DNI,FECHORAINI,FECHORAFIN) VALUES (" + id + "," + dni + ",SYSDATE,NULL)");
                    return 3;
                }
                return -1;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_BD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
