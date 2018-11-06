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
//import m.m_aset;
//import m.m_marning;
//import v.home;
//import v.tokoPenjualanProduk;

/**
 *
 * @author Rangora
 */
public class c_toko {

//    private tokoPenjualanProduk vToko;
//    private home vHome;
//    private m_marning mMarning;
//    private m_aset mAset;
    private String username;
    private boolean jual;
    private int marningA;
    private int marningB;
    private int marningC;
    private int empingA;
    private int empingB;
    private int empingC;
    private int totalMarning;
    private int totalEmping;
    private int koin;
//    private time jualThread;
    private Random random = new Random();

//    public c_toko(home vHome, String username) throws SQLException {
//        vToko = new tokoPenjualanProduk();
//        mMarning = new m_marning();
//        mAset = new m_aset();
//        this.vHome = vHome;
//        this.username = username;
//        koin = mAset.getKoin(mAset.cekIdPlayer(username));
//        marningA = mMarning.getMarningA(mMarning.cekIdPlayer(username));
//        marningB = mMarning.getMarningB(mMarning.cekIdPlayer(username));
//        marningC = mMarning.getMarningC(mMarning.cekIdPlayer(username));
//        totalMarning = marningA + marningB + marningC;
//        empingA = mMarning.getEmpingA(mMarning.cekIdPlayer(username));
//        empingB = mMarning.getEmpingB(mMarning.cekIdPlayer(username));
//        empingC = mMarning.getEmpingC(mMarning.cekIdPlayer(username));
//        totalEmping = empingA + empingB + empingC;
//
//        vToko.getBtnKembali().addActionListener(new kembaliAction());
//        vToko.getBtnMulaiJual().addActionListener(new mulaiJualAction());
//
//        jualThread = new time();
//        jualThread.start();
//    }

//    private class mulaiJualAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                if (jual == false) {
//                    if (mMarning.getMarningA(mMarning.cekIdPlayer(username)) == 0 && mMarning.getMarningB(mMarning.cekIdPlayer(username)) == 0 && 
//                            mMarning.getMarningC(mMarning.cekIdPlayer(username)) == 0) {
//                        JOptionPane.showMessageDialog(vToko, "Stok Marning Habis");
//                    } else {
//                        jual = true;
//                        vToko.getBtnMulaiJual().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblBukaToko.png")));
//                        vToko.getBtnMulaiJual().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblBukaTokoHover.png")));
//                    }
//                } else {
//                    jual = false;
//                    vToko.getBtnMulaiJual().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblTutupToko.png")));
//                    vToko.getBtnMulaiJual().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblTutupTokoHover.png")));
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

//    private class kembaliAction implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            vToko.setVisible(false);
//            vHome.setVisible(true);
//        }
//    }

//    private class time extends Thread {
//
//        @Override
//        public void run() {
//            while (true) {
//                try {
//                    Thread.sleep(3000);
//                    if (jual) {
//                        if (mMarning.getMarningA(mMarning.cekIdPlayer(username)) > 0) {
//                            if (random.nextInt(3) == 1) {
//                                marningA = mMarning.getMarningA(mMarning.cekIdPlayer(username))- 1;
//                                koin += 70;
//                                mMarning.updateMarningA(marningA, mMarning.cekIdPlayer(username));
//                            }
//                        }
//                        if (mMarning.getMarningB(mMarning.cekIdPlayer(username)) > 0) {
//                            if (random.nextInt(5) == 1) {
//                                marningB =mMarning.getMarningB(mMarning.cekIdPlayer(username))- 1;
//                                koin += 70;
//                                mMarning.updateMarningB(marningB, mMarning.cekIdPlayer(username));
//                            }
//                        }
//                        if (mMarning.getMarningC(mMarning.cekIdPlayer(username)) > 0) {
//                            if (random.nextInt(10) == 1) {
//                                marningC =mMarning.getMarningC(mMarning.cekIdPlayer(username))- 1;
//                                koin += 70;
//                                mMarning.updateMarningC(marningC, mMarning.cekIdPlayer(username));
//                            }
//                        }
//                        if (mMarning.getMarningA(mMarning.cekIdPlayer(username)) == 0 && mMarning.getMarningB(mMarning.cekIdPlayer(username)) == 0 && 
//                            mMarning.getMarningC(mMarning.cekIdPlayer(username)) == 0) {
//                            jual = false;
//                            vToko.getBtnMulaiJual().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblTutupToko.png")));
//                            vToko.getBtnMulaiJual().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isitoko/tblTutupTokoHover.png")));
//                        }
//                        mAset.updateKoin(koin, mAset.cekIdPlayer(username));
//                        vHome.getLblMarning().setText((mMarning.getMarningA(mMarning.cekIdPlayer(username)) + mMarning.getMarningB(mMarning.cekIdPlayer(username))
//                                + mMarning.getMarningC(mMarning.cekIdPlayer(username))) + "");
//                        vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
//                        System.out.println("marning a= " + marningA);
//                        System.out.println("marning b= " + marningB);
//                        System.out.println("marning c= " + marningC);
//                    }
//                    totalMarning = marningA + marningB + marningC;
//                    vToko.getLblMarning().setText(totalMarning + "");
//                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }

    public void marning (int m1, int m2, int m3){
        marningA = m1;
        marningB = m2;
        marningC = m3;
    }
//    public tokoPenjualanProduk getView() {
//        return vToko;
//    }
}
