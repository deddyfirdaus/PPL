/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.m_akun;
import tani.go.Toko;
import tani.go.lahan;

/**
 *
 * @author Deddy
 */
public class c_toko {

    private Toko toko;
    
     private String nama;

    public c_toko(Toko tk) {
        toko = new Toko();
        toko = tk;

        toko.setVisible(true);

        toko.getBack().addMouseListener(new klikback());

    }

    private class klikback implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            new c_lahan(new lahan(), new m_akun(), nama);
            System.out.println("bisa");
            toko.dispose();
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }

}
