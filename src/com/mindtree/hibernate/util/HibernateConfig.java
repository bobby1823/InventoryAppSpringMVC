package com.mindtree.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mindtree.beans.DeptInfoTable;
import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.LoginUserTable;
import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreDept;
import com.mindtree.beans.StoreInfo;
 
public class HibernateConfig {
 
    private static final SessionFactory sessionFactory;
    /*SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(LoginUserTable.class)
			.buildSessionFactory();*/
    static {
        try {
            sessionFactory = new Configuration()
            					.configure("hibernate.cfg.xml")
            					.addAnnotatedClass(ProductTable.class)
            					.addAnnotatedClass(LoginUserTable.class)
            					.addAnnotatedClass(DeptInfoTable.class)
            					.addAnnotatedClass(StoreInfo.class)
            					.addAnnotatedClass(StoreDept.class)
            					.addAnnotatedClass(InventoryUpdateTable.class)
            					.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
