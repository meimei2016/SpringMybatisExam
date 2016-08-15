package com.hand.SpringMybatisExam.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.SpringMybatisExam.bean.Address;

public class AddressManageDao extends SqlSessionDaoSupport {
	private static final String className= Address.class.getName();
	public int addressIdCheck(int addressId){
		String sqlId=".getAddressId";
		int result=getSqlSession().selectOne(className+sqlId, addressId);
		return result;
	}

}
