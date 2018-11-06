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
import v.map;
import v.tokotani;

public class c_tokotani {
    private tokotani vToko;
    private map vMap;
    private m_aset mAset;
    private String username;
    private int hargabibitjagung = 700;
    private int hargabibitpadi = 500;
    private int hargabibittebu = 800;
    private int hargapestisida = 300;
    private int hargapupuk = 300;
    private int hargaBibit = 280;
    private int hargaJagung = 60;
    private int hargaGaram = 150;
    private int hargaMinyakGoreng = 300;

    public c_tokotani(map vMap, String username) throws SQLException {
        vToko = new tokotani();
        mAset = new m_aset();
        this.vMap = vMap;
        this.username = username;

        vToko.getBtnKembali().addActionListener(new kembaliAction());
        vToko.getBtnItem1().addActionListener(new bibitJagungAction());
        vToko.getBtnItem2().addActionListener(new bibitPadiAction());
        vToko.getBtnItem3().addActionListener(new bibitTebuAction());
        vToko.getBtnItem4().addActionListener(new pupukAction());
        vToko.getBtnItem5().addActionListener(new pestisidaAction());
    }

    private class bibitJagungAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin beli bibit jagung?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargabibitjagung, mAset.cekIdPlayer(username));
                    mAset.updateBibitJagung(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class bibitPadiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin beli bibit padi?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargabibitpadi, mAset.cekIdPlayer(username));
                    mAset.updateBibitPadi(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class bibitTebuAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin beli bibit tebu?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargabibittebu, mAset.cekIdPlayer(username));
                    mAset.updateBibitTebu(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class pestisidaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin beli pestisida?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargapestisida, mAset.cekIdPlayer(username));
                    mAset.updatePestisida(mAset.getPestisida(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private class pupukAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vMap, "Yakin beli pupuk?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargapupuk, mAset.cekIdPlayer(username));
                    mAset.updatePupuk(mAset.getPupuk(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vToko.setVisible(false);
            vMap.setVisible(true);
            vMap.toFront();
            try {
                vMap.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_tokotani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public tokotani getView() {
        return vToko;
    }
}
