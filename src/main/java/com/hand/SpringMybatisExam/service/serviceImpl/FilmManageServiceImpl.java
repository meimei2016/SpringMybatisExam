package com.hand.SpringMybatisExam.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.SpringMybatisExam.bean.Film;
import com.hand.SpringMybatisExam.bean.Language;
import com.hand.SpringMybatisExam.dao.FilmsManageDao;
import com.hand.SpringMybatisExam.dao.LanguageManageDao;
import com.hand.SpringMybatisExam.service.FilmsManageService;

public class FilmManageServiceImpl implements FilmsManageService{
	@Autowired
	private FilmsManageDao filmsManageDao;
	@Autowired
	private LanguageManageDao languageManageDao;

	
	public void setLanguageManageDao(
			LanguageManageDao languageManageDaoImpl) {
		this.languageManageDao = languageManageDaoImpl;
	}
	public void setFilmsManageDao(FilmsManageDao filmsManageDaoImpl){
		this.filmsManageDao=filmsManageDaoImpl;
	}
	public List<Film>getAllFilm(){
		List<Film> list=filmsManageDao.getAllFilm();
		return list;
	}
	
	public int addFilm(Film film){
		int languageId=languageManageDao.getLanguage(film.getLanguage()).getLanguage_id();
		
		
		int result=filmsManageDao.addFilm(film,languageId);
		
		return result;
	}
	
	public int deleteFilm(int filmId){
		int result=filmsManageDao.deleteFilmRefer(filmId);
		return result;
	}
	public int modifyFilmById(Film film){
		Language language=languageManageDao.getLanguage(film.getLanguage());
		int result=filmsManageDao.modifyFilmById(film,language);
		return result;
	}

}
