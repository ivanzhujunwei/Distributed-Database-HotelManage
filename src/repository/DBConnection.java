/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author wudhichart
 * @version Omega
 */
public final class DBConnection {
    public static Connection conn = null;
    public static Connection getConnectionA(){
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a", "S27118347", "student");
            System.out.println("Connected to FIT5148A Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static Connection getConnectionB(){
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148b", "S27118347", "student");
            System.out.println("Connected to FIT5148B Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void closeConnection(){
        try {
            conn.close();
            System.out.println("Connection is closed.");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
