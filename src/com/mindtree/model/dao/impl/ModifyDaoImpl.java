package com.mindtree.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreInfo;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.ModifyDao;

@Repository
public class ModifyDaoImpl implements ModifyDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	StoreInfo userInfo;
	
	@Autowired
	InventoryUpdateTable updateTable;
	
	@Override
	@Transactional
	public void modifyProduct(String userName, ProductTable product) {
		//StoreInfo storeInfo = new StoreInfo();
		//StoreDept storeDeptInfo = new StoreDept();
		//ProductTable product = new ProductTable();

		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			/*List<StoreInfo> storeInfoList = session.createQuery(" from StoreInfo where storeId='"+product.getStoreInfo().getStoreId()+"'").list();
			for(StoreInfo storeInfo1 : storeInfoList) {
				storeInfo = storeInfo1;
				System.out.println("Respective StoreId is "+storeInfo.getStoreId());
			}
			List<ProductTable> userInfoList = session.createQuery(" from ProductTable where storeId='"+product.getStoreInfo().getStoreId()+"' and productId='"+product.getProductId()+"'").list();
			for(ProductTable userInfo1 : userInfoList) {
				product = userInfo1;
				System.out.println("Respective DeptID is "+product.getDeptInfo());
			}*/
		
			System.out.println("Product Details from DB: "+product);
//			product.setBatchDate(batchDate);
//			product.setBatchNum(batchNum);
//			product.setDeptInfo(product.getDeptInfo());
//			product.setMrp(mrp);
//			product.setProductId(productId);
//			product.setProductName(productName);
//			product.setQuantity(quantity);
//			product.setVendor(vendor);
//			product.setStoreInfo(storeInfo);
			session.update(product);
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
	public void modifyInventory(String userName, ProductTable product) {
		Session session = sessionFactory.getCurrentSession();
		//Session session = HibernateConfig.openSession();
		//Getting the Product object
		List<StoreInfo> q = session.createQuery("From StoreInfo where storeId="+product.getStoreInfo().getStoreId()).list();
		
		System.out.println("Store Details for modifying: "+userInfo);
		//Passing the data to InventoryUpdate Table
		updateTable.setStatus("Pending");
		updateTable.setOperationType("Modify");
		updateTable.setBatchDate(product.getBatchDate());
		updateTable.setBatchNum(product.getBatchNum());
		updateTable.setDeptInfo(product.getDeptInfo());
		updateTable.setMrp(product.getMrp());
		updateTable.setProductId(product.getProductId());
		updateTable.setProductName(product.getProductName());
		updateTable.setQuantity(product.getQuantity());
		updateTable.setStoreInfo(product.getStoreInfo());
		updateTable.setVendor(product.getVendor());
		System.out.println("Data Sent for Approval: "+updateTable);
		session.saveOrUpdate(updateTable);
	}
		
}
