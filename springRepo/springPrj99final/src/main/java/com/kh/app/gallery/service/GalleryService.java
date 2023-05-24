package com.kh.app.gallery.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.gallery.dao.GalleryDao;

@Service
@Transactional
public class GalleryService {
	
	private final GalleryDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public GalleryService(GalleryDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}
	
	

	

}
