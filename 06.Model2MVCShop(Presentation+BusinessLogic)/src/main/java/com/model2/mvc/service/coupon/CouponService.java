package com.model2.mvc.service.coupon;

import java.util.List;

import com.model2.mvc.service.domain.Coupon;

public interface CouponService {
	public void addCoupon(Coupon coupon) throws Exception;
	public void upadteCoupon(Coupon coupon) throws Exception;
	public List<Coupon> getCuponList(String userId) throws Exception;
}
