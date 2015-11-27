package com.example.web;

import com.example.model.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.ArrayList;


public class ListSymptoms extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {		    
		    RequestDispatcher view;
		    HttpSession session = request.getSession(true);
		    
		    ArrayList<SymptomPatient> episodes = new ArrayList<SymptomPatient>();
		    String docEmail = session.getAttribute("email").toString();
		    String patientEmail = request.getParameter("pemail");	
		    
		    episodes = DoctorDAO.getAllSymptom(patientEmail);
		    PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Patients Assigned</h1>");
			out.println("<table >  <tr>");
			out.println("<th > Episode Id </th>");
			out.println("<th > Symptoms </th>");
			out.println("<th >View Symptoms</th></tr>");
			session.setAttribute("email", patientEmail);
			session.setAttribute("docEmail", docEmail);
			for (SymptomPatient episode : episodes) {
				out.println("<tr> <td>"+ episode.getEpisodeid() + "</td>");
				out.println("<td>"+ episode.getSymptom1() + ", " + episode.getSymptom2() +", " + episode.getSymptom3() +", " + episode.getSymptom4() +", " + episode.getSymptom5() + "</td>");
				out.println("<td><a href=\"http://localhost:8080/Patient_System/DocViewPatient?episode="+episode.getEpisodeid()+"\">Link</a></td></tr>");
			    					
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