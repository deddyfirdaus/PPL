/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_akun;
import tani.go.lahan;

/**
 *
 * @author Deddy
 */
public class c_lahan {
     private m_akun mA ;
    private lahan game = new lahan();

    public c_lahan() {
        game = new lahan();
        game.setVisible(true);
         try {
             mA = new m_akun();
         } catch (SQLException ex) {
             Logger.getLogger(c_lahan.class.getName()).log(Level.SEVERE, null, ex);
         }
        
//         try {
//             game.setNama(mA.NamaPlayer());
//         } catch (SQLException ex) {
//             Logger.getLogger(c_lahan.class.getName()).log(Level.SEVERE, null, ex);
//         }

    }
}
