package com.model2.mvc.service.coupon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.coupon.CouponDao;
import com.model2.mvc.service.domain.Coupon;

@Repository("couponDaoImpl")
public class CouponDaoImpl implements CouponDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public CouponDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public void addCoupon(Coupon coupon) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("CouponMapper.addCoupon",coupon);
	}

	@Override
	public List<Coupon> getCoupon(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CouponMapper.getCoupon",userId);
	}

	@Override
	public void updateCoupon(Coupon coupon) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("CouponMapper.addCoupon",coupon);
	}

}
