package com.service;

import java.util.Date;

import com.exception.InventoryAppException;
import com.model.dao.AddProductDao;
import com.model.dao.CheckUserType;
import com.model.dao.DeleteProductDao;
import com.model.dao.ModifyDao;
import com.model.dao.impl.AddProductDaoImpl;
import com.model.dao.impl.DeleteProductDaoImpl;
import com.model.dao.impl.ModifyDaoImpl;

public class ApproveService {
	
	ModifyDao modifyDao = new ModifyDaoImpl();
	AddProductDao productDao = new  AddProductDaoImpl();
	DeleteProductDao delete = new DeleteProductDaoImpl();
	
	public void approveItem(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity, String operationType) throws InventoryAppException {
		
		switch(operationType) {
		case "Add":
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				productDao.addProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
				//Deleting Item From InventoryUpdate Table
				delete.deleteFromInventory(userName, productId);
			}
			break;
			
		case "Modify":
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				modifyDao.modifyProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
				//Deleting Item From InventoryUpdate Table
				delete.deleteFromInventory(userName, productId);
			}
			break;
		
		case "Delete":
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				delete.deleteProduct(userName, productId);				
				//Deleting Item From InventoryUpdate Table
				delete.deleteFromInventory(userName, productId);
			}
			break;
		}
		
	}
	
	public void deny(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity, String operationType) throws InventoryAppException {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			delete.deleteFromInventory(userName, productId);
		}
	}

}
