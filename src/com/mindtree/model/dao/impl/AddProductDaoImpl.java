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
import com.mindtree.model.dao.AddProductDao;
import com.mindtree.model.dao.CheckUserType;

@Repository
public class AddProductDaoImpl implements AddProductDao{

	//@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addProduct(String userName, ProductTable product) {
			Session session = HibernateConfig.openSession();
			//Session session = sessionFactory.getCurrentSession();			
			session.getTransaction().begin();
			session.saveOrUpdate(product);
	        session.getTransaction().commit();
	        System.out.println("Product Details from DB: "+product);	
	}

	@Transactional
	@Override
	public void addInventory(String userName, ProductTable product/*int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity*/) {		
		StoreInfo userInfo = new StoreInfo();
		InventoryUpdateTable updateTable = new InventoryUpdateTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
			tx = session.getTransaction();
			tx.begin();
			//Getting the Product object
			List<StoreInfo> q = session.createQuery("From StoreInfo where storeId="+product.getStoreInfo().getStoreId()).list();
			
			for(StoreInfo userInfo1 : q) {
				userInfo = userInfo1;
				System.out.println("Respective StoreId is "+userInfo.getStoreId());
			}
			
			System.out.println("Store Details for Adding: "+userInfo);
			//Passing the data to InventoryUpdate Table
			updateTable.setStatus("Pending");
			updateTable.setOperationType("Add");
			updateTable.setBatchDate(product.getBatchDate());
			updateTable.setBatchNum(product.getBatchNum());
			updateTable.setDeptInfo(product.getDeptInfo());
			updateTable.setMrp(product.getMrp());
			updateTable.setProductId(product.getProductId());
			updateTable.setProductName(product.getProductName());
			updateTable.setQuantity(product.getQuantity());
			updateTable.setStoreInfo(userInfo);
			updateTable.setVendor(product.getVendor());
			System.out.println("Data Sent for Approval: "+updateTable);
			session.saveOrUpdate(updateTable);
			tx.commit(); 
		
	}
	
	
	//---------------------Has to Delete
	/*@Override
	public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity) {
		StoreInfo userInfo = new StoreInfo();

		ProductTable product = new ProductTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            //Getting the StoreId object
	            userInfo = session.get(StoreInfo.class, storeId);
	            //Setting all the data into ProductTable Bean. And place passing it to product object 
	            product.setProductId(productId);
	            product.setStoreInfo(userInfo);
	            product.setDeptInfo(deptId);
	            product.setProductName(productName);
	            product.setVendor(vendor);
	            product.setMrp(mrp);
	            product.setBatchNum(batchNum);
	            product.setBatchDate(batchDate);				
				product.setQuantity(quantity);
				
	            session.save(product);
	            tx.commit();
	            System.out.println("Product Details from DB: "+product);
	          
	        } 
	        catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
		
	}*/
	
	//---------------------Has to Delete
	
	/*@Override
	public void addInventory(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity) {
		
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
			
			System.out.println("Store Details for Adding: "+userInfo);
			//Passing the data to InventoryUpdate Table
			updateTable.setStatus("Pending");
			updateTable.setOperationType("Add");
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
		
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addStatus(String userName, ProductTable product/*int productId, int storeId, int deptId*/) {
		boolean status = true;	
		boolean productIdstatus = false;
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		List<ProductTable> productIdList = null;
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            List<StoreInfo> storeIdInfoList = session.createQuery("FROM StoreInfo where storeId="+product.getStoreInfo().getStoreId()).list();
	            List<StoreInfo> deptIdInfoList = session.createQuery("FROM DeptInfoTable where deptId="+product.getDeptInfo()).list();
	            
	            if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
	            	productIdList = session.createQuery("FROM ProductTable where productId="+product.getProductId()).list();
	            	if(!(productIdList.isEmpty())) {
	            		productIdstatus = true;
	            	}
	            }
	            else {
	            	productIdList = session.createQuery("FROM ProductTable where productId="+product.getProductId()).list();
	            	if(!(productIdList.isEmpty())) {
	            		productIdstatus = true;
	            	}
	            	
	            }
	            System.out.println("StoreId Retrived: "+storeIdInfoList.toString());
	            System.out.println("DeptId Retrived: "+deptIdInfoList.toString());
	            System.out.println("ProductId Retrived: "+productIdList.toString());
	           
	            if((storeIdInfoList.isEmpty()) || productIdstatus || (deptIdInfoList.isEmpty())) {
	            	status = false;
	            }
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
		return status;
	}
	/*public static void main(String[] args) throws ParseException {
		AddProductDaoImpl ad = new AddProductDaoImpl();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("09/09/2019");
		System.out.println(ad.addStatus("Kirti", 1, 2, 2));
	}*/

}
