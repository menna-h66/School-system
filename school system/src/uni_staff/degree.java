/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Allewaa
 */
public class degree extends JPanel{
    JTable table;
    JScrollPane sc;
    String data[][];
    String header[]={"id","fname","lname"};
    ArrayList<domain.student> arr=database.student_database.get_student();
    public degree()
    {
        
        this.setLayout(null);
        show_table();
    }
    public void show_table()
    {
        data=new String[arr.size()][3];
        for(int i = 0 ;i<arr.size();i++)
        {
            data[i][0]=""+arr.get(i).getId();
            data[i][1]=arr.get(i).getFname();
            data[i][2]=arr.get(i).getLname();
        }
        table = new JTable(data,header);
        sc=new JScrollPane(table);
        sc.setBounds(0, 0, 350, 500);
        add(sc);       
        
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v=new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for(int i=0;i<table.getColumnCount();i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        
        
        
        
        
    }

   
}
