
package uni_staff;

import database.user_database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class first_screen extends JFrame implements ActionListener{
    JLabel user=new JLabel("User Name");
    JLabel Pass=new JLabel("Password");
    JTextField user_name=new JTextField();
    JPasswordField Password=new JPasswordField();
    JButton signin=new JButton("Sign in");
    JButton signup=new JButton("Sign up");
    image ii=new image();
    public first_screen()
    {
        show_first_Screen();
    }
    public void show_first_Screen()
    {   //..in..main form for project
        setTitle("uni_staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,422);
        setVisible(true);
        add(ii);
        
        //..in..user and password
        user.setBounds(130,85,80,25);
        Pass.setBounds(130,115,80,25);
        user.setForeground(Color.white);
        Pass.setForeground(Color.white);
        ii.add(user);ii.add(Pass);
        //..in..user and password textfield
        user_name.setBounds(220,88,130,18);
        Password.setBounds(220,118,130,18);
        ii.add(user_name);ii.add(Password);
       //..in..signin and signup
       signin.setBounds(150,173,80,25);
       signup.setBounds(250,173,80,25);
       signin.setForeground(Color.DARK_GRAY);
       signup.setForeground(Color.DARK_GRAY);
       ii.add(signin);ii.add(signup);
       signin.addActionListener(this);
       signup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==signin)
    {
     int i= database.user_database.check_user(user_name.getText(), Password.getText());
     switch(i){
     case 1:
          JOptionPane.showMessageDialog(null, "Hello Doctor "+ user_name.getText(),"Ok",JOptionPane.INFORMATION_MESSAGE);
          this.dispose();
          new doctor().setVisible(true);
          break;
      case 2:
         JOptionPane.showMessageDialog(null,"password wrong", "Error Password",JOptionPane.WARNING_MESSAGE);
         //System.out.println("password wrong");
         break;
      default:
         JOptionPane.showMessageDialog(null,"user is not exists","Error User",JOptionPane.WARNING_MESSAGE);
         //System.out.println("user is not exists");
         break;
    }}
    if(ae.getSource()==signup)
    {
        this.dispose();
        //new sec_screen().show_sec_screen();
        new sec_screen().setVisible(true);
        new first_screen().setVisible(false);
    }
    
    }}
