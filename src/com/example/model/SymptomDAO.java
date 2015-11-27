package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SymptomDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/patientcaresystem";

    //  Database credentials
	static final String USER = "root";
    static final String PASS = "root";    
    
    
    
    public static boolean insertLatestSymptom(String patientEmailId, String[] Symptoms, int[] PainLevels)
	{// insert into Symptomtable and fill the Symptom object ansd return it 
		
    	try
    	
        {	// TODO - insert default DOC into DocPat table 
    		Class.forName(JDBC_DRIVER);
    	      System.out.println("Connecting to database...");
    	      Connection conn = DriverManager.getConnection(DB_URL, "root", PASS);
    	     
    	      // create a sql date object so we can use it in our INSERT statement
    	     // Calendar calendar = Calendar.getInstance();
    	     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    	 
    	      // the mysql insert statement
    	      String query = " insert into Symptoms (PatientEmailid, Symptom1, Symp1level, Symptom2,Symp2level,Symptom3,Symp3level, Symptom4, Symp1leve4, Symptom5, Symp5level)"
    	        + " values ( ?, ?, ?, ?,?,?, ?,?,?,?,?)";
    	 
    	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmt = conn.prepareStatement(query);
    	      preparedStmt.setString (1, patientEmailId );
    	      preparedStmt.setString (2, Symptoms[0] );
    	      preparedStmt.setInt  (3, PainLevels[0]);
    	      preparedStmt.setString(4, Symptoms[1]);
    	      preparedStmt.setInt    (5, PainLevels[1]);
    	      preparedStmt.setString   (6, Symptoms[2]);
    	      preparedStmt.setInt    (7, PainLevels[2]);
    	      preparedStmt.setString    (8, Symptoms[3]);
    	      preparedStmt.setInt    (9, PainLevels[3]);
    	      preparedStmt.setString    (10, Symptoms[4]);
    	      preparedStmt.setInt    (11, PainLevels[4]);
    	 
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
    
    public static SymptomPatient getLatestSymptom(String email)
	{// get Latest Symptom and populate to SymptomPatient Object. Given the Patient Name 
    	
    	SymptomPatient sp=new SymptomPatient();
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
	       sql = "select s.symptom1, s.symptom2, s.symptom3, s.symptom4, s.symptom5,s.episodeid,s.Symp1level,s.Symp2level,s.Symp3level,s.Symp1leve4,s.Symp5level from UserProfile u INNER JOIN Symptoms s on u.emailid=s.patientemailid where u.Emailid='" +email+"'  and s.episodeid in (select max(episodeid) from Symptoms where patientemailid in (select emailid from userprofile where Emailid='" + email +"')) ";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	      
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	          //Retrieve by column name
	    	   sp.setSymptom1(rs.getString(1));
	    	   sp.setSymptom2(rs.getString(2));
	    	   sp.setSymptom3(rs.getString(3));
	    	   sp.setSymptom4(rs.getString(4));
	    	   sp.setSymptom5(rs.getString(5));
	    	   sp.setEpisodeid(Integer.parseInt(rs.getString(6)));
	    	   sp.setSymp1level(Integer.parseInt(rs.getString(7)));
	    	   sp.setSymp2level(Integer.parseInt(rs.getString(8)));
	    	   sp.setSymp3level(Integer.parseInt(rs.getString(9)));
	    	   sp.setSymp4level(Integer.parseInt(rs.getString(10)));
	    	   sp.setSymp5level(Integer.parseInt(rs.getString(11)));	    	   
	       }
	       
	       //getPrescription(Integer.parseInt(rs.getString(4)));
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return sp;
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
    
    public static SymptomPatient getSymptom(int episode)
   	{// get Latest Symptom and populate to SymptomPatient Object. Given the Patient Name 
       	
       	SymptomPatient sp=new SymptomPatient();
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
   	       sql = "select s.symptom1, s.symptom2, s.symptom3, s.symptom4, s.symptom5,s.episodeid from symptoms s where Episodeid="+episode;
   	       ResultSet rs = stmt.executeQuery(sql);
   	       
   	      
   	       //STEP 5: Extract data from result set
   	       while(rs.next()){
   	    	   System.out.println(sql + "reached");
   	          //Retrieve by column name
   	    	   sp.setSymptom1(rs.getString(1));
   	    	   sp.setSymptom2(rs.getString(2));
   	    	   sp.setSymptom3(rs.getString(3));
   	    	   sp.setSymptom4(rs.getString(4));
   	    	   sp.setSymptom5(rs.getString(5));
   	    	   sp.setEpisodeid(Integer.parseInt(rs.getString(6)));
   	    	       	   
   	       }
   	       
   	       //getPrescription(Integer.parseInt(rs.getString(4)));
   	       
   	       //STEP 6: Clean-up environment
   	       rs.close();
   	       stmt.close();
   	       conn.close();
   	       return sp;
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
    
    public static Prescription getPrescription(int episodeId)
	{// get Prescription and populate to Prescription Object. Given the Episode ID  
		
    	Prescription p=new Prescription();
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
	       sql = "select p.drug, p.dosage, p.frequency from UserProfile u INNER JOIN Symptoms s on u.emailid=s.patientemailid LEFT OUTER JOIN Prescription p on p.episode=s.episodeid  where s.episodeid="+ episodeId ;
	       ResultSet rs = stmt.executeQuery(sql);
	       
	       
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	          //Retrieve by column name
	    	   p.setDrug(rs.getString(1));
	    	   p.setDose(rs.getString(2));
	    	   p.setFrequency(rs.getString(3));
	    	   
	       }
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return p;
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
    
    public static String[] getComments(int episodeId)
	{// get comments  Given the Episode ID  
		
    	String comments[]=new String[100];
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
	       sql = "select comments from Comments where episode=" + episodeId + " order by commentid";
	       ResultSet rs = stmt.executeQuery(sql);
	       
	       int i=0;
	       //STEP 5: Extract data from result set
	       while(rs.next()){
	    	   System.out.println(sql + "reached");
	          //Retrieve by column name
	    	   comments[i]=rs.getString(1);
	    	   i++;
	    	   
	       }
	       
	       //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	       return comments;
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