package com.mindtree.model.dao;

import java.util.Date;

public interface AddProductDao {

	public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity);
	
	public void addInventory(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity);
	
	public boolean addStatus(String userName, int productId, int storeId, int deptId);
}
