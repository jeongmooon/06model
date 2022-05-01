package com.model2.mvc.service.cart.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.cart.CartDao;
import com.model2.mvc.service.domain.Cart;

@Repository("cartDaoImpl")
public class CartDaoImpl implements CartDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public CartDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void addCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("CartMapper.addCart", cart);
	}
	@Override
	public List<Cart> getCart(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CartMapper.getCart",userId);
	}
	@Override
	public void updateCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("CartMapper.updateCart", cart);
	}
	
}
