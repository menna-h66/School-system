/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Allewaa
 */
public class image2 extends JPanel{
    private ImageIcon ii;
    public image2()
    {
        this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ii=new ImageIcon(getClass().getResource("..\\img\\darckimg.jpg"));
        ii.paintIcon(this, g, 0, 0);
    }
    
}
