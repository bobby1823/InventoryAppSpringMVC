package com.mindtree.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.beans.LoginUserTable;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{

	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	@Override
	public String userId(String userID) {

		String data = "";
		Session session = HibernateConfig.openSession();
		//Session session = sessionFactory.getCurrentSession();
        //User user = null;
		LoginUserTable loginUserDB = null;       
		loginUserDB = session.get(LoginUserTable.class, userID);
		data = loginUserDB.getUsername();
		System.out.println("UserName from DB: "+data);
	
        return data;
	}

	
	@Override
	public String userPassword(String userID) {
		String data = "";
		Session session = sessionFactory.getCurrentSession();
		//Session session = HibernateConfig.openSession();
		LoginUserTable loginUserDB = null;
		loginUserDB = session.get(LoginUserTable.class, userID);
		data = loginUserDB.getPassword();
		System.out.println("UserName from DB: "+data);
        return data;
	}
	
	
	/*@Override
	public String userId(String userID) {

		String data = "";
		Session session = HibernateConfig.openSession();
        Transaction tx = null;
        //User user = null;
        LoginUserTable loginUserDB = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            //Query query = session.createQuery("from userTable where username='"+userID+"'");
            //loginUserDB = (LoginUserTable)query.uniqueResult();
            loginUserDB = session.get(LoginUserTable.class, userID);
            data = loginUserDB.getUsername();
            System.out.println("UserName from DB: "+data);
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
        return data;
	}

	
	@Override
	public String userPassword(String userID) {
		String data = "";
		Session session = HibernateConfig.openSession();
        Transaction tx = null;
//        User user = null;
        LoginUserTable loginUserDB = null;
        try {
            tx = session.getTransaction();
            tx.begin();
//            Query query = session.createQuery("from userTable where password='"+password+"'");
//            loginUserDB = (LoginUserTable)query.uniqueResult();
            loginUserDB = session.get(LoginUserTable.class, userID);
            data = loginUserDB.getPassword();
            System.out.println("UserName from DB: "+data);
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
        return data;
	}*/
}
