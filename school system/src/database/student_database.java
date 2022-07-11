
package database;

import domain.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.student;
import static jdk.nashorn.internal.runtime.Debug.id;


public class student_database {
     public static Connection connect() throws SQLException{
        String url="jdbc:sqlserver://localhost\\DESKTOP-E5A6RQ2\\SQLEXPRESS:1433;databaseName=1";
        String username="NewPro";
        String password="123123";
        Connection con= DriverManager.getConnection(url,username,password);
        return con;
        
    }
    
    public static void insert_student(String fname,String lname,String address, String depart) throws SQLException
    {
        try{
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into student1 (fname,lname,address,department) values(?,?,?,?)");
        p.setString(1, fname);
        p.setString(2, lname);
        p.setString(3, address);
         p.setString(4, depart);
        p.execute();
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }   
    public static ArrayList<student> get_student(){
         ArrayList<student> list=new ArrayList<>();
         try{
             Connection con=connect();
             PreparedStatement p=con.prepareStatement("select * from student1");
             ResultSet r=p.executeQuery();
             while(r.next()){
                 list.add(new student(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("address"),r.getString("department")));
             }
         }catch(SQLException ee)
         {
             System.out.println(ee.getMessage());
         }
         return list;
    }
}
   /* public static Connection connect() throws SQLException
    {
       String url="jdbc:sqlserver://localhost\\DESKTOP-E5A6RQ2\\SQLEXPRESS:1433;databaseName=New";
       String username="NewPro";
       String password="123123";
       Connection con=DriverManager.getConnection(url,username,password);
        return con;
    }
    public void insert_student(String fname,String lname,String address, String depart)
    {
        try
        {
           Connection con=connect();
           PreparedStatement p = con.prepareStatement("insert into student values(?,?,?)");
           p.setString(1, fname);
           p.setString(2, lname);
           p.setString(3, address);
           p.setString(4, depart);
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }
    }
    public static ArrayList<student>get_student() throws SQLException
    {
        ArrayList<student> list= new ArrayList<>();
        try{
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("select * from student");
         ResultSet r=p.executeQuery();
             while(r.next()){
                 list.add(new student(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("address"),r.getString("departmentt")));
             }
         }catch(SQLException ee)
         {
             System.out.println(ee.getMessage());
         }
         return list;
    }
}
*/