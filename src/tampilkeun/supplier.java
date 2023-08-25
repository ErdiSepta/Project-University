/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilkeun;

import Koneksi.config;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author wahyu
 */
public class supplier extends javax.swing.JFrame {

    private void setJam() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(500, listener).start();
    }

    /**
     * Creates new form supplier
     */
    public supplier() {
        initComponents();
        load_tabelkun();
        this.txt_idsupp.setEditable(false);
        kosong();
        id_auto();
        setJam();
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        HeaderColumn();
    }

    private void load_tabelkun() {
        this.tabelkeun.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID Supplier", "Nama Supplier", "Alamat", "No Kontak"

                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        DefaultTableModel model = (DefaultTableModel) this.tabelkeun.getModel();
        //menampilkan data database kedalam tabel
        String cari = txt_cari.getText();
        try {
            String sql = "select * from supplier where Nama_Supplier LIKE '%" + cari + "%'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            for (int i = 0; i < this.tabelkeun.getRowCount(); i++) {
                model.isCellEditable(i, 0);
                model.isCellEditable(i, 1);
                model.isCellEditable(i, 2);
                model.isCellEditable(i, 3);

            }
            tabelkeun.setModel(model);
            HeaderColumn();

        } catch (Exception e) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void HeaderColumn() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelkeun.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tabelkeun.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tabelkeun.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(0);
        column.setPreferredWidth(128);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(1);
        column.setPreferredWidth(203);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(2);
        column.setPreferredWidth(283);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(3);
        column.setPreferredWidth(211);
    }

    private void kosong() {

        txt_idsupp.setText(null);
        txt_namasupp.setText(null);
        txt_alamatsupp.setText(null);
        txt_notelpsupp.setText(null);
    }

    public void id_auto() {
        try {
            Connection conn = (Connection) config.configDB();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select max(right(Id_Supplier,4)) from supplier";
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                if (res.first() == false) {
                    txt_idsupp.setText("SUP0001");

                } else {
                    res.last();
                    int set_id = res.getInt(1) + 1;
                    String id = String.valueOf(set_id);
                    int id_next = id.length();
                    for (int a = 0; a < 4 - id_next; a++) {
                        id = "0" + id;
                    }
                    txt_idsupp.setText("SUP" + id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txt_idsupp = new javax.swing.JTextField();
        txt_namasupp = new javax.swing.JTextField();
        txt_alamatsupp = new javax.swing.JTextField();
        txt_notelpsupp = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkeun = new javax.swing.JTable();
        Transaksi = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        back = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        txt_idsupp.setBackground(new java.awt.Color(42, 171, 212));
        txt_idsupp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_idsupp.setForeground(new java.awt.Color(255, 255, 255));
        txt_idsupp.setBorder(null);
        txt_idsupp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_idsuppMousePressed(evt);
            }
        });
        txt_idsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsuppActionPerformed(evt);
            }
        });
        txt_idsupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idsuppKeyPressed(evt);
            }
        });
        getContentPane().add(txt_idsupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 190, 27));

        txt_namasupp.setBackground(new java.awt.Color(42, 171, 212));
        txt_namasupp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_namasupp.setForeground(new java.awt.Color(255, 255, 255));
        txt_namasupp.setBorder(null);
        txt_namasupp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_namasuppMousePressed(evt);
            }
        });
        txt_namasupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namasuppActionPerformed(evt);
            }
        });
        txt_namasupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_namasuppKeyPressed(evt);
            }
        });
        getContentPane().add(txt_namasupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 175, 190, 27));

        txt_alamatsupp.setBackground(new java.awt.Color(42, 171, 212));
        txt_alamatsupp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_alamatsupp.setForeground(new java.awt.Color(255, 255, 255));
        txt_alamatsupp.setBorder(null);
        txt_alamatsupp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_alamatsuppMousePressed(evt);
            }
        });
        txt_alamatsupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_alamatsuppKeyPressed(evt);
            }
        });
        getContentPane().add(txt_alamatsupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 190, 27));

        txt_notelpsupp.setBackground(new java.awt.Color(42, 171, 212));
        txt_notelpsupp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_notelpsupp.setForeground(new java.awt.Color(255, 255, 255));
        txt_notelpsupp.setBorder(null);
        txt_notelpsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_notelpsuppActionPerformed(evt);
            }
        });
        txt_notelpsupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_notelpsuppKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_notelpsuppKeyTyped(evt);
            }
        });
        getContentPane().add(txt_notelpsupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 245, 190, 27));

        btn_simpan.setOpaque(false);
        btn_simpan.setContentAreaFilled(false);
        btn_simpan.setBorderPainted(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 90, 30));

        btn_ubah.setOpaque(false);
        btn_ubah.setContentAreaFilled(false);
        btn_ubah.setBorderPainted(false);
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 90, 20));

        btn_hapus.setOpaque(false);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.setBorderPainted(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 90, 30));

        btn_clear.setOpaque(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setBorderPainted(false);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 90, 20));

        txt_cari.setBackground(new java.awt.Color(42, 171, 212));
        txt_cari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(255, 255, 255));
        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 294, 240, 26));

        tabelkeun.setBackground(new java.awt.Color(0, 204, 204));
        tabelkeun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelkeun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelkeun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkeunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkeun);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 830, 250));

        Transaksi.setOpaque(false);
        Transaksi.setContentAreaFilled(false);
        Transaksi.setBorderPainted(false);
        Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(Transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 180, 50));

        Home.setOpaque(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 50));

        Laporan.setOpaque(false);
        Laporan.setContentAreaFilled(false);
        Laporan.setBorderPainted(false);
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        getContentPane().add(Laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 180, 50));

        Account.setOpaque(false);
        Account.setContentAreaFilled(false);
        Account.setBorderPainted(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });
        getContentPane().add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 180, 50));

        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 40));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Supplier.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idsuppMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idsuppMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsuppMousePressed

    private void txt_idsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsuppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsuppActionPerformed

    private void txt_idsuppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idsuppKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsuppKeyPressed

    private void txt_namasuppMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_namasuppMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_namasuppMousePressed

    private void txt_namasuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasuppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namasuppActionPerformed

    private void txt_namasuppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasuppKeyPressed

    }//GEN-LAST:event_txt_namasuppKeyPressed

    private void txt_alamatsuppMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_alamatsuppMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatsuppMousePressed

    private void txt_alamatsuppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_alamatsuppKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_alamatsuppKeyPressed

    private void txt_notelpsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_notelpsuppActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_notelpsuppActionPerformed

    private void txt_notelpsuppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notelpsuppKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_notelpsuppKeyPressed

    private void txt_notelpsuppKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notelpsuppKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_notelpsuppKeyTyped

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (txt_idsupp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Id Supplier Harus Diisi");
        } else if (txt_namasupp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Supplier Harus Diisi");
        } else if (txt_alamatsupp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Harus Diisi");
        } else if (txt_notelpsupp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Kontak Harus Diisi");

        } else {

            String sql = "insert into supplier values (?,?,?,?)";
            try {
                java.sql.Connection conn = (Connection) config.configDB();
                java.sql.PreparedStatement stat = conn.prepareStatement(sql);

                stat.setString(1, txt_idsupp.getText());
                stat.setString(2, txt_namasupp.getText());
                stat.setString(3, txt_alamatsupp.getText());
                stat.setString(4, txt_notelpsupp.getText());

                if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menyimpan perubahan", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    stat.executeUpdate();
                    kosong();
                    id_auto();
                    load_tabelkun();
                    HeaderColumn();
                } else {
                }
                txt_idsupp.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data failed to save" + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        //    TODO add your handling code here:
        try {
            String sql = "UPDATE supplier SET Id_Supplier = '" + txt_idsupp.getText() + "',Nama_Supplier ='" + txt_namasupp.getText() + "', Alamat = '" + txt_alamatsupp.getText() + "',No_Kontak = '" + txt_notelpsupp.getText()
                    + "' WHERE Id_Supplier = '" + txt_idsupp.getText() + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menyimpan perubahan?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.execute();
                kosong();
                id_auto();
                load_tabelkun();
                HeaderColumn();
            } else {
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "failed to edit data" + e.getMessage());
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from supplier where Id_Supplier='" + txt_idsupp.getText() + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menghapus Data?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.execute();
                kosong();
                id_auto();
                load_tabelkun();
                HeaderColumn();
            } else {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "data failed to delete" + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        kosong();
        load_tabelkun();
        id_auto();
        HeaderColumn();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tabelkeunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkeunMouseClicked
        // TODO add your handling code here:

        // menampilkan data kedalam form pengisian:
        int baris = tabelkeun.rowAtPoint(evt.getPoint());

        String IdSupplier = tabelkeun.getValueAt(baris, 0).toString();
        txt_idsupp.setText(IdSupplier);
        String NamaSupplier = tabelkeun.getValueAt(baris, 1).toString();
        txt_namasupp.setText(NamaSupplier);
        String AlamatSupplier = tabelkeun.getValueAt(baris, 2).toString();
        txt_alamatsupp.setText(AlamatSupplier);
        String NoTelp = tabelkeun.getValueAt(baris, 3).toString();
        txt_notelpsupp.setText(NoTelp);

    }//GEN-LAST:event_tabelkeunMouseClicked

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        load_tabelkun();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new log_menu().setVisible(true);
    }//GEN-LAST:event_TransaksiActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan_Menu().setVisible(true);
    }//GEN-LAST:event_LaporanActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new tentang().setVisible(true);
    }//GEN-LAST:event_AccountActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new produk_lanjutan().setVisible(true);
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
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Home;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton Transaksi;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jam;
    private javax.swing.JTable tabelkeun;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txt_alamatsupp;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_idsupp;
    private javax.swing.JTextField txt_namasupp;
    private javax.swing.JTextField txt_notelpsupp;
    // End of variables declaration//GEN-END:variables
}
