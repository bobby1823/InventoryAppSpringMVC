package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.beans.ProductTable;
import com.mindtree.hibernate.util.AppUtils;
import com.mindtree.service.AddProductService;

/**
 * Controller implementation class AddProduct
 */
@Controller
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddProduct.class.getName());
	
	@Autowired
	AddProductService addProductService; /*= new AddProductService();*/
	
	@PostMapping("/addProduct")
	protected void AddProductController(@ModelAttribute("product") ProductTable product, HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException, ParseException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("username").toString();
		logger.info("Date from form is: "+product.getBatchDate());
		System.out.println("Date from form is: "+product.getBatchDate());
		product.setBatchDate(AppUtils.parseDate(product.getBatchDate()));
		System.out.println("Value "+addProductService.checkStatusAddingProduct(userName, product));
		PrintWriter out = response.getWriter();
		if(!(addProductService.checkStatusAddingProduct(userName, product/*productId, storeId, deptId*/))) {
			System.out.println("Inside If Condition");
			out.print("<script language='JavaScript'>alert('Please enter correct StoreId, ProductId and DeptId.');</script>");
			
			response.sendRedirect("deptHome.jsp");
		}
		else {
			System.out.println("Inside Else Condition");
			//For adding the product into DB
			addProductService.addProduct(userName, product/*productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity*/);
			response.sendRedirect("AfterProductAdded.jsp");
			
		}
	}

}
