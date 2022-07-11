/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.student;
import domain.user;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 *
 * @author Allewaa
 */
public class user_database  {
    public static Connection connect() throws SQLException{
        String url="jdbc:sqlserver://localhost\\DESKTOP-E5A6RQ2\\SQLEXPRESS:1433;databaseName=New";
        String username="NewPro";
        String password="123123";
        Connection con= DriverManager.getConnection(url,username,password);
        return con;
        
    }
    
    public static void insert_user(String user, String pass ,String depart) throws SQLException
    {
        try{
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into user2 values(?,?,?)");
        p.setString(1, user);
        p.setString(2, pass);
        p.setString(3, depart);
        p.execute();
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }   
    public static ArrayList<user> get_users(){
         ArrayList<user> list=new ArrayList<>();
         try{
             Connection con=connect();
             PreparedStatement p=con.prepareStatement("select * from user2");
             ResultSet r=p.executeQuery();
             while(r.next()){
                 list.add(new user(r.getString("user_name"),r.getString("password"),r.getString("department")));
             }
         }catch(SQLException ee)
         {
             System.out.println(ee.getMessage());
         }
         return list;
    }
    public static int check_user(String user,String Pass)
        {
          ArrayList<user> arr =get_users();
          int x=0;
          for(int i=0;i<arr.size();i++)
          {
              if(arr.get(i).getUser_name().equalsIgnoreCase(user))
              {
                  if(arr.get(i).getPassword().equalsIgnoreCase(Pass)) 
                     {
                       x=1;
                       break;
                     }
                  else
                  {
                      x=2;
                      break;
                  }
             }
              else{
                  x=0;
              }
          }
          return x;
        }

    
    
}