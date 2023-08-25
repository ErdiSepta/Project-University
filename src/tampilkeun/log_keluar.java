/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilkeun;

import Koneksi.config;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public final class log_keluar extends javax.swing.JFrame {

    public void tanggal() {
        DateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
        String tglk = tgl.format(Calendar.getInstance().getTime());
        txt_tgl.setText(tglk);
    }

    public log_keluar() {
        initComponents();
        this.txt_tgl.setEditable(false);
        this.txt_idlog.setEditable(false);
        this.txt_idprd.setEditable(false);
        this.txt_namaprd.setEditable(false);
        this.txt_hrgjual.setEditable(false);
        this.txt_totalhrg.setEditable(false);
        
        load_table();
        hapus();
        setJam();
        tanggal();
        id_auto();
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        HeaderColumn();
        HeaderColumn2();
    }

    public void id_auto() {
        try {
            Connection conn = (Connection) config.configDB();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select max(right(Id_Logkeluar,4)) from log_produkkeluar";
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                if (res.first() == false) {
                    txt_idlog.setText("LOG0001");

                } else {
                    res.last();
                    int set_id = res.getInt(1) + 1;
                    String id = String.valueOf(set_id);
                    int id_next = id.length();
                    for (int a = 0; a < 4 - id_next; a++) {
                        id = "0" + id;
                    }
                    txt_idlog.setText("LOG" + id);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setJam() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(0, listener).start();
    }

    private void load_table() {
        // membuat tampilan model tabel
        this.tbl_listprd.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID Produk", "Nama Produk", "Jumlah", "Harga Beli"

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

        DefaultTableModel model = (DefaultTableModel) this.tbl_listprd.getModel();
        //menampilkan data database kedalam tabel
        String cari = txt_cari.getText();
        try {
            String sql = "select * from produk where Nama_Produk LIKE '%" + cari + "%'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(5), res.getString(6)});
            }
            for (int i = 0; i < this.tbl_listprd.getRowCount(); i++) {
                model.isCellEditable(i, 0);
                model.isCellEditable(i, 1);
                model.isCellEditable(i, 2);
                model.isCellEditable(i, 3);
            }
            tbl_listprd.setModel(model);
            HeaderColumn2();
            
        } catch (Exception e) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void HeaderColumn() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabel_penampungan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_penampungan.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabel_penampungan.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabel_penampungan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tabel_penampungan.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tabel_penampungan.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(0);
        column.setPreferredWidth(138);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(2);
        column.setPreferredWidth(120);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(3);
        column.setPreferredWidth(213);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(4);
        column.setPreferredWidth(93);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(5);
        column.setPreferredWidth(77);
        tabel_penampungan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_penampungan.getColumnModel().getColumn(6);
        column.setPreferredWidth(83);
    }

    public void HeaderColumn2() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_listprd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_listprd.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbl_listprd.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbl_listprd.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tbl_listprd.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tbl_listprd.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tbl_listprd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_listprd.getColumnModel().getColumn(0);
        column.setPreferredWidth(91);
        tbl_listprd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_listprd.getColumnModel().getColumn(1);
        column.setPreferredWidth(211);

    }

    private void load_table1() {
        // membuat tampilan model tabel

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tanggal");
        model.addColumn("ID Log Keluar");
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga Jual");
        model.addColumn("Total Harga");

        //menampilkan data database kedalam tabel
        try {
            String sql = "select * from detail_logprodukkeluar";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            tabel_penampungan.setModel(model);

        } catch (Exception e) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void hapus() {
        txt_totalhrg.setText(null);
    }

    private void kosong() {

        txt_tgl.setText(null);
        txt_idlog.setText(null);
        txt_idprd.setText(null);
        txt_namaprd.setText(null);
        txt_jml.setText(null);
        txt_hrgjual.setText(null);
        txt_totalhrg.setText(null);

    }

    private void kosong1() {

        txt_idprd.setText(null);
        txt_namaprd.setText(null);
        txt_jml.setText(null);
        txt_hrgjual.setText(null);
        txt_totalhrg.setText(null);
        txtTotal.setText(null);

    }

    private void addrowtotabeldetail(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) tabel_penampungan.getModel();
        model.addRow(dataRow);
    }

    private void setrowtotabeldetail(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) tabel_penampungan.getModel();
        model.setValueAt(dataRow[0], tabel_penampungan.getRowCount() - 1, 0);
        model.setValueAt(dataRow[1], tabel_penampungan.getRowCount() - 1, 1);
        model.setValueAt(dataRow[2], tabel_penampungan.getRowCount() - 1, 2);
        model.setValueAt(dataRow[3], tabel_penampungan.getRowCount() - 1, 3);
        model.setValueAt(dataRow[4], tabel_penampungan.getRowCount() - 1, 4);
        model.setValueAt(dataRow[5], tabel_penampungan.getRowCount() - 1, 5);
        model.setValueAt(dataRow[6], tabel_penampungan.getRowCount() - 1, 6);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_listprd = new javax.swing.JTable();
        Home = new javax.swing.JButton();
        Produk = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        back = new javax.swing.JButton();
        txt_tgl = new javax.swing.JTextField();
        txt_idlog = new javax.swing.JTextField();
        txt_idprd = new javax.swing.JTextField();
        txt_namaprd = new javax.swing.JTextField();
        txt_jml = new javax.swing.JTextField();
        txt_hrgjual = new javax.swing.JTextField();
        txt_totalhrg = new javax.swing.JTextField();
        txt_cari = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_hitung = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_penampungan = new javax.swing.JTable();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_listprd.setBackground(new java.awt.Color(42, 171, 212));
        tbl_listprd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbl_listprd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_listprd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_listprdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_listprd);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 350, 180));

        Home.setOpaque(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jPanel1.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 50));

        Produk.setOpaque(false);
        Produk.setContentAreaFilled(false);
        Produk.setBorderPainted(false);
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        jPanel1.add(Produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 180, 50));

        Laporan.setOpaque(false);
        Laporan.setContentAreaFilled(false);
        Laporan.setBorderPainted(false);
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        jPanel1.add(Laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 180, 50));

        Account.setOpaque(false);
        Account.setContentAreaFilled(false);
        Account.setBorderPainted(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });
        jPanel1.add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 180, 50));

        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 40));

        txt_tgl.setBackground(new java.awt.Color(42, 171, 212));
        txt_tgl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tgl.setForeground(new java.awt.Color(255, 255, 255));
        txt_tgl.setBorder(null);
        txt_tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tglActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 137, 200, 26));

        txt_idlog.setBackground(new java.awt.Color(42, 171, 212));
        txt_idlog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_idlog.setForeground(new java.awt.Color(255, 255, 255));
        txt_idlog.setBorder(null);
        jPanel1.add(txt_idlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 172, 200, 26));

        txt_idprd.setBackground(new java.awt.Color(42, 171, 212));
        txt_idprd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_idprd.setForeground(new java.awt.Color(255, 255, 255));
        txt_idprd.setBorder(null);
        txt_idprd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idprdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_idprd, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 210, 200, 24));

        txt_namaprd.setBackground(new java.awt.Color(42, 171, 212));
        txt_namaprd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_namaprd.setForeground(new java.awt.Color(255, 255, 255));
        txt_namaprd.setBorder(null);
        jPanel1.add(txt_namaprd, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 245, 200, 26));

        txt_jml.setBackground(new java.awt.Color(42, 171, 212));
        txt_jml.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_jml.setForeground(new java.awt.Color(255, 255, 255));
        txt_jml.setBorder(null);
        txt_jml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jmlKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jmlKeyTyped(evt);
            }
        });
        jPanel1.add(txt_jml, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 280, 40, 26));

        txt_hrgjual.setBackground(new java.awt.Color(42, 171, 212));
        txt_hrgjual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_hrgjual.setForeground(new java.awt.Color(255, 255, 255));
        txt_hrgjual.setBorder(null);
        jPanel1.add(txt_hrgjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 316, 100, 26));

        txt_totalhrg.setBackground(new java.awt.Color(42, 171, 212));
        txt_totalhrg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_totalhrg.setForeground(new java.awt.Color(255, 255, 255));
        txt_totalhrg.setBorder(null);
        txt_totalhrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalhrgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totalhrgKeyReleased(evt);
            }
        });
        jPanel1.add(txt_totalhrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 353, 100, 26));

        txt_cari.setBackground(new java.awt.Color(42, 171, 212));
        txt_cari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(255, 255, 255));
        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 172, 170, 13));

        btn_simpan.setOpaque(false);
        btn_simpan.setContentAreaFilled(false);
        btn_simpan.setBorderPainted(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 90, 30));

        btn_hapus.setOpaque(false);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.setBorderPainted(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 90, 40));

        btn_hitung.setOpaque(false);
        btn_hitung.setContentAreaFilled(false);
        btn_hitung.setBorderPainted(false);
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 70, 20));

        btn_clear.setOpaque(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setBorderPainted(false);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 245, 90, 30));

        btn_cetak.setOpaque(false);
        btn_cetak.setContentAreaFilled(false);
        btn_cetak.setBorderPainted(false);
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 90, 40));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 670, 210, 23));

        tabel_penampungan.setBackground(new java.awt.Color(42, 171, 212));
        tabel_penampungan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabel_penampungan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "ID Log", "ID Produk", "Nama Produk", "Jumlah", "Harga Jual", "Total Harga"
            }
        ));
        jScrollPane3.setViewportView(tabel_penampungan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 880, 200));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Log Keluar.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 705));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new produk_lanjutan().setVisible(true);
    }//GEN-LAST:event_ProdukActionPerformed

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
        new log_menu().setVisible(true);
    }//GEN-LAST:event_backActionPerformed
//    private String resultid = "";
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed

        if (this.txt_idprd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Produk tidak boleh kosong");
            return;
        } else if (this.txt_jml.getText().isEmpty() || this.txt_jml.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            return;
        } else if (this.txt_totalhrg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Total Harga tidak boleh kosong");
            return;
        }
        boolean error = false;
        String total, tharga, tharga1;
        int totalHarga = 0, stok2 = 0, tharga2 = 0, idProduk, totalProduk = 0, stok = 0, stok1 = 0;
        String idProdukBaru = txt_idprd.getText();
        if (txt_idprd.getText().equals("")) {
            error = true;
            JOptionPane.showMessageDialog(null, "Pilih produk terlebih dahulu");
        } else if (txt_jml.getText().equals("0")) {
            error = true;
            JOptionPane.showMessageDialog(null, "Jumlah produk harus diisi");
        } else {

        }
        if (!error) {
            if (tabel_penampungan.getRowCount() >= 1) {
                String idProdukLama = tabel_penampungan.getValueAt(tabel_penampungan.getRowCount() - 1, 2).toString();
                stok = Integer.parseInt(tabel_penampungan.getValueAt(tabel_penampungan.getRowCount() - 1, 4).toString());
                stok1 = Integer.parseInt(txt_jml.getText());
                stok2 = stok + stok1;
                idProduk = Integer.parseInt(idProdukLama.substring(3));
                if (idProdukLama.equals(idProdukBaru)) { //jika ada duplikasi 
                    tharga = tabel_penampungan.getValueAt(tabel_penampungan.getRowCount() - 1, 6).toString();
                    tharga1 = txt_totalhrg.getText();
                    tharga2 = Integer.parseInt(tharga) + Integer.parseInt(tharga1);
                    totalProduk = Integer.parseInt(tbl_listprd.getValueAt(idProduk - 1, 2).toString());
                    System.out.println(idProdukLama);
                    System.out.println("total produk " + totalProduk);
                    if (stok2 > totalProduk) {
                        JOptionPane.showMessageDialog(null, "Jumlah stok tidak cukup");
                    } else {
                        setrowtotabeldetail(new Object[]{
                            this.txt_tgl.getText(),
                            this.txt_idlog.getText(),
                            this.txt_idprd.getText(),
                            this.txt_namaprd.getText(),
                            stok2,
                            this.txt_hrgjual.getText(),
                            tharga2,});
                    }
                } else { //jika tidak ada duplikasi

                    addrowtotabeldetail(new Object[]{
                        this.txt_tgl.getText(),
                        this.txt_idlog.getText(),
                        this.txt_idprd.getText(),
                        this.txt_namaprd.getText(),
                        this.txt_jml.getText(),
                        this.txt_hrgjual.getText(),
                        this.txt_totalhrg.getText()
                    });
                }
                System.out.println(totalHarga);
                this.txtTotal.setText(Integer.toString(totalHarga));
            } else { //jika tabel kosong 

                String idProdukLama = txt_idprd.getText();
                stok1 = Integer.parseInt(txt_jml.getText());
                idProduk = Integer.parseInt(idProdukLama.substring(3));
                totalProduk = Integer.parseInt(tbl_listprd.getValueAt(idProduk - 1, 2).toString());
                if (stok1 > totalProduk) {
                    JOptionPane.showMessageDialog(null, "Jumlah stok tidak cukup");
                } else {
                    addrowtotabeldetail(new Object[]{
                        this.txt_tgl.getText(),
                        this.txt_idlog.getText(),
                        this.txt_idprd.getText(),
                        this.txt_namaprd.getText(),
                        this.txt_jml.getText(),
                        this.txt_hrgjual.getText(),
                        this.txt_totalhrg.getText()
                    });
                    this.txtTotal.setText(this.txt_totalhrg.getText()); //ubah total harga
                }
            }
            for (int i = 0; i < tabel_penampungan.getRowCount(); i++) { //Menampilkan data total harga saat pertama 
                total = tabel_penampungan.getValueAt(i, 6).toString();
                totalHarga += Integer.parseInt(total);
            }
            this.txtTotal.setText(Integer.toString(totalHarga));
            hapus();
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        //TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel_penampungan.getModel();
        model.removeRow(tabel_penampungan.getSelectedRow());
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_listprdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_listprdMouseClicked
        // TODO add your handling code here:

        int baris = tbl_listprd.rowAtPoint(evt.getPoint());

        String IdProduk = tbl_listprd.getValueAt(baris, 0).toString();
        txt_idprd.setText(IdProduk);
        String NamaProduk = tbl_listprd.getValueAt(baris, 1).toString();
        txt_namaprd.setText(NamaProduk);
        String HargaJual = tbl_listprd.getValueAt(baris, 3).toString();
        txt_hrgjual.setText(HargaJual);
    }//GEN-LAST:event_tbl_listprdMouseClicked

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        if (txt_jml.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah produk harus diisi");
        } else {
            int jumlah, harga, total;
            jumlah = Integer.valueOf(txt_jml.getText());
            harga = Integer.valueOf(txt_hrgjual.getText());
            total = jumlah * harga;
            txt_totalhrg.setText(String.valueOf(total));
    }//GEN-LAST:event_btn_hitungActionPerformed
    }
    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        load_table();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:  
        try {
            if (tabel_penampungan.getRowCount() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Data belum lengkap");
            } else {
                java.sql.Connection conn = (Connection) config.configDB();
                String sql = "insert into  log_produkkeluar values (?,?,?)";
                java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_tgl.getText());
                stat.setString(2, txt_idlog.getText());
                stat.setString(3, txtTotal.getText());
                stat.executeUpdate();
                String idProduk, namaProduk, jumlah, hargaJual, totalHarga;
                // Data ke 2
                for (int i = 0; i < tabel_penampungan.getRowCount(); i++) {
                    idProduk = tabel_penampungan.getValueAt(i, 2).toString();
                    namaProduk = tabel_penampungan.getValueAt(i, 3).toString();
                    jumlah = tabel_penampungan.getValueAt(i, 4).toString();
                    hargaJual = tabel_penampungan.getValueAt(i, 5).toString();
                    totalHarga = tabel_penampungan.getValueAt(i, 6).toString();
                    String sql1 = "insert into  detail_logprodukkeluar values (?,?,?,?,?,?)";
                    java.sql.PreparedStatement stat1 = conn.prepareStatement(sql1);
                    stat1.setString(1, txt_idlog.getText());
                    stat1.setString(2, idProduk);
                    stat1.setString(3, namaProduk);
                    stat1.setString(4, jumlah);
                    stat1.setString(5, hargaJual);
                    stat1.setString(6, totalHarga);
                    stat1.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
                load_table();
                DefaultTableModel model = (DefaultTableModel) tabel_penampungan.getModel();
                while (tabel_penampungan.getRowCount() > 0) {
                    model.removeRow(0);
                }
                kosong();
                id_auto();
                tanggal();
                HeaderColumn();
                HeaderColumn2();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan" + e);
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void txt_idprdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idprdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idprdActionPerformed

    private void txt_jmlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jmlKeyTyped

    }//GEN-LAST:event_txt_jmlKeyTyped

    private void txt_totalhrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalhrgKeyPressed

    }//GEN-LAST:event_txt_totalhrgKeyPressed

    private void txt_totalhrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalhrgKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalhrgKeyReleased

    private void txt_jmlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jmlKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_hitungActionPerformed(new ActionEvent(evt.getSource(), evt.getID(), "Key Press Hitung"));
        }

    }//GEN-LAST:event_txt_jmlKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        kosong1();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tglActionPerformed

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
            java.util.logging.Logger.getLogger(log_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new log_keluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Home;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jam;
    private javax.swing.JTable tabel_penampungan;
    private javax.swing.JTable tbl_listprd;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_hrgjual;
    private javax.swing.JTextField txt_idlog;
    private javax.swing.JTextField txt_idprd;
    private javax.swing.JTextField txt_jml;
    private javax.swing.JTextField txt_namaprd;
    private javax.swing.JTextField txt_tgl;
    private javax.swing.JTextField txt_totalhrg;
    // End of variables declaration//GEN-END:variables
}
