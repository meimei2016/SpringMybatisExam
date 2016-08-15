package com.hand.SpringMybatisExam.Util;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.SpringMybatisExam.bean.Customer;
import com.hand.SpringMybatisExam.service.AddressManageService;
import com.hand.SpringMybatisExam.service.CustomerManageService;

public class CustomerDataPrepare {
	@Autowired
	private AddressManageService addressManageService;
	@Autowired
	private CustomerManageService customerManageService;
	
	Customer customer=new Customer();
	
	public Customer getCustomerInfo(){
		customer.setStore_id(1);
		System.out.println("请输入FirstName(first_name):");
		Scanner scn=new Scanner(System.in);		
		String firstName=scn.next().trim();
		if(!firstName.isEmpty()){
			customer.setFirst_name(firstName);
			System.out.println("请输入LastName(last_name):");
			String lastName=scn.next().trim();
			if(!lastName.isEmpty()){
				customer.setLast_name(lastName);
				System.out.println("请输入Email(email):");
				String email=scn.next().trim();
				if(email.matches("[\\w]*@[\\w]*\\.com$")){
					customer.setEmail(email);
					System.out.println("请输入AddressId:");
					int addressId=scn.nextInt();
					customer.setAddress_id(addressId);
				}
			}
		}
		scn.close();
		return customer;		
	}
	public void dataCheck(){
		int i=addressManageService.addressIdCheck(customer.getAddress_id());
		if(i>0){
			customerManageService.addCustomer(customer);
		}else{
			System.out.println("你输入的AddressID不存在,请重新输入:");
			Scanner scn3=new Scanner(System.in);
			int addressId=scn3.nextInt();
			customer.setAddress_id(addressId);
			scn3.close();
			dataCheck();
		}		
	}
	
	public void outPutLastCustomer(){
		Customer customer1=customerManageService.getLastCustomer();	
		System.out.println("first_name:"+customer1.getFirst_name());
		System.out.println("last_name:"+customer1.getLast_name());
		System.out.println("email:"+customer1.getEmail());
		System.out.println("address="+customer1.getAddress());
		System.out.println("create_date="+customer1.getCreate_date());
	}
	
	public void deleteCustomerById(){
		Scanner scn1=new Scanner(System.in);
		int customerId=scn1.nextInt();
		int i=customerManageService.deleteCustomerById(customerId);
		if(i>0){
			System.out.println("你输入的ID为"+customerId+"的Customer已经删除.");
			scn1.close();
		}else{
			System.out.println("你输入的Customer的ID不存在,请重新输入:");
			deleteCustomerById();
			
		}
	}
}
