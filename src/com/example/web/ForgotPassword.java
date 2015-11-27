package com.example.web;

import com.example.model.*;

import javax.servlet.*;
import javax.servlet.http.*;

import sun.text.normalizer.CharTrie.FriendAgent;

import java.io.*;
import java.util.*;
import java.sql.*;



public class ForgotPassword extends HttpServlet {
    
    int id;
	  String fname, lname, email;
    
  public void doPost( HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {

	 
    String answer = request.getParameter("answer");
    String email = request.getParameter("email");
    RequestDispatcher view;
    HttpSession session = request.getSession(true);
    
    UserReg user = PatientSystemDao.checkForgotPasswordAnswer(answer, email);
    
    
    if (user != null)
    	{
    	
    	view = request.getRequestDispatcher("SymptomForm.jsp");
    	session.setAttribute("user",user);
    	session.setAttribute("name",user.getFname() +", " + user.getLname());
    	session.setAttribute("doctor",PatientSystemDao.getDocName(email));
    	}
    else 
    	{
    	request.setAttribute("errorMessage", "Invalid answer, Try Again!");
    	view = request.getRequestDispatcher("ForgotPwd.jsp");
    	}
    view.forward(request, response); 
  }
}