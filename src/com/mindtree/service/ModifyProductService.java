package com.mindtree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.ProductTable;
import com.mindtree.model.dao.CheckUserType;
import com.mindtree.model.dao.ModifyDao;

@Service
public class ModifyProductService {

	public ModifyProductService() {
		
	}
	
	@Autowired
	ModifyDao modifyDao /*= new ModifyDaoImpl()*/;
	
	@Transactional
	public void modifyProduct(String userName, ProductTable product) {
			modifyDao.modifyProduct(userName, product);
	}
	
	@Transactional
	public void modifyProductInventory(String userName, ProductTable product) {		
			modifyDao.modifyInventory(userName, product);
	}
	/*public static void main(String args[]) throws ParseException {
		ModifyProductService modify = new ModifyProductService();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
		modify.modifyProduct("Sayanta", 7, 2, 2, "Cricket Gloves", "Willow and Jones", 80.87, "541", date, 12);
	}*/
}
