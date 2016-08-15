package com.hand.SpringMybatisExam.service.serviceImpl;

import java.util.List;

import com.hand.SpringMybatisExam.bean.Language;
import com.hand.SpringMybatisExam.dao.LanguageManageDao;
import com.hand.SpringMybatisExam.service.LanguageManageService;

public class LanguageManageServiceImpl implements LanguageManageService{
	LanguageManageDao languageManageDao;
	public void setLanguageManageDao(LanguageManageDao languageManageDaoImpl){
		this.languageManageDao=languageManageDaoImpl;
	}
	public List<Language> getAllLanguage(){
		List<Language> list=languageManageDao.getAllLanguage();
		return list;
	}

}
