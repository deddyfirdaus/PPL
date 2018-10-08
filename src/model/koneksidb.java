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

/**
 *
 * @author Deddy
 */
public class koneksidb {
     private static Connection koneksi;
    private Statement stm;
    
    public koneksidb(String username, String password, String database) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + database;
        koneksi = DriverManager.getConnection(url, username, password);
        stm = koneksi.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }
    
    public ResultSet getResult(String sql) throws SQLException {
        return stm.executeQuery(sql);

    }

    public void execute(String sql) throws SQLException {
        this.stm.executeUpdate(sql);
    }

    public koneksidb Koneksi() {
        return (koneksidb) koneksi;
    }
}
