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

/**
 *
 * @author Deddy
 */
public class m_akun extends basemodel{
    
//    String username = c_menu.getUser();
    
    public m_akun() throws SQLException {
        kon = new koneksidb("root", "", "tanigo");

    }
    public boolean simpan(String query) throws SQLException {
        String queri = "INSERT INTO `player` (`id`, `nama`) VALUES (" +query+ " )";
        System.out.println(queri);
        return super.save(queri);
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
