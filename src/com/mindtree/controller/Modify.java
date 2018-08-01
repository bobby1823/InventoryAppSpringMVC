package com.mindtree.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.service.ModifyProductService;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("username").toString();
		System.out.println("ProductID "+session.getAttribute("productId").toString());
		System.out.println("Store ID is "+session.getAttribute("storeId").toString());
		System.out.println("Dept ID is "+session.getAttribute("deptId").toString());
		
		//Fetch product data from UI
		int productId = Integer.valueOf(session.getAttribute("productId").toString());
		int storeId = Integer.valueOf(session.getAttribute("storeId").toString());
		int deptId = Integer.valueOf(session.getAttribute("deptId").toString());
		String productName = (request.getParameter("productName"));
		String vendor = request.getParameter("vendor");
		double mrp = Double.parseDouble(request.getParameter("mrp"));
		String batchNum = request.getParameter("batchNumber");
		Date batchDate = null;
		try {
			String[] date = request.getParameter("batchDate").split("-");
			String year = date[0];
			String month = date[1];
			String day = date[2];
			batchDate = new SimpleDateFormat("dd/MM/yy").parse(day+"/"+month+"/"+year);
			System.out.println("Date: "+batchDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		
		ModifyProductService modify = new ModifyProductService();
		modify.modifyProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		response.sendRedirect("AfterModify.jsp");
	}

}
