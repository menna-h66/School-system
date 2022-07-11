
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class sec_screen extends JFrame implements ActionListener{
    JLabel user=new JLabel("User name");
    JLabel pass=new JLabel("Password");
    JLabel depart=new JLabel("Department");
    JLabel note=new JLabel("enter department (cs,is or it) only");
    JTextField user_name=new JTextField();
    JTextField department=new JTextField();
    JPasswordField password=new JPasswordField();
    JButton send=new JButton("Send");
    JButton back=new JButton("<<Back");
    image ii=new image();
    public sec_screen()
    {
      show_sec_screen();   
    }
    public void show_sec_screen()
    {  //..in..main form for project
        setTitle("log up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,422);
        setVisible(true);
        add(ii);
        
        //..in..user & pass & depert
        user.setBounds(50,85,80,25);
        pass.setBounds(50,115,80,25);
        depart.setBounds(50,145,80,25);
        user.setForeground(Color.white);
        pass.setForeground(Color.white);
        depart.setForeground(Color.white);
        ii.add(depart);ii.add(user);ii.add(pass);
        //..in..user_name & password & depertment
        user_name.setBounds(150,89,130,19);
        password.setBounds(150,119,130,19);
        department.setBounds(150,146,130,19);
        note.setBounds(290,146,270,19);
        note.setForeground(Color.white);
        ii.add(department);ii.add(user_name);ii.add(password);ii.add(note);
        //..in.. send & back
        send.setBounds(150,196,80,25);
        send.setForeground(Color.red);
        back.setBounds(0,0,80,20);
        back.setForeground(Color.white);
        back.setBackground(Color.red);
        ii.add(send);ii.add(back);
        send.addActionListener(this);
        back.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==back)
    {
        
       this.dispose();
        new first_screen().setVisible(true);
    }
            if(ae.getSource()==send)
            {
                try {
                    String t1=department.getText();
                    if(t1.equalsIgnoreCase("cs")||t1.equalsIgnoreCase("is")||t1.equalsIgnoreCase("it")){
                    database.user_database.insert_user(user_name.getText(), password.getText(), department.getText());
                    JOptionPane.showMessageDialog(null,"Hello Doctor "+ user_name.getText(),"Ok",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                     new first_screen().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"department is not exist","error department",JOptionPane.WARNING_MESSAGE);
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
    }
}
