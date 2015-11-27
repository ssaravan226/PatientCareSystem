package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class SymptomRequest extends HttpServlet {
  public void doPost( HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
	String[] Symptoms = new String[5];
	int[] PainLevel = new int[5];
  
	  
    Symptoms[0] = request.getParameter("SymptomDD1");
    Symptoms[1] = request.getParameter("SymptomDD2");
    Symptoms[2] = request.getParameter("SymptomDD3");
    Symptoms[3] = request.getParameter("SymptomDD4");
    Symptoms[4] = request.getParameter("SymptomDD5");
    
    PainLevel[0] =Integer.parseInt(request.getParameter("PainLevelDD1"));
    PainLevel[1] =Integer.parseInt(request.getParameter("PainLevelDD2"));
    PainLevel[2] =Integer.parseInt(request.getParameter("PainLevelDD3"));
    PainLevel[3] =Integer.parseInt(request.getParameter("PainLevelDD4"));
    PainLevel[4] =Integer.parseInt(request.getParameter("PainLevelDD5"));
    
    String pwd = request.getParameter("pwd");

    RequestDispatcher view;
    HttpSession session = request.getSession(true);
    String symptom = "";
    
    String email = session.getAttribute("email").toString();
         
    if (SymptomDAO.insertLatestSymptom(email, Symptoms, PainLevel)){
    	//view = request.getRequestDispatcher("PatientViewRequest.jsp");
    	//view = request.getRequestDispatcher("PatientsHomePage.jsp");
    	response.sendRedirect("http://localhost:8080/Patient_System/ViewPatient");
    	
    }
    else {
    	request.setAttribute("errorMessage", "Error adding Symptom");
    	view = request.getRequestDispatcher("PatientViewRequest.jsp");
    	view.forward(request, response); 
    }
    
    //
  }
}