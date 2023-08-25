/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilkeun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Login.login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import popup.backtologin;
import popup.popup_keluar;

/**
 *
 * @author wahyu
 */
public class Home extends javax.swing.JFrame {

    private login login = new login();

    private void setJam() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(500, listener).start();
    }
    public void tanggal() {
        Date tgl = new Date();
        tgl1.setDate(tgl);
        tgl2.setDate(tgl);
        tgl3.setDate(tgl);
        tgl4.setDate(tgl);

    }
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        dataTable();
        dataTable1();
        jumlahData();
        jumlahData1();
        HeaderColumn();
        HeaderColumn1();
        setJam();
        this.namaku.setText(login.getNamaUserr().toUpperCase());
        this.namaku.setHorizontalAlignment(JLabel.CENTER);
        this.namaku.setVerticalAlignment(JLabel.CENTER);
        this.tgl.setHorizontalAlignment(JLabel.CENTER);
        this.tgl.setVerticalAlignment(JLabel.CENTER);
        tanggal();
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggalAwal = String.valueOf(fm.format(tgl1.getDate()));  
        System.out.println(tanggalAwal);
        this.showPieChartPenjualan(piePenjualan, "Penjualan", tanggalAwal, tanggalAwal);
        this.showPieChartPembelian(piePembelian, "Pembelian", tanggalAwal, tanggalAwal);

    }
    private void showPieChartPenjualan(JPanel panel, String title, String tgl1, String tgl2){
        // mendapatkan data dari database
        double alattulis1 = this.getPieDataPenjualan("Alat Tulis", tgl1, tgl2)
              ,buku1 = this.getPieDataPenjualan("Buku", tgl1, tgl2)
              ,kertas1 = this.getPieDataPenjualan("Kertas", tgl1, tgl2)
              ,cattulis1 = this.getPieDataPenjualan("Cat Tulis", tgl1, tgl2)
              ,aksesoris1 = this.getPieDataPenjualan("Aksesoris", tgl1, tgl2);
        
        System.out.println(alattulis1);
        System.out.println(buku1);
        System.out.println(kertas1);
        System.out.println(cattulis1);
        System.out.println(aksesoris1);
        
        // membuat data set untuk menampung data        
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        // jika datanya kosong maka data tidak akan ditampilkan didalam chart
        if(alattulis1 > 0){
            barDataset.setValue( "Alat Tulis", new Double(alattulis1));
        }
        if(buku1 > 0){
            barDataset.setValue( "Buku", new Double(buku1));
        }
        if(kertas1 > 0){
            barDataset.setValue("Kertas", new Double(kertas1));
        }
        if(cattulis1 > 0){
            barDataset.setValue("Cat Tulis", new Double(cattulis1));
        }
        if(aksesoris1 > 0){
            barDataset.setValue("Aksesoris", new Double(aksesoris1));
        }
        
        System.out.println("JUMLAH ITEM -> : " + barDataset.getItemCount());
        // membuat chart
        JFreeChart piechart = ChartFactory.createPieChart(title,barDataset, false,true,false);//explain
        piechart.setTitle(new TextTitle(title, new java.awt.Font("Dialog", 1, 12)));

        // merubah warna dari setiap data pada chart
        PiePlot piePlot =(PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(new Color(255,255,255));
        
        // menampilkan chart ke panel
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panel.removeAll();
        panel.add(barChartPanel, BorderLayout.CENTER);
        panel.validate();
    }
    
    private void showPieChartPembelian(JPanel panel, String title, String tgl1, String tgl2){
        // mendapatkan data dari database
        double alattulis = this.getPieDataPembelian("Alat Tulis", tgl1, tgl2)
              ,buku = this.getPieDataPembelian("Buku", tgl1, tgl2)
              ,kertas = this.getPieDataPembelian("Kertas", tgl1, tgl2)
              ,cattulis = this.getPieDataPembelian("Cat Tulis", tgl1, tgl2)
              ,aksesoris = this.getPieDataPembelian("Aksesoris", tgl1, tgl2);
        
        // membuat data set untuk menampung data      
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        // jika datanya kosong maka data tidak akan ditampilkan didalam chart
        if(alattulis > 0){
            barDataset.setValue( "Alat Tulis", new Double(alattulis));
        }
        if(buku > 0){
            barDataset.setValue( "Buku", new Double(buku));
        }
        if(kertas > 0){
            barDataset.setValue("Kertas", new Double(kertas));
        }
        if(cattulis > 0){
            barDataset.setValue("Cat Tulis", new Double(cattulis));
        }
        if(aksesoris > 0){
            barDataset.setValue("Aksesoris", new Double(aksesoris));
        }
        // membuat chart
        JFreeChart piechart = ChartFactory.createPieChart(title,barDataset, false,true,false);//explain
            piechart.setTitle(new TextTitle(title, new java.awt.Font("Dialog", 1, 12)));

        // merubah warna dari setiap data pada chart
        PiePlot piePlot =(PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(new Color(255,255,255));
        
        // menampilkan chart ke panel
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panel.removeAll();
        panel.add(barChartPanel, BorderLayout.CENTER);
        panel.validate();
    }
    
    private int getPieDataPembelian(String jenis, String hari1, String hari2){
        // membuat query
        String sql = "SELECT p.kategori, SUM(d.jumlah) AS total " +
                    "FROM detail_logprodukmasuk AS d " +
                    "JOIN produk AS p " +
                    "ON p.Id_Produk = d.Id_Produk " +
                    "JOIN log_produkmasuk AS l " +
                    "ON l.Id_Logmasuk = d.Id_Logmasuk " +
                    "WHERE p.kategori = '"+jenis+"' AND DATE(l.Tanggal) BETWEEN '"+hari1+"' AND '"+hari2+"'";
        System.out.println(sql);
        
        try{
            Connection c = (Connection) Koneksi.config.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            // mengembalikan data total pesanan berdasarkan jenis menu
            if(r.next()){
                int total = r.getInt("total");
                System.out.println("TOTAL " + jenis.toUpperCase() + " : " + total);
                c.close(); s.close(); r.close();
                return total;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
//            Message.showException(null, ex);
        }
        return 0;
    }
    
    private int getPieDataPenjualan(String jenis, String tgl1, String tgl2){
        // membuat query
        String sql = "SELECT p.kategori, SUM(d.jumlah) AS total " +
                    "FROM detail_logprodukkeluar AS d " +
                    "JOIN produk AS p " +
                    "ON p.Id_Produk = d.Id_Produk " +
                    "JOIN log_produkkeluar AS l " +
                    "ON l.Id_Logkeluar = d.Id_Logkeluar " +
                    "WHERE p.kategori = '"+jenis+"' AND DATE(l.Tanggal) BETWEEN '"+tgl1+"' AND '"+tgl2+"'";
        System.out.println(sql);
        
        try{
            Connection c = (Connection) Koneksi.config.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            // mengembalikan data total pesanan berdasarkan jenis bahan
            if(r.next()){
                int total = r.getInt("total");
                System.out.println("TOTAL " + jenis.toUpperCase() + " : " + total);
                c.close(); s.close(); r.close();
                return total;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       return 0;
    }

    public void HeaderColumn() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_harian.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_harian.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_harian.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        ((DefaultTableCellRenderer) tbl_harian.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tbl_harian1.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(0);
        column.setPreferredWidth(74);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(1);
        column.setPreferredWidth(97);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(2);
        column.setPreferredWidth(155);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(3);
        column.setPreferredWidth(161);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(4);
        column.setPreferredWidth(55);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian.getColumnModel().getColumn(5);
        column.setPreferredWidth(55);
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    }
    public void HeaderColumn1() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_harian1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_harian1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        ((DefaultTableCellRenderer) tbl_harian1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader thead = tbl_harian.getTableHeader();
        thead.setForeground(Color.BLACK);
        thead.setFont(new Font("Tahome", Font.BOLD, 12));

        TableColumn column;
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian1.getColumnModel().getColumn(0);
        column.setPreferredWidth(74);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian1.getColumnModel().getColumn(1);
        column.setPreferredWidth(97);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian1.getColumnModel().getColumn(2);
        column.setPreferredWidth(147);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian1.getColumnModel().getColumn(3);
        column.setPreferredWidth(55);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tbl_harian1.getColumnModel().getColumn(4);
        column.setPreferredWidth(55);
        tbl_harian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    }

    public void dataTable() {
        this.tbl_harian.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "Tanggal", "ID LOG MASUK", "Nama Supplier", "Nama Produk", "Jumlah", "Total"

                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_harian.getModel();
        tbl_harian.setModel(tbl);
        
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        String tgl = date.toString();
        txt_tgl.setText(tgl);
        
                   
        try {
            Connection conn = (Connection) Koneksi.config.configDB();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT log_produkmasuk.Tanggal,detail_logprodukmasuk.Id_Logmasuk,detail_logprodukmasuk.Nama_Supplier,detail_logprodukmasuk.Nama_Produk,detail_logprodukmasuk.jumlah ,detail_logprodukmasuk.total FROM log_produkmasuk JOIN detail_logprodukmasuk ON log_produkmasuk.Id_Logmasuk = detail_logprodukmasuk.Id_Logmasuk WHERE month (log_produkmasuk.Tanggal) ='"+tgl.substring(5,7)+"' ORDER BY Id_Logmasuk DESC");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Tanggal"),
                    res.getString("Id_Logmasuk"),
                    res.getString("Nama_Supplier"),
                    res.getString("Nama_Produk"),
                    res.getString("jumlah"),
                    res.getString("total")
                });
                for (int i = 0; i < this.tbl_harian.getRowCount(); i++) {
                tbl.isCellEditable(i, 0);
                tbl.isCellEditable(i, 1);
                tbl.isCellEditable(i, 2);
                tbl.isCellEditable(i, 3);
                tbl.isCellEditable(i, 4);
                tbl.isCellEditable(i, 5);
            }
                tbl_harian.setModel(tbl);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void dataTable1() {
        this.tbl_harian1.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "Tanggal", "ID LOG KELUAR","Nama Produk", "Jumlah", "Total"

                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_harian1.getModel();
        tbl_harian1.setModel(tbl);
        
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
        String tgl = date.toString();
        txt_tgl.setText(tgl);
        
                   
        try {
            String sql = "SELECT log_produkkeluar.Tanggal,detail_logprodukkeluar.Id_Logkeluar,detail_logprodukkeluar.Nama_Produk,detail_logprodukkeluar.jumlah ,detail_logprodukkeluar.total FROM log_produkkeluar JOIN detail_logprodukkeluar ON log_produkkeluar.Id_Logkeluar = detail_logprodukkeluar.Id_Logkeluar WHERE DATE (log_produkkeluar.Tanggal) ='"+tgl+"' ORDER BY Id_Logkeluar DESC";
            System.out.println(sql);
            Connection conn = (Connection) Koneksi.config.configDB();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Tanggal"),
                    res.getString("Id_Logkeluar"),
                    res.getString("Nama_Produk"),
                    res.getString("jumlah"),
                    res.getString("total")
                });
                for (int i = 0; i < this.tbl_harian1.getRowCount(); i++) {
                tbl.isCellEditable(i, 0);
                tbl.isCellEditable(i, 1);
                tbl.isCellEditable(i, 2);
                tbl.isCellEditable(i, 3);
                tbl.isCellEditable(i, 4);
                
            }
                tbl_harian1.setModel(tbl);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void jumlahData() {
        int jumlah = 0;
        for (int i = 0; i < this.tbl_harian.getRowCount(); i++) {
            jumlah += Integer.parseInt(this.tbl_harian.getValueAt(i, 5).toString());
        }
        // set label mu mbek jumlah
        this.jLabel2.setText(Integer.toString(jumlah));
    }
    private void jumlahData1() {
        int jumlah = 0;
        for (int i = 0; i < this.tbl_harian1.getRowCount(); i++) {
            jumlah += Integer.parseInt(this.tbl_harian1.getValueAt(i, 4).toString());
        }
        // set label mu mbek jumlah
        this.jLabel4.setText(Integer.toString(jumlah));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_tgl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Account = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Transaksi = new javax.swing.JButton();
        Produk = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        namaku = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_harian = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_harian1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tgl2 = new com.toedter.calendar.JDateChooser();
        tgl1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        piePenjualan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tgl3 = new com.toedter.calendar.JDateChooser();
        tgl4 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        piePembelian = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        txt_tgl.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Account.setOpaque(false);
        Account.setContentAreaFilled(false);
        Account.setBorderPainted(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });
        jPanel1.add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 180, 50));

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

        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 190, 40));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, 170, 29));
        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));

        jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 20, 90, 25));

        namaku.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(namaku, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 170, 140, 30));

        tbl_harian.setBackground(new java.awt.Color(0, 204, 204));
        tbl_harian.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tbl_harian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_harian.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tbl_harian);
        if (tbl_harian.getColumnModel().getColumnCount() > 0) {
            tbl_harian.getColumnModel().getColumn(0).setResizable(false);
            tbl_harian.getColumnModel().getColumn(1).setResizable(false);
            tbl_harian.getColumnModel().getColumn(2).setResizable(false);
            tbl_harian.getColumnModel().getColumn(3).setResizable(false);
            tbl_harian.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 380, 160));

        tbl_harian1.setBackground(new java.awt.Color(0, 204, 204));
        tbl_harian1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tbl_harian1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(tbl_harian1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 380, 160));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 250, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 177, 180, 30));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl2.setForeground(new java.awt.Color(255, 255, 255));
        tgl2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(tgl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 150, 180, 30));

        tgl1.setForeground(new java.awt.Color(255, 255, 255));
        tgl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(tgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 79, 180, 30));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 110, 30));

        piePenjualan.setLayout(new java.awt.BorderLayout());
        jPanel2.add(piePenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 450, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Frame chart.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 260));

        jTabbedPane1.addTab("Statistik Penjualan", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl3.setForeground(new java.awt.Color(255, 255, 255));
        tgl3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(tgl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 150, 180, 30));

        tgl4.setForeground(new java.awt.Color(255, 255, 255));
        tgl4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(tgl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 79, 180, 30));

        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 110, 30));

        piePembelian.setLayout(new java.awt.BorderLayout());
        jPanel3.add(piePembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 450, 230));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Frame chart beli.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 260));

        jTabbedPane1.addTab("Statistik Pembelian", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, 280));

        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar_Menu/Home.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
//        this.setVisible(true);
//        if (JOptionPane.showConfirmDialog(null, "Apakah kamu yakin mau kembali ke tampilan Login Aplikasi ?", "WARNING",
//                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            new login().setVisible(true);
//            this.dispose();
//        } else {
        backtologin p = new backtologin(this, true);
        p.setVisible(true);
        
        // jika button ya diclose
        if(p.isClose()){
            // menutup window owner dan menampilkan window landing page
            this.setVisible(false);
            new login().setVisible(true);
}
    }//GEN-LAST:event_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggalAwal = String.valueOf(fm.format(tgl1.getDate()));
        String tanggalAkhir = String.valueOf(fm.format(tgl2.getDate()));
        this.showPieChartPenjualan(this.piePenjualan, "Penjualan tanggal " + tanggalAwal + "-" + tanggalAkhir, tanggalAwal, tanggalAkhir);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggalAwal = String.valueOf(fm.format(tgl4.getDate()));
        String tanggalAkhir = String.valueOf(fm.format(tgl3.getDate()));
        System.out.println(tanggalAwal);
        System.out.println(tanggalAkhir);
        this.showPieChartPembelian(this.piePembelian, "Pembelian tanggal " + tanggalAwal + "-" + tanggalAkhir, tanggalAwal, tanggalAkhir);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        new popup_keluar().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login.Splashscreen().setVisible(true);
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton Produk;
    private javax.swing.JButton Transaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jam;
    private javax.swing.JButton logout;
    private javax.swing.JLabel namaku;
    private javax.swing.JPanel piePembelian;
    private javax.swing.JPanel piePenjualan;
    private javax.swing.JTable tbl_harian;
    private javax.swing.JTable tbl_harian1;
    private javax.swing.JLabel tgl;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    private com.toedter.calendar.JDateChooser tgl3;
    private com.toedter.calendar.JDateChooser tgl4;
    private javax.swing.JLabel txt_tgl;
    // End of variables declaration//GEN-END:variables

}
