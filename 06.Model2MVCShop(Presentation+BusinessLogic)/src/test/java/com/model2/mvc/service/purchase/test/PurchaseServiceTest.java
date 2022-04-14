package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml"})
public class PurchaseServiceTest {
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	//@Test
	public void testAddPurcahse() throws Exception{
		Purchase p = new Purchase();
		Product pro = new Product();
		User u = new User();
		
		pro.setProdNo(10000);
		p.setPurchaseProd(pro);
		
		u.setUserId("user02");
		p.setBuyer(u);
		
		p.setPaymentOption("1");
		p.setTranCode("1");
		p.setPurchaseStock(2);
		
		purchaseService.addPurchase(p);		
		
		p = purchaseService.getPurcahse(10066);
		System.out.println("°á°ú°ª >>>>>>>>>>>>> "+p);
		
		Assert.assertEquals("user02", p.getBuyer().getUserId());
	}
	
	//@Test
	public void testGetPurchase() throws Exception {
		Purchase p = purchaseService.getPurcahse(10064);
		System.out.println("°á°ú°ª >>>>>>>>>>>>> "+p);
	}
	
	//@Test
	public void testUpdatePurchase() throws Exception {
		Purchase p = new Purchase();
		Product pro = new Product();
		User u = new User();
		
		pro.setProdNo(10000);
		u.setUserId("user02");
		
		p.setTranNo(10071);
		p.setPurchaseProd(pro);
		p.setBuyer(u);
		p.setDivyRequest("»¡¸®Á»¿À¼À");
		purchaseService.updatePurchase(p);
		
		p = purchaseService.getPurcahse(10071);
		System.out.println("°á°ú°ª>>>>>> "+p);
		Assert.assertEquals("»¡¸®Á»¿À¼À", p.getDivyRequest());
	}
	
	//@Test
	public void testUpdateCode() throws Exception {
		Purchase p = new Purchase();
		p.setTranNo(10071);
		p.setTranCode("2");
		
		purchaseService.updateTranCode(p);
		p= purchaseService.getPurcahse(10071);
		System.out.println(p);
		
		Assert.assertEquals("2  ", p.getTranCode());
	}
	
	//@Test
	public void testGetPurchaseListAll() throws Exception {
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		
		Map<String,Object> map = purchaseService.getPurchaseList(search, "user01");
		List<Purchase> list = (List<Purchase>)map.get("list");
		
		for (Purchase purchase : list) {
			System.out.println(purchase);
		}
		
		System.out.println((Integer)map.get("totalCount"));
	}
	
	@Test
	public void testGetSaleListAll() throws Exception{
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchValue("0");
		Map<String, Object> map = purchaseService.getSaleList(search);
		
		List<Purchase> list = (List<Purchase>)map.get("list");
		
		for (Purchase purchase : list) {
			System.out.println(purchase);
		}
	}
}
