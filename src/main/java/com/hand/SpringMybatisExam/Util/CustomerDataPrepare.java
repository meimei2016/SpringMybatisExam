package com.hand.SpringMybatisExam.Util;

import java.util.InputMismatchException;
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
	
	public Customer getCustomerInfo(Scanner scn){
		customer.setStore_id(1);
		System.out.println("请输入FirstName(first_name):");	
		String firstName=scn.next().trim();
		if(!firstName.isEmpty()){
			customer.setFirst_name(firstName);
			System.out.println("请输入LastName(last_name):");
			String lastName=scn.next().trim();
			if(!lastName.isEmpty()){
				customer.setLast_name(lastName);
				System.out.println("请输入Email(email):");
				boolean c=true;
				String email="";
				do{
					email=scn.next().trim();
					if(email.matches("[\\w]*@[\\w]*\\.com$")){
						customer.setEmail(email);
						getAddressId(scn);
						c=false;
					}else{
						System.out.println("您输入的Email格式不对:");
					}
				}while(c);
			}
		}
		return customer;		
	}
	public void dataCheck(Scanner scn){
		int i=addressManageService.addressIdCheck(customer.getAddress_id());
		if(i>0){
			customerManageService.addCustomer(customer);
		}else{
			System.out.println("你输入的AddressID不存在,请重新输入:");
			int addressId=scn.nextInt();
			customer.setAddress_id(addressId);
			dataCheck(scn);
		}		
	}
	public void outPutLastCustomer(){
		System.out.println("已保存的数据如下：");
		Customer customer1=customerManageService.getLastCustomer();	
		System.out.println("ID:"+customer1.getCustomer_id());
		System.out.println("FirstName:"+customer1.getFirst_name());
		System.out.println("LastName:"+customer1.getLast_name());
		System.out.println("Email:"+customer1.getEmail());
		System.out.println("Address:"+customer1.getAddress());
		System.out.println("CreateDate:"+customer1.getCreate_date());
	}
	
	public void deleteCustomerById(Scanner scn){
		int customerId=0;
		int i=0;
		boolean a=true;
		System.out.println("请输入要删除的Customer的ID:");
		do{
			customerId=scn.nextInt();
			i=customerManageService.deleteCustomerById(customerId);
			if(i>0){
				System.out.println("你输入的ID为"+customerId+"的Customer已经删除.");
				a=false;
			}else{
				System.out.println("你输入的Customer的ID不存在,请重新输入:");
			}
		}while(a);
	}
	
	public void getAddressId(Scanner scn){
		boolean check=true;
		int addressId=0;
		System.out.println("请输入AddressId:");
		do{
			try{
				addressId=scn.nextInt();
				if(addressId>0){
					customer.setAddress_id(addressId);
					check=false;
				}else{
					System.out.println("输入错误，请输入一个正整数");	
				}
			}catch (InputMismatchException e){
				System.out.println("输入错误，请输入一个整数");
			}						
		}while(check);
	}
}
