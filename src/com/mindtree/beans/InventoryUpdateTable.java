package com.mindtree.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="inventoryupdate")
@IdClass(InventoryUpdateCompoundTable.class)
public class InventoryUpdateTable {

	public InventoryUpdateTable() {
		
	}
	
	public InventoryUpdateTable(int productId, String productName, String vendor, double mrp, String batchNum,
			Date batchDate, int quantity, String operationType, String status) {
		this.productId = productId;
		this.productName = productName;
		this.vendor = vendor;
		this.mrp = mrp;
		this.batchNum = batchNum;
		this.batchDate = batchDate;
		this.quantity = quantity;
		this.operationType = operationType;
		this.status = status;
	}



	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	@Id
	@ManyToOne(cascade={
			CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	)
	@JoinColumn(name="storeId")
	private StoreInfo storeInfo ;
	
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
	
	//@JoinColumn(name="deptId")
	@Column(name="deptId")
	private int deptInfo;
	
	@Column(name="operationType")
	private String operationType;
	
	@Column(name="status")
	private String status;

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

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	public int getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(int deptInfo) {
		this.deptInfo = deptInfo;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InventoryUpdateTable [productId=" + productId + ", productName=" + productName + ", vendor=" + vendor
				+ ", mrp=" + mrp + ", batchNum=" + batchNum + ", batchDate=" + batchDate + ", quantity=" + quantity
				+ ", storeInfo=" + storeInfo + ", deptInfo=" + deptInfo + ", operationType=" + operationType
				+ ", status=" + status + "]";
	}
	
	
}
