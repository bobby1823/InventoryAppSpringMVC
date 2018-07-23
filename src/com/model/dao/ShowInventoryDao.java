package com.model.dao;

import java.util.ArrayList;

public interface ShowInventoryDao {

	public void showInventoryData(String userName, String productId);
	
	public ArrayList showInventoryData();
}
