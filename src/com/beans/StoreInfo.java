package com.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="storeinfo")
public class StoreInfo {

	public StoreInfo() {
		
	}
	
	public StoreInfo(int storeId, String storeName) {
		this.storeId = storeId;
		this.storeName = storeName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="storeId")
	private int storeId;

	@Column(name="storeName")
	private String storeName;
	
	//If you don't specify anything, then by default all will be Type of Cascade
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="storeManager")
	private LoginUserTable storeManager;
	
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public LoginUserTable getStoreManager() {
		return this.storeManager;
	}
	
	@Override
	public String toString() {
		return "StoreInfo [storeId=" + storeId + ", storeName=" + storeName + ", storeManager=" + storeManager + "]";
	}
}
