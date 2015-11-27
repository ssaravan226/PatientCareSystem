package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.PatientSystemDao;
import com.example.model.UserReg;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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
	    RequestDispatcher view;
		UserReg user=new UserReg();
	
		user.setFname(request.getParameter("FirstNameTextBox"));
		user.setLname(request.getParameter("LastNameTextBox"));
		user.setEmail(request.getParameter("EmailTextBox"));
		user.setPwd(request.getParameter("PwdTextBox"));
		user.setAddress(request.getParameter("AddrTextArea"));
		user.setContactNum(Integer.parseInt(request.getParameter("ConNumTextBox")));
		user.setEmergencyNum(Integer.parseInt(request.getParameter("ECNumTextBox")));
		if(request.getParameter("Role")!=null)
		{
			user.setroleId(Integer.parseInt(request.getParameter("Role")));
		}
		user.setans(request.getParameter("SecurityAnswer"));
		
		if(PatientSystemDao.insertUserRegInfo(user)){
		view = request.getRequestDispatcher("MedicalHistoryForm.jsp");
		view.forward(request, response);
		}
		else
			request.setAttribute("errorMessage", "User Data could not be added, please try again ");
		
		
	}

}