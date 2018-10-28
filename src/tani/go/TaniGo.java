/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tani.go;

import controller.c_lahan;
import controller.c_menu;
import model.m_akun;

/**
 *
 * @author Deddy
 */
public class TaniGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new c_menu(new Awal(), new createname(), new m_akun(), new exit(), new framepilih());
//        new c_lahan(new lahan(), new m_akun(), "ree");
    }
    
}
