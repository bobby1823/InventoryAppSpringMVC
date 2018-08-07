package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.beans.LoginUserTable;
import com.mindtree.model.dao.LoginDao;
import com.mindtree.model.dao.impl.LoginDaoImpl;

@Service
public class LoginService {

	public LoginService() {
		
	}
	
	@Autowired
	LoginDao login;
	
	public boolean authentication(LoginUserTable user) {
		String [] loginUserValidation = login.userValidation(user);
		boolean status = !(loginUserValidation ==(null)) && !(loginUserValidation.equals(""));
		if(status) {
			System.out.println("Authentication Status: "+status);
			return true;
		}
		return false;
	}
	
}
