package com.mindtree.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.beans.ProductTable;

public interface ShowInventoryDao {

	public void showInventoryData(String userName, String productId);
	
	public ArrayList showInventoryData();
	
	public List<ProductTable> showProductData();
}
