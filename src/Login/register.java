/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Koneksi.config;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author wahyu
 */
public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    public register() {
        initComponents();
        kosong();
        this.hide.setVisible(false);
        this.pilih_gender.setEnabled(false);
        this.txt_gender.setEditable(false);
        this.txt_Alamat.setEditable(false);
        this.txt_no.setEditable(false);
        this.txt_gender.setEditable(false);
        this.kalender.setEnabled(false);
        this.txt_username.setBackground(new Color(0, 0, 0, 0));
        this.txt_password.setBackground(new Color(0, 0, 0, 0));
        this.txt_nama.setBackground(new Color(0, 0, 0, 0));
        this.txt_namapanggil.setBackground(new Color(0, 0, 0, 0));
        this.txt_no.setBackground(new Color(0, 0, 0, 0));
        this.txt_Alamat.setBackground(new Color(0, 0, 0, 0));

    }

    private void kosong() {
        txt_nama.setText(null);
        txt_username.setText(null);
        txt_password.setText(null);
        txt_gender.setText(null);
        kalender.setDate(null);
        txt_Alamat.setText(null);
        txt_no.setText(null);

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
        txt_namapanggil = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        txt_gender = new javax.swing.JTextField();
        pilih_gender = new javax.swing.JComboBox<>();
        txt_Alamat = new javax.swing.JTextField();
        txt_no = new javax.swing.JTextField();
        Batalkan = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        kalender = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        hide1 = new javax.swing.JLabel();
        show1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_namapanggil.setBackground(new java.awt.Color(59, 133, 191));
        txt_namapanggil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_namapanggil.setForeground(new java.awt.Color(255, 255, 255));
        txt_namapanggil.setBorder(null);
        txt_namapanggil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_namapanggilKeyTyped(evt);
            }
        });
        jPanel1.add(txt_namapanggil, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 305, 190, 34));

        txt_nama.setBackground(new java.awt.Color(59, 133, 191));
        txt_nama.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        txt_nama.setBorder(null);
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        txt_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_namaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 258, 190, 36));

        txt_password.setBackground(new java.awt.Color(59, 133, 191));
        txt_password.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 398, 100, 36));

        txt_username.setBackground(new java.awt.Color(59, 133, 191));
        txt_username.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 351, 190, 34));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 406, 50, 20));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Icon/hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        jPanel1.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 400, 50, 30));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Icon/show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        jPanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 400, -1, 30));

        txt_gender.setEditable(false);
        txt_gender.setBackground(new java.awt.Color(59, 133, 191));
        txt_gender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_gender.setForeground(new java.awt.Color(255, 255, 255));
        txt_gender.setBorder(null);
        jPanel1.add(txt_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 444, 180, 34));

        pilih_gender.setBackground(new java.awt.Color(57, 121, 218));
        pilih_gender.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pilih_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        pilih_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_genderActionPerformed(evt);
            }
        });
        jPanel1.add(pilih_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 446, 190, 30));

        txt_Alamat.setBackground(new java.awt.Color(59, 133, 191));
        txt_Alamat.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_Alamat.setForeground(new java.awt.Color(255, 255, 255));
        txt_Alamat.setBorder(null);
        jPanel1.add(txt_Alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 537, 190, 34));

        txt_no.setBackground(new java.awt.Color(59, 133, 191));
        txt_no.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_no.setForeground(new java.awt.Color(255, 255, 255));
        txt_no.setBorder(null);
        txt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noActionPerformed(evt);
            }
        });
        txt_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_noKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_noKeyTyped(evt);
            }
        });
        jPanel1.add(txt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 584, 190, 34));

        Batalkan.setOpaque(false);
        Batalkan.setContentAreaFilled(false);
        Batalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalkanActionPerformed(evt);
            }
        });
        jPanel1.add(Batalkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 120, 30));

        Simpan.setOpaque(false);
        Simpan.setContentAreaFilled(false);
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, 120, 30));

        kalender.setBackground(new java.awt.Color(111, 159, 233));
        kalender.setForeground(new java.awt.Color(255, 255, 255));
        kalender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalenderMouseClicked(evt);
            }
        });
        kalender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kalenderKeyTyped(evt);
            }
        });
        jPanel1.add(kalender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 492, 200, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Pendaftaran_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, -1));

        hide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Icon/hide.png"))); // NOI18N
        hide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hide1MousePressed(evt);
            }
        });
        jPanel1.add(hide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 50, 30));

        show1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Icon/show.png"))); // NOI18N
        show1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                show1MousePressed(evt);
            }
        });
        jPanel1.add(show1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Pendaftaran_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BatalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalkanActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Semua perubahan data tidak akan disimpan kalau kamu kembali ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login().setVisible(true);
            this.dispose();
        } else {
        }
    }//GEN-LAST:event_BatalkanActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        // TODO add your handling code here:
        if (txt_nama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Lengkap Harus Di isi");
        } else if(txt_namapanggil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Panggilan Harus Di isi");
        } else if (txt_username.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username Harus Di isi");
        } else if (txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Harus Di isi");
        } else if (txt_gender.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jenis Kelamin Harus Di isi");
        } else if (txt_Alamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Harus Di isi");
        } else if (txt_no.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomer Kontak Beli Harus Di isi");
            // } else if  (txt_id.getText().equals("")){
        } else {

            String tanggalahir = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tanggalahir);
            String tanggal = String.valueOf(fm.format(kalender.getDate()));
            String sql = "insert into users values (?,?,?,?,?,?,?,?)";
            try {
//             String enkrip = aes.encrypt("password");
                java.sql.Connection conn = (Connection) config.configDB();
                java.sql.PreparedStatement stat = conn.prepareStatement(sql);

                stat.setString(1, txt_nama.getText());
                stat.setString(2, txt_namapanggil.getText());
                stat.setString(3, txt_username.getText());
                stat.setString(4, txt_password.getText());
                stat.setString(5, txt_gender.getText());
                stat.setString(6, tanggal);
                stat.setString(7, txt_Alamat.getText());
                stat.setString(8, txt_no.getText());

                if (JOptionPane.showConfirmDialog(null, "Apakah data yang dimasukan telah sesuai?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Akun Berhasil Dibuat");
                    kosong();
                    this.setVisible(false);
                    new login().setVisible(true);

                } else {
                }
                //aes.encrypt(
                txt_nama.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Akun Gagal Dibuat" + e);
            }
        
    }//GEN-LAST:event_SimpanActionPerformed
}
    private void txt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noActionPerformed

    private void pilih_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_genderActionPerformed
        // TODO add your handling code here:
        switch (pilih_gender.getSelectedIndex()) {
            case 0:
                txt_gender.setText("Laki - Laki");
                break;
            case 1:
                txt_gender.setText("Perempuan");
                break;
    }//GEN-LAST:event_pilih_genderActionPerformed
    }
    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        // TODO add your handling code here:
        show.setVisible(true);
        hide.setVisible(false);
        txt_password.setEchoChar('*');
    }//GEN-LAST:event_hideMousePressed

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        show.setVisible(false);
        hide.setVisible(true);
        txt_password.setEchoChar((char) 0);
    }//GEN-LAST:event_showMousePressed

    private void kalenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kalenderKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_kalenderKeyTyped

    private void kalenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kalenderMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kalenderMouseClicked

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.cekPw()) {
            this.txt_Alamat.setEditable(true);
            this.txt_no.setEditable(true);
            this.pilih_gender.setEnabled(true);
            this.txt_gender.setEditable(true);
            this.kalender.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        // TODO add your handling code here:
        if ((txt_password.getText() + evt.getKeyChar()).length() > 12) {
        evt.consume();
        }
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        // TODO add your handling code here:
        if ((txt_username.getText() + evt.getKeyChar()).length() > 10) {
        evt.consume();
        }
    }//GEN-LAST:event_txt_usernameKeyTyped

    private void hide1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hide1MousePressed

    private void show1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_show1MousePressed

    private void txt_namapanggilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namapanggilKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namapanggilKeyTyped

    private void txt_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_namaKeyTyped

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noKeyPressed
        // TODO add your handling code here:
        if ((txt_password.getText() + evt.getKeyChar()).length() > 13) {
        evt.consume();
        }
    }//GEN-LAST:event_txt_noKeyPressed

    private void txt_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_noKeyTyped

    public boolean cekPw() {
        int upChars = 0, lowChars = 0;
        int digits = 0;
        char ch;
        String password = this.txt_password.getText();

        int total = password.length();

        for (int i = 0; i < total; i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upChars = 1;
            } else if (Character.isLowerCase(ch)) {
                lowChars = 1;
            } else if (Character.isDigit(ch)) {
                digits = 1;
            } else {
              
            }
        }

        if (upChars == 1 && lowChars == 1 && digits == 1) {
            JOptionPane.showMessageDialog(this, "Password dapat digunakan");
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Password Tidak dapat digunakan, tambahkan huruf kapital dan angka !");
            return false;
        }
    }
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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batalkan;
    private javax.swing.JButton Simpan;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel hide1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser kalender;
    private javax.swing.JComboBox<String> pilih_gender;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show1;
    private javax.swing.JTextField txt_Alamat;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_namapanggil;
    private javax.swing.JTextField txt_no;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
