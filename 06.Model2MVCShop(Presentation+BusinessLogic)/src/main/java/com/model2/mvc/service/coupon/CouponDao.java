package com.model2.mvc.service.coupon;

import java.util.List;

import com.model2.mvc.service.domain.Coupon;

public interface CouponDao {
	public void addCoupon(Coupon coupon) throws Exception;
	public List<Coupon> getCoupon(String userId) throws Exception;
	public void updateCoupon(Coupon coupon) throws Exception;
}
