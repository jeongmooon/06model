package com.model2.mvc.service.purchase;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseService {
	public Product addPurchasView(int prodNo) throws Exception;
	
	public void addPurchase(Purchase purchase) throws Exception;
	
	public Purchase getPurcahse(int tranNo) throws Exception;
	
	public Map<String,Object> getPurchaseList(Search search,String userId) throws Exception;
	
	public Map<String,Object> getSaleList(Search search) throws Exception;
	
	public void updatePurchase(Purchase purchase) throws Exception;
	
	public void updateTranCode(Purchase purchase) throws Exception;
}
