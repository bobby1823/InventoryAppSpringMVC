package com.mindtree.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreInfo;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.service.AddProductService;
import com.mindtree.service.ModifyProductService;


//@WebServlet("/Modify")
@Controller
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	ModifyProductService modify = new ModifyProductService();
	
	@Autowired
	AddProductService productService;
	
	@Autowired
	ProductTable product;
	
	@PostMapping("/modify")
	protected void modifyController(/*@RequestParam("productId") int product,*/Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("username").toString();
		System.out.println("ProductID "+session.getAttribute("productId").toString());
		System.out.println("Store ID is "+session.getAttribute("storeId").toString());
		System.out.println("Dept ID is "+session.getAttribute("deptId").toString());
		
		//Fetch product data from UI and storing it in product bean
		product.setProductId(Integer.valueOf(session.getAttribute("productId").toString()));
		StoreInfo storeInfo = (StoreInfo) productService.getObjectService(Integer.valueOf(session.getAttribute("storeId").toString()), "StoreInfo"); 
		product.setStoreInfo(storeInfo);
		product.setDeptInfo(Integer.valueOf(session.getAttribute("deptId").toString()));
		product.setProductName((request.getParameter("productName")));
		product.setVendor(request.getParameter("vendor"));
		product.setMrp(Double.parseDouble(request.getParameter("mrp")));
		product.setBatchNum(request.getParameter("batchNumber"));
		Date batchDate = null;
		try {
			String[] date = request.getParameter("batchDate").split("-");
			String year = date[0];
			String month = date[1];
			String day = date[2];
			product.setBatchDate(new SimpleDateFormat("dd/MM/yy").parse(day+"/"+month+"/"+year));
			System.out.println("Date: "+batchDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		product.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		
		//ModifyProductService modify = new ModifyProductService();
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			modify.modifyProduct(userName, product);
		}
		else {
			modify.modifyProductInventory(userName, product);
		}
		
		response.sendRedirect("AfterModify.jsp");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
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
	}*/

}
