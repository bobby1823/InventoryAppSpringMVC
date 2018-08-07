package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.beans.LoginUserTable;
import com.mindtree.service.LoginService;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("serial")
//@WebServlet(description = "Used for Logging in", urlPatterns = { "/Login" })
@Controller
public class LoginController extends HttpServlet {
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/Login")
	protected String loginController(@ModelAttribute("loginDetails") LoginUserTable user, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside PostMapping");
		HttpSession session = request.getSession();
		logger.info("User from Login User form "+user.getEmail());
		logger.info("User from Login User form "+user.getUsername());
		logger.info("User from Login User form "+user.getPassword());
		
		if(loginService.authentication(user)) {
			session.setAttribute("username", request.getParameter("username"));
			System.out.println("username is: "+request.getParameter("username") );
			//response.sendRedirect("deptHome.jsp");
			return "deptHome";
		}
		else {
			System.out.println("username is: "+request.getParameter("username") );
			return "login-error";
			//response.sendRedirect("login.jsp");
			//return "login";		
		}
	}
}
