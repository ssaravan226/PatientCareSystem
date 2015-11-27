package com.example.web;

import com.example.model.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.ArrayList;


public class ListPatient extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {		    
		    RequestDispatcher view;
		    HttpSession session = request.getSession(true);
		    
		    ArrayList<UserReg> patients = new ArrayList<UserReg>();
		    String docEmail = session.getAttribute("email").toString();
		    	    
		    patients = DoctorDAO.getPatientAssigned(docEmail);
		    PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Patients Assigned</h1>");
			out.println("<table >  <tr>");
			out.println("<th >Patient Name </th>");
			out.println("<th >Severity     </th>");
			out.println("<th >View Symptoms</th></tr>");
			
			for (UserReg patient : patients) {
				out.println("<tr> <td>"+ patient.getFname() +", " + patient.getLname() + "</td>");
				out.println("<td>"+ getSeverityScore(patient.getEmail())+ "</td>");
				
				//
				out.println("<td><a href=\"http://localhost:8080/Patient_System/ListSymptoms?pemail="+patient.getEmail()+"\">Link</a></td></tr>");
			    					
			}

			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");	
			
		    	
		  }  
	public static int getSeverityScore(String patientEmailid)
	{// TODO do not touch yet 
    	int severity=0;
    	SymptomPatient symptom = SymptomDAO.getLatestSymptom(patientEmailid);
    	severity = symptom.getSymp1level() + symptom.getSymp2level() + 
    			symptom.getSymp3level() + symptom.getSymp4level() + symptom.getSymp5level();
    	return severity;
	}
  

}