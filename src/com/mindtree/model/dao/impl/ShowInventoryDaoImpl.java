package com.mindtree.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.ProductTable;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.ShowInventoryDao;
import org.apache.log4j.Logger;


@SuppressWarnings("unused")
@Repository
public class ShowInventoryDaoImpl implements ShowInventoryDao{
	final static Logger logger = Logger.getLogger(ShowInventoryDaoImpl.class);
	
	@Override
	public void showInventoryData(String userName, String productId) {
		
	}
	
//	@Autowired
//	SessionFactory sessionFactory; 
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProductTable> showProductData() {
		Session session = HibernateConfig.openSession();
		//Session session = sessionFactory.getCurrentSession();
		List<ProductTable> products =  session.createQuery("from ProductTable").list();
		return products;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ArrayList<InventoryUpdateTable> showInventoryData() {
		//InventoryUpdateTable inventory = new InventoryUpdateTable();
		Session session = HibernateConfig.openSession();
		List<InventoryUpdateTable> inventoryData = null;
		//Getting all the data into InventoryUpdateTable Bean. 
		inventoryData = session.createQuery("from InventoryUpdateTable").list();
		
		return (ArrayList<InventoryUpdateTable>) inventoryData;
	}


	/*public static void main(String args[]) {
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/spring-mvc-servlet.xml");
		ShowInventoryDao dao = new ShowInventoryDaoImpl();
		System.out.println("Size of Product Table is "+dao.showProductData().size());
		dao.showInventoryData();

	}*/
}
