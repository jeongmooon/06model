package com.model2.mvc.service.starNum.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.StarNum;
import com.model2.mvc.service.starNum.StarNumDao;

@Repository("starNumDaoImpl")
public class StarNumDaoImpl implements StarNumDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public StarNumDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addStarNum(StarNum starNum) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("StarNumMapper.addStarNum",starNum);
	}

}
