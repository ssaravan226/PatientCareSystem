package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class DocViewPatient extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
		    		    
		    RequestDispatcher view;
		    HttpSession session = request.getSession(true);
		    int episode = Integer.parseInt(request.getParameter("episode"));
		    
		    
		    SymptomPatient symptom = SymptomDAO.getSymptom(episode);
		    
		    if(symptom!=null){
		    	
		    	request.setAttribute("symptom", symptom.getSymptom1() + ", " + 
		    			symptom.getSymptom2() +", " +  symptom.getSymptom3() +", " +  
		    					symptom.getSymptom4() +", " + symptom.getSymptom5());
		    	session.setAttribute("episode", symptom.getEpisodeid());
		    			    	
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
		    	
		    	
		    	view = request.getRequestDispatcher("DocPatientViewRequest.jsp");
		    	view.forward(request, response); 
		    	
		  }  
  
public void doPost( HttpServletRequest request, 
       HttpServletResponse response) 
       throws IOException, ServletException {   
	
	
		
	String comment = request.getParameter("commentUpdate");
	Prescription pres = new Prescription();
	boolean success = false;

    RequestDispatcher view;
    HttpSession session = request.getSession(true);
       
    Integer episodeId = Integer.parseInt(session.getAttribute("episode").toString());
    String email = session.getAttribute("email").toString();
    String docEmail = session.getAttribute("docEmail").toString();
    
    
    pres.setDrug(request.getParameter("drug"));
	pres.setDose(request.getParameter("dosage"));
	pres.setFrequency(request.getParameter("frequency"));
	pres.setEpisode(episodeId);
    
	if(pres.getDrug()!="")
    if(DoctorDAO.insertPrescription(pres, email, docEmail))
    	success = true;
       
    if(comment!="")
    	if( DoctorDAO.updateComments(episodeId, comment, email))
        success = true;	    	
        	
    if(success)
    	response.sendRedirect("http://localhost:8080/Patient_System/DocViewPatient?episode=" + episodeId);
    else{
        	request.setAttribute("errorMessage", "Error Updating Patient Page");
        	view = request.getRequestDispatcher("DocPatientViewRequest.jsp");
        	view.forward(request, response); 
        	
        }
	}
}