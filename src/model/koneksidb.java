/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deddy
 */
public class koneksidb {
    private Connection koneksi;
    String url = "jdbc:mysql://localhost:3306/tanigo";
    String username = "root";
    String password = "";
    
    public Connection koneksidb() {
        try {
            koneksi = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(koneksidb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return koneksi;
    }
    
}
