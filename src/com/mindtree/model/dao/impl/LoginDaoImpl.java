package com.mindtree.model.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.LoginUserTable;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{

	
	@Autowired
	public SessionFactory sessionFactory;

	
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public String[] userValidation(LoginUserTable user) {
		String[] data = new String[3];
		Session session = sessionFactory.getCurrentSession();
		//Session session = HibernateConfig.openSession();
		LoginUserTable loginUserDB = null;		
		Query query = session.createQuery("from LoginUserTable where password='"+user.getPassword()+"' and username='"+user.getUsername()+"'");
		List<LoginUserTable> userList = query.list();
		if(userList.isEmpty()) {
			return null;
		}
		else {
			loginUserDB = userList.get(0);
			data[0] = loginUserDB.getUsername();
			data[1] = loginUserDB.getPassword();
			System.out.println("Credentials from DB: "+loginUserDB.getUsername());
			return data;
		}       
	}
	

}
