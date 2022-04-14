package com.model2.mvc.service.coupon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.coupon.CouponDao;
import com.model2.mvc.service.coupon.CouponService;
import com.model2.mvc.service.domain.Coupon;

@Service("couponServiceImpl")
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	@Qualifier("couponDaoImpl")
	private CouponDao couponDao;
	
	public CouponServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public void addCoupon(Coupon coupon) throws Exception {
		// TODO Auto-generated method stub
		couponDao.addCoupon(coupon);
	}

	@Override
	public void upadteCoupon(Coupon coupon) throws Exception {
		// TODO Auto-generated method stub
		couponDao.updateCoupon(coupon);
	}

	@Override
	public List<Coupon> getCuponList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return couponDao.getCoupon(userId);
	}

}
