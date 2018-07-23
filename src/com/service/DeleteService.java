package com.service;

import com.exception.InventoryAppException;
import com.model.dao.CheckUserType;
import com.model.dao.DeleteProductDao;
import com.model.dao.impl.DeleteProductDaoImpl;

public class DeleteService {

	DeleteProductDao deleteData = new DeleteProductDaoImpl();
	
	public void deleteProduct(String userName, int productId/*, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity*/) throws InventoryAppException {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			deleteData.deleteProduct(userName, productId);
		}
		else {
			deleteData.deleteInventory(userName, productId);
		}
	}
	
	/*public static void main(String[] args) {
		DeleteService delete = new DeleteService();
		delete.deleteProduct("Kirti", 4);
	}*/
}
