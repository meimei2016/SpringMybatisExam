package com.hand.SpringMybatisExam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.SpringMybatisExam.bean.Inventory;

public class InventoryManageDao extends SqlSessionDaoSupport{
	private static final String className=Inventory.class.getName();

	public List<com.hand.SpringMybatisExam.bean.Inventory> getInventoryByFilmId(int filmId){		
		String sqlId=".getInventoryByFilmId";
		List<Inventory> list=getSqlSession().selectList(className+sqlId, filmId);
		return list;
	}
	
	public int deleteByFilmId(int filmId){
		String sqlId=".deleteByFilmId";
		int i=getSqlSession().delete(className+sqlId, filmId);
		return i;
	}

}
