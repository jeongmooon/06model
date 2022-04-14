package com.model2.mvc.service.stock.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.stock.StockDao;

@Repository("stockDaoImpl")
public class StockDaoImpl implements StockDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public StockDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public List<Product> getStockList(List<Product> productList) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("StockMapper.getStockList",productList);
	}

	@Override
	public void updateStock(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("StockMapper.updateStock",product);
	}

}
