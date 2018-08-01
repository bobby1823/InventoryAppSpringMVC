package com.mindtree.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="storedept")
@IdClass(StoreDeptCompoundClass.class)
public class StoreDept {

	public StoreDept() {
		
	}	
	
	public StoreDept(StoreInfo storeId, DeptInfoTable deptId, LoginUserTable deptManager) {
		this.storeId = storeId;
		this.deptId = deptId;
		this.deptManager = deptManager;
	}

	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="storeId")
	private StoreInfo storeId;
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deptId")
	private DeptInfoTable deptId;
	
	@ManyToOne()
	@JoinColumn(name="deptManager")
	private LoginUserTable deptManager;

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

	public LoginUserTable getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(LoginUserTable deptManager) {
		this.deptManager = deptManager;
	}
	
	
}
