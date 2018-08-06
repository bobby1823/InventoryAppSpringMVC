package com.mindtree.model.dao;

import com.mindtree.beans.LoginUserTable;

public interface LoginDao {

	public String[] userValidation(LoginUserTable user);
	
}
