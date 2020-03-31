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
public class update extends JFrame
                implements ActionListener {
    seluruh x = new seluruh();
    String aba;
    private JLabel  ujudul;
    private JLabel  unama;
    private JLabel  unim;
    private JLabel  ualamat;
    private JTextField unama1;
    private JTextField unim1;
    private JTextField ualamat1;
    private JButton usimpan;
    String DBurl = "jdbc:mysql://localhost/crud_pbo";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    public update()  {  
   
        System.out.println(x.panja);
        ujudul = new JLabel("Data Mahasiswa");
        unama = new JLabel("Nama :");
        unim = new JLabel("Nim :");
        ualamat = new JLabel("Alamat :");
        unama1 = new JTextField();
        unim1 = new JTextField();
        ualamat1 = new JTextField();
        usimpan = new JButton("Update");
        unama1.addActionListener(this);
        unim1.addActionListener(this);
        ualamat1.addActionListener(this);
        usimpan.addActionListener(this);
        
        setSize(400,300);
        setLayout(null);
        add(ujudul);
        add(unama);
        add(unim);
        add(ualamat);
        add(unama1);
        add(unim1);
        add(ualamat1);
        add(usimpan);
        setVisible(true);
        ujudul.setBounds(170,10,120,20);
        unama.setBounds(10,50,120,20);
        unama1.setBounds(150,50,120,20);
        unim.setBounds(10,90,120,20);
        unim1.setBounds(150,90,120,20);
        ualamat.setBounds(10,130,120,20);
        ualamat1.setBounds(150,130,120,20);
        usimpan.setBounds(150,170,120,20);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         try{
             
             
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
             
             statement.executeUpdate("update mahasiswa set nama='"+unama1.getText()+"', nim='"+unim1.getText()+"',alamat='"+ualamat1.getText()+"' where nim='"+aba+"'") ;
     JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
            new Menu();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDiupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
