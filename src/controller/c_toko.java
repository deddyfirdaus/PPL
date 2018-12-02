/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_aset;
import model.m_koperasi;
import v.koperasi;
import v.koperasi;
import v.map;



public class c_toko {


    private koperasi vKoperasi;
    private map vMap;
    private m_koperasi mKoperasi;
    private m_aset mAset;
    private String username;
    private int jagung;
    private int jmljagung;

    private int koin;
    private int dptkoin;
    private int hrgajgng=4000;
    private int jumlah;



    public c_toko(map vMap, String username) throws SQLException {

        vKoperasi = new koperasi();
        mAset = new m_aset();
        mKoperasi = new m_koperasi();
        this.vMap = vMap;
        this.username = username;
        koin = mAset.getKoin(mAset.cekIdPlayer(username));

//
        vKoperasi.getBtnKembali().addActionListener(new kembaliAction());
        vKoperasi.getBtnTambah().addActionListener(new tambahAction());
        vKoperasi.getBtnKurang().addActionListener(new kurangAction());
        vKoperasi.getBtnJual().addActionListener(new jualAction());
    }

    private class jualAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin ingin menjual Jagung?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                jmljagung = jagung - jumlah;
            
                dptkoin = koin + (hrgajgng*jumlah);
                
                try {
                    mKoperasi.updateJagung(jmljagung, mKoperasi.cekIdPlayer(username));
                    mAset.updateKoin(dptkoin, mAset.cekIdPlayer(username));
                    vKoperasi.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username))+"");
                } catch (SQLException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    private class tambahAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                jagung = mKoperasi.getJagung(mKoperasi.cekIdPlayer(username));
            } catch (SQLException ex) {
                Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (jumlah < jagung) {
                jumlah++;
                vKoperasi.getLblJumlah().setText(jumlah + "");
            } else {
                JOptionPane.showMessageDialog(vMap, "max pembelian jagung : " + jagung + " jagung");
            }
        }

    }

    private class kurangAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (jumlah > 1) {
                jumlah--;
                vKoperasi.getLblJumlah().setText(jumlah + "");
            } else {
                JOptionPane.showMessageDialog(vMap, "min pembelian jagung : 1");
            }
        }

    }


    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vKoperasi.setVisible(false);
            vMap.setVisible(true);
        }
    }

    public koperasi getView() {
        return vKoperasi;
    }
}
