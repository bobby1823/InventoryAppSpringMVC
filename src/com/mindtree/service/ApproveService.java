package com.mindtree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.beans.ProductTable;
import com.mindtree.exception.InventoryAppException;
import com.mindtree.model.dao.AddProductDao;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.model.dao.DeleteProductDao;
import com.mindtree.model.dao.GetObjectDao;
import com.mindtree.model.dao.ModifyDao;

@Service
public class ApproveService {
	
	@Autowired
	ModifyDao modifyDao /*= new ModifyDaoImpl()*/;
	
	@Autowired
	AddProductDao productDao /*= new  AddProductDaoImpl()*/;
	
	@Autowired
	DeleteProductDao delete /*= new DeleteProductDaoImpl()*/;
	
	@Autowired
	GetObjectDao getObject;
	
	@Autowired
	ProductTable product;
	
	public void approveItem(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity, String operationType) throws InventoryAppException {
		
		switch(operationType) {
		case "Add":
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				product = (ProductTable) getObject.getProduct(productId, storeId, deptId, product);
				productDao.addProduct(userName, product/*productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity*/);
				//Deleting Item From InventoryUpdate Table
				delete.deleteFromInventory(userName, productId);
			}
			break;
			
		case "Modify":
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				product = (ProductTable) getObject.getProduct(productId, storeId, deptId, product);
				modifyDao.modifyProduct(userName, product);
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
