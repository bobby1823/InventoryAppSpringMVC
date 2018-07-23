package com.beans;

import java.io.Serializable;

public class StoreDeptCompoundClass implements Serializable {

	public StoreDeptCompoundClass() {
	
	}

	public StoreInfo storeId;
	public DeptInfoTable deptId;
	
	public StoreInfo getStoreId() {
		return storeId;
	}
	public void setStoreId(StoreInfo storeId) {
		this.storeId = storeId;
	}
	public DeptInfoTable getDeptId() {
		return deptId;
	}
	public void setDeptId(DeptInfoTable deptId) {
		this.deptId = deptId;
	}
	
	
	
}
