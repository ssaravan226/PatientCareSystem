package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.*;

/**
 * Servlet implementation class MedicalHistory
 */
@WebServlet("/MedicalHistory")
public class MedicalHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MedicalHis history=new MedicalHis();
		RequestDispatcher view;
		HttpSession session = request.getSession(true);
		
		
		if(request.getParameter("radiocare") != null) {
			
            if(request.getParameter("radiocare").equals("Y")) {
            	history.setCare('Y');
            	System.out.println("phycare" + request.getParameter("radiocare"));
            }
            else if (request.getParameter("radiocare").equals("N"))
            {
            	history.setCare('N');
            }
            else
            {
            	
            }
        
		}
		history.setCareExplanation(request.getParameter("CareExplanation"));
		if(request.getParameter("radiomedication") != null) {
            if(request.getParameter("radiomedication").equals("Y")) {
            	history.setMedication('Y');
            }
            else if (request.getParameter("radiomedication").equals("N"))
            {
            	history.setMedication('N');
            }
            else
            {
            	
            }
	}
		history.setMedExpanation(request.getParameter("medExpanation"));
		if(request.getParameter("radiosurgery") != null) {
            if(request.getParameter("radiosurgery").equals("Y")) {
            	history.setSurgery ('Y');
            }
            else if (request.getParameter("radiosurgery").equals("N"))
            {
            	history.setSurgery('N');
            }
            else
            {
            	
            }
		}
		history.setSurExplanation(request.getParameter("surExplanation"));
		if(request.getParameter("radiotobacco") != null) {
            if(request.getParameter("radiotobacco").equals("Y")) {
            	history.setTobacco('Y');
            }
            else if (request.getParameter("radiotobacco").equals("N"))
            {
            	history.setTobacco('N');
            }
            else
            {
            	
            }
		}
		if(request.getParameter("chkallergy") != null) {
            if(request.getParameter("chkallergy").equals("Aspirin")) {
            	history.setAllergy("Aspirin");
            }
            else if (request.getParameter("chkallergy").equals("Pencilin"))
            {
            	history.setAllergy("Pencilin");
            }
            else if (request.getParameter("chkallergy").equals("Codeine"))
            {
            	history.setAllergy("Codeine");
            }
            else if (request.getParameter("chkallergy").equals("Latex"))
            {
            	history.setAllergy("Latex");
            }
            else if (request.getParameter("chkallergy").equals("Other"))
            {
            	history.setAllergy("Other");
            }
		}
		history.setAllerExplanation(request.getParameter("allerExplanation"));
		
		String email = session.getAttribute("email").toString();
		
		if(PatientSystemDao.insertMedicalHistory(history, email)){
	    	view = request.getRequestDispatcher("SymptomForm.jsp");
	    }
	    else {
	    	request.setAttribute("errorMessage", "Error Updating Medical History");
	    	view = request.getRequestDispatcher("MedicalHistoryForm.jsp");
	    }
	    view.forward(request, response); 

}
}
