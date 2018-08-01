package com.mindtree.beans;

import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Table(name="product")
public class ProductTable {

	public ProductTable() {
		
	}
	
	
	
	public ProductTable(int productId, String productName, String vendor, double mrp, String batchNum, Date batchDate, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.vendor = vendor;
		this.mrp = mrp;
		this.batchNum = batchNum;
		this.batchDate = batchDate;
		this.quantity = quantity;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="vendor")
	private String vendor;
	
	@Column(name="mrp")
	private double mrp;
	
	@Column(name="batchNum")
	private String batchNum;
	
	@Temporal(TemporalType.DATE)
	@Column(name="batchDate")
	private Date batchDate;	
	
	@Column(name="quantity")
	private int quantity;
	
	
	@ManyToOne(cascade={
			CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	)
	@JoinColumn(name="storeId")
	private StoreInfo storeInfo ;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="deptId")
	@Column(name="deptId")
	private int deptInfo;
	
	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getVendor() {
		return vendor;
	}



	public void setVendor(String vendor) {
		this.vendor = vendor;
	}



	public double getMrp() {
		return mrp;
	}



	public void setMrp(double mrp) {
		this.mrp = mrp;
	}



	public String getBatchNum() {
		return batchNum;
	}



	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}



	public Date getBatchDate() {
		return batchDate;
	}



	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	/*public Collection<StoreInfo> getStoreInfo() {
		return storeInfo;
	}



	public void setStoreInfo(List<StoreInfo> storeInfo) {
		this.storeInfo = storeInfo;
	}*/



	public int getDeptInfo() {
		return deptInfo;
	}

	/*public void setStoreInfo(int storeInfo) {
		this.storeInfo = storeInfo;
	}*/



	public void setDeptInfo(int deptInfo) {
		this.deptInfo = deptInfo;
	}



	public StoreInfo getStoreInfo() {
		return storeInfo;
	}



	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}



	@Override
	public String toString() {
		return "ProductTable [productId=" + productId + ", productName=" + productName + ", vendor=" + vendor + ", mrp="
				+ mrp + ", batchNum=" + batchNum + ", batchDate=" + batchDate + ", quantity=" + quantity
				+ ", storeInfo=" + storeInfo + ", deptInfo=" + deptInfo + "]";
	}

	

	/*public List<DeptInfoTable> getDeptInfo() {
		return deptInfo;
	}



	public void setDeptInfo(List<DeptInfoTable> deptInfo) {
		this.deptInfo = deptInfo;
	}*/
	
	
	
}
