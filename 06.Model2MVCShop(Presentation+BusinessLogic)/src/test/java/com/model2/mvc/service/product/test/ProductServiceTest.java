package com.model2.mvc.service.product.test;

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
import com.model2.mvc.service.product.ProductService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml"})
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	//@Test
	public void testAddProduct() throws Exception{
		Product pro	 = new Product();
		pro.setProdName("±èÄ¡2");
		pro.setManuDate("12343322");
		pro.setProdDetail("¸ÀÀÖ´Ù!");
		pro.setPrice(10000);
		
		Search search = new Search();
		search.setSearchCondition("2");
		search.setSearchKeyword(pro.getProdName());
		search.setSearchValue("0");
		
		productService.addProduct(pro);
	}
	
	@Test
	public void testGetProduct() throws Exception{
		Product pro	 = new Product();
		
		pro = productService.getProduct(10080);
		
		System.out.println(pro);
		Assert.assertEquals("ÅÁ¼öÀ°", pro.getProdName());
		Assert.assertEquals("12343322", pro.getManuDate());
		Assert.assertEquals("´Þ´ÞÇÏ´Ù", pro.getProdDetail());
		Assert.assertEquals(100000, pro.getPrice());		
	}
	
	//@Test
	public void testUpateProduct() throws Exception{
		Product pro	 = new Product();		
		pro = productService.getProduct(10080);
		System.out.println("±âÁ¸ °ª : >>>>>>>>>> "+pro);
		
		Assert.assertNotNull(pro);
		Assert.assertEquals("±èÄ¡", pro.getProdName());
		Assert.assertEquals("12343322", pro.getManuDate());
		Assert.assertEquals("¸ÀÀÖ´Ù!", pro.getProdDetail());
		Assert.assertEquals(10000, pro.getPrice());	
		
		pro.setProdName("ÅÁ¼öÀ°");
		pro.setProdDetail("´Þ´ÞÇÏ´Ù");
		pro.setPrice(100000);
		
		productService.updateProduct(pro);
		
		pro = productService.getProduct(10080);
		System.out.println("¹Ù²ï °ª : >>>>>>>>>> "+pro);
		
		Assert.assertEquals("ÅÁ¼öÀ°", pro.getProdName());
		Assert.assertEquals("´Þ´ÞÇÏ´Ù", pro.getProdDetail());
		Assert.assertEquals(100000, pro.getPrice());	
	}
	
	//@Test
	public void testGetProductListAll() throws Exception {
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchValue("0");
		Map<String, Object> map = productService.getProductList(search);
		
		List<Product> list = (List<Product>)map.get("list");
		Assert.assertEquals(3, list.size());
		
		System.out.println("=======================================");
		
		for (Product product : list) {
			System.out.println("°á°ú°ª >>>>>>>>>>>>> "+product);
			System.out.println("Àç°í°ª >>>>>>>>>>>>> "+product.getStock());
			System.out.println("=======================================");
		}
		
		Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Product>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	}
	
	//@Test
	public void testGetProductByProdNo() throws Exception {
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchValue("0");
		search.setSearchCondition("1");
		search.setSearchKeyword("10080");
		
		Map<String,Object> map = productService.getProductList(search);
		
		List<Product>  list = (List<Product>)map.get("list");
		Assert.assertEquals(1, list.size());
		
		System.out.println("°á°ú °ª >>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+list.get(0));
	}
	
	//@Test
	public void testGetProductByProdName() throws Exception {
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchValue("0");
		search.setSearchCondition("2");
		search.setSearchKeyword("ÅÁ¼öÀ°");
		
		Map<String,Object> map = productService.getProductList(search);
		
		List<Product>  list = (List<Product>)map.get("list");
		Assert.assertEquals(1, list.size());
		
		System.out.println("°á°ú °ª >>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+list.get(0));
		Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
		
	}
}
