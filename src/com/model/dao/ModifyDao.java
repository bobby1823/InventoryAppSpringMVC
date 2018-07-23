package com.model.dao;

import java.util.Date;

public interface ModifyDao {

	public void modifyProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity);
	
	public void modifyInventory(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity);
}
