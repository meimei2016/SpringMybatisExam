package com.hand.SpringMybatisExam.service;

import java.util.List;

import com.hand.SpringMybatisExam.bean.Film;

public interface FilmsManageService {

	public List<Film>getAllFilm();
	
	public int addFilm(Film film);
	
	public int deleteFilm(int filmId);
	public int modifyFilmById(Film film);
}
