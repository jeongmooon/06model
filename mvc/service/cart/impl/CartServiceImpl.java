package com.model2.mvc.service.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.cart.CartDao;
import com.model2.mvc.service.cart.CartService;
import com.model2.mvc.service.domain.Cart;

@Service("cartServiceImpl")
public class CartServiceImpl implements CartService {
	@Autowired
	@Qualifier("cartDaoImpl")
	private CartDao cartDao;
	
	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		cartDao.addCart(cart);
	}

	@Override
	public List<Cart> getCart(String userId) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getCart(userId);
	}

	@Override
	public void updateCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		cartDao.updateCart(cart);
	}

}
