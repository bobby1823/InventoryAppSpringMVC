package com.mindtree.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.beans.ProductTable;
import com.mindtree.hibernate.util.HibernateConfig;

public class ShowProductService {

	public ShowProductService() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static void getAllItems(){
    	Session session = HibernateConfig.openSession();
    	ProductTable itemList1 = new ProductTable();
    	ArrayList<ProductTable> itemList = null;
    	Transaction tx = null;
    	try{
//    		Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSSWORD);
//    		PreparedStatement statement = conn.prepareStatement("select * from product");
//    		ResultSet rs = statement.executeQuery();
    		session.beginTransaction();
    		tx = session.getTransaction();
    		tx.begin();					
    		itemList1 = session.get(ProductTable.class, 1);
    		System.out.println("Data is "+itemList1.getProductName());
//    		itemList1 = (ProductTable) session
//							.createQuery("from product")
//							.list();
    		//int size = itemList.size(); 
    		tx.commit();
    		/*while(size!=0){
    			Item item = new Item();
    			item.setProductId(rs.getInt("productId"));
    			item.setStoreId(rs.getInt("storeId"));
    			item.setDeptId(rs.getInt("deptId"));
    			item.setProductName(rs.getString("productName"));
    			item.setVendor(rs.getString("vendor"));
    			item.setMrp(rs.getDouble("mrp"));
    			item.setBatchNum(rs.getString("batchNum"));
    			item.setBatchDate(rs.getDate("batchDate"));
    			item.setQuantity(rs.getInt("quantity"));
    			itemList.add(item);
    			size--;
    		}*/
    	}
    	catch(Exception ex){
    		System.out.println("Exception occurred in getting the list of products : "+ex.getMessage());
    	}
    	//return itemList;
    }
    
    public static Item getItem(int storeId, int productId){
    	Item item = new Item();
    	/*try{
    		Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSSWORD);
    		PreparedStatement statement = conn.prepareStatement("select * from product where productId=? and storeId=?");
    		statement.setInt(1, productId);
    		statement.setInt(2, storeId);
    		ResultSet rs = statement.executeQuery();
    		if(rs.next()){
    			item.setProductId(rs.getInt("productId"));
    			item.setStoreId(rs.getInt("storeId"));
    			item.setDeptId(rs.getInt("deptId"));
    			item.setProductName(rs.getString("productName"));
    			item.setVendor(rs.getString("vendor"));
    			item.setMrp(rs.getDouble("mrp"));
    			item.setBatchNum(rs.getString("batchNum"));
    			item.setBatchDate(rs.getDate("batchDate"));
    			item.setQuantity(rs.getInt("quantity"));
    		}
    	}
    	catch(Exception ex){
    		System.out.println("Exception occurred in getting the product : "+ex.getMessage());
    	}*/
    	return item;
    }
    
    public static void main(String args[]) {
    	ShowProductService.getAllItems();
    }
}
