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
import tani.go.Toko;
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
    public static int waktu = 10;

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
        lahan.getToko().addMouseListener(new b_toko());

        lahan.getPetak1().addMouseListener(new pilihLahan1());
        lahan.getPetak2().addMouseListener(new pilihLahan1());
        lahan.getPetak3().addMouseListener(new pilihLahan1());
        lahan.getPetak4().addMouseListener(new pilihLahan1());
        lahan.getPetak5().addMouseListener(new pilihLahan1());
        lahan.getPetak6().addMouseListener(new pilihLahan1());

        lahan.getjg1_1().setVisible(false);
        lahan.getjg2_1().setVisible(false);
        lahan.getjg3_1().setVisible(false);
        lahan.getjg1_2().setVisible(false);
        lahan.getjg2_2().setVisible(false);
        lahan.getjg3_2().setVisible(false);
        lahan.getjg1_3().setVisible(false);
        lahan.getjg2_3().setVisible(false);
        lahan.getjg3_3().setVisible(false);
        lahan.getjg1_4().setVisible(false);
        lahan.getjg2_4().setVisible(false);
        lahan.getjg3_4().setVisible(false);
        lahan.getjg1_5().setVisible(false);
        lahan.getjg2_5().setVisible(false);
        lahan.getjg3_5().setVisible(false);
        lahan.getjg1_6().setVisible(false);
        lahan.getjg2_6().setVisible(false);
        lahan.getjg3_6().setVisible(false);
        lahan.getpd1_1().setVisible(false);
        lahan.getpd2_1().setVisible(false);
        lahan.getpd3_1().setVisible(false);
        lahan.getpd1_2().setVisible(false);
        lahan.getpd2_2().setVisible(false);
        lahan.getpd3_2().setVisible(false);
        lahan.getpd1_3().setVisible(false);
        lahan.getpd2_3().setVisible(false);
        lahan.getpd3_3().setVisible(false);
        lahan.getpd1_4().setVisible(false);
        lahan.getpd2_4().setVisible(false);
        lahan.getpd3_4().setVisible(false);
        lahan.getpd1_5().setVisible(false);
        lahan.getpd2_5().setVisible(false);
        lahan.getpd3_5().setVisible(false);
        lahan.getpd1_6().setVisible(false);
        lahan.getpd2_6().setVisible(false);
        lahan.getpd3_6().setVisible(false);
        lahan.sabit().setVisible(false);
        lahan.pupuk().setVisible(false);
        lahan.alatsiram().setVisible(false);
        lahan.pestisida().setVisible(false);
        lahan.bibit_jagung().setVisible(false);
        lahan.bibit_tebu().setVisible(false);

    }

    private void timer(int idlhn, int dbbt) {
        Timer time;
        ActionListener gameTimer = new ActionListener() {
            int sec = waktu;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(sec);
                sec--;

                if (sec == 5) {
                    if (lahan.getjg1_1().isVisible() && idlahan == 1 && idbibit == 2) {
                        lahan.getjg2_1().setVisible(true);
                        lahan.getjg1_1().setVisible(false);
                    }
                    if (lahan.getjg1_2().isVisible() && idlahan == 2 && idbibit == 2) {
                        lahan.getjg2_2().setVisible(true);
                        lahan.getjg1_2().setVisible(false);
                    }
                    if (lahan.getjg1_3().isVisible() && idlahan == 3 && idbibit == 2) {
                        lahan.getjg2_3().setVisible(true);
                        lahan.getjg1_3().setVisible(false);
                    }
                    if (lahan.getjg1_4().isVisible() && idlahan == 4 && idbibit == 2) {
                        lahan.getjg2_4().setVisible(true);
                        lahan.getjg1_4().setVisible(false);
                    }
                    if (lahan.getjg1_5().isVisible() && idlahan == 5 && idbibit == 2) {
                        lahan.getjg2_5().setVisible(true);
                        lahan.getjg1_5().setVisible(false);
                    }
                    if (lahan.getjg1_6().isVisible() && idlahan == 6 && idbibit == 2) {
                        lahan.getjg2_6().setVisible(true);
                        lahan.getjg1_6().setVisible(false);
                    }
                    if (lahan.getpd1_1().isVisible() && idlahan == 1 && idbibit == 1) {
                        lahan.getpd2_1().setVisible(true);
                        lahan.getpd1_1().setVisible(false);
                    }
                    if (lahan.getpd1_2().isVisible() && idlahan == 2 && idbibit == 1) {
                        lahan.getpd2_2().setVisible(true);
                        lahan.getpd1_2().setVisible(false);
                    }
                    if (lahan.getpd1_3().isVisible() && idlahan == 3 && idbibit == 1) {
                        lahan.getpd2_3().setVisible(true);
                        lahan.getpd1_3().setVisible(false);
                    }
                    if (lahan.getpd1_4().isVisible() && idlahan == 4 && idbibit == 1) {
                        lahan.getpd2_4().setVisible(true);
                        lahan.getpd1_4().setVisible(false);
                    }
                    if (lahan.getpd1_5().isVisible() && idlahan == 5 && idbibit == 1) {
                        lahan.getpd2_5().setVisible(true);
                        lahan.getpd1_5().setVisible(false);
                    }
                    if (lahan.getpd1_6().isVisible() && idlahan == 6 && idbibit == 1) {
                        lahan.getpd2_6().setVisible(true);
                        lahan.getpd1_6().setVisible(false);
                    }
                }
                if (sec == 0) {
                    if (lahan.getjg2_1().isVisible() && idlahan == 1 && idbibit == 2) {
                        lahan.getjg3_1().setVisible(true);
                        lahan.getjg2_1().setVisible(false);
                        lahan.getjg1_1().setVisible(false);
                    }
                    if (lahan.getjg2_2().isVisible() && idlahan == 2 && idbibit == 2) {
                        lahan.getjg3_2().setVisible(true);
                        lahan.getjg2_2().setVisible(false);
                        lahan.getjg1_2().setVisible(false);
                    }
                    if (lahan.getjg2_3().isVisible() && idlahan == 3 && idbibit == 2) {
                        lahan.getjg3_3().setVisible(true);
                        lahan.getjg2_3().setVisible(false);
                        lahan.getjg1_3().setVisible(false);
                    }
                    if (lahan.getjg2_4().isVisible() && idlahan == 4 && idbibit == 2) {
                        lahan.getjg3_4().setVisible(true);
                        lahan.getjg2_4().setVisible(false);
                        lahan.getjg1_4().setVisible(false);
                    }
                    if (lahan.getjg2_5().isVisible() && idlahan == 5 && idbibit == 2) {
                        lahan.getjg3_5().setVisible(true);
                        lahan.getjg2_5().setVisible(false);
                        lahan.getjg1_5().setVisible(false);
                    }
                    if (lahan.getjg2_6().isVisible() && idlahan == 6 && idbibit == 2) {
                        lahan.getjg3_6().setVisible(true);
                        lahan.getjg2_6().setVisible(false);
                        lahan.getjg1_6().setVisible(false);
                    }
                    if (lahan.getpd2_1().isVisible() && idlahan == 1 && idbibit == 1) {
                        lahan.getpd3_1().setVisible(true);
                        lahan.getpd2_1().setVisible(false);
                        lahan.getpd1_1().setVisible(false);
                    }
                    if (lahan.getpd2_2().isVisible() && idlahan == 2 && idbibit == 1) {
                        lahan.getpd3_2().setVisible(true);
                        lahan.getpd2_2().setVisible(false);
                        lahan.getpd1_2().setVisible(false);
                    }
                    if (lahan.getpd2_3().isVisible() && idlahan == 3 && idbibit == 1) {
                        lahan.getpd3_3().setVisible(true);
                        lahan.getpd2_3().setVisible(false);
                        lahan.getpd1_3().setVisible(false);
                    }
                    if (lahan.getpd2_4().isVisible() && idlahan == 4 && idbibit == 1) {
                        lahan.getpd3_4().setVisible(true);
                        lahan.getpd2_4().setVisible(false);
                        lahan.getpd1_4().setVisible(false);
                    }
                    if (lahan.getpd2_5().isVisible() && idlahan == 5 && idbibit == 1) {
                        lahan.getpd3_5().setVisible(true);
                        lahan.getpd2_5().setVisible(false);
                        lahan.getpd1_5().setVisible(false);
                    }
                    if (lahan.getpd2_6().isVisible() && idlahan == 6 && idbibit == 1) {
                        lahan.getpd3_6().setVisible(true);
                        lahan.getpd2_6().setVisible(false);
                        lahan.getpd1_6().setVisible(false);
                    }
                }

            }

        };
        time = new Timer(1000, gameTimer);
        time.start();
    }

    private class b_toko implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            new c_toko(new Toko());
            lahan.dispose();
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

    
    
    
    private class pilihLahan1 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
    
    private class pilihLahan2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
    
    private class pilihLahan3 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
    
    private class pilihLahan4 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
    
    private class pilihLahan5 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
    
    private class pilihLahan6 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            idlahan = 0;
            if (lahan.getPetak1() == me.getSource()) {
                idlahan = 1;
//                timer(idlahan, idbibit);
                lahan.getPetak1().setVisible(false);
                System.out.println(idlahan);
            } else if (lahan.getPetak2() == me.getSource()) {
                idlahan = 2;
//                timer(idlahan, idbibit);
                lahan.getPetak2().setVisible(false);
                System.out.println("lahan2");
            } else if (lahan.getPetak3() == me.getSource()) {
                idlahan = 3;
//                timer(idlahan, idbibit);
                lahan.getPetak3().setVisible(false);
                System.out.println("lahan3");
            } else if (lahan.getPetak4() == me.getSource()) {
                idlahan = 4;
//                timer(idlahan, idbibit);
                lahan.getPetak4().setVisible(false);
                System.out.println("lahan4");
            } else if (lahan.getPetak5() == me.getSource()) {
                idlahan = 5;
//                timer(idlahan, idbibit);
                lahan.getPetak5().setVisible(false);
                System.out.println("lahan5");
            } else if (lahan.getPetak6() == me.getSource()) {
                idlahan = 6;
//                timer(idlahan, idbibit);
                lahan.getPetak6().setVisible(false);
                System.out.println("lahan6");
            }
            menanam(idlahan, idbibit);
//            mulai();
//            System.out.println(waktu);

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
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 2 && idbbt == 1) {
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 3 && idbbt == 1) {
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 4 && idbbt == 1) {
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 5 && idbbt == 1) {
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 6 && idbbt == 1) {
            lahan.getpd1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 1 && idbbt == 2) {
            lahan.getjg1_1().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 2 && idbbt == 2) {
            lahan.getjg1_2().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 3 && idbbt == 2) {
            lahan.getjg1_3().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 4 && idbbt == 2) {
            lahan.getjg1_4().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 5 && idbbt == 2) {
            lahan.getjg1_5().setVisible(true);
            timer(idlhn, idbbt);
        } else if (idlhn == 6 && idbbt == 2) {
            lahan.getjg1_6().setVisible(true);
            timer(idlhn, idbbt);
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
//                timer(idlahan, idbibit);
                System.out.println("bibitpadi");
            } else if (lahan.bibit_jagung() == me.getSource()) {
                idbibit = 2;
//                timer(idlahan, idbibit);
                System.out.println("bibitjagung");
            } else if (lahan.bibit_tebu() == me.getSource()) {
                idbibit = 3;
                System.out.println("bibittebu");
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
                lahan.bibit_jagung().setVisible(true);
                lahan.bibit_tebu().setVisible(true);
            } else if (e.getClickCount() == 2) {
                lahan.bar_bibit().setVisible(false);
                lahan.bibit_padi().setVisible(false);
                lahan.bibit_jagung().setVisible(false);
                lahan.bibit_tebu().setVisible(false);
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
                lahan.sabit().setVisible(true);
                lahan.pupuk().setVisible(true);
                lahan.alatsiram().setVisible(true);
                lahan.pestisida().setVisible(true);
            } else if (e.getClickCount() == 2) {
                lahan.bar_alatBahan().setVisible(false);
                lahan.sabit().setVisible(false);
                lahan.pupuk().setVisible(false);
                lahan.alatsiram().setVisible(false);
                lahan.pestisida().setVisible(false);
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
