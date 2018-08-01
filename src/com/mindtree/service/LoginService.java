package com.mindtree.service;

import org.springframework.stereotype.Service;

import com.mindtree.model.dao.LoginDao;
import com.mindtree.model.dao.impl.LoginDaoImpl;

@Service
public class LoginService {

	public LoginService() {
		
	}
	
	LoginDao login = new LoginDaoImpl();
	
	public boolean authentication(String userName, String passWord) {
		boolean status = !(login.userId(userName).equals(null)) && !(login.userPassword(passWord).equals(null)) 
				&& !(login.userId(userName).equals("")) && !(login.userPassword(passWord).equals(""));
		if(status) {
			System.out.println("Value: "+status);
			return true;
		}
		return false;
	}
	
}
