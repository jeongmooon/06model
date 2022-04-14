package com.model2.mvc.service.stock;

import java.util.List;

import com.model2.mvc.service.domain.Product;

public interface StockService {
	public void updateStock(Product product) throws Exception;
	public List<Product> getStockList(List<Product> productList) throws Exception;
}
