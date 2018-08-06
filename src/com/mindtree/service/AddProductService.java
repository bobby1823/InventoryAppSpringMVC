package com.mindtree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreInfo;
import com.mindtree.model.dao.AddProductDao;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.model.dao.GetObjectDao;
import com.mindtree.model.dao.impl.AddProductDaoImpl;
import com.mindtree.model.dao.impl.GetObjectDaoImpl;

@Service
public class AddProductService {

	public AddProductService() {
		
	}
	
	@Autowired
	GetObjectDao getObjectDao/* = new GetObjectDaoImpl();*/;
	
	//@Autowired
	AddProductDao productDao = new AddProductDaoImpl();
	
	//@Autowired
	ProductTable product = new ProductTable();
	
	StoreInfo storeInfo = new StoreInfo();
	
	@Transactional
	public Object getObjectService(int storeId, String entityName) {
		return getObjectDao.get(storeId,entityName);
	}
	@Transactional
	public void addProduct(String userName, ProductTable product/*int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity*/) {
		
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {

			productDao.addProduct(userName, product);
		}
		else {
			productDao.addInventory(userName, product/*productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity*/);
		}

	}
	
	/*public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
															double mrp, String batchNum, Date batchDate, int quantity) {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			
			productDao.addProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}
		else {
			productDao.addInventory(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}
			
	}*/
	
	/*
	 * Returns the status whether product can be added or not based on the storeId, productId, deptId passed in UI
	 */
	public boolean checkStatusAddingProduct(String userName, ProductTable product/*int productId,int storeId, int deptId*/) {
		return (productDao.addStatus(userName, product));
	}
	
}
