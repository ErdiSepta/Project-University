/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilkeun;

import Koneksi.config;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author wahyu
 */
public class Laporan_Keluar extends javax.swing.JFrame {

    private DefaultTableModel tabmode;
    private DefaultTableModel caritbl;
//   

    private void setJam() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(0, listener).start();
    }

    public void dataTable() {
        Object[] Baris = {"No", "Tanggal", "ID LOG KELUAR", "TOTAL HARGA KESELURUHAN"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel_rentang.setModel(tabmode);
    }

    private void jumlahData1() {
        int jumlah = 0;
        for (int i = 0; i < this.tabel_rentang.getRowCount(); i++) {
            jumlah += Integer.parseInt(this.tabel_rentang.getValueAt(i, 3).toString());
        }
        // set label mu mbek jumlah
        this.txt_jumlahkeun.setText(Integer.toString(jumlah));
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void tanggal() {
        Date tgl = new Date();
        Tanggal_Awal.setDate(tgl);
        Tanggal_Akhir.setDate(tgl);

    }

    public void HeaderColumn() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_rentang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabel_rentang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_rentang.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabel_rentang.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabel_rentang.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        ((DefaultTableCellRenderer) tabel_rentang.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tabel_rentang.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tabel_rentang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_rentang.getColumnModel().getColumn(0);
        column.setPreferredWidth(31);
        tabel_rentang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_rentang.getColumnModel().getColumn(1);
        column.setPreferredWidth(337);
        tabel_rentang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_rentang.getColumnModel().getColumn(2);
        column.setPreferredWidth(167);
        tabel_rentang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_rentang.getColumnModel().getColumn(3);
        column.setPreferredWidth(229);
    }

    public void HeaderColumn1() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_logkeluar.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbl_logkeluar.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbl_logkeluar.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbl_logkeluar.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbl_logkeluar.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbl_logkeluar.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tbl_logkeluar.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tbl_logkeluar.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(0);
        column.setPreferredWidth(30);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(1);
        column.setPreferredWidth(84);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(2);
        column.setPreferredWidth(148);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(3);
        column.setPreferredWidth(68);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(4);
        column.setPreferredWidth(172);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(5);
        column.setPreferredWidth(53);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(6);
        column.setPreferredWidth(90);
        tbl_logkeluar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_logkeluar.getColumnModel().getColumn(7);
        column.setPreferredWidth(70);
    }

    public void tbl_logkeluar1() {

        this.tbl_logkeluar.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "No", "Tanggal", "ID Log Masuk", "ID Produk", "Nama Produk", "Jumlah", "Harga Jual", "Total"

                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_logkeluar.getModel();

        tbl_logkeluar.setModel(tbl);

        try {

            int no = 1;

            String sql = "SELECT log_produkkeluar.Tanggal,detail_logprodukkeluar.Id_Logkeluar,detail_logprodukkeluar.Id_Produk,detail_logprodukkeluar.Nama_Produk,detail_logprodukkeluar.jumlah,detail_logprodukkeluar.Harga_Jual,detail_logprodukkeluar.total FROM log_produkkeluar JOIN detail_logprodukkeluar ON detail_logprodukkeluar.Id_Logkeluar = log_produkkeluar.Id_Logkeluar ";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            for (int i = 0; i < this.tbl_logkeluar.getRowCount(); i++) {
                tbl.isCellEditable(i, 0);
                tbl.isCellEditable(i, 1);
                tbl.isCellEditable(i, 2);
                tbl.isCellEditable(i, 3);
                tbl.isCellEditable(i, 4);
                tbl.isCellEditable(i, 5);
                tbl.isCellEditable(i, 6);
                tbl.isCellEditable(i, 7);
            }
            tbl_logkeluar.setModel(tbl);
            this.caritbl = tbl;
        } catch (Exception e) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void cariData() {
        // reset tabel laporan
        this.resetTableLpHarian();
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_logkeluar.getModel();
        String key = txt_cari.getText().toLowerCase(), id, nama, namaSup, tanggal;

        // membaca semua is tabel laporan
        for (int i = 0; i < this.caritbl.getRowCount(); i++) {
            // mendapatkan data id, nama dan tanggal
            id = this.caritbl.getValueAt(i, 2).toString().toLowerCase();

            // pengecekan id, nama dan tanggal
            if (id.contains(key)) {
                // jika match maka data ditampilkan kedalam tabel
                tbl.addRow(
                        new Object[]{
                            i + 1,
                            this.caritbl.getValueAt(i, 1),
                            this.caritbl.getValueAt(i, 2),
                            this.caritbl.getValueAt(i, 3),
                            this.caritbl.getValueAt(i, 4),
                            this.caritbl.getValueAt(i, 5),
                            this.caritbl.getValueAt(i, 6),
                            this.caritbl.getValueAt(i, 7)
                           }
                );
            }
        }

        this.tbl_logkeluar.setModel(tbl);
    }

    private void onPaste() {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable t = c.getContents(this);
        if (t == null) {
            return;
        }
        try {
            txt_cari.setText((String) t.getTransferData(DataFlavor.stringFlavor));
        } catch (Exception e) {
            e.printStackTrace();
        }//try
    }//onPaste

    private void resetTableLpHarian() {

        this.tbl_logkeluar.setModel(new javax.swing.table.DefaultTableModel(
                new String[][]{},
                new String[]{
                    "No",
                    "Tanggal",
                    "ID Log Masuk",
                    "ID Produk",
                    "Nama Produk",
                    "Jumlah",
                    "Harga Jual",
                    "Total"
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

        TableColumnModel columnModel = this.tbl_logkeluar.getColumnModel();
        HeaderColumn1();
    }

    public Laporan_Keluar() {
        initComponents();
        tbl_logkeluar1();
        dataTable();
        tanggal();
        jumlahData1();
        setJam();
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        HeaderColumn();
        HeaderColumn1();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_rentang = new javax.swing.JPanel();
        btn_tampil = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_rentang = new javax.swing.JTable();
        Tanggal_Awal = new com.toedter.calendar.JDateChooser();
        Tanggal_Akhir = new com.toedter.calendar.JDateChooser();
        txt_jumlahkeun = new javax.swing.JLabel();
        txt_salin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        harian1 = new javax.swing.JLabel();
        panel_tbl_logmasuk = new javax.swing.JPanel();
        txt_cari = new javax.swing.JTextField();
        btn_paste = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_logkeluar = new javax.swing.JTable();
        label_logmasuk = new javax.swing.JLabel();
        Home = new javax.swing.JButton();
        Produk = new javax.swing.JButton();
        Transaksi = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jam = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        labelutama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(59, 133, 191));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(887, 538));

        panel_rentang.setBackground(new java.awt.Color(59, 133, 191));
        panel_rentang.setForeground(new java.awt.Color(255, 255, 255));
        panel_rentang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panel_rentang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_tampil.setOpaque(false);
        btn_tampil.setContentAreaFilled(false);
        btn_tampil.setBorderPainted(false);
        btn_tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tampilActionPerformed(evt);
            }
        });
        panel_rentang.add(btn_tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 12, 110, 30));

        tabel_rentang.setBackground(new java.awt.Color(0, 204, 204));
        tabel_rentang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabel_rentang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Tanggal", "ID Log Keluar", "TotalHargaSeluruh"
            }
        ));
        tabel_rentang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_rentangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_rentang);
        if (tabel_rentang.getColumnModel().getColumnCount() > 0) {
            tabel_rentang.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        panel_rentang.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 770, 340));

        Tanggal_Awal.setBackground(new java.awt.Color(21, 71, 99));
        Tanggal_Awal.setForeground(new java.awt.Color(255, 255, 255));
        Tanggal_Awal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        panel_rentang.add(Tanggal_Awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 13, 170, 27));

        Tanggal_Akhir.setBackground(new java.awt.Color(21, 71, 99));
        Tanggal_Akhir.setForeground(new java.awt.Color(255, 255, 255));
        Tanggal_Akhir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        panel_rentang.add(Tanggal_Akhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 13, 170, 27));

        txt_jumlahkeun.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_jumlahkeun.setForeground(new java.awt.Color(255, 255, 255));
        panel_rentang.add(txt_jumlahkeun, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 491, 320, 27));

        txt_salin.setBackground(new java.awt.Color(42, 171, 212));
        txt_salin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_salin.setForeground(new java.awt.Color(255, 255, 255));
        txt_salin.setBorder(null);
        panel_rentang.add(txt_salin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 82, 110, 25));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_rentang.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 30));

        btn_cetak.setContentAreaFilled(false);
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        panel_rentang.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 140, 30));

        harian1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Frame Rentang Tanggal_1.png"))); // NOI18N
        panel_rentang.add(harian1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        jTabbedPane1.addTab("Rentang Waktu", panel_rentang);

        panel_tbl_logmasuk.setBackground(new java.awt.Color(59, 133, 191));
        panel_tbl_logmasuk.setForeground(new java.awt.Color(255, 255, 255));
        panel_tbl_logmasuk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panel_tbl_logmasuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cari.setBackground(new java.awt.Color(42, 171, 212));
        txt_cari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(255, 255, 255));
        txt_cari.setBorder(null);
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        panel_tbl_logmasuk.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 12, 450, 38));

        btn_paste.setContentAreaFilled(false);
        btn_paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pasteActionPerformed(evt);
            }
        });
        panel_tbl_logmasuk.add(btn_paste, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 100, 40));

        tbl_logkeluar.setBackground(new java.awt.Color(0, 204, 204));
        tbl_logkeluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbl_logkeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_logkeluar);

        panel_tbl_logmasuk.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 720, 430));

        label_logmasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Frame Table Log.png"))); // NOI18N
        panel_tbl_logmasuk.add(label_logmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        jTabbedPane1.addTab("Tabel Log Masuk", panel_tbl_logmasuk);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 880, 560));

        Home.setOpaque(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 50));

        Produk.setOpaque(false);
        Produk.setContentAreaFilled(false);
        Produk.setBorderPainted(false);
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        getContentPane().add(Produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 180, 50));

        Transaksi.setOpaque(false);
        Transaksi.setContentAreaFilled(false);
        Transaksi.setBorderPainted(false);
        Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(Transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 180, 50));

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
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 50, 40));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        labelutama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Laporan Log Keluar.png"))); // NOI18N
        getContentPane().add(labelutama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new log_menu().setVisible(true);
    }//GEN-LAST:event_TransaksiActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new tentang().setVisible(true);
    }//GEN-LAST:event_AccountActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan_Menu().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StringSelection stringSelection = new StringSelection(txt_salin.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabel_rentangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_rentangMouseClicked
        // TODO add your handling code here:
        int baris = tabel_rentang.rowAtPoint(evt.getPoint());
        String IdLog = tabel_rentang.getValueAt(baris, 2).toString();
        txt_salin.setText(IdLog);
    }//GEN-LAST:event_tabel_rentangMouseClicked

    private void btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tampilActionPerformed
        // TODO add your handling code here:
        dataTable();
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggalAwal = String.valueOf(fm.format(Tanggal_Awal.getDate()));
        String tanggalAkhir = String.valueOf(fm.format(Tanggal_Akhir.getDate()));
        String sql = "select * from Log_produkkeluar where Tanggal between '" + tanggalAwal + "' and '" + tanggalAkhir + "'";
        try {
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet hasil = stm.executeQuery(sql);

            while (hasil.next()) {
                String tanggal = hasil.getString("Tanggal");
                String id_logkeluar = hasil.getString("Id_Logkeluar");
                String total = hasil.getString("Total_HargaSeluruh");
                String[] data = {"", tanggal, id_logkeluar, total};
                tabmode.addRow(data);
                noTable();
                jumlahData1();

            }
            HeaderColumn();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_tampilActionPerformed

    private void btn_pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pasteActionPerformed
        // TODO add your handling code here:
        this.onPaste();
        this.cariData();
    }//GEN-LAST:event_btn_pasteActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        this.cariData();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        this.cariData();
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariKeyReleased

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed
   
    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            // set header dan footer
            MessageFormat header = new MessageFormat("Laporan Log Keluar");
            MessageFormat footer = new MessageFormat("Halaman {0,number,integer}");
            // cek tabel kosong atau tidak
            if (this.tabel_rentang.getRowCount() > 0) {
                // print tabel
                this.tabel_rentang.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                JOptionPane.showMessageDialog(this, "Cek hasil data pada directory !");
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada data yang dicetak !");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Tabel gagal dicetak" + ex);
}
  
                                      
    }//GEN-LAST:event_btn_cetakActionPerformed
 
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
            java.util.logging.Logger.getLogger(Laporan_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Keluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Home;
    private javax.swing.JButton Produk;
    private com.toedter.calendar.JDateChooser Tanggal_Akhir;
    private com.toedter.calendar.JDateChooser Tanggal_Awal;
    private javax.swing.JButton Transaksi;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_paste;
    private javax.swing.JButton btn_tampil;
    private javax.swing.JLabel harian1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jam;
    private javax.swing.JLabel label_logmasuk;
    private javax.swing.JLabel labelutama;
    private javax.swing.JPanel panel_rentang;
    private javax.swing.JPanel panel_tbl_logmasuk;
    private javax.swing.JTable tabel_rentang;
    private javax.swing.JTable tbl_logkeluar;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JLabel txt_jumlahkeun;
    private javax.swing.JTextField txt_salin;
    // End of variables declaration//GEN-END:variables
}
