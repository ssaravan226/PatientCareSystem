package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientSystemDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/patientcaresystem";

    //  Database credentials
	static final String USER = "root";
    static final String PASS = "root";    
    
    //TODO Logically need to have update medical history
    public static boolean insertMedicalHistory(MedicalHis history, String email )
	{
		try
	
    {
	      // create a mysql database connection
	      
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     
	      // create a sql date object so we can use it in our INSERT statement
	     // Calendar calendar = Calendar.getInstance();
	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	      ;
	      
	      String query1= "select emailid from UserProfile where EmailId='" +email +"' and roleid=1";
	      
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(query1);
	      
	      while(rs.next())
	      {
	        email=rs.getString("Emailid");
	      }

	      // the mysql insert statement
	      String query = " insert into medicalhistory (Emailid, PhyCare, PhyCareExp, MajorSur,MajorSurExp,Medication,MediExp, Allergy,Disease, Tobacco)"
	        + " values (?, ?, ?, ?, ?,?,?,?,?,?)";
	 
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, email);
	      System.out.println("email: " +email);
	      preparedStmt.setString (2, String.valueOf(history.getCare()));
	      System.out.println("care: " +String.valueOf(history.getCare()));
	      preparedStmt.setString (3, history.getCareExplanation() );
	      preparedStmt.setString   (4, String.valueOf(history.getSurgery()));
	      preparedStmt.setString (5, history.getSurExplanation());
	      preparedStmt.setString    (6, String.valueOf(history.getMedication()));
	      preparedStmt.setString   (7, history.getMedExpanation());
	      preparedStmt.setString    (8, String.valueOf(history.getAllergy()));
	      preparedStmt.setString    (9, history.getAllerExplanation());
	      preparedStmt.setString    (10, String.valueOf(history.getTobacco()));

	 
	      // execute the preparedstatement
	      preparedStmt.execute();
	       
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return false;
	    }
		return true;
	}
    
    public static boolean insertUserRegInfo(UserReg user)
	{
		try
	
    {	// TODO - insert default DOC into DocPat table 
		Class.forName(JDBC_DRIVER);
	      System.out.println("Connecting to database...");
	      Connection conn = DriverManager.getConnection(DB_URL, "root", PASS);
	     
	      // create a sql date object so we can use it in our INSERT statement
	     // Calendar calendar = Calendar.getInstance();
	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	 
	      // the mysql insert statement
	      String query = " insert into UserProfile (Emailid, FirstName, LastName, Password,Address,ContactNumber,EmergencyContNum, Roleid, Answer)"
	        + " values (?, ?, ?, ?, ?,?,?, ?,?)";
	 
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, user.getEmail());
	      preparedStmt.setString (2, user.getFname());
	      preparedStmt.setString (3, user.getLname());
	      preparedStmt.setString(4, user.getPwd());
	      preparedStmt.setString    (5, user.getAddress());
	      preparedStmt.setInt    (6, user.getContactNum());
	      preparedStmt.setInt    (7, user.getEmergencyNum());
	      preparedStmt.setInt    (8, user.getroleId());
	      preparedStmt.setString    (9, user.getans());
	 
	      // execute the preparedstatement
	      preparedStmt.execute();
	       
	      conn.close();
	      return true;
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return false;
	    }
		
	}
    
    public static UserReg checkForgotPasswordAnswer(String answer, String email){
    	UserReg user = new UserReg();
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	       Class.forName("com.mysql.jdbc.Driver");

	       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	       stmt = conn.createStatement();
	       String sql;
	       sql = "select * from UserProfile where Emailid='"+email+"'";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	       while(rs.next()){
	          if(rs.getString("Answer").equals(answer))
	        	 
		        	  user.setEmail(rs.getString(1));
		        	  user.setFname(rs.getString(2));
		        	  user.setLname(rs.getString(3));
		        	  user.setroleId(rs.getInt(5));
		        	  user.setPwd(rs.getString(6));
		        	  user.setAddress(rs.getString(7));
		        	  user.setContactNum(rs.getInt(8));
		        	  user.setEmergencyNum(rs.getInt(9));
		        	  user.setans(rs.getString(11));
	       }
	       rs.close();
	       stmt.close();
	       conn.close();
	       return user;
	    }catch(SQLException se){
	       se.printStackTrace();
	    }catch(Exception e){
	       e.printStackTrace();
	    }finally{
	       try{
	          if(stmt!=null)
	             stmt.close();
	       }catch(SQLException se2){
	       }
	       try{
	          if(conn!=null)
	             conn.close();
	       }catch(SQLException se){
	          se.printStackTrace();
	       }    
	    }
	    return null;
	}
    
    
	public static UserReg checkLogin(String email, String pwd){

	    UserReg user = new UserReg();
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	       //STEP 2: Register JDBC driver
	       Class.forName("com.mysql.jdbc.Driver");

	       //STEP 3: Open a connection
	       System.out.println("Connecting to database...");
	       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	       //STEP 4: Execute a query
	       System.out.println("Creating statement...");
	       stmt = conn.createStatement();
	       String sql;
	       sql = "select * from UserProfile where Emailid='"+email+"'";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	       
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	          //Retrieve by column name
	          if(rs.getString("Password").equals(pwd)){
	        	  user.setEmail(rs.getString(1));
	        	  user.setFname(rs.getString(2));
	        	  user.setLname(rs.getString(3));
	        	  user.setroleId(rs.getInt(5));
	        	  user.setPwd(rs.getString(6));
	        	  user.setAddress(rs.getString(7));
	        	  user.setContactNum(rs.getInt(8));
	        	  user.setEmergencyNum(rs.getInt(9));
	        	  user.setans(rs.getString(11));
	          }
	       }
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return user;
	    }catch(SQLException se){
	       //Handle errors for JDBC
	       se.printStackTrace();
	    }catch(Exception e){
	       //Handle errors for Class.forName
	       e.printStackTrace();
	    }finally{
	       //finally block used to close resources
	       try{
	          if(stmt!=null)
	             stmt.close();
	       }catch(SQLException se2){
	       }// nothing we can do
	       try{
	          if(conn!=null)
	             conn.close();
	       }catch(SQLException se){
	          se.printStackTrace();
	       }//end finally try    
	    }
	    return null;
	}
	
	public static String getDocName(String Patientemail){

	    String docName="";
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	       //STEP 2: Register JDBC driver
	       Class.forName("com.mysql.jdbc.Driver");

	       //STEP 3: Open a connection
	       System.out.println("Connecting to database...");
	       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	       //STEP 4: Execute a query
	       System.out.println("Creating statement...");
	       stmt = conn.createStatement();
	       String sql;
	       sql = "select u.firstname, u.lastname from DocPatMap d INNER JOIN UserProfile u on d.DocEmailid=u.emailid where d.PatientEmailid='" + Patientemail +"'";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	       
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	          //Retrieve by column name
	    	   docName = rs.getString(1) + ", " + rs.getString(2);
	       }
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return docName;
	    }catch(SQLException se){
	       //Handle errors for JDBC
	       se.printStackTrace();
	    }catch(Exception e){
	       //Handle errors for Class.forName
	       e.printStackTrace();
	    }finally{
	       //finally block used to close resources
	       try{
	          if(stmt!=null)
	             stmt.close();
	       }catch(SQLException se2){
	       }// nothing we can do
	       try{
	          if(conn!=null)
	             conn.close();
	       }catch(SQLException se){
	          se.printStackTrace();
	       }//end finally try    
	    }
	    return null;
	}
	
}
