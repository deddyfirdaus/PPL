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
import v.about;

import v.map;

public class c_home {
    private map vMap;
    private about vAbout;
    private m_aset mAset;
    private String username;

    public c_home(String username) throws SQLException {
        vAbout = new about();
        vMap = new map();
        mAset = new m_aset();
        this.username = username;
        vMap.getBtnKoperasi().addActionListener(new tokotaniAction());
        vMap.getBtnSawah1().addActionListener(new sawahAction());
        vMap.getBtnToko().addActionListener(new tokoAction());
        vMap.getBtnLogOut().addActionListener(new logOutAction());;
        vMap.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
        vMap.getLabelUsername().setText(username);
        vMap.setVisible(true);
    }

    private class logOutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin Meniggalkan Game..??", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private class sawahAction implements ActionListener {

        private c_sawah sawah;

        public sawahAction() throws SQLException {
            sawah = new c_sawah(vMap, username);
            sawah.getView().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                sawah.getView().getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");
                sawah.getView().getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                sawah.getView().getLblPestisida().setText(mAset.getPestisida(mAset.cekIdPlayer(username)) + "");
                sawah.getView().getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            sawah.getView().setVisible(true);
            vMap.setVisible(false);

        }
    }

    private class tokotaniAction implements ActionListener {

        private c_tokotani tokotani;

        public tokotaniAction() throws SQLException {
            tokotani = new c_tokotani(vMap, username);
            tokotani.getView().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tokotani.getView().getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            tokotani.getView().setVisible(true);
            vMap.setVisible(false);
        }
    }
    
     private class tokoAction implements ActionListener {
//
        private c_toko toko;

        public tokoAction() throws SQLException {
            toko = new c_toko(vMap, username);
            toko.getView().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int jumlah=1;
                toko.getView().getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblJumlah().setText(jumlah+"");

            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            toko.getView().setVisible(true);
            vMap.setVisible(false);
        }
//
    }

    public map getView() {
        return vMap;
    }

}
