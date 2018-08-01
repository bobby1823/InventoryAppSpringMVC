package com.mindtree.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.service.LoginService;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("serial")
//@WebServlet(description = "Used for Logging in", urlPatterns = { "/Login" })
@Controller
public class Login extends HttpServlet {
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userNameForm = request.getParameter("uname");
		String passWordForm = request.getParameter("uname");
		
		LoginService loginService = new LoginService();
		
		//FetchUserNamePass fetchUserName = new FetchUserNamePass(loginBean);
		
		if(loginService.authentication(userNameForm, passWordForm)) {
			session.setAttribute("username", request.getParameter("uname"));
			System.out.println("UserName is: "+request.getParameter("uname") );
			response.sendRedirect("deptHome.jsp");
		}
		else {
			System.out.println("UserName is: "+request.getParameter("uname") );
			response.sendRedirect("login.jsp");
			//Alert alert = new Alert(Alert.getAlertType(), "", null); 
		}
	}*/
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/Login")
	protected String loginController(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside PostMapping");
		HttpSession session = request.getSession();
		String userNameForm = request.getParameter("uname");
		String passWordForm = request.getParameter("uname");
		
		//LoginService loginService; /*= new LoginService();*/
		
		//FetchUserNamePass fetchUserName = new FetchUserNamePass(loginBean);
		
		if(loginService.authentication(userNameForm, passWordForm)) {
			session.setAttribute("username", request.getParameter("uname"));
			System.out.println("UserName is: "+request.getParameter("uname") );
			//response.sendRedirect("deptHome.jsp");
			return "deptHome";
		}
		else {
			System.out.println("UserName is: "+request.getParameter("uname") );
			//response.sendRedirect("login.jsp");
			return "login";
			//Alert alert = new Alert(Alert.getAlertType(), "", null); 
		}
	}
}
