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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import model.m_akun;
import tani.go.lahan;

/**
 *
 * @author Deddy
 */
public class c_lahan {

    String lhn[] = new String[5];
    private m_akun m_akun;
    private lahan lahan = new lahan();
    private String nama;
    private boolean bar = false;
    int idlahan;
    int idbibit;
    public static int waktu;
  
  

    public c_lahan(lahan lahan, m_akun m_akun, String nama) {
        this.nama = nama;
        this.m_akun = m_akun;
        this.lahan = lahan;

        lahan.setVisible(true);
        lahan.bar_alatBahan().setVisible(false);
        lahan.bar_bibit().setVisible(false);
        lahan.bibit_padi().setVisible(false);

        lahan.namaplayer().setText(nama);

        lahan.bibit_jagung().addMouseListener(new pilihbibit());
        lahan.bibit_padi().addMouseListener(new pilihbibit());
        lahan.alat_bahan().addMouseListener(new klikAlatBahan());
        lahan.bibit().addMouseListener(new klikBibit());

        lahan.getPetak1().addMouseListener(new pilihLahan());
        lahan.getPetak2().addMouseListener(new pilihLahan());
        lahan.getPetak3().addMouseListener(new pilihLahan());
        lahan.getPetak4().addMouseListener(new pilihLahan());
        lahan.getPetak5().addMouseListener(new pilihLahan());
        lahan.getPetak6().addMouseListener(new pilihLahan());

    }
    
//    ActionListener time = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            waktu++;
//        }
//    };
//    Timer t = new Timer(1000, time);
//    
//    public void mulai(){
//        t.start();
//    }


    private class pilihLahan implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
            System.out.println(waktu);

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

    
    private void menanam(int idlhn, int idbbt) {
        if (idlhn == 1 && idbbt == 1) {
            ubahIcon(lahan.getPetak1(), "/gambarlahan/ns1.png");
           
            if(waktu == 5){
                 ubahIcon(lahan.getPetak1(), "/gambarlahan/ns2.png");
            }
        } else if (idlhn == 2 && idbbt == 1) {
            ubahIcon(lahan.getPetak2(), "/gambarlahan/ns1.png");
        } else if (idlhn == 3 && idbbt == 1) {
            ubahIcon(lahan.getPetak3(), "/gambarlahan/ns1.png");
        } else if (idlhn == 4 && idbbt == 1) {
            ubahIcon(lahan.getPetak4(), "/gambarlahan/ns1.png");
        } else if (idlhn == 5 && idbbt == 1) {
            ubahIcon(lahan.getPetak5(), "/gambarlahan/ns1.png");
        } else if (idlhn == 6 && idbbt == 1) {
            ubahIcon(lahan.getPetak6(), "/gambarlahan/ns1.png");
        } else if (idlhn == 1 && idbbt == 2) {
            ubahIcon(lahan.getPetak1(), "/gambarlahan/jg1.png");
        } else if (idlhn == 2 && idbbt == 2) {
            ubahIcon(lahan.getPetak2(), "/gambarlahan/jg1.png");
        } else if (idlhn == 3 && idbbt == 2) {
            ubahIcon(lahan.getPetak3(), "/gambarlahan/jg1.png");
        } else if (idlhn == 4 && idbbt == 2) {
            ubahIcon(lahan.getPetak4(), "/gambarlahan/jg1.png");
        } else if (idlhn == 5 && idbbt == 2) {
            ubahIcon(lahan.getPetak5(), "/gambarlahan/jg1.png");
        } else if (idlhn == 6 && idbbt == 2) {
            ubahIcon(lahan.getPetak6(), "/gambarlahan/jg1.png");
        }
    }

    public void ubahLabel(JLabel label, String src) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        label.setIcon(ii);
    }

    public void ubahIcon(JButton tombol, String src) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        tombol.setIcon(ii);
    }

    private class pilihbibit implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idbibit = 0;
            if (lahan.bibit_padi() == me.getSource()) {
                idbibit = 1;
                System.out.println("bibitpadi");
            } else if (lahan.bibit_jagung() == me.getSource()) {
                idbibit = 2;
                System.out.println("bibitjagung");
            }
            menanam(idlahan, idbibit);

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
                lahan.bar_bibit().setVisible(true);
                lahan.bibit_padi().setVisible(true);
            } else if (e.getClickCount() == 2) {
                lahan.bar_bibit().setVisible(false);
                lahan.bibit_padi().setVisible(false);
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
                lahan.bar_alatBahan().setVisible(true);
            } else if (e.getClickCount() == 2) {
                lahan.bar_alatBahan().setVisible(false);
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
            ubahIcon(lahan.alat_bahan(), "/gambarlahan/alat2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ubahIcon(lahan.alat_bahan(), "/gambarlahan/alat.png");
        }
    }

}
