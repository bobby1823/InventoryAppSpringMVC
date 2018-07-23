package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deptinfo")
public class DeptInfoTable {

	public DeptInfoTable() {
		
	}

	public DeptInfoTable(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deptId")
	private int deptId;
	
	@Column(name="deptName")
	private String deptName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DeptInfoTable [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

	
}
