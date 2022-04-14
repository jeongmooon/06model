package com.model2.mvc.service.coupon.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.coupon.CouponService;
import com.model2.mvc.service.domain.Coupon;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml"})
public class CouponServiceTest {
	@Autowired
	@Qualifier("couponServiceImpl")
	private CouponService couponService;
	
	//@Test
	public void testGetCoupon() throws Exception{
		List<Coupon> list =couponService.getCuponList("user01");
		
		for (Coupon coupon : list) {
			System.out.println(coupon);
		}
	}

}
