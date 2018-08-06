package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.exception.InventoryAppException;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.model.dao.DeleteProductDao;
import com.mindtree.model.dao.impl.DeleteProductDaoImpl;

@Service
public class DeleteService {

	@Autowired
	DeleteProductDao deleteData1 /*= new DeleteProductDaoImpl()*/;
	
	DeleteProductDao deleteData = new DeleteProductDaoImpl();
	
	@Transactional
	public void deleteProduct(String userName, int productId) throws InventoryAppException {
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
