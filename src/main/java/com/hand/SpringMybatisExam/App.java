package com.hand.SpringMybatisExam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringMybatisExam.Util.CustomerDataPrepare;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		CustomerDataPrepare customerDataPrepare = (new ClassPathXmlApplicationContext(
				"ApplicationContext.xml")).getBean("customerDataPrepare",
				CustomerDataPrepare.class);
		customerDataPrepare.getCustomerInfo();
		customerDataPrepare.dataCheck();
		
	}
}
