package com.hand.SpringMybatisExam.service.serviceImpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hand.SpringMybatisExam.bean.Customer;
import com.hand.SpringMybatisExam.dao.CustomerManageDao;
import com.hand.SpringMybatisExam.service.CustomerManageService;
import com.hand.SpringMybatisExam.service.event.AfterInsertFilmEvent;
import com.hand.SpringMybatisExam.service.event.BeforeInsertFilmEvent;

public class CustomerManageServiceImpl implements  CustomerManageService , ApplicationContextAware {
	@Autowired
	private CustomerManageDao customerManageDao;
	@Autowired
	private ApplicationContext ac;
	@Override
	public void setApplicationContext(ApplicationContext arg)
			throws BeansException {
		ac=arg;
	}
	@Override
	public int addCustomer(Customer customer) {
		int result=0;
		String before="";
		String after="After Insert Customer Data";
		ac.publishEvent(new BeforeInsertFilmEvent(before));
		result=customerManageDao.insertCustomer(customer);
		if(result>0){
			ac.publishEvent(new AfterInsertFilmEvent(after));
		}
		return result;
	}
	@Override
	public Customer getLastCustomer() {
		Customer Customer=customerManageDao.getLastCustomer();
		return Customer;
	}

	@Override
	public int deleteCustomerById(int customerId) {
		int i=customerManageDao.deleteCustomerById(customerId);
		return i;
	}

}
