package com.hand.SpringMybatisExam;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringMybatisExam.Util.CustomerDataPrepare;

public class DeleteCustomer {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		CustomerDataPrepare customerDataPrepare = (new ClassPathXmlApplicationContext(
				"ApplicationContext.xml")).getBean("customerDataPrepare",
				CustomerDataPrepare.class);
		Scanner scn=new Scanner(System.in);
		System.out.println("请输入要删除的Customer的ID:");
		customerDataPrepare.deleteCustomerById(scn);
		//System.exit(0);
	}

}
