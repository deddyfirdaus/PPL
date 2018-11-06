/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_aset;
import model.m_player;
import v.about;
import v.createname;
import v.framepilih;
import v.keluargame;
import v.load;
import v.menu;

public class c_menu {

    private about vAbout;
    private keluargame exit;
    private createname cn;
    private menu vMenu;
    private framepilih fp;
    private load vLoad;
    private m_player mPlayer;
    private m_aset mAset;


    public c_menu() throws SQLException {
        vAbout = new about();
        vMenu = new menu();
        vLoad = new load();
        fp = new framepilih();
        cn = new createname();
        exit = new keluargame();
        mPlayer = new m_player();
        mAset = new m_aset();
        vMenu.getBtnMulai().addActionListener(new mulaiAction());
        cn.getOK().addActionListener(new okAction());;
        vLoad.getBtnOk().addActionListener(new okActionLoad());
        vLoad.getBtnBatal().addActionListener(new batalActionLoad());
        vMenu.getBtnKeluar().addActionListener(new keluarAction());
        vMenu.getBtnAbout().addActionListener(new aboutAction());
        vAbout.getBtnKembali().addActionListener(new kembaliAction());
        vMenu.setVisible(true);
        
        exit.b_ya().addActionListener(new klikYa());
        exit.b_tidak().addActionListener(new klikTidak());
        fp.b_mulaibaru().addActionListener(new klikMulaibaru());
        fp.b_lanjut().addActionListener(new loadAction());
    }

    private class klikMulaibaru implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            cn.setVisible(true);
            fp.dispose();
        }
    
    }
    private class klikYa implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    
    }
    private class klikTidak implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            exit.dispose();
        }
    
    }
       
    private class aboutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vAbout.setVisible(true);
            vMenu.setVisible(false);
        }

    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vAbout.setVisible(false);
            vMenu.setVisible(true);
        }
        
    }

    private class batalActionLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vLoad.dispose();
            vMenu.setVisible(true);
        }
    }

    private class okActionLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vLoad.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vLoad, "Pilih dahulu");
            } else {
                try {
                    new c_home(vLoad.getIdTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(c_menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                vLoad.setVisible(false);
            }
        }
    }

    private class loadAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vLoad.setVisible(true);
            fp.dispose();
            try {
                vLoad.setTableModel(mPlayer.getTabel());
            } catch (SQLException ex) {
                Logger.getLogger(c_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            vMenu.setVisible(false);
        }
    }

    private class okAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                if (cn.getNama().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cn, "Username tidak boleh kosong");
                } else {
                    mPlayer.insertUsername(cn.getNama().getText());
                    mAset.insertAset();
                    JOptionPane.showMessageDialog(cn, "Username " + cn.getNama().getText() + " berhasil dibuat");
                    new c_home(cn.getNama().getText());
                    cn.dispose();
                    vMenu.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

 private class mulaiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fp.setVisible(true);

        }

    }


    private class keluarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            exit.setVisible(true);
        }

    }
}
