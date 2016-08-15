package com.hand.SpringMybatisExam.service;

import com.hand.SpringMybatisExam.bean.Customer;

public interface CustomerManageService {
	public int addCustomer(Customer customer);
	public Customer getLastCustomer();
	public int deleteCustomerById(int customerId);

}
