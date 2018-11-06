/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tani.go;

import controller.c_menu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Deddy
 */
public class TaniGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new c_menu();
        } catch (SQLException ex) {
            Logger.getLogger(TaniGo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
