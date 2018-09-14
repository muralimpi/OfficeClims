package com.db.connection.check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A test class to verify the Hana Database connectivity
 * @author Serole_Vijay 
 */		
public class HanaSeroleDbConnect {
	
	public static void main(String[] argv) {
	      Connection connection = null;
	      String user = "ELSECO_APP_USER";
	      String passwd = "Elseco123";
	      try {                  
	         connection = DriverManager.getConnection("jdbc:sap://203.90.111.85:30062/",user,passwd);                  
	      } catch (SQLException e) {
	         System.err.println("Connection Failed. User/Passwd Error?");
	         return;
	      }
	      if (connection != null) {
	         try {
	            System.out.println("Connection to HANA successful!");
	            Statement stmt = connection.createStatement();
	            ResultSet resultSet = stmt.executeQuery("SELECT UCR_NO FROM \"EL_CLAIMS\".\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_ClaimHeader_T\"");
	            resultSet.next();
	            String hello = resultSet.getString(1);
	            System.out.println(hello);
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	          System.err.println("Query failed!");
	       }
	     }
	   }
}
