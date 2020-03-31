/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumahasiswa;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class seluruh extends JFrame 
                    implements ActionListener{
    String[][] data = new String[500][3];
    String[] kolom = {"Nama", "Nim", "Alamat"};
    String aba;
    float panja ;
    JTable tabel;
    JButton hapus;
    JButton update;
    JButton balek;
    JTextField cari;
    JScrollPane scrollPane;
    String DBurl = "jdbc:mysql://localhost/crud_pbo";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    public seluruh() {
        setTitle("Data Mahasiswa!");
        hapus = new JButton("Hapus");
        update = new JButton("Update");
        cari = new JTextField("Isi Nim");
        hapus.addActionListener(this);
        update.addActionListener(this);
        cari.addActionListener(this);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from mahasiswa";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("nim");
                data[p][2] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        setLayout(new FlowLayout());
        add(scrollPane);
        add(cari);
        add(hapus);
        add(update);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    if (e.getSource()==hapus) {
           hapus(); 
        }
    if (e.getSource()==update) {
         
          panja = Float.valueOf(cari.getText());
         System.out.println(panja);
         new update(); 
        }
    
    }

    private void hapus() {
        try{
           
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
             statement.executeUpdate("delete from mahasiswa where nim ='"+cari.getText()+"'" );
     JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
            new Menu();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }

}
    }
    

