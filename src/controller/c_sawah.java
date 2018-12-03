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
import javax.swing.Timer;
import model.m_aset;
import model.m_koperasi;
import v.lahan;
import v.map;

public class c_sawah {

    Timer waktu;
    private static int sekpd = 0;
    private static int sekjg = 0;
    private static int sektb = 0;
    private map vMap;
    private lahan vlahan;
    private m_aset mAset;
    private m_koperasi mKoperasi;
    private JButton btnKotak[] = new JButton[6];
    private JLabel notif[] = new JLabel[6];
    private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
    private int statusTime4[] = {0, 0, 0, 0, 0, 0};
    private int statusTime5[] = {0, 0, 0, 0, 0, 0};
    private int statusTime6[] = {0, 0, 0, 0, 0, 0};
    private boolean statusSiram[] = {false, false, false, false, false, false};
    private boolean statusPupuk[] = {false, false, false, false, false, false};
    private boolean statusPenyakit[] = {false, false, false, false, false, false};
    private boolean penyakit[] = {false, false, false, false, false, false};
    private boolean sakit;
    private int bibitjagung;
    private int pestisida;
    private int jagung;
    private int pupuk;
    private String username;
    private Random random = new Random();

    public c_sawah(map vMap, String username) throws SQLException {
        vlahan = new lahan();

        mAset = new m_aset();
        mKoperasi = new m_koperasi();
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
        pestisida = mAset.getPestisida(mAset.cekIdPlayer(username));
        pupuk = mAset.getPupuk(mAset.cekIdPlayer(username));
        jagung = mKoperasi.getJagung(mKoperasi.cekIdPlayer(username));

        vlahan.getBtnKembali().addActionListener(new kembaliAction());
        vlahan.getBtnKotak1().addActionListener(new kotak1Action());
        vlahan.getBtnKotak2().addActionListener(new kotak2Action());
        vlahan.getBtnKotak3().addActionListener(new kotak3Action());
        vlahan.getBtnKotak4().addActionListener(new kotak4Action());
        vlahan.getBtnKotak5().addActionListener(new kotak5Action());
        vlahan.getBtnKotak6().addActionListener(new kotak6Action());
        vlahan.alatsiram().addActionListener(new airAction());
        vlahan.pupuk().addActionListener(new pupukAction());
        vlahan.pestisida().addActionListener(new pestisidaAction());
        vlahan.sabit().addActionListener(new sabitAction());

        vlahan.alat_bahan().addMouseListener(new klikAlatBahan());


        vlahan.bar_alatBahan().setVisible(false);

        vlahan.sabit().setVisible(false);
        vlahan.pupuk().setVisible(false);
        vlahan.alatsiram().setVisible(false);
        vlahan.pestisida().setVisible(false);
    
        vlahan.getLblPadi().setVisible(false);
        vlahan.getLblTebu().setVisible(false);
        vlahan.getPadi().setVisible(false);
        vlahan.getTebu().setVisible(false);

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
                if (statusKotak[i] == 2 && statusSiram[i] == false) {
                    statusSiram[i] = true;
                    notif[i].setVisible(true);
                    notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/siram.gif")));
                    //set gif menyiram
                    //set label butuh air false
                    vlahan.bar_alatBahan().setVisible(false);
                    vlahan.pestisida().setVisible(false);
                    vlahan.alatsiram().setVisible(false);
                    vlahan.sabit().setVisible(false);
                    vlahan.pupuk().setVisible(false);

                }
            }
        }
    }

    private class sabitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 6) {

                    notif[i].setVisible(false);
                    ubahIcon(btnKotak[i], "/gambar/isisawah/www.png");

                    //set gif menyiram
                    //set label butuh air false
                    vlahan.bar_alatBahan().setVisible(false);
                    vlahan.pestisida().setVisible(false);
                    vlahan.alatsiram().setVisible(false);
                    vlahan.sabit().setVisible(false);
                    vlahan.pupuk().setVisible(false);
                    statusKotak[i] = 1;
                    statusSiram[i] = false;
                    statusPupuk[i] = false;
                    statusTime1[i] = 0;
                    statusTime2[i] = 0;
                    statusTime3[i] = 0;
                    statusTime4[i] = 0;
                    statusTime5[i] = 0;
                    statusTime6[i] = 0;

                }
            }
        }
    }

    private class pupukAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 3 && statusPupuk[i] == false) {
                    if (pupuk > 0) {
                        pupuk -= 1;
                        try {
                            mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                            vlahan.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        statusPupuk[i] = true;

                        vlahan.bar_alatBahan().setVisible(false);
                        vlahan.pestisida().setVisible(false);
                        vlahan.alatsiram().setVisible(false);
                        vlahan.sabit().setVisible(false);
                        vlahan.pupuk().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya pupuk");
                    }

                }
            }
        }
    }

    private class pestisidaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusPenyakit[i] == true) {
                    if (pestisida > 0) {
                        pestisida -= 1;
                        try {
                            mAset.updatePestisida(pestisida, mAset.cekIdPlayer(username));
                            vlahan.getLblPestisida().setText(mAset.getPestisida(mAset.cekIdPlayer(username)) + "");

                        } catch (SQLException ex) {
                            Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        statusPenyakit[i] = false;
                        notif[i].setVisible(false);

                        vlahan.bar_alatBahan().setVisible(false);
                        vlahan.pestisida().setVisible(false);
                        vlahan.alatsiram().setVisible(false);
                        vlahan.sabit().setVisible(false);
                        vlahan.pupuk().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vMap, "Tidak punya pestisida");
                    }

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

            waktu();
            if (statusKotak[0] == 1) {//kosong
                if (bibitjagung > 0) {
                    sakit = Math.random() < 0.5;
                    penyakit[0] = sakit;
                    System.out.println("penyakit1" + penyakit[0]);
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
                ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusPupuk[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
                statusTime4[0] = 0;
                statusTime5[0] = 0;
                statusTime6[0] = 0;
            } else if (statusKotak[0] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak1(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusPupuk[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
                statusTime4[0] = 0;
                statusTime5[0] = 0;
                statusTime6[0] = 0;
            }
//            

        }
    }

    private class kotak2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            waktu();
            if (statusKotak[1] == 1) {//kosong
                if (bibitjagung > 0) {
                    sakit = Math.random() < 0.5;
                    ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/jg1.png");
                    penyakit[1] = sakit;
                    System.out.println("penyakit2" + penyakit[1]);
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
                ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[1] = 1;
                statusSiram[1] = false;
                statusPupuk[1] = false;
                statusTime1[1] = 0;
                statusTime2[1] = 0;
                statusTime3[1] = 0;
                statusTime4[1] = 0;
                statusTime5[1] = 0;
                statusTime6[1] = 0;
            } else if (statusKotak[1] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak2(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[1] = 1;
                statusSiram[1] = false;
                statusPupuk[1] = false;
                statusTime1[1] = 0;
                statusTime2[1] = 0;
                statusTime3[1] = 0;
                statusTime4[1] = 0;
                statusTime5[1] = 0;
                statusTime6[1] = 0;
            }

        }
    }

    private class kotak3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            waktu();
            if (statusKotak[2] == 1) {//kosong
                if (bibitjagung > 0) {
                    sakit = Math.random() < 0.5;
                    penyakit[2] = sakit;
                    System.out.println("penyakit3" + penyakit[2]);
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
                ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[2] = 1;
                statusSiram[2] = false;
                statusPupuk[2] = false;
                statusTime1[2] = 0;
                statusTime2[2] = 0;
                statusTime3[2] = 0;
                statusTime4[2] = 0;
                statusTime5[2] = 0;
                statusTime6[2] = 0;
            } else if (statusKotak[2] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak3(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[2] = 1;
                statusSiram[2] = false;
                statusPupuk[2] = false;
                statusTime1[2] = 0;
                statusTime2[2] = 0;
                statusTime3[2] = 0;
                statusTime4[2] = 0;
                statusTime5[2] = 0;
                statusTime6[2] = 0;
            }

        }

    }

    private class kotak4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            waktu();
            if (statusKotak[3] == 1) {//kosong
                if (bibitjagung > 0) {
                    sakit = Math.random() < 0.5;
                    penyakit[3] = sakit;
                    System.out.println("penyakit4" + penyakit[3]);
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
                ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[3] = 1;
                statusSiram[3] = false;
                statusPupuk[3] = false;
                statusTime1[3] = 0;
                statusTime2[3] = 0;
                statusTime3[3] = 0;
                statusTime4[3] = 0;
                statusTime5[3] = 0;
                statusTime6[3] = 0;
            } else if (statusKotak[3] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak4(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[3] = 1;
                statusSiram[3] = false;
                statusPupuk[3] = false;
                statusTime1[3] = 0;
                statusTime2[3] = 0;
                statusTime3[3] = 0;
                statusTime4[3] = 0;
                statusTime5[3] = 0;
                statusTime6[3] = 0;
            }
        }

    }

    private class kotak5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            waktu();

            if (statusKotak[4] == 1) {//kosong
                if (bibitjagung > 0) {
                    ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/jg1.png");
                    sakit = Math.random() < 0.5;
                    penyakit[4] = sakit;
                    System.out.println("penyakit5" + penyakit[4]);
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
                ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[4] = 1;
                statusSiram[4] = false;
                statusPupuk[4] = false;
                statusTime1[4] = 0;
                statusTime2[4] = 0;
                statusTime3[4] = 0;
                statusTime4[4] = 0;
                statusTime5[4] = 0;
                statusTime6[4] = 0;
            } else if (statusKotak[4] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak5(), "/gambar/isisawah/www.png");

                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[4] = 1;
                statusSiram[4] = false;
                statusPupuk[4] = false;
                statusTime1[4] = 0;
                statusTime2[4] = 0;
                statusTime3[4] = 0;
                statusTime4[4] = 0;
                statusTime5[4] = 0;
                statusTime6[4] = 0;
            }
        }

    }

    private class kotak6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            waktu();
            if (statusKotak[5] == 1) {//kosong
                if (bibitjagung > 0) {
                    sakit = Math.random() < 0.5;
                    penyakit[5] = sakit;
                    System.out.println("penyakit6" + penyakit[5]);
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
                ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((3 - 2) + 1) + 2;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[5] = 1;
                statusSiram[5] = false;
                statusPupuk[5] = false;
                statusTime1[5] = 0;
                statusTime2[5] = 0;
                statusTime3[5] = 0;
                statusTime4[5] = 0;
                statusTime5[5] = 0;
                statusTime6[5] = 0;
            } else if (statusKotak[5] == 5) {//siap panen
                ubahIcon(vlahan.getBtnKotak6(), "/gambar/isisawah/www.png");
                jagung += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mKoperasi.updateJagung(jagung, mAset.cekIdPlayer(username));
                } catch (SQLException ex) {
                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[5] = 1;
                statusSiram[5] = false;
                statusPupuk[5] = false;
                statusTime1[5] = 0;
                statusTime2[5] = 0;
                statusTime3[5] = 0;
                statusTime4[5] = 0;
                statusTime5[5] = 0;
                statusTime6[5] = 0;
            }
//           
        }

    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlahan.setVisible(false);
            vMap.setVisible(true);
        }

    }

    private void waktu() {
        ActionListener gameTime = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                for (int i = 0; i < statusKotak.length; i++) {

                    if (statusKotak[i] == 2) {
                        statusTime1[i] += 1;
                        System.out.println("1= " + statusTime1[i]);
                        if (statusTime1[i] == 5) {
                            notif[i].setVisible(true);
                            notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notif air.png")));
                            vlahan.bar_alatBahan().setVisible(true);
                            vlahan.pestisida().setVisible(true);
                            vlahan.alatsiram().setVisible(true);
                            vlahan.sabit().setVisible(true);
                            vlahan.pupuk().setVisible(true);

                        }
                    }
                    if (statusSiram[i] == true) {
                        statusTime2[i] += 1;
                        System.out.println("2= " + statusTime2[i]);
                        if (statusTime2[i] == 2) {
                            notif[i].setVisible(false);
                        } else if (statusTime2[i] == 10) {
                            ubahIcon(btnKotak[i], "/gambar/isisawah/jg2.png");
                            statusPenyakit[i] = penyakit[i];
                            System.out.println(statusPenyakit[i]);
                            statusKotak[i] = 3;
                        }
                    }
                    if (statusPenyakit[i] == true) {
                        notif[i].setVisible(true);
                        notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notifpest.png")));
                        vlahan.bar_alatBahan().setVisible(true);
                        vlahan.pestisida().setVisible(true);
                        vlahan.alatsiram().setVisible(true);
                        vlahan.sabit().setVisible(true);
                        vlahan.pupuk().setVisible(true);

                    }

                    if (statusKotak[i] == 3 && statusPenyakit[i] == false) {
                        statusTime4[i] += 1;
                        System.out.println("4= " + statusTime4[i]);
                        if (statusTime4[i] == 10) {
                            notif[i].setVisible(true);
                            notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/pupuk.png")));
                            vlahan.bar_alatBahan().setVisible(true);
                            vlahan.pestisida().setVisible(true);
                            vlahan.alatsiram().setVisible(true);
                            vlahan.sabit().setVisible(true);
                            vlahan.pupuk().setVisible(true);

                        }
                    }
                    if (statusPupuk[i] == true) {
                        statusTime5[i] += 1;
                        System.out.println("5= " + statusTime5[i]);
                        if (statusTime5[i] == 2) {
                            notif[i].setVisible(false);
                        } else if (statusTime5[i] == 5) {

                            statusKotak[i] = 4;
                        }
                    }
                    if (statusKotak[i] == 4) {
                        statusTime3[i] += 1;
                        System.out.println("3= " + statusTime3[i]);
                        if (statusTime3[i] == 20) {
                            statusKotak[i] = 5;
                            ubahIcon(btnKotak[i], "/gambar/isisawah/jg3.png");
                        }
                    }
                    if (statusKotak[i] == 5) {
                        statusTime6[i] += 1;
                        if(statusTime6 [i] == 20){
                        statusKotak[i] = 6;
                        notif[i].setVisible(true);
                        notif[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/notifsabit.png")));
                        vlahan.bar_alatBahan().setVisible(true);
                        vlahan.pestisida().setVisible(true);
                        vlahan.alatsiram().setVisible(true);
                        vlahan.sabit().setVisible(true);
                        vlahan.pupuk().setVisible(true);
                        }
                    }
                }
            }
        };
        waktu = new Timer(1000, gameTime);
        waktu.start();
    }

    public lahan getView() {
        return vlahan;
    }

}
