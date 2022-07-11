/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Allewaa
 */
public class doctor extends JFrame{
    JTabbedPane tap=new JTabbedPane();
    add a1=new add();
    degree d1=new degree();
    
    public doctor()
    {
        show_doctor_screen();
    }
    public void show_doctor_screen()
    {
        
        //..in..main form for project
        setTitle("doctor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,422);
        setVisible(true);
        
        tap.addTab("Student",a1);
        tap.addTab("degree",d1);
        add(tap);
    }
}
