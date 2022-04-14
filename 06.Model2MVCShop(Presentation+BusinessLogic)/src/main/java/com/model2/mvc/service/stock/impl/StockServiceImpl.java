package com.model2.mvc.service.stock.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.stock.StockDao;
import com.model2.mvc.service.stock.StockService;

@Service("stockServiceImpl")
public class StockServiceImpl implements StockService {
	
	@Autowired
	@Qualifier("stockDaoImpl")
	private StockDao stockDao;
	
	public StockServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public void updateStock(Product product) throws Exception {
		// TODO Auto-generated method stub
		stockDao.updateStock(product);
	}

	@Override
	public List<Product> getStockList(List<Product> productList) throws Exception {
		// TODO Auto-generated method stub
		return stockDao.getStockList(productList);
	}

}
