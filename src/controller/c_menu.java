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
import model.m_koperasi;
import model.m_player;
import v.about;
import v.bantuan1;
import v.bantuan2;
import v.bantuan3;
import v.bantuan4;
import v.bantuan5;
import v.createname;
import v.framepilih;
import v.keluargame;
import v.load;
import v.menu;

public class c_menu {

    private bantuan1 vB1;
    private bantuan2 vB2;
    private bantuan3 vB3;
    private bantuan4 vB4;
    private bantuan5 vB5;
    private about vAbout;
    private keluargame exit;
    private createname cn;
    private menu vMenu;
    private framepilih fp;
    private load vLoad;
    private m_player mPlayer;
    private m_aset mAset;
    private m_koperasi mKoperasi;

    public c_menu() throws SQLException {
        vAbout = new about();
        vMenu = new menu();
        vLoad = new load();
        vB1 = new bantuan1();
        vB2 = new bantuan2();
        vB3 = new bantuan3();
        vB4 = new bantuan4();
        vB5 = new bantuan5();
        fp = new framepilih();
        cn = new createname();
        exit = new keluargame();
        mPlayer = new m_player();
        mAset = new m_aset();
        mKoperasi = new m_koperasi();
        vMenu.getBtnMulai().addActionListener(new mulaiAction());
        cn.getOK().addActionListener(new okAction());;
        vLoad.getBtnOk().addActionListener(new okActionLoad());
        vLoad.getBtnBatal().addActionListener(new batalActionLoad());
        vMenu.getBtnKeluar().addActionListener(new keluarAction());
        vMenu.getBtnAbout().addActionListener(new aboutAction());
        vMenu.getBtnBantuan().addActionListener(new bantuanAction());
        vAbout.getBtnKembali().addActionListener(new kembaliAction());
        vB1.getClose().addActionListener(new bantuan1CloseAction());
        vB2.getClose().addActionListener(new bantuan2CloseAction());
        vB3.getClose().addActionListener(new bantuan3CloseAction());
        vB4.getClose().addActionListener(new bantuan4CloseAction());
        vB5.getClose().addActionListener(new bantuan5CloseAction());
        vB1.getNext().addActionListener(new bantuan1NextAction());
        vB2.getNext().addActionListener(new bantuan2NextAction());
        vB3.getNext().addActionListener(new bantuan3NextAction());
        vB4.getNext().addActionListener(new bantuan4NextAction());
        vB2.getBack().addActionListener(new bantuan2BackAction());
        vB3.getBack().addActionListener(new bantuan3BackAction());
        vB4.getBack().addActionListener(new bantuan4BackAction());
        vB5.getBack().addActionListener(new bantuan5BackAction());
        vMenu.setVisible(true);

        exit.b_ya().addActionListener(new klikYa());
        exit.b_tidak().addActionListener(new klikTidak());
        fp.b_mulaibaru().addActionListener(new klikMulaibaru());
        fp.b_lanjut().addActionListener(new loadAction());
    }

    private class klikMulaibaru implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cn.setVisible(true);
            fp.dispose();
        }

    }

    private class klikYa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }

    }

    private class klikTidak implements ActionListener {

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

    private class bantuanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB1.setVisible(true);
            vMenu.setVisible(false);
        }

    }

    private class bantuan1CloseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB1.setVisible(false);
            vMenu.setVisible(true);
        }

    }

    private class bantuan2CloseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB2.setVisible(false);
            vMenu.setVisible(true);
        }

    }

    private class bantuan3CloseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB3.setVisible(false);
            vMenu.setVisible(true);
        }

    }
    private class bantuan4CloseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB4.setVisible(false);
            vMenu.setVisible(true);
        }

    }
    private class bantuan5CloseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB5.setVisible(false);
            vMenu.setVisible(true);
        }

    }

    private class bantuan1NextAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB1.setVisible(false);
            vB2.setVisible(true);
        }

    }

    private class bantuan2NextAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB2.setVisible(false);
            vB3.setVisible(true);
        }

    }
    private class bantuan3NextAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB3.setVisible(false);
            vB4.setVisible(true);
        }

    }
    private class bantuan4NextAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB4.setVisible(false);
            vB5.setVisible(true);
        }

    }

    private class bantuan2BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB2.setVisible(false);
            vB1.setVisible(true);
        }

    }
    private class bantuan3BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB3.setVisible(false);
            vB2.setVisible(true);
        }

    }
    private class bantuan4BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB4.setVisible(false);
            vB3.setVisible(true);
        }

    }
    private class bantuan5BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vB5.setVisible(false);
            vB4.setVisible(true);
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
                    mKoperasi.insertPenjualan();
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
