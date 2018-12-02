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
 * @author Rangora
 */
public class m_aset extends m_function {

    private ResultSet rs;

    public m_aset() throws SQLException {
    }

    public String cekIdPlayer(String username) throws SQLException {
        String query = "SELECT `id_user` FROM `user` WHERE `username` = '" + username + "'";
        return getDataString(query);
    }

    public int getKoin(String idUser) throws SQLException {
        String query = "SELECT koin FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }

    public int getBibit(String idUser) throws SQLException {
        String query = "SELECT bibit FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }
    public int getBibitJagung(String idUser) throws SQLException {
        String query = "SELECT bibitjagung FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }
    public int getBibitPadi(String idUser) throws SQLException {
        String query = "SELECT bibitpadi FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }
    public int getBibitTebu(String idUser) throws SQLException {
        String query = "SELECT bibittebu FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }
    public int getPestisida(String idUser) throws SQLException {
        String query = "SELECT pestisida FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }
    public int getPupuk(String idUser) throws SQLException {
        String query = "SELECT pupuk FROM `aset` where id_user = " + idUser;
        return getDataInt(query);
    }

 

    //==============================================================================================
    public boolean updateKoin(int koin, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `koin` = '" + koin + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }

    public boolean updateBibit(int bibit, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `bibit` = '" + bibit + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }
    public boolean updateBibitJagung(int bibit, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `bibitjagung` = '" + bibit + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }
    public boolean updateBibitPadi(int bibit, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `bibitpadi` = '" + bibit + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }
    public boolean updateBibitTebu(int bibit, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `bibittebu` = '" + bibit + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }
    public boolean updatePestisida(int pestisida, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `pestisida` = '" + pestisida + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }
    public boolean updatePupuk(int pupuk, String idUser) throws SQLException {
        String query = "UPDATE `aset` SET `pupuk` = '" + pupuk + "' WHERE id_user = " + idUser;
        return getStatusQuery(query);
    }



    //===========================================================================
    public int cekId() throws SQLException {
        String query = "select id_aset from aset where id_aset = ";
        return checkId(query);
    }

    public boolean insertAset() throws SQLException {
        int id = cekId();
        String query = "INSERT INTO `aset` VALUES (" + id + "," + id + ",10000,5,1,1)";
        return getStatusQuery(query);
    }

}
