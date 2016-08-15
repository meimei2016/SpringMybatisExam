package com.hand.SpringMybatisExam.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.SpringMybatisExam.bean.Customer;

public class CustomerManageDao extends SqlSessionDaoSupport {
	private static final String className=Customer.class.getName();
	public int getUserName(String userName) {
		String sqlId=".getUserByName";
		int result=getSqlSession().selectOne(className+sqlId,userName);
		return result;
	}
	
	public Customer getLastCustomer(){
		String sqlId=".getCustomerByFistName";
		Customer customer=getSqlSession().selectOne(className+sqlId);
		return customer;
	}
	
	public int insertCustomer(Customer customer){
		String sqlId=".addCustormer";
		int i=getSqlSession().insert(className+sqlId, customer);
		return i;
	}

	public int deleteCustomerById(int customerId) {
		String sqlId=".deleteCustomerById";
		int i=getSqlSession().delete(className+sqlId, customerId);
		return i;
	}

}
