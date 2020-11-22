package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Database
{
  private Connection conn;
  
  public Database()
  {
	//Properties Object
	Properties prop = new Properties();
	
	//Use a FileInputStream as input to the Properties object for reading the db.properties
	try 
	{
		FileInputStream fis = new FileInputStream("db.properties");
		prop.load(fis);
	} catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// Get the username, password, and url from properties
	String url = prop.getProperty("url");
    String user = prop.getProperty("user");
    String pass = prop.getProperty("password");    
    
	//Set connection
    try {
		conn = DriverManager.getConnection(url,user,pass);
		System.out.println("Connection Established");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
  }
  
  public ArrayList<String> query(String query)
  {
	  Statement stmt;
	  ResultSet rs;
	  ArrayList<String> toReturn = new ArrayList<String>();
	  ResultSetMetaData rmd;
	  
	  try
	  {
		// Using the conn object create a statement object
		stmt=conn.createStatement();
		  
		//Using the statement object executeQuery using the input query
		rs = stmt.executeQuery(query);
	
		if(rs.next()){
			toReturn.add(rs.getString(1));
			System.out.println(toReturn.get(0));
		}
		
	  } catch (SQLException e)
	  {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	  } 

	  return toReturn;
  }
  
  public void executeDML(String dml) throws SQLException
  {
	  Statement stmt;
	  
	  try
	  {
		// Using the conn object create a statement object
			stmt=conn.createStatement();
			stmt.execute(dml);
			System.out.println("Success");
			
	  }
	  catch (SQLException e)
	  {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	} 
	
  }
  
  //Method for verifying a username and password.
  public boolean verifyAccount(String username, String password)
  {
	  System.out.println("searching database for account");
	 String command = String.format("select password from users where username = '%s'", username);
   System.out.println(command);
   // Stop if this account doesn't exist.
   if (query(command).isEmpty())
     return false;
   
   // Check the username and password.
   if (query(command).get(0).equals(password))
     return true;
   else
     return false;
  }
 
  //Method for creating a new account.
  public boolean createNewAccount(String username, String password)
  {
	  String command1 = String.format("select username from users where username = '%s'", username);
	  String command2 = String.format("INSERT INTO users(username, password, admin) VALUES ('%s','%s',0)", username, password);
	  System.out.println(command2);
	  // Stop if this account already exists.
	  if (!query(command1).isEmpty()) 
	  {
		  return false;
	  }

	  
	  // Add the new account.
	  try {
		executeDML(command2);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	  
	  return true;
  }

  public void CloseConnection() {
	  try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
}
