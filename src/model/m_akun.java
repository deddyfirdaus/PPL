/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.c_menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deddy
 */
public class m_akun {

    Connection conn;
    Statement stmt;
    
    public m_akun() {
        conn = new koneksidb().koneksidb();
    }
    
    public boolean createAkun(String nama){
        boolean hasil = false;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO `player`(`id`, `nama`) VALUES (" +nama+ ")";
            stmt.executeUpdate(sql);
            hasil = true;
        } catch (SQLException ex) {
            Logger.getLogger(m_akun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }

    
//     public String[] NamaPlayer() throws SQLException {
//        String query = "SELECT nama FROM player where id = (select id from player where nama='" + username + "')";
//         System.out.println(query);
//        String db = "tanigo";
//        String username = "root";
//        String password = "";
//        String url = "jdbc:mysql://localhost:3306/" + db;
//        Connection con = DriverManager.getConnection(url, username, password);
//        PreparedStatement stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        Statement stmq = con.createStatement();
//        ResultSet rs = stmt.executeQuery();
//        rs.getRow();
//        rs.last();
//        String Nama[] = new String[rs.getRow()];
//        rs.beforeFirst();
//        int a = 0;
//        while (rs.next()) {
//            Nama[a] = rs.getString("nama");
//            a++;
//        }
//        return Nama;
//    }
}
