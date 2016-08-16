package com.hand.SpringMybatisExam.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.hand.SpringMybatisExam.Util.CustomerDataPrepare;


public class AddFilmEventListener implements ApplicationListener<ApplicationEvent> {
	@Autowired
	CustomerDataPrepare customerDataPrepare;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof BeforeInsertFilmEvent){
			System.out.println("Before Insert Customer Data");
		}
		if(event instanceof AfterInsertFilmEvent){
			customerDataPrepare.outPutLastCustomer();
			System.out.println("After Insert Customer Data");
			
		}
		
	}
}
