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
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author wahyu
 */
public class produk extends javax.swing.JFrame {

    private void setJam() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(0, listener).start();
    }

    //private String staff;
    /**
     * Creates new form produk
     */
    public produk() {
        initComponents();
        load_table();
        kosong();
        this.txt_kategori.setEditable(false);
        this.txt_date.setEditable(false);
        this.txt_id.setEditable(false);
        id_auto();
        tanggal();
        setJam();
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        HeaderColumn();
    }

    public void id_auto() {
        try {
            Connection conn = (Connection) config.configDB();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select max(right(Id_Produk,4)) from produk";
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                if (res.first() == false) {
                    txt_id.setText("BRG0001");

                } else {
                    res.last();
                    int set_id = res.getInt(1) + 1;
                    String id = String.valueOf(set_id);
                    int id_next = id.length();
                    for (int a = 0; a < 4 - id_next; a++) {
                        id = "0" + id;
                    }
                    txt_id.setText("STT" + id);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_date = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        txt_stok = new javax.swing.JTextField();
        txt_hrgJual = new javax.swing.JTextField();
        txt_hrgBeli = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkeun = new javax.swing.JTable();
        txt_cari = new javax.swing.JTextField();
        Produk = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Transaksi = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_date.setBackground(new java.awt.Color(42, 171, 212));
        txt_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_date.setForeground(new java.awt.Color(255, 255, 255));
        txt_date.setBorder(null);
        txt_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_dateMousePressed(evt);
            }
        });
        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });
        txt_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dateKeyPressed(evt);
            }
        });
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 140, 200, 27));

        txt_kategori.setBackground(new java.awt.Color(42, 171, 212));
        txt_kategori.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kategori.setForeground(new java.awt.Color(255, 255, 255));
        txt_kategori.setBorder(null);
        txt_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kategoriActionPerformed(evt);
            }
        });
        txt_kategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_kategoriKeyPressed(evt);
            }
        });
        jPanel2.add(txt_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 245, 190, 27));

        txt_id.setBackground(new java.awt.Color(42, 171, 212));
        txt_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setBorder(null);
        txt_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_idMousePressed(evt);
            }
        });
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 175, 200, 27));

        txt_nama.setBackground(new java.awt.Color(42, 171, 212));
        txt_nama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        txt_nama.setBorder(null);
        txt_nama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_namaMousePressed(evt);
            }
        });
        txt_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_namaKeyPressed(evt);
            }
        });
        jPanel2.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 210, 200, 27));

        jComboBox2.setBackground(new java.awt.Color(42, 171, 212));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alat Tulis", "Buku", "Kertas", "Cat Tulis", "Aksesoris" }));
        jComboBox2.setBorder(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 246, 140, 25));

        txt_stok.setBackground(new java.awt.Color(42, 171, 212));
        txt_stok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_stok.setForeground(new java.awt.Color(255, 255, 255));
        txt_stok.setBorder(null);
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        txt_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_stokKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stokKeyTyped(evt);
            }
        });
        jPanel2.add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 50, 27));

        txt_hrgJual.setBackground(new java.awt.Color(42, 171, 212));
        txt_hrgJual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_hrgJual.setForeground(new java.awt.Color(255, 255, 255));
        txt_hrgJual.setBorder(null);
        txt_hrgJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hrgJualActionPerformed(evt);
            }
        });
        txt_hrgJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hrgJualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hrgJualKeyTyped(evt);
            }
        });
        jPanel2.add(txt_hrgJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 315, 90, 27));

        txt_hrgBeli.setBackground(new java.awt.Color(42, 171, 212));
        txt_hrgBeli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_hrgBeli.setForeground(new java.awt.Color(255, 255, 255));
        txt_hrgBeli.setBorder(null);
        txt_hrgBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hrgBeliActionPerformed(evt);
            }
        });
        txt_hrgBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hrgBeliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hrgBeliKeyTyped(evt);
            }
        });
        jPanel2.add(txt_hrgBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 350, 90, 27));

        btn_simpan.setOpaque(false);
        btn_simpan.setContentAreaFilled(false);
        btn_simpan.setBorderPainted(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel2.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 90, 40));

        btn_ubah.setOpaque(false);
        btn_ubah.setContentAreaFilled(false);
        btn_ubah.setBorderPainted(false);
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 90, 40));

        btn_hapus.setOpaque(false);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.setBorderPainted(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 90, 30));

        btn_clear.setOpaque(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setBorderPainted(false);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 90, 40));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelkeunMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkeun);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 900, 250));

        txt_cari.setBackground(new java.awt.Color(42, 171, 212));
        txt_cari.setBorder(null);
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 393, 210, 29));

        Produk.setOpaque(false);
        Produk.setContentAreaFilled(false);
        Produk.setBorderPainted(false);
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        jPanel2.add(Produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 40));

        Laporan.setOpaque(false);
        Laporan.setContentAreaFilled(false);
        Laporan.setBorderPainted(false);
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        jPanel2.add(Laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 180, 50));

        Account.setOpaque(false);
        Account.setContentAreaFilled(false);
        Account.setBorderPainted(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });
        jPanel2.add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 180, 50));

        Transaksi.setOpaque(false);
        Transaksi.setContentAreaFilled(false);
        Transaksi.setBorderPainted(false);
        Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(Transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 180, 50));

        Home.setOpaque(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jPanel2.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 50));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Data Produk 22.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 705));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void load_table() {
        // membuat tampilan model tabel
        this.tabelkeun.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "Tanggal","ID Produk","Nama Produk","Kategori","Stok","Harga Jual","Harga Beli"

                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
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
            String sql = "select * from produk where Nama_Produk LIKE '%" + cari + "%'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5), res.getString(6), res.getString(7)});
            }
            for (int i = 0; i < this.tabelkeun.getRowCount(); i++) {
                model.isCellEditable(i, 0);
                model.isCellEditable(i, 1);
                model.isCellEditable(i, 2);
                model.isCellEditable(i, 3);
                model.isCellEditable(i, 4);
                model.isCellEditable(i, 5);
                model.isCellEditable(i, 6);
            }
            tabelkeun.setModel(model);
            HeaderColumn();

        } catch (Exception e) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (txt_date.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tanggal Harus Di isi");
        } else if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Id Produk Harus Di isi");
        } else if (txt_nama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk Harus Di isi");
        } else if (txt_kategori.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kategori Harus Di isi");
        } else if (txt_stok.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Stok Harus Di isi");
        } else if (txt_hrgJual.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Jual Harus Di isi");
        } else if (txt_hrgBeli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Beli Harus Di isi");
        } else {

            String sql = "insert into produk values (?,?,?,?,?,?,?)";
            try {
                java.sql.Connection conn = (Connection) config.configDB();
                java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_date.getText());
                stat.setString(2, txt_id.getText());
                stat.setString(3, txt_nama.getText());
                stat.setString(4, txt_kategori.getText());
                stat.setString(5, txt_stok.getText());
                stat.setString(6, txt_hrgJual.getText());
                stat.setString(7, txt_hrgBeli.getText());
                if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menyimpan perubahan ?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    stat.executeUpdate();
                    kosong();
                    id_auto();
                    tanggal();
                    load_table();
                } else {
                }
                txt_id.requestFocus();
                HeaderColumn();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal disimpan" + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void kosong() {

        txt_date.setText(null);
        txt_id.setText(null);
        txt_nama.setText(null);
        txt_kategori.setText(null);
        txt_stok.setText(null);
        txt_hrgJual.setText(null);
        txt_hrgBeli.setText(null);
    }

    public void HeaderColumn() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelkeun.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabelkeun.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabelkeun.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabelkeun.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tabelkeun.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tabelkeun.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tabelkeun.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tabelkeun.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(0);
        column.setPreferredWidth(123);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(1);
        column.setPreferredWidth(122);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(2);
        column.setPreferredWidth(235);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(3);
        column.setPreferredWidth(123);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(4);
        column.setPreferredWidth(42);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(5);
        column.setPreferredWidth(142);
        tabelkeun.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelkeun.getColumnModel().getColumn(6);
        column.setPreferredWidth(149);
    }

    public void tanggal() {
        DateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");

        String tglk = tgl.format(Calendar.getInstance().getTime());

        //LocalDateTime now = LocalDateTime.now();  
        txt_date.setText(tglk);
    }
    private void txt_hrgBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hrgBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hrgBeliActionPerformed

    private void txt_hrgJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hrgJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hrgJualActionPerformed

    private void tabelkeunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkeunMouseClicked
        // TODO add your handling code here:

        // menampilkan data kedalam form pengisian:
        int baris = tabelkeun.rowAtPoint(evt.getPoint());

        String Tanggal = tabelkeun.getValueAt(baris, 0).toString();
        txt_date.setText(Tanggal);
        String IdProduk = tabelkeun.getValueAt(baris, 1).toString();
        txt_id.setText(IdProduk);
        String NamaProduk = tabelkeun.getValueAt(baris, 2).toString();
        txt_nama.setText(NamaProduk);
        String kategori = tabelkeun.getValueAt(baris, 3).toString();
        txt_kategori.setText(kategori);
        String jumlah = tabelkeun.getValueAt(baris, 4).toString();
        txt_stok.setText(jumlah);
        String HargaJual = tabelkeun.getValueAt(baris, 5).toString();
        txt_hrgJual.setText(HargaJual);
        String HargaBeli = tabelkeun.getValueAt(baris, 6).toString();
        txt_hrgBeli.setText(HargaBeli);
        
    }//GEN-LAST:event_tabelkeunMouseClicked

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        //    TODO add your handling code here:
        try {
            String sql = "UPDATE produk SET Tanggal = '" + txt_date.getText() + "',Id_Produk ='" + txt_id.getText() + "', Nama_Produk = '" + txt_nama.getText() + "',Kategori = '" + txt_kategori.getText() + "',Harga_Jual= '" + txt_hrgJual.getText() + "',Harga_Beli= '" + txt_hrgBeli.getText()+"', jumlah = '" + txt_stok.getText()+ "' WHERE Id_Produk = '" + txt_id.getText() + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menyimpan perubahan?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.execute();
                kosong();
                id_auto();
                tanggal();
                load_table();
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
            String sql = "delete from produk where Id_Produk='" + txt_id.getText() + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau menghapus Data ?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.execute();
                kosong();
                id_auto();
                tanggal();
                load_table();
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
        load_table();
        id_auto();
        tanggal();
        HeaderColumn();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_idMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idMousePressed

    private void txt_namaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_namaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaMousePressed

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed

    }//GEN-LAST:event_txt_idKeyPressed

    private void txt_namaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            txt_stok.requestFocus();
        }
    }//GEN-LAST:event_txt_namaKeyPressed

    private void txt_stokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokKeyPressed
        // TODO add your handling code here:
        if ((txt_stok.getText() + evt.getKeyChar()).length() > 4) {
        evt.consume();
        }
        
    }//GEN-LAST:event_txt_stokKeyPressed

    private void txt_hrgJualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hrgJualKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            txt_hrgBeli.requestFocus();
    }//GEN-LAST:event_txt_hrgJualKeyPressed
    }
    private void txt_hrgBeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hrgBeliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hrgBeliKeyPressed

    private void txt_kategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kategoriKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_kategoriKeyPressed

    private void txt_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kategoriActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_dateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dateMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateMousePressed

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txt_dateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateKeyPressed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_stokKeyTyped

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        switch (jComboBox2.getSelectedIndex()) {
            case 0:
                txt_kategori.setText("Alat Tulis");
                break;
            case 1:
                txt_kategori.setText("Buku");
                break;

            case 2:
                txt_kategori.setText("Kertas");
                break;

            case 3:
                txt_kategori.setText("Cat Tulis");
                break;
            case 4:
                txt_kategori.setText("Aksesoris");
                break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new produk_lanjutan().setVisible(true);
    }//GEN-LAST:event_ProdukActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LaporanActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new tentang().setVisible(true);
    }//GEN-LAST:event_AccountActionPerformed

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

    private void txt_hrgJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hrgJualKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_hrgJualKeyTyped

    private void txt_hrgBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hrgBeliKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
    }//GEN-LAST:event_txt_hrgBeliKeyTyped
    }
    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        
        load_table();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void tabelkeunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkeunMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelkeunMouseEntered

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk_lanjutan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Home;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton Transaksi;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jam;
    private javax.swing.JTable tabelkeun;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_hrgBeli;
    private javax.swing.JTextField txt_hrgJual;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables
}
