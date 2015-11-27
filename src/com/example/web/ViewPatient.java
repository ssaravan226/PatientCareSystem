package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class ViewPatient extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
		    		    
		    RequestDispatcher view;
		    HttpSession session = request.getSession(true);
		    
		    SymptomPatient symptom = SymptomDAO.getLatestSymptom(session.getAttribute("email").toString());
		    
		    if(symptom!=null){
		    	
		    	request.setAttribute("symptom", symptom.getSymptom1() + ", " + 
		    			symptom.getSymptom2() +", " +  symptom.getSymptom3() +", " +  
		    					symptom.getSymptom4() +", " + symptom.getSymptom5());
		    	session.setAttribute("episode", symptom.getEpisodeid());
		    	// get prescription 
		    	Prescription prescription = SymptomDAO.getPrescription(symptom.getEpisodeid());
		    	if(prescription !=null){
		    	request.setAttribute("drug", prescription.getDrug());
		    	request.setAttribute("dosage", prescription.getDose());
		    	request.setAttribute("frequency",prescription.getFrequency());}
		    	
		    	String comment[] = SymptomDAO.getComments(symptom.getEpisodeid());
		    	String commentUpdate = "";
		    	for(int i=0; i<10;i++)
		    	{
		    		if(comment[i]!=null)
		    		commentUpdate = comment[i] + ", " + commentUpdate;
		    	}
		    	request.setAttribute("comment",commentUpdate);    	
		    }else     
		    request.setAttribute("errorMessage", "Error on View Recent Symptom Page");
		    	
		    	
		    	view = request.getRequestDispatcher("PatientViewRequest.jsp");
		    	view.forward(request, response); 
		    	
		  }  
  
public void doPost( HttpServletRequest request, 
       HttpServletResponse response) 
       throws IOException, ServletException {   
		
	String comment = request.getParameter("commentUpdate");

    RequestDispatcher view;
    HttpSession session = request.getSession(true);
       
    Integer episodeId = Integer.parseInt(session.getAttribute("episode").toString());
    String email = session.getAttribute("email").toString();
    
    if( DoctorDAO.updateComments(episodeId, comment, email)){
    	System.out.println("inserted comment");
    	response.sendRedirect("http://localhost:8080/Patient_System/ViewPatient");
    	
    }else{
    	request.setAttribute("errorMessage", "Error Updating Comment");
    	view = request.getRequestDispatcher("PatientViewRequest.jsp");
    	view.forward(request, response); 
    	
    }
    
		}
}