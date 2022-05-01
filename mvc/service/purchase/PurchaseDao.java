package com.model2.mvc.service.purchase;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseDao {
	public void addPurchase(Purchase purchase) throws Exception;
	public Purchase getPurchase(int tranNo) throws Exception;
	public List<Purchase> getPurchaseList(Search search,String userId) throws Exception;
	public List<Purchase> getSaleList(Search search) throws Exception;
	public void updatePurchase(Purchase purcahse) throws Exception;
	public void updateTranCode(Purchase purcahse) throws Exception;
	public int getTotalCount(Search search,String userId) throws Exception;
	public int getTotalSaleCount(Search search) throws Exception;
}
