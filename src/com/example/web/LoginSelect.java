package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;

import sun.text.normalizer.CharTrie.FriendAgent;

import java.io.*;
import java.util.*;
import java.sql.*;



public class LoginSelect extends HttpServlet {
    
    int id;
	  String fname, lname, email;
    
  public void doPost( HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
	
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");

    RequestDispatcher view;
    HttpSession session = request.getSession(true);
    UserReg user = PatientSystemDao.checkLogin(email, pwd);
    if (user != null){    	
    	/*if(user.getroleId() == 1){
    		view = request.getRequestDispatcher("PatientsHomePage.jsp");
    		session.setAttribute("doctor",PatientSystemDao.getDocName(email));
    	}
    	else if (user.getroleId() == 2)
        	view = request.getRequestDispatcher("DoctorsHomePage.jsp");
    	else {
    		view = request.getRequestDispatcher("Login.jsp");
    		request.setAttribute("errorMessage", "Invalid login - Contact Admin");
    		}
    	*/
    	
    	session.setAttribute("user",user);
    	session.setAttribute("email",email);
    	session.setAttribute("name",user.getFname() +", " + user.getLname());
    	
    	if(user.getroleId() == 1){
    		view = request.getRequestDispatcher("SymptomForm.jsp");
    		session.setAttribute("doctor",PatientSystemDao.getDocName(email));
    		 view.forward(request, response); 
    	}
    	else if (user.getroleId() == 2)
        response.sendRedirect("http://localhost:8080/Patient_System/ListPatient");
    	else {
    		view = request.getRequestDispatcher("Login.jsp");
    		request.setAttribute("errorMessage", "Invalid login - Contact Admin");
    		 view.forward(request, response); 
    		}
    	}
    else {
    	view = request.getRequestDispatcher("Login.jsp");
    	request.setAttribute("errorMessage", "Invalid username or password");	
    	 view.forward(request, response); 
    }
    
   
  }
}