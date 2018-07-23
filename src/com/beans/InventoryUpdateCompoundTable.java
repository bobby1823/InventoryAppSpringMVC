package com.beans;

import java.io.Serializable;

public class InventoryUpdateCompoundTable implements Serializable {

	public InventoryUpdateCompoundTable() {
	
	}

	public StoreInfo storeInfo;
	public int productId;
	
	public StoreInfo getStoreId() {
		return storeInfo;
	}
	public void setStoreId(StoreInfo storeId) {
		this.storeInfo = storeId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
