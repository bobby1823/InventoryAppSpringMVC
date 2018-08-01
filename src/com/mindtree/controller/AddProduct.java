package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.service.AddProductService;

/**
 * Servlet implementation class AddProduct
 */
//@WebServlet(description = "Adds the new product in Product Table/ Inventory Table based on User Role", urlPatterns = { "/AddProduct" })
@Controller
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("username").toString();
		
		//Fetch product data from UI
		int productId = Integer.valueOf(request.getParameter("productId"));
		int storeId = Integer.valueOf(request.getParameter("storeId"));
		int deptId = Integer.valueOf(request.getParameter("deptId"));
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
			System.out.println("Date: "+batchNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		AddProductService addProduct = new AddProductService();
		
		System.out.println("Value "+addProduct.checkStatusAddingProduct(userName, productId, storeId, deptId));
		PrintWriter out = response.getWriter();
		if(!(addProduct.checkStatusAddingProduct(userName, productId, storeId, deptId))) {
			System.out.println("Inside If Condition");
			out.print("<script language='JavaScript'>alert('Please enter correct StoreId, ProductId and DeptId.');</script>");
			
			response.sendRedirect("deptHome.jsp");
		}
		else {
			System.out.println("Inside Else Condition");
			//For adding the product into DB
			addProduct.addProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
			response.sendRedirect("AfterProductAdded.jsp");
		}
		
	}*/
	
	@PostMapping("/AddProduct")
	protected void AddProductController(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("username").toString();
		
		//Fetch product data from UI
		int productId = Integer.valueOf(request.getParameter("productId"));
		int storeId = Integer.valueOf(request.getParameter("storeId"));
		int deptId = Integer.valueOf(request.getParameter("deptId"));
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
			System.out.println("Date: "+batchNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		AddProductService addProduct = new AddProductService();
		
		System.out.println("Value "+addProduct.checkStatusAddingProduct(userName, productId, storeId, deptId));
		PrintWriter out = response.getWriter();
		if(!(addProduct.checkStatusAddingProduct(userName, productId, storeId, deptId))) {
			System.out.println("Inside If Condition");
			out.print("<script language='JavaScript'>alert('Please enter correct StoreId, ProductId and DeptId.');</script>");
			
			response.sendRedirect("deptHome.jsp");
		}
		else {
			System.out.println("Inside Else Condition");
			//For adding the product into DB
			addProduct.addProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
			response.sendRedirect("AfterProductAdded.jsp");
		}
	}

}
