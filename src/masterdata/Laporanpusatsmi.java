/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PC
 */
public class Laporanpusatsmi extends javax.swing.JFrame {

    /**
     * Creates new form Laporanpusatsmi
     */
    public Laporanpusatsmi() {
        initComponents();
        tampil();
    }

    public void tampil() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://0.tcp.ap.ngrok.io:10827/db_uas_pbo2", "root", "")) {
            String sql = "SELECT DISTINCT g.tglmskgudang, g.kode_alat, g.nama_alat, g.merek, pc.hargajual, g.jumlah, cb.tgl_kirim, cb.tgl_terima, cb.jumlah AS stock_cabang, cb.Cabang, "
                    + "pc.tgl_jual, sb.tanggal_setor, sb.jam, pc.nama_marketing, pc.hargaSetorSMI, pc.pokok, pc.profitSMI "
                    + "FROM tb_gudang AS g "
                    + "INNER JOIN tb_cabang AS cb ON g.kode_alat = cb.kode_alat "
                    + "INNER JOIN tb_setor_cabang AS sb ON g.kode_alat = sb.kode_alat "
                    + "INNER JOIN tb_penjualan_cabang AS pc ON g.kode_alat = pc.kode_alat";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // Membuat DefaultTableModel untuk menyimpan data dari ResultSet
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("tglmskgudang");
            tableModel.addColumn("kode_alat");
            tableModel.addColumn("nama_alat");
            tableModel.addColumn("merek");
            tableModel.addColumn("hargajual");
            tableModel.addColumn("stock_pusat");
            tableModel.addColumn("tgl_kirim");
            tableModel.addColumn("tgl_terima");
            tableModel.addColumn("jumlah_cabang");
            tableModel.addColumn("cabang");
            tableModel.addColumn("tgl_jual");
            tableModel.addColumn("tanggal_setor");
            tableModel.addColumn("jam");
            tableModel.addColumn("nama_marketing");
            tableModel.addColumn("harga_setor");
            tableModel.addColumn("pokok");
            tableModel.addColumn("profit");

            // Mengisi DefaultTableModel dengan data dari ResultSet
            while (rs.next()) {
                String tglmskgudang = rs.getString("tglmskgudang");
                String kode_alat = rs.getString("kode_alat");
                String nama_alat = rs.getString("nama_alat");
                String merek = rs.getString("merek");
                String hargajual = rs.getString("hargajual");
                String jumlah_pusat = rs.getString("jumlah");
                String tgl_kirim = rs.getString("tgl_kirim");
                String tgl_terima = rs.getString("tgl_terima");
                String jumlah_cabang = rs.getString("stock_cabang");
                String cabang = rs.getString("Cabang");
                String tgl_jual = rs.getString("tgl_jual");
                String tanggal_setor = rs.getString("tanggal_setor");
                String jam = rs.getString("jam");
                String nama_marketing = rs.getString("nama_marketing");
                String harga_setor = rs.getString("hargaSetorSMI");
                String pokok = rs.getString("pokok");
                String profit = rs.getString("profitSMI");

                tableModel.addRow(new Object[]{tglmskgudang, kode_alat, nama_alat, merek, hargajual, jumlah_pusat, tgl_kirim, tgl_terima, jumlah_cabang, cabang, tgl_jual, tanggal_setor, jam, nama_marketing, harga_setor, pokok, profit});
            }

            // Menutup ResultSet, PreparedStatement, dan Connection
            rs.close();
            statement.close();
            conn.close();

            // Menetapkan model DefaultTableModel ke JTable "jTable12"
            jTable12.setModel(tableModel);

            // Mengatur lebar kolom "nama_alat" menjadi 200 piksel (px)
            TableColumn column = jTable12.getColumnModel().getColumn(2);
            column.setPreferredWidth(200);
        } catch (SQLException e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable12);

        jButton1.setText("cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            // Load file .jasper dan membuat objek JasperReport
            String reportPath = "src/Ireport/laporanpusatsmi.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            // Mengisi laporan dengan data
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://0.tcp.ap.ngrok.io:10827/db_uas_pbo2", "root", "")) {
               String sql = "SELECT DISTINCT g.tglmskgudang, g.kode_alat, g.nama_alat, g.merek, pc.hargajual, g.jumlah, cb.tgl_kirim, cb.tgl_terima, cb.jumlah AS stock_cabang, cb.Cabang, "
                    + "pc.tgl_jual, sb.tanggal_setor, sb.jam, pc.nama_marketing, pc.hargaSetorSMI, pc.pokok, pc.profitSMI "
                    + "FROM tb_gudang AS g "
                    + "INNER JOIN tb_cabang AS cb ON g.kode_alat = cb.kode_alat "
                    + "INNER JOIN tb_setor_cabang AS sb ON g.kode_alat = sb.kode_alat "
                    + "INNER JOIN tb_penjualan_cabang AS pc ON g.kode_alat = pc.kode_alat";

                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();

                JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                // Menampilkan laporan dalam JasperViewer
                JasperViewer.viewReport(jasperPrint, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporanpusatsmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporanpusatsmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporanpusatsmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporanpusatsmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporanpusatsmi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable12;
    // End of variables declaration//GEN-END:variables
}
