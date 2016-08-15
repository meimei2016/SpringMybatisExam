package com.hand.SpringMybatisExam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.SpringMybatisExam.bean.Language;

public class LanguageManageDao extends SqlSessionDaoSupport {
	private static final String className=com.hand.SpringMybatisExam.bean.Language.class.getName();
	public List<Language> getAllLanguage() {
		String sqlId=".selectAllLanguage";
		List<Language> list=getSqlSession().selectList(className+sqlId);
		return list;
	}

	public Language getLanguage(String title) {
		String sqlId=".getLanguageByName";
		Language language=getSqlSession().selectOne(className+sqlId,title);
		return language;
	}

}
