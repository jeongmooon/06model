package com.model2.mvc.service.starNum.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.StarNum;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.starNum.StarNumDao;
import com.model2.mvc.service.starNum.StarNumService;

@Service("starNumServiceImpl")
public class StarNumServiceImpl implements StarNumService {
	
	@Autowired
	@Qualifier("starNumDaoImpl")
	private StarNumDao starNumDao;
	
	public StarNumServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addStarNum(StarNum starNum) throws Exception {
		// TODO Auto-generated method stub
		starNumDao.addStarNum(starNum);
	}

}
