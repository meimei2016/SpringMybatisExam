package com.hand.SpringMybatisExam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.hand.SpringMybatisExam.bean.Film;
import com.hand.SpringMybatisExam.bean.Inventory;
import com.hand.SpringMybatisExam.bean.Language;

public class FilmsManageDao extends SqlSessionDaoSupport {
	private static final String className=Film.class.getName();
	@Autowired
	RentalManageDao rentalManageDao;
	@Autowired
	InventoryManageDao inventoryManageDao;

	public List<Film> getAllFilm() {
		String sqlId=".queryAll";
		List<Film> list=getSqlSession().selectList(className+sqlId);
		return list;
	}


	public int addFilm(Film f, int languageId) {
		String sqlId=".addFilm";
		f.setLanguage_id(languageId);
		int i=getSqlSession().insert(className+sqlId, f);
		return i;
	}


	public int deleteFilm(String sql, int film_id) {
		String sqlId=".deleteFilmByID";
		int i=getSqlSession().delete(className+sqlId, film_id);
		return i;
	}


	public int deleteFilmRefer(int film_id) {
		String sqlId1=".deleteFilmActorByID";
		String sqlId2=".deleteFilmCategoryByID";
		String sqlId3=".deleteFilmByID";
		int i=0;
		if(film_id!=0){
			
			List<Inventory> list=inventoryManageDao.getInventoryByFilmId(film_id);
			for(Inventory inventory:list){
				rentalManageDao.deleteRentalByInventoryId(inventory.getInventory_id());
			}
			getSqlSession().delete(className+sqlId1, film_id);
			getSqlSession().delete(className+sqlId2, film_id);
			inventoryManageDao.deleteByFilmId(film_id);
			i=getSqlSession().delete(className+sqlId3, film_id);			
		}
		return i;
	}


	public int modifyFilmById(Film f, Language language) {
		String sqlId=className+".modifyFilm";
		f.setLanguage_id(language.getLanguage_id());
		int i=getSqlSession().update(sqlId, f);
		return i;
	}

}
