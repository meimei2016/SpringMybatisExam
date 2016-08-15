package com.hand.SpringMybatisExam.service.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


public class AddFilmEventListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof BeforeInsertFilmEvent){
			System.out.println("Before Insert Customer Data");
		}
		if(event instanceof AfterInsertFilmEvent){
			System.out.println("After Insert Customer Data");
			
		}
		
	}
}
