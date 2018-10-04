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
import tani.go.exit;

/**
 *
 * @author ggnryr
 */
public class c_menu {
    private Awal main_menu = new Awal();
    private exit exit = new exit();
  
    
    public c_menu(Awal mm){
        main_menu = mm;
        
        main_menu.setVisible(true);
        main_menu.pindah("main_menu");
        
        main_menu.b_tentang().addMouseListener(new klikTentang());
        main_menu.b_kembten().addMouseListener(new kembaliTentang());
        main_menu.b_keluar().addMouseListener(new klikKeluar());
    }
    
    public c_menu(exit ext){
        exit = ext;
        exit.setVisible(true);
    }

    private class klikKeluar implements MouseListener {
                  
        private klikKeluar(){
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            new c_menu(exit);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambarmenu/keluar1.png"));
            main_menu.b_keluar().setIcon(ii);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambarmenu/keluar.png"));
            main_menu.b_keluar().setIcon(ii);
        }

    }

    private class kembaliTentang implements MouseListener {

        public kembaliTentang() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            main_menu.pindah("main_menu");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambar_tentang/back1.png"));
            main_menu.b_kembten().setIcon(ii);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambar_tentang/back.png"));
            main_menu.b_kembten().setIcon(ii);
        }
    }

    private class klikTentang implements MouseListener {

        public klikTentang() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            main_menu.pindah("tentang");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
  
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambarmenu/tentang1.png"));
            main_menu.b_tentang().setIcon(ii);
        }

        @Override
        public void mouseExited(MouseEvent e) {
           ImageIcon ii = new ImageIcon(this.getClass().getResource("/gambarmenu/tentang.png"));
            main_menu.b_tentang().setIcon(ii);
        }
    }

}
