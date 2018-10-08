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
public abstract class basemodel {
    public koneksidb kon;

    public basemodel() throws SQLException {
        this.kon = new koneksidb("root", "", "tanigo");
    }
    
      public boolean save(String query) throws SQLException {
        try {
            kon.execute(query);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
