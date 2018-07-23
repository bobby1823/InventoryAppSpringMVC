package com.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.LoginUserTable;
import com.hibernate.util.HibernateConfig;
import com.model.dao.LoginDao;

public class LoginDaoImpl implements LoginDao{

	@Override
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
	}
}
