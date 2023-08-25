/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilkeun;

import Login.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author wahyu
 */
public class informasi_akun extends javax.swing.JFrame {

    /**
     * Creates new form informasi_akun
     */
    public informasi_akun() {
        initComponents();
        setJam();
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        
        this.nama_lengkap.setText(login.getNamaUser().toUpperCase());
        this.nama_lengkap.setHorizontalAlignment(JLabel.CENTER);
        this.nama_lengkap.setVerticalAlignment(JLabel.CENTER);
        
        this.panggilan.setText(login.getNamaUser1().toUpperCase());
        this.panggilan.setHorizontalAlignment(JLabel.CENTER);
        this.panggilan.setVerticalAlignment(JLabel.CENTER);
        
        this.kelamin.setText(login.getNamaUser2().toUpperCase());
        this.kelamin.setHorizontalAlignment(JLabel.CENTER);
        this.kelamin.setVerticalAlignment(JLabel.CENTER);
        
        this.tgl_lahir.setText(login.getNamaUser3().toUpperCase());
        this.tgl_lahir.setHorizontalAlignment(JLabel.CENTER);
        this.tgl_lahir.setVerticalAlignment(JLabel.CENTER);
        
        this.no_kontak.setText(login.getNamaUser5().toUpperCase());
        this.no_kontak.setHorizontalAlignment(JLabel.CENTER);
        this.no_kontak.setVerticalAlignment(JLabel.CENTER);
        
        this.alamat.setText(login.getNamaUser4().toUpperCase());
        this.alamat.setHorizontalAlignment(JLabel.CENTER);
        this.alamat.setVerticalAlignment(JLabel.CENTER);
    }

    private void setJam() {
        ActionListener listener = new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(0, listener).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Transaksi = new javax.swing.JButton();
        Produk = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        back = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        panggilan = new javax.swing.JLabel();
        kelamin = new javax.swing.JLabel();
        tgl_lahir = new javax.swing.JLabel();
        no_kontak = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        nama_lengkap = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 260, 50));

        Laporan.setOpaque(false);
        Laporan.setContentAreaFilled(false);
        Laporan.setBorderPainted(false);
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        jPanel1.add(Laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 180, 50));

        Transaksi.setOpaque(false);
        Transaksi.setContentAreaFilled(false);
        Transaksi.setBorderPainted(false);
        Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(Transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 180, 50));

        Produk.setOpaque(false);
        Produk.setContentAreaFilled(false);
        Produk.setBorderPainted(false);
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        jPanel1.add(Produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 180, 50));

        Home.setOpaque(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jPanel1.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 50));

        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 40));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        panggilan.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(panggilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 240, 30));

        kelamin.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 240, 30));

        tgl_lahir.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 372, 240, 30));

        no_kontak.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(no_kontak, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 492, 240, 30));

        alamat.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, 240, 30));

        nama_lengkap.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jPanel1.add(nama_lengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 372, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Informasi Akun.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 705));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new informasi_akun().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan_Menu().setVisible(true);
    }//GEN-LAST:event_LaporanActionPerformed

    private void TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new log_menu().setVisible(true);
    }//GEN-LAST:event_TransaksiActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new produk_lanjutan().setVisible(true);
    }//GEN-LAST:event_ProdukActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new tentang().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(informasi_akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informasi_akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informasi_akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informasi_akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informasi_akun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton Transaksi;
    private javax.swing.JLabel alamat;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jam;
    private javax.swing.JLabel kelamin;
    private javax.swing.JLabel nama_lengkap;
    private javax.swing.JLabel no_kontak;
    private javax.swing.JLabel panggilan;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tgl_lahir;
    // End of variables declaration//GEN-END:variables
}
