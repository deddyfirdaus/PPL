/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Deddy
 */
public class m_koperasi extends m_function {

    private ResultSet rs;

    public m_koperasi() throws SQLException {
    }

    public String cekIdPlayer(String username) throws SQLException {
        String query = "SELECT `id_user` FROM `user` WHERE `username` = '" + username + "'";
        return getDataString(query);
    }
    
      public int getJagung(String idUser) throws SQLException {
        String query = "SELECT jagung FROM `penjualan` where id_user = " + idUser;
        return getDataInt(query);
    }

    //===========================================================================
    public boolean updateJagung(int jagung, String idUser) throws SQLException {
        String query = "UPDATE `penjualan` SET `jagung` = '" + jagung + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }

    //===========================================================================
    public int cekId() throws SQLException {
        String query = "select id_penjualan from penjualan where id_penjualan = ";
        return checkId(query);
    }

    public boolean insertPenjualan() throws SQLException {
        int id = cekId();
        String query = "INSERT INTO `penjualan` VALUES (" + id + "," + id + ",5)";
        return getStatusQuery(query);
    }
}
