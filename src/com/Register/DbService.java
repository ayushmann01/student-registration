package com.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbService {
	static Connection con;

	static {
         String url = "jdbc:mysql://localhost:3306/iimt";
         String uname = "root";
         String pass = "newjava@123";
      try {
          Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException ex) {
          System.out.println(ex);
      }
      try {        
          con=DriverManager.getConnection(url, uname, pass);
      } catch (SQLException ex) {
          System.out.println(ex);
      }
      if(con==null) 
       System.out.println("Connection fail");
      else
          System.out.println("Connection done");
    }
  public static Connection getConnection()
  {
    return con;
  }
	/*
	 * public static void main(String... acb) {
	 * 
	 * }
	 */
}    


