package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreDept;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.CheckUserType;
import com.model.dao.ModifyDao;
import com.model.dao.impl.ModifyDaoImpl;

public class ModifyProductService {

	public ModifyProductService() {
		
	}
	
	ModifyDao modifyDao = new ModifyDaoImpl();
	
	public void modifyProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity) {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			modifyDao.modifyProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}
		else {
			modifyDao.modifyInventory(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}

	}
	
	/*public static void main(String args[]) throws ParseException {
		ModifyProductService modify = new ModifyProductService();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
		modify.modifyProduct("Sayanta", 7, 2, 2, "Cricket Gloves", "Willow and Jones", 80.87, "541", date, 12);
	}*/
}
