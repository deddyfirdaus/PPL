/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deddy
 */
public class m_lahan {
    
    Connection conn;
    Statement stmt;
    
    public m_lahan() {
        conn = new koneksidb().koneksidb();
    }
      public boolean createLahan(String lahan){
        boolean hasil = false;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO `lahan`(`idlahan`, `namalahan`,`id_bibit`) VALUES (" +lahan+ ")";
            stmt.executeUpdate(sql);
            hasil = true;
        } catch (SQLException ex) {
            Logger.getLogger(m_akun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
      
}
