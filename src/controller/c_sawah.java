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
import java.math.MathContext;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.m_aset;

//import v.home;
import v.lahan;
import v.map;
//import v.sawah;

/**
 *
 * @author Rangora
 */
public class c_sawah {

    private map vMap;
    private lahan vlahan;
//    private sawah vSawah;
//    private home vHome;
    private m_aset mAset;
    private JButton btnKotak[] = new JButton[6];
    private JLabel notif[] = new JLabel[6];
    private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
    private boolean statusSiram[] = {false, false, false, false, false, false};
    private int bibitjagung;
    private int bibitpadi;
    private int bibittebu;
    private int pestisida;
    private int pupuk;
    private int bibit;
    private int jagung;
    private int idbibit;
    private int detikSiram = 0;
    private boolean detikSiram1 = false;
    private String username;
    private Random random = new Random();

    private Thread t;

    public c_sawah(map vMap, String username) throws SQLException {
        vlahan = new lahan();

        mAset = new m_aset();
        this.vMap = vMap;
        this.username = username;
        btnKotak[0] = vlahan.getBtnKotak1();
        btnKotak[1] = vlahan.getBtnKotak2();
        btnKotak[2] = vlahan.getBtnKotak3();
        btnKotak[3] = vlahan.getBtnKotak4();
        btnKotak[4] = vlahan.getBtnKotak5();
        btnKotak[5] = vlahan.getBtnKotak6();

        notif[0] = vlahan.getLblNotif();
        notif[1] = vlahan.getLblNotif1();
        notif[2] = vlahan.getLblNotif2();
        notif[3] = vlahan.getLblNotif5();
        notif[4] = vlahan.getLblNotif4();
        notif[5] = vlahan.getLblNotif3();

        for (int i = 0; i < notif.length; i++) {
            notif[i].setVisible(false);
        }

        bibitjagung = mAset.getBibitJagung(mAset.cekIdPlayer(username));
        bibitpadi = mAset.getBibitPadi(mAset.cekIdPlayer(username));
        bibittebu = mAset.getBibitTebu(mAset.cekIdPlayer(username));
        pestisida = mAset.getPestisida(mAset.cekIdPlayer(username));
        pupuk = mAset.getPupuk(mAset.cekIdPlayer(username));

        vlahan.getBtnKembali().addActionListener(new kembaliAction());
        vlahan.getBtnKotak1().addActionListener(new kotak1Action());
        vlahan.getBtnKotak2().addActionListener(new kotak2Action());
        vlahan.getBtnKotak3().addActionListener(new kotak3Action());
        vlahan.getBtnKotak4().addActionListener(new kotak4Action());
        vlahan.getBtnKotak5().addActionListener(new kotak5Action());
        vlahan.getBtnKotak6().addActionListener(new kotak6Action());
        vlahan.alatsiram().addActionListener(new airAction());

        vlahan.bibit_jagung().addMouseListener(new pilihbibit());
        vlahan.bibit_padi().addMouseListener(new pilihbibit());

        vlahan.alat_bahan().addMouseListener(new klikAlatBahan());
        vlahan.bibit().addMouseListener(new klikBibit());

        vlahan.bar_alatBahan().setVisible(false);
        vlahan.bar_bibit().setVisible(false);
        vlahan.bibit_padi().setVisible(false);
        vlahan.sabit().setVisible(false);
        vlahan.pupuk().setVisible(false);
        vlahan.alatsiram().setVisible(false);
        vlahan.pestisida().setVisible(false);
        vlahan.bibit_jagung().setVisible(false);
        vlahan.bibit_tebu().setVisible(false);

        t = new time();
        t.start();
    }

    private class pilihbibit implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idbibit = 0;
            if (vlahan.bibit_padi() == me.getSource()) {
                idbibit = 1;
                System.out.println("bibitpadi");
                System.out.println(idbibit);
            } else if (vlahan.bibit_jagung() == me.getSource()) {
                idbibit = 2;
                System.out.println("bibitjagung");
                System.out.println(idbibit);
            } else if (vlahan.bibit_tebu() == me.getSource()) {
                idbibit = 3;
                System.out.println("bibittebu");
            }

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

    private class klikBibit implements MouseListener {

        public klikBibit() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                vlahan.bar_bibit().setVisible(true);
                vlahan.bibit_padi().setVisible(true);
                vlahan.bibit_jagung().setVisible(true);
                vlahan.bibit_tebu().setVisible(true);
            } else if (e.getClickCount() == 2) {
                vlahan.bar_bibit().setVisible(false);
                vlahan.bibit_padi().setVisible(false);
                vlahan.bibit_jagung().setVisible(false);
                vlahan.bibit_tebu().setVisible(false);
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
            if (e.getClickCount() == 1) {
                vlahan.bar_alatBahan().setVisible(true);
                vlahan.sabit().setVisible(true);
                vlahan.pupuk().setVisible(true);
                vlahan.alatsiram().setVisible(true);
                vlahan.pestisida().setVisible(true);
            } else if (e.getClickCount() == 2) {
                vlahan.bar_alatBahan().setVisible(false);
                vlahan.sabit().setVisible(false);
                vlahan.pupuk().setVisible(false);
                vlahan.alatsiram().setVisible(false);
                vlahan.pestisida().setVisible(false);
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

    private class airAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 2) {
                    statusSiram[i] = true;
                    detikSiram1 = true;
                    notif[i].setVisible(true);
                    notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/siram.gif")));
                    //set gif menyiram
                    //set label butuh air false
                    vlahan.bar_alatBahan().setVisible(false);
                    vlahan.pestisida().setVisible(false);
                    vlahan.alatsiram().setVisible(false);
                    vlahan.sabit().setVisible(false);
                    vlahan.pupuk().setVisible(false);
//                    vlahan.getBtnAir().setEnabled(false);

                }
            }
        }
    }

    public void ubahIcon(JButton tombol, String src) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        tombol.setIcon(ii);
    }

    private class kotak1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[0] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/ns1.png");
                        statusKotak[0] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[0] == 3) {//tumbuh
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                } else if (statusKotak[0] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[0] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/jg1.png");
                        statusKotak[0] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[0] == 3) {//tumbuh
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                } else if (statusKotak[0] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[0] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/tb1.png");
                        statusKotak[0] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[0] == 3) {//tumbuh
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                } else if (statusKotak[0] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/lhn.png");

                    statusKotak[0] = 1;
                    statusSiram[0] = false;
                    statusTime1[0] = 0;
                    statusTime2[0] = 0;
                    statusTime3[0] = 0;
                }
            }

        }
    }

    private class kotak2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[1] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/ns1.png");
                        statusKotak[1] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[1] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                } else if (statusKotak[1] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[1] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/jg1.png");
                        statusKotak[1] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[1] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                } else if (statusKotak[1] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[1] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/tb1.png");
                        statusKotak[1] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[1] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                } else if (statusKotak[1] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/lhn.png");

                    statusKotak[1] = 1;
                    statusSiram[1] = false;
                    statusTime1[1] = 0;
                    statusTime2[1] = 0;
                    statusTime3[1] = 0;
                }
            }

        }
    }

    private class kotak3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[2] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/ns1.png");
                        statusKotak[2] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[2] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                } else if (statusKotak[2] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[2] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/jg1.png");
                        statusKotak[2] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[2] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                } else if (statusKotak[2] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[2] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/tb1.png");
                        statusKotak[2] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[2] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                } else if (statusKotak[2] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/lhn.png");

                    statusKotak[2] = 1;
                    statusSiram[2] = false;
                    statusTime1[2] = 0;
                    statusTime2[2] = 0;
                    statusTime3[2] = 0;
                }
            }

        }

    }

    private class kotak4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[3] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/ns1.png");
                        statusKotak[3] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[3] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                } else if (statusKotak[3] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[3] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/jg1.png");
                        statusKotak[3] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[3] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                } else if (statusKotak[3] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[3] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/tb1.png");
                        statusKotak[3] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");
                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[3] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                } else if (statusKotak[3] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/lhn.png");

                    statusKotak[3] = 1;
                    statusSiram[3] = false;
                    statusTime1[3] = 0;
                    statusTime2[3] = 0;
                    statusTime3[3] = 0;
                }
            }

        }

    }

    private class kotak5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[4] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/ns1.png");

                        statusKotak[4] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[4] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                } else if (statusKotak[4] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[4] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/jg1.png");

                        statusKotak[4] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[4] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                } else if (statusKotak[4] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[4] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/tb1.png");

                        statusKotak[4] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[4] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                } else if (statusKotak[4] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/lhn.png");

                    statusKotak[4] = 1;
                    statusSiram[4] = false;
                    statusTime1[4] = 0;
                    statusTime2[4] = 0;
                    statusTime3[4] = 0;
                }
            }

        }

    }

    private class kotak6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.bar_bibit().setVisible(false);
            vlahan.bibit_padi().setVisible(false);
            vlahan.bibit_jagung().setVisible(false);
            vlahan.bibit_tebu().setVisible(false);
            if (idbibit == 1) {
                if (statusKotak[5] == 1) {//kosong
                    if (bibitpadi > 0) {
                        ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/ns1.png");
                        statusKotak[5] = 2;
                        bibitpadi -= 1;
                        try {
                            mAset.updateBibitPadi(bibitpadi, mAset.cekIdPlayer(username));
                            vlahan.getLblPadi().setText(mAset.getBibitPadi(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[5] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");

                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                } else if (statusKotak[5] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");
                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                }
            }
            if (idbibit == 2) {
                if (statusKotak[5] == 1) {//kosong
                    if (bibitjagung > 0) {
                        ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/jg1.png");
                        statusKotak[5] = 2;
                        bibitjagung -= 1;
                        try {
                            mAset.updateBibitJagung(bibitjagung, mAset.cekIdPlayer(username));
                            vlahan.getLblJagung().setText(mAset.getBibitJagung(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[5] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");

                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                } else if (statusKotak[5] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");
                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                }
            }
            if (idbibit == 3) {
                if (statusKotak[5] == 1) {//kosong
                    if (bibittebu > 0) {
                        ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/tb1.png");
                        statusKotak[5] = 2;
                        bibittebu -= 1;
                        try {
                            mAset.updateBibitTebu(bibittebu, mAset.cekIdPlayer(username));
                            vlahan.getLblTebu().setText(mAset.getBibitTebu(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya bibit");

                    }
                } else if (statusKotak[5] == 3) {//tumbuh 
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");

                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                } else if (statusKotak[5] == 4) {//siap panen
                    ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/lhn.png");
                    statusKotak[5] = 1;
                    statusSiram[5] = false;
                    statusTime1[5] = 0;
                    statusTime2[5] = 0;
                    statusTime3[5] = 0;
                }
            }

        }

    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.setVisible(false);
            vMap.setVisible(true);
        }

    }

    private class time extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (idbibit == 1) {
                        bibitpadi = mAset.getBibitPadi(mAset.cekIdPlayer(username));
                        for (int i = 0; i < statusKotak.length; i++) {
                            if (statusKotak[i] == 2) {
                                statusTime1[i] += 1;
                                if (statusTime1[i] == 5) {
                                    notif[i].setVisible(true);
                                    notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notif air.png")));
                                    vlahan.bar_alatBahan().setVisible(true);
                                    vlahan.pestisida().setVisible(true);
                                    vlahan.alatsiram().setVisible(true);
                                    vlahan.sabit().setVisible(true);
                                    vlahan.pupuk().setVisible(true);

//                                    vlahan.getBtnAir().setEnabled(true);
                                }
                            }
                            if (statusSiram[i]) {

                                statusTime2[i] += 1;
                                if (statusTime2[i] == 2) {
                                    notif[i].setVisible(false);
                                } else if (statusTime2[i] == 20) {
                                    statusKotak[i] = 3;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/ns2.png");
                                }
                            }
                            if (statusKotak[i] == 3) {
                                statusTime3[i] += 1;
                                if (statusTime3[i] == 40) {
                                    statusKotak[i] = 4;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/ns3.png");
                                }
                            }
                        }
                    }
                    if (idbibit == 2) {
                        bibitjagung = mAset.getBibitJagung(mAset.cekIdPlayer(username));
                        for (int i = 0; i < statusKotak.length; i++) {
                            if (statusKotak[i] == 2) {
                                statusTime1[i] += 1;
                                if (statusTime1[i] == 5) {
                                    notif[i].setVisible(true);
                                    notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notif air.png")));
                                    vlahan.bar_alatBahan().setVisible(true);
                                    vlahan.pestisida().setVisible(true);
                                    vlahan.alatsiram().setVisible(true);
                                    vlahan.sabit().setVisible(true);
                                    vlahan.pupuk().setVisible(true);
//                                    vlahan.getBtnAir().setEnabled(true);

                                }
                            }
                            if (statusSiram[i]) {

                                statusTime2[i] += 1;
                                if (statusTime2[i] == 2) {
                                    notif[i].setVisible(false);
                                } else if (statusTime2[i] == 20) {
                                    statusKotak[i] = 3;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/jg2.png");
                                }
                            }
                            if (statusKotak[i] == 3) {
                                statusTime3[i] += 1;
                                if (statusTime3[i] == 40) {
                                    statusKotak[i] = 4;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/jg3.png");
                                }
                            }
                        }
                    }
                    if (idbibit == 3) {
                        bibittebu = mAset.getBibitTebu(mAset.cekIdPlayer(username));
                        for (int i = 0; i < statusKotak.length; i++) {
                            if (statusKotak[i] == 2) {
                                statusTime1[i] += 1;
                                if (statusTime1[i] == 5) {
                                    notif[i].setVisible(true);
                                    notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notif air.png")));
                                    vlahan.bar_alatBahan().setVisible(true);
                                    vlahan.pestisida().setVisible(true);
                                    vlahan.alatsiram().setVisible(true);
                                    vlahan.sabit().setVisible(true);
                                    vlahan.pupuk().setVisible(true);
//                                    vlahan.getBtnAir().setEnabled(true);

                                }
                            }
                            if (statusSiram[i]) {

                                statusTime2[i] += 1;
                                if (statusTime2[i] == 2) {
                                    notif[i].setVisible(false);
                                } else if (statusTime2[i] == 20) {
                                    statusKotak[i] = 3;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/tb2.png");
                                }
                            }
                            if (statusKotak[i] == 3) {
                                statusTime3[i] += 1;
                                if (statusTime3[i] == 40) {
                                    statusKotak[i] = 4;
                                    ubahIcon(btnKotak[i], "/gambar/isisawah/tb3.png");
                                }
                            }
                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public lahan getView() {
        return vlahan;
    }

}
