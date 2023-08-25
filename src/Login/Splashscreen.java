/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.sun.javafx.applet.Splash;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import popup.POPUP_WELCOME;
import tampilkeun.Home;

/**
 *
 * @author wahyu
 */
public class Splashscreen extends javax.swing.JFrame {

    Timer timer;
    ActionListener action;
//    Splash sp;

    /**
     * Creates new form Splashscreen
     */
    public Splashscreen() {
        initComponents();
        setBackground(Color.red);
        setLocationRelativeTo(this);
        aksi();
        timer = new Timer(100, action);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressbar.setBackground(new java.awt.Color(59, 133, 191));
        progressbar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(progressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 390, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/Splash Screen.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splashscreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables

    private void aksi() {
        action = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                progressbar.setValue(progressbar.getValue() + 3);
                progressbar.setStringPainted(true);
                if (progressbar.getPercentComplete() == 1.0) {
                    timer.stop();
                    dispose();
                    new Home().setVisible(true);
                    new POPUP_WELCOME().setVisible(true);

                }
            }
        

    };
}
}
