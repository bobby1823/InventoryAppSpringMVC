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
import com.mindtree.exception.InventoryAppException;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.DeleteProductDao;

@Repository
public class DeleteProductDaoImpl implements DeleteProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	//@Autowired
	ProductTable product1 /*= new ProductTable()*/;
	
	ProductTable product = new ProductTable();
	
	//@Autowired
	StoreInfo userInfo = new StoreInfo();
	
	//@Autowired
	InventoryUpdateTable updateTable = new InventoryUpdateTable();
	
	@Override
	@Transactional
	public void deleteProduct(String userName, int productId) {		
		//Session session = sessionFactory.getCurrentSession();
		Session session = HibernateConfig.openSession();
		session.getTransaction().begin();
		//Getting the Product object
		product = session.get(ProductTable.class, productId);
		System.out.println("Product Details for deleting: "+product);
		//Deleting the Fetched object
		session.delete(product);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void deleteInventory(String userName, int productId) throws InventoryAppException {
		//Logic for getting data from Inventory update table
		//Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		
			tx = session.getTransaction();
			tx.begin();
			//Getting the Product object
			List<ProductTable> q = session.createQuery("From ProductTable where productId="+productId).list();
			
			for(ProductTable product1 : q) {
				product = product1;
				System.out.println("Respective ProductId is "+product.getProductId());
			}
			
			System.out.println("Product Details for deleting: "+product);
			//Passing the data to InventoryUpdate Table
			updateTable.setStatus("Pending");
			updateTable.setOperationType("Delete");
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
			tx.commit();

		/*} 
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}*/
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void deleteFromInventory(String userName, int productId) throws InventoryAppException {
//		InventoryUpdateTable updateTable = new InventoryUpdateTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		//Session session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			//Getting the Product object
			List<InventoryUpdateTable> updateTableList = session.createQuery("From InventoryUpdateTable where productId="+productId).list();
			//Equating into updateTable
			updateTable = updateTableList.get(0);
			System.out.println("Inventory Details for deleting: "+updateTable);
			//Deleting the Fetched object
			session.delete(updateTable);
			tx.commit();
	}
	
	/*public static void main(String args[]) throws InventoryAppException {
		DeleteProductImpl asd = new DeleteProductImpl();
		asd.deleteFromInventory("Sayanta", 4);
	}*/

}
