/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        this.setLocationRelativeTo(this);
        
    }

    public JButton getBtnAbout() {
        return btnAbout;
    }

    public JButton getBtnBantuan() {
        return btnBantuan;
    }

    public JButton getBtnKeluar() {
        return btnKeluar;
    }

    public JButton getBtnMulai() {
        return btnMulai;
    }

   

  

 

    public void tampilPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKeluar = new javax.swing.JButton();
        btnMulai = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnBantuan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/keluar.png"))); // NOI18N
        btnKeluar.setBorderPainted(false);
        btnKeluar.setContentAreaFilled(false);
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.setFocusable(false);
        btnKeluar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/keluar1.png"))); // NOI18N
        getContentPane().add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 320, 90));

        btnMulai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/mulai.png"))); // NOI18N
        btnMulai.setBorderPainted(false);
        btnMulai.setContentAreaFilled(false);
        btnMulai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMulai.setFocusable(false);
        btnMulai.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/mulai1.png"))); // NOI18N
        getContentPane().add(btnMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 320, 90));

        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/tentang.png"))); // NOI18N
        btnAbout.setBorderPainted(false);
        btnAbout.setContentAreaFilled(false);
        btnAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbout.setFocusable(false);
        btnAbout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/tentang1.png"))); // NOI18N
        getContentPane().add(btnAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 320, 90));

        btnBantuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/bantuan.png"))); // NOI18N
        btnBantuan.setBorderPainted(false);
        btnBantuan.setContentAreaFilled(false);
        btnBantuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBantuan.setFocusable(false);
        btnBantuan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/bantuan1.png"))); // NOI18N
        getContentPane().add(btnBantuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 320, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mainmenu/menu.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnBantuan;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnMulai;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
