package com.mindtree.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
	private static final String DRIVER_URL = "com.mysql.jdbc.Driver";
    private static final String CONN_URL = "jdbc:mysql://localhost/inventoryDB";
    private static final String USER = "hbstudent";
    private static final String PASSSWORD = "hbstudent";
 
    static {
        try {
            Class.forName(DRIVER_URL);
        } catch (Exception ex) {
            System.out.println("Error loading Driver " + ex);
        }
    }
    
    public static ArrayList<Item> getAllItems(){
    	ArrayList<Item> itemList = new ArrayList<>();
    	try{
    		Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSSWORD);
    		PreparedStatement statement = conn.prepareStatement("select * from product");
    		ResultSet rs = statement.executeQuery();
    		while(rs.next()){
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
    		}
    	}
    	catch(Exception ex){
    		System.out.println("Exception occurred in getting the list of products : "+ex.getMessage());
    	}
    	return itemList;
    }
    
    public static Item getItem(int storeId, int productId){
    	Item item = new Item();
    	try{
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
    	}
    	return item;
    }
}
