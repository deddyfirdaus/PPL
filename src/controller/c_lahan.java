/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.m_akun;
import tani.go.lahan;

/**
 *
 * @author Deddy
 */
public class c_lahan {

    private m_akun m_akun;
    private lahan lahan = new lahan();
    private String nama;

    public c_lahan(lahan lahan, m_akun m_akun, String nama) {
        this.nama = nama;
        this.m_akun = m_akun;
        this.lahan = lahan;

        lahan.setVisible(true);
        lahan.bar_alatBahan().setVisible(false);
        lahan.bar_bibit().setVisible(false);
        lahan.bibit_padi().setVisible(false);
        lahan.bibit_jagung().setVisible(false);
        lahan.bibit_tebu().setVisible(false);
        lahan.alat_ktl().setVisible(false);
        lahan.alat_ppk().setVisible(false);
        lahan.alat_sbt().setVisible(false);

        lahan.namaplayer().setText(nama);

        lahan.alat_bahan().addMouseListener(new klikAlatBahan());
        lahan.bibit().addMouseListener(new klikBibit());
        
        
        

    }

    public void ubahIcon(JButton tombol, String src) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        tombol.setIcon(ii);
    }


    private class klikBibit implements MouseListener {

        public klikBibit() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
             if(e.getClickCount()==1){
               lahan.bar_bibit().setVisible(true);
               lahan.bibit_padi().setVisible(true);
           } else if(e.getClickCount()==2){
               lahan.bar_bibit().setVisible(false);
               lahan.bibit_padi().setVisible(false);
           }
        }

        @Override
        public void mousePressed(MouseEvent e) {
  
        }

        @Override
        public void mouseReleased(MouseEvent e) {
   
        }

        @Override
        public void mouseEntered(MouseEvent e) {
      
        }

        @Override
        public void mouseExited(MouseEvent e) {
         
        }
    }
    
    private class klikAlatBahan implements MouseListener {

        public klikAlatBahan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           if(e.getClickCount()==1){
               lahan.bar_alatBahan().setVisible(true);
           } else if(e.getClickCount()==2){
               lahan.bar_alatBahan().setVisible(false);
           }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(lahan.alat_bahan(), "/gambarlahan/alat2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(lahan.alat_bahan(), "/gambarlahan/alat.png");
        }
    }

}
