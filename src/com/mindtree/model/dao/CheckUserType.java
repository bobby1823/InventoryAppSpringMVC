package com.mindtree.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.beans.StoreDept;
import com.mindtree.beans.StoreInfo;
import com.mindtree.hibernate.util.HibernateConfig;


public class CheckUserType {
	
	public static String checkUserType(int userType) {
		 
		Session session = HibernateConfig.openSession();
		StoreInfo userInfo = new StoreInfo();
		Transaction tx = null;
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            userInfo = session.get(StoreInfo.class, userType);	     
	           // System.out.println("UserName from DB: "+userInfo.getStoreId());
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
		if((userInfo!=(null))) {
			return "Store Manager";
		}
		else {
			return "Department Manager";
		}
	}
	@SuppressWarnings("unchecked")
	public static String checkUserType(String userName) {
		Session session = HibernateConfig.openSession();
		StoreDept userInfo = new StoreDept();
		Transaction tx = null;
		try {// 
	            tx = session.getTransaction();
	            tx.begin();
	           List<StoreDept> userInfoList = session.createQuery(" from StoreDept where deptManager='"+userName+"'").list();
	           for(StoreDept userInfo1 : userInfoList) {
	        	   userInfo = userInfo1;
	        	   System.out.println("Respective DeptID is "+userInfo1.getDeptId().getDeptId());
		           System.out.println("Respective StoreID is "+userInfo1.getStoreId().getStoreId());
	           }
	           // System.out.println("UserName from DB: "+userInfo.getStoreId());
	            
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
		System.out.println("userInfo " +userInfo.getDeptManager().getPassword());
		
		if(userInfo.getDeptId().getDeptId() == userInfo.getStoreId().getStoreId()) {
			return "Store Manager";
		}
		else {
			return "Department Manager";
		}
	}
	
	/*public static void main(String args[]) {
	//System.out.println("User is "+AddProductService.checkUserType(1));
	Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
	AddProductService.addProduct(5, 2, 1, "Mach 3 Turbo", "Gillette", 40, "5312", date, 100);
	System.out.println("User Type: "+AddProductService.checkUserType(10));
	CheckUserType.checkUserType("Divyank");
	}*/
}
