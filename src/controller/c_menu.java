/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import tani.go.Awal;
import tani.go.tentang;

/**
 *
 * @author ggnryr
 */
public class c_menu {
    private Awal main_menu;
    
    public c_menu(Awal mm){
        this.main_menu = mm;
        
        main_menu.setVisible(true);
        main_menu.pindah("main_menu");
        
        main_menu.b_tentang().addActionListener(new b_tentang());
        
    }


    private class b_tentang implements ActionListener {

        public b_tentang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            main_menu.pindah("tentang");
        }
    }
}
