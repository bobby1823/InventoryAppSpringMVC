package com.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.InventoryUpdateTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.ShowInventoryDao;

public class ShowInventoryDaoImpl implements ShowInventoryDao{

	@Override
	public void showInventoryData(String userName, String productId) {
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<InventoryUpdateTable> showInventoryData() {
		//InventoryUpdateTable inventory = new InventoryUpdateTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		List<InventoryUpdateTable> inventoryData = null;
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            //Getting all the data into InventoryUpdateTable Bean. 
	            inventoryData = session.createQuery("From InventoryUpdateTable").list();
	            
	            tx.commit();
	            System.out.println("Inventory Details from DB: "+inventoryData.get(0).getStoreInfo().getStoreId());
	            
	        } 
	        catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
		return (ArrayList<InventoryUpdateTable>) inventoryData;
	}

	/*public static void main(String args[]) {
		ShowInventoryDao dao = new ShowInventoryDaoImpl();
		ArrayList<InventoryUpdateTable> arr = dao.showInventoryData();

	}*/
}
