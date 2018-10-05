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
import javax.swing.JButton;
import tani.go.Awal;
import tani.go.exit;
import tani.go.framepilih;

/**
 *
 * @author ggnryr
 */
public class c_menu {

    private Awal main_menu = new Awal();
    private exit exit = new exit();
    private framepilih frap = new framepilih();

    public c_menu(Awal mm) {
        main_menu = mm;

        main_menu.setVisible(true);
        main_menu.pindah("main_menu");

        main_menu.b_tentang().addMouseListener(new klikTentang());
        main_menu.b_kembten().addMouseListener(new kembaliTentang());
        main_menu.b_keluar().addMouseListener(new klikKeluar());
        main_menu.b_mulai().addMouseListener(new klikMulai());
        main_menu.b_bantuan().addMouseListener(new klikBantuan());
    }

    public c_menu(exit ext) {
        exit = ext;
        exit.setVisible(true);

        exit.b_ya().addMouseListener(new klikYa());
        exit.b_tidak().addMouseListener(new klikTidak());
    }

    public c_menu(framepilih fp) {
        frap = fp;
        frap.setVisible(true);
        
        frap.b_mulaibaru().addMouseListener(new klikMulaibaru());
        frap.b_lanjut().addMouseListener(new klikLanjut());
    }

    public void ubahIcon(JButton tombol, String src) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        tombol.setIcon(ii);
    }

    private class klikBantuan implements MouseListener {

        public klikBantuan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(main_menu.b_bantuan(), "/gambarmenu/bantuan1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(main_menu.b_bantuan(), "/gambarmenu/bantuan.png");
        }
    }

    private class klikMulai implements MouseListener {

        public klikMulai() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            new c_menu(frap);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(main_menu.b_mulai(), "/gambarmenu/mulai1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(main_menu.b_mulai(), "/gambarmenu/mulai.png");
        }
    }
    private class klikTidak implements MouseListener {

        public klikTidak() {
        }

//        @Override
//        public void actionPerformed(ActionEvent e) {
//            exit.setVisible(false);
//        }
        @Override
        public void mouseClicked(MouseEvent e) {
            exit.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(exit.b_tidak(), "/gambar_exit/tidak1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(exit.b_tidak(), "/gambar_exit/tidak.png");
        }
    }

    private class klikLanjut implements MouseListener {

        public klikLanjut() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(frap.b_lanjut(), "/gambarplay/continue.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(frap.b_lanjut(), "/gambarplay/continue1.png");
        }
    }
    private class klikMulaibaru implements MouseListener {

        public klikMulaibaru() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(frap.b_mulaibaru(), "/gambarplay/new game.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(frap.b_mulaibaru(), "/gambarplay/new game1.png");
        }
    }

    private class klikYa implements MouseListener {

        public klikYa() {
        }

//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.exit(0);
//        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ubahIcon(exit.b_ya(), "/gambar_exit/ya1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(exit.b_ya(), "/gambar_exit/ya.png");
        }

    }

    private class klikKeluar implements MouseListener {

        private klikKeluar() {
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
            ubahIcon(main_menu.b_keluar(), "/gambarmenu/keluar1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(main_menu.b_keluar(), "/gambarmenu/keluar.png");
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
            ubahIcon(main_menu.b_kembten(), "/gambar_tentang/back1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(main_menu.b_kembten(), "/gambar_tentang/back.png");
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
            ubahIcon(main_menu.b_tentang(), "/gambarmenu/tentang1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(main_menu.b_tentang(), "/gambarmenu/tentang.png");
        }
    }

}
