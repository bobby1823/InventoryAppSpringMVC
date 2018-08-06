package com.mindtree.model.dao;

import java.util.Date;

import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.ProductTable;

public interface AddProductDao {

	public void addProduct(String userName, ProductTable product);
	
	public void addInventory(String userName, ProductTable product/*int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity*/);
	
	public boolean addStatus(String userName, ProductTable product/*int productId, int storeId, int deptId*/);
	
	
	//--------------------------Has to delete
	/*public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity);*/
}
