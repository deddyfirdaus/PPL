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

/**
 *
 * @author ggnryr
 */
public class c_menu {

    private Awal main_menu = new Awal();
    private exit exit = new exit();

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

        exit.b_ya().addActionListener(new klikYa());
        exit.b_tidak().addActionListener(new klikTidak());
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

    private class klikTidak implements ActionListener {

        public klikTidak() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            exit.setVisible(false);
        }
    }

    private class klikYa implements ActionListener {

        public klikYa() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
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
