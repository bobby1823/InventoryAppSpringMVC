package com.mindtree.service;

import com.mindtree.exception.InventoryAppException;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.model.dao.DeleteProductDao;
import com.mindtree.model.dao.impl.DeleteProductDaoImpl;

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
