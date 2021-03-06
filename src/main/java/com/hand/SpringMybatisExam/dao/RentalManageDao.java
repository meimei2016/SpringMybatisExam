package com.hand.SpringMybatisExam.dao;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class RentalManageDao extends SqlSessionDaoSupport {
	private static final String className=com.hand.SpringMybatisExam.bean.Rental.class.getName();
	public int deleteRentalByInventoryId(int inventoryId){
		String sqlId=".deleteRentalById";
		int i=getSqlSession().delete(className+sqlId, inventoryId);
		return i;
	}
	public int deleteRentalByCustomerId(int customer_id){
		String sqlId=".deleteRentalByCustomerId";
		int i=getSqlSession().delete(className+sqlId, customer_id);
		return i;
	}
}
