/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumahasiswa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Menu extends JFrame
        implements ActionListener {
     private JLabel judul;
    private JButton btndata;
    private JButton btnseluruh;
    public Menu(){
        judul = new JLabel("Menu");
        btndata = new JButton("Input Mahasiswa");
        btnseluruh = new JButton("Kumpulan Data");
        setLayout(null);
        add(judul);
        add(btndata);
        add(btnseluruh);
        setSize(400,200);
        btndata.addActionListener(this);
        btnseluruh.addActionListener(this);
        judul.setBounds(190,10,120,20);
        btndata.setBounds(130,50,150,20);
        btnseluruh.setBounds(130,90,150,20);
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btndata) {
            new data();
        }
       if (e.getSource()==btnseluruh) {
            new seluruh();
        }
    }
}



public class MenuMahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Menu();
    }
    
}
