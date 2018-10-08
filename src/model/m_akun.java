/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Deddy
 */
public class m_akun extends basemodel{
    
    public m_akun() throws SQLException {
        kon = new koneksidb("root", "", "tanigo");

    }
    public boolean simpan(String query) throws SQLException {
        String queri = "INSERT INTO `player` (`id`, `nama`) VALUES (" +query+ " )";
        System.out.println(queri);
        return super.save(queri);
    }
}
