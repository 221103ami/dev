package com.kh.app.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.vo.GalleryVo;

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

	
	public List<GalleryVo> getGalleryList() {
		return dao.getGalleryList(sst);
	}


	public int write(GalleryVo vo) {
		return dao.write(sst, vo);
	}


	public GalleryVo getGallery(String no) {
		return dao.getGallery(sst, no);
	}
	
	
}//class
















