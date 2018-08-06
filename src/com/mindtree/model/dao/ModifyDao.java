package com.mindtree.model.dao;

import java.util.Date;

import com.mindtree.beans.ProductTable;

public interface ModifyDao {

	public void modifyProduct(String userName, ProductTable product);
	
	public void modifyInventory(String userName, ProductTable product);
}
