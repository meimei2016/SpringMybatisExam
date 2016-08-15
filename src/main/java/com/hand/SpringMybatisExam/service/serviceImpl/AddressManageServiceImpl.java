package com.hand.SpringMybatisExam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.SpringMybatisExam.dao.AddressManageDao;
import com.hand.SpringMybatisExam.service.AddressManageService;

public class AddressManageServiceImpl implements AddressManageService{
	@Autowired
	private AddressManageDao addressManageDao;
	@Override
	public int addressIdCheck(int addressId) {
		int result=addressManageDao.addressIdCheck(addressId);
		return result;
	}

}
