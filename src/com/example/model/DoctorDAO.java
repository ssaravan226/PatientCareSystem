package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/patientcaresystem";

    //  Database credentials
	static final String USER = "root";
    static final String PASS = "root";    
    
    public static ArrayList<UserReg> getPatientAssigned(String docEmail)
	{// TODO do not touch yet 

	    Connection conn = null;
	    Statement stmt = null;
	    ArrayList<UserReg> patients = new ArrayList<UserReg>();
	    try{
	       Class.forName("com.mysql.jdbc.Driver");

	       System.out.println("Connecting to get Patients assigned...");
	       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	       stmt = conn.createStatement();
	       String sql;
	       sql = "select u.emailid, u.firstname, u.lastname,u.roleid, d.docemailid from UserProfile u INNER JOIN Docpatmap d on d.patientemailid=u.emailid where d.docemailid='" + docEmail +"' and u.roleid=1 ";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	      
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	     	UserReg user = new UserReg();
	    	user.setEmail(rs.getString(1));
	    	user.setFname(rs.getString(2));
	    	user.setLname(rs.getString(3));
	        user.setroleId(Integer.parseInt(rs.getString(4)));
	    	
	    	   patients.add(user);
	       }
	       
	       
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return patients;
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
    
    public static ArrayList<SymptomPatient> getAllSymptom(String patientEmailid)
	{// TODO do not touch yet 
		
    	ArrayList<SymptomPatient> symptoms = new ArrayList<SymptomPatient>();
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
	       sql = "select s.episodeid, s.symptom1, s.symp1level, s.symptom2, symp2level,s.symptom3, symp3level, s.symptom4, s.Symp1leve4, s.symptom5, s.symp5level from UserProfile u INNER JOIN Symptoms s on u.emailid=s.patientemailid where u.emailid='" + patientEmailid +"' order by  episodeid desc ";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	     
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   SymptomPatient sym=new SymptomPatient();
	        sym.setEpisodeid(Integer.parseInt(rs.getString(1)));
	    	sym.setSymptom1(rs.getString(2));
	    	sym.setSymp1level(Integer.parseInt(rs.getString(3)));
	    	sym.setSymptom2(rs.getString(4));
	    	sym.setSymp2level(Integer.parseInt(rs.getString(5)));
	    	sym.setSymptom3(rs.getString(6));
	    	sym.setSymp3level(Integer.parseInt(rs.getString(7)));
	    	sym.setSymptom4(rs.getString(8));
	    	sym.setSymp4level(Integer.parseInt(rs.getString(9)));
            sym.setSymptom5(rs.getString(10));
            sym.setSymp5level(Integer.parseInt(rs.getString(11)));
            symptoms.add(sym);
	    	   
	       }
	       
	       
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return symptoms;
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
    
    public static boolean insertPrescription(Prescription prescription, String patientEmailid, String docEmailid)
	{// get Prescription and populate to Prescription Object. Given the Episode ID  
try
    	
        {	// TODO - insert default DOC into DocPat table 
    		Class.forName(JDBC_DRIVER);
    	      System.out.println("Connecting to insert Prescription...");
    	      Connection conn = DriverManager.getConnection(DB_URL, "root", PASS);
    	     
    	      // create a sql date object so we can use it in our INSERT statement
    	     // Calendar calendar = Calendar.getInstance();
    	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    	 
    	      // the mysql insert statement
    	      String query = " insert into Prescription (PatientEmailid, Episode, Doctemailid, Drug, Dosage,Frequency)"
    	        + " values (?, ?, ?,?,?,?)";
    	 
    	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmt = conn.prepareStatement(query);
    	      preparedStmt.setString (1,patientEmailid );
    	      preparedStmt.setInt (2, prescription.getEpisode());
    	      preparedStmt.setString  (3, docEmailid);
    	      preparedStmt.setString(4, prescription.getDrug());
    	      System.out.println("the drug is:" +prescription.getDrug());
    	      preparedStmt.setString    (5, prescription.getDose());
    	      preparedStmt.setString   (6, prescription.getFrequency());
    	      
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
    
    
    public static boolean updateComments(int episodeId, String comment, String emailid)
	{// update comments  Given the Episode ID  and comment - 
    	// need to detect if it is new comment and insert  
try
    	
        {	// TODO - insert default DOC into DocPat table 
    		Class.forName(JDBC_DRIVER);
    	      System.out.println("update comments...");
    	      Connection conn = DriverManager.getConnection(DB_URL, "root", PASS);
    	     
    	      // create a sql date object so we can use it in our INSERT statement
    	     // Calendar calendar = Calendar.getInstance();
    	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    	 
    	      // the mysql insert statement
    	      String query = " insert into Comments (Emailid, Comments, Episode)"
    	        + " values (?,?,?)";
    	 
    	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmt = conn.prepareStatement(query);
    	      preparedStmt.setString (1,emailid);
    	      //preparedStmt.setInt (2, roleid);
    	      preparedStmt.setString  (2, comment);
    	      preparedStmt.setInt(3, episodeId);
    	      
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
    
    
    
	
}