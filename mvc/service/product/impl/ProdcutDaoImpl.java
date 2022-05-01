package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDao;

@Repository("productDaoImpl")
public class ProdcutDaoImpl implements ProductDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public ProdcutDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public void addProdcut(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("ProductMapper.addProduct",product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ProductMapper.getProduct",prodNo);
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(search.getSearchValue());
		if(search.getSearchValue().equals("5,0") || search.getSearchValue().equals("5")) {
			search.setSearchValue("5");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+search.getSearchKeyword().split(",")[0]);
			map.put("rowPrice", new Integer(search.getSearchKeyword().split(",")[0]));
			map.put("highPrice", new Integer(search.getSearchKeyword().split(",")[1]));
		}
		
		User user = new User();
		user.setAddr("%박달%");
		map.put("user",user);
		map.put("search", search);
		return sqlSession.selectList("ProductMapper.getProductList",map);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("ProductMapper.updateProduct",product);		
	}
	
	@Override
	public void updateStatus(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("ProductMapper.updateStatusProduct",product);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub		
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(search.getSearchValue());
		if(search.getSearchValue().equals("5")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+search.getSearchKeyword().split(",")[0]);
			map.put("rowPrice", new Integer(search.getSearchKeyword().split(",")[0]));
			map.put("highPrice", new Integer(search.getSearchKeyword().split(",")[1]));
		}
		
		User user = new User();
		user.setAddr("%박달%");
		map.put("user",user);
		map.put("search", search);
		
		return sqlSession.selectOne("ProductMapper.getTotalCount",map);
	}

}
