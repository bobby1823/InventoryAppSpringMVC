package com.mindtree.model.dao;

import com.mindtree.exception.InventoryAppException;

public interface DeleteProductDao {

	public void deleteProduct(String userName, int productId) throws InventoryAppException;
	
	public void deleteInventory(String userName, int productId) throws InventoryAppException;
	
	public void deleteFromInventory(String userName, int productId) throws InventoryAppException;
}
