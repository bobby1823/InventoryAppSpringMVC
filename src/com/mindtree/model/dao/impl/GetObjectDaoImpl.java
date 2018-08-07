package com.mindtree.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.beans.DeptInfoTable;
import com.mindtree.beans.InventoryUpdateTable;
import com.mindtree.beans.ProductTable;
import com.mindtree.beans.StoreInfo;
import com.mindtree.hibernate.util.HibernateConfig;
import com.mindtree.model.dao.GetObjectDao;

@Repository
public class GetObjectDaoImpl implements GetObjectDao{

	//@Autowired
	StoreInfo storeInfo = new StoreInfo();
	
	@Override
	@Transactional
	public Object get(int storeId, String entityName) {
		Session session = HibernateConfig.openSession();
		if(entityName.equalsIgnoreCase("StoreInfo"))
			return session.get(StoreInfo.class, storeId);
		else
			return session.get(DeptInfoTable.class, storeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Object getProduct(int productId, int storeId, int deptId, Object object) {
		Session session = HibernateConfig.openSession();
		if(object.getClass().getName().contains("ProductTable")){
			List<InventoryUpdateTable> productList = session.createQuery("from InventoryUpdateTable where productId="+productId+" and deptId="+deptId).list();
			if(productList.size()<=0) {
				return null;
			}
			else{
				ProductTable updateTable = new ProductTable();
				updateTable.setBatchDate(productList.get(0).getBatchDate());
				updateTable.setBatchNum(productList.get(0).getBatchNum());
				updateTable.setDeptInfo(productList.get(0).getDeptInfo());
				updateTable.setMrp(productList.get(0).getMrp());
				updateTable.setProductId(productList.get(0).getProductId());
				updateTable.setProductName(productList.get(0).getProductName());
				updateTable.setQuantity(productList.get(0).getQuantity());
				updateTable.setStoreInfo(productList.get(0).getStoreInfo());
				updateTable.setVendor(productList.get(0).getVendor());
				return updateTable;
			}
		}
		else {
			List<InventoryUpdateTable> inventoryProductList = session.createQuery("from InventoryUpdateTable where productId="+productId+" and deptId="+deptId).list();
			return inventoryProductList.get(0);	
		}
	}

	@Override
	public ProductTable getProductTable(int productId, int storeId, int deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public static void main(String args[]) {
		GetObjectDaoImpl dao = new GetObjectDaoImpl();
		//List theList = new ArrayList(dao.getProduct(1, 2, 2, new InventoryUpdateTable()));
		ProductTable product = new ProductTable();
		System.out.println(product.getClass().getName());
		System.out.println(dao.getProduct(5, 2, 1, new ProductTable()));
	}*/
}
