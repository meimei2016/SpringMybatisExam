package com.hand.SpringMybatisExam.service.event;

import org.springframework.context.ApplicationEvent;

public class BeforeInsertFilmEvent extends ApplicationEvent {

	public BeforeInsertFilmEvent(Object source) {
		super(source);
		System.out.println(source);
	}

	private static final long serialVersionUID = 6849292368251796231L;


}
