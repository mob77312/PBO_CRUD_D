/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumahasiswa;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class data extends JFrame 
            implements ActionListener{
    private JLabel  judul;
    private JLabel  nama;
    private JLabel  nim;
    private JLabel  alamat;
    private JTextField nama1;
    private JTextField nim1;
    private JTextField alamat1;
    private JButton simpan;
    String DBurl = "jdbc:mysql://localhost/crud_pbo";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public data() {
        judul = new JLabel("Data Mahasiswa");
        nama = new JLabel("Nama :");
        nim = new JLabel("Nim :");
        alamat = new JLabel("Alamat :");
        nama1 = new JTextField();
        nim1 = new JTextField();
        alamat1 = new JTextField();
        simpan = new JButton("Simpan");
        nama1.addActionListener(this);
        nim1.addActionListener(this);
        alamat1.addActionListener(this);
        simpan.addActionListener(this);
        setSize(400,300);
        setLayout(null);
        add(judul);
        add(nama);
        add(nim);
        add(alamat);
        add(nama1);
        add(nim1);
        add(alamat1);
        add(simpan);
        setVisible(true);
        judul.setBounds(170,10,120,20);
        nama.setBounds(10,50,120,20);
        nama1.setBounds(150,50,120,20);
        nim.setBounds(10,90,120,20);
        nim1.setBounds(150,90,120,20);
        alamat.setBounds(10,130,120,20);
        alamat1.setBounds(150,130,120,20);
        simpan.setBounds(150,170,120,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==simpan) {
           masukandata();
      }
    
}
  public void masukandata(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
             statement.executeUpdate("insert into mahasiswa values("+ nama1.getText() + "," +  nim1.getText() + "," + alamat1.getText() + ")");
     JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
            new Menu();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDisimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }

}
    }
    