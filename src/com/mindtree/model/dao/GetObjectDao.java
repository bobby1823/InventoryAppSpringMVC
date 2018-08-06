package com.mindtree.model.dao;

import java.util.Collection;

import com.mindtree.beans.StoreInfo;

public interface GetObjectDao {

	public Object get(int storeId, String entityName);
	
	public Object getProduct(int productId, int storeId, int deptId, Object object);
	
}
