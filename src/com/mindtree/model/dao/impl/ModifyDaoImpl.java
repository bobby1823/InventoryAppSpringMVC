package com.mindtree.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreInfo;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.ModifyDao;

public class ModifyDaoImpl implements ModifyDao{

	@Override
	public void modifyProduct(String userName, int productId, int storeId, int deptId, String productName,
			String vendor, double mrp, String batchNum, Date batchDate, int quantity) {
		StoreInfo storeInfo = new StoreInfo();
		//StoreDept storeDeptInfo = new StoreDept();
		ProductTable product = new ProductTable();

		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			List<StoreInfo> storeInfoList = session.createQuery(" from StoreInfo where storeId='"+storeId+"'").list();
			for(StoreInfo storeInfo1 : storeInfoList) {
				storeInfo = storeInfo1;
				System.out.println("Respective StoreId is "+storeInfo.getStoreId());
			}
			List<ProductTable> userInfoList = session.createQuery(" from ProductTable where storeId='"+storeId+"' and productId='"+productId+"'").list();
			for(ProductTable userInfo1 : userInfoList) {
				product = userInfo1;
				System.out.println("Respective DeptID is "+product.getDeptInfo());
			}
		
			System.out.println("Product Details from DB: "+product);
			product.setBatchDate(batchDate);
			product.setBatchNum(batchNum);
			product.setDeptInfo(product.getDeptInfo());
			product.setMrp(mrp);
			product.setProductId(productId);
			product.setProductName(productName);
			product.setQuantity(quantity);
			product.setVendor(vendor);
			product.setStoreInfo(storeInfo);
			session.save(product);
			tx.commit();

		} 
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void modifyInventory(String userName, int productId, int storeId, int deptId, String productName,
			String vendor, double mrp, String batchNum, Date batchDate, int quantity) {
		
		StoreInfo userInfo = new StoreInfo();
		InventoryUpdateTable updateTable = new InventoryUpdateTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			//Getting the Product object
			List<StoreInfo> q = session.createQuery("From StoreInfo where storeId="+storeId).list();
			
			for(StoreInfo userInfo1 : q) {
				userInfo = userInfo1;
				System.out.println("Respective StoreId is "+userInfo.getStoreId());
			}
			
			System.out.println("Store Details for deleting: "+userInfo);
			//Passing the data to InventoryUpdate Table
			updateTable.setStatus("Pending");
			updateTable.setOperationType("Modify");
			updateTable.setBatchDate(batchDate);
			updateTable.setBatchNum(batchNum);
			updateTable.setDeptInfo(deptId);
			updateTable.setMrp(mrp);
			updateTable.setProductId(productId);
			updateTable.setProductName(productName);
			updateTable.setQuantity(quantity);
			updateTable.setStoreInfo(userInfo);
			updateTable.setVendor(vendor);
			System.out.println("Data Sent for Approval: "+updateTable);
			session.save(updateTable);
			tx.commit();

		} 
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	
}
