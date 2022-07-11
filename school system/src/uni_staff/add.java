/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import database.user_database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Allewaa
 */
public class add extends JPanel implements ActionListener {
    JLabel f_name=new JLabel("first name");
    JLabel l_name=new JLabel("last name");
    JLabel addr=new JLabel("address");
    JLabel depart=new JLabel("department");
    JTextField first_name=new JTextField();
    JTextField last_name=new JTextField();
    JTextField address=new JTextField();
    JTextField departmentt=new JTextField();
    JButton send=new JButton("Send");
    public add()
    {
        this.setVisible(true);
        this.setLayout(null);
        //..in..fnamr & lname & addr & depart
        f_name.setBounds(130,85,80,25);
        l_name.setBounds(130,115,80,25);
        addr.setBounds(130,145,80,25);
        depart.setBounds(130,175,80,25);
        add(f_name);add(l_name);add(addr);add(depart);
        //..in..first_namr & last_name & address & department
        first_name.setBounds(220,85,120,20);
        last_name.setBounds(220,115,120,20);
        address.setBounds(220,145,120,20);
        departmentt.setBounds(220,175,120,20);
        add(first_name);add(last_name);add(address);add(departmentt);
        //..in..send
        send.setBounds(220,235,80,25);
        add(send);
        send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==send)
    {
        try{
        database.student_database.insert_student(first_name.getText(),last_name.getText(),address.getText(), departmentt.getText());
        JOptionPane.showMessageDialog(null,"Inserted Student ","Ok",JOptionPane.INFORMATION_MESSAGE);
        
        }catch(Exception r)
        {
            System.out.println(r.getMessage());
            
        }}
    }

}