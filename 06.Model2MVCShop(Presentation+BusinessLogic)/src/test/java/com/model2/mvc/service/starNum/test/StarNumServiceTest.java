package com.model2.mvc.service.starNum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.domain.StarNum;
import com.model2.mvc.service.starNum.StarNumService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml"})
public class StarNumServiceTest {
	
	@Autowired
	@Qualifier("starNumServiceImpl")
	private StarNumService starNumService;
	
	@Test
	public void testAddStarNum() throws Exception {
		StarNum s = new StarNum();
		s.setScore(8);
		s.setProdNo(10000);
		s.setUserId("user01");
		s.setReview("������ ��ǻ���ε�");
		s.setCheckB("1");
		
		starNumService.addStarNum(s);		
	}
}
