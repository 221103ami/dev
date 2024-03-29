package com.kh.app.gallery.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.gallery.vo.GalleryVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class GalleryDao {

	public List<GalleryVo> getGalleryList(SqlSessionTemplate sst) {
		return sst.selectList("gallery.getGalleryList");
	}

	public int write(SqlSessionTemplate sst, GalleryVo vo) {
		return sst.insert("gallery.write" , vo);
	}

	public GalleryVo getGallery(SqlSessionTemplate sst, String no) {
		return sst.selectOne("gallery.getGallery" , no);
	}

	public int del(SqlSessionTemplate sst, String no) {
		return sst.update("gallery.del" , no);
	}

	public int edit(SqlSessionTemplate sst, GalleryVo vo) {
		log.info(vo.toString());
		return sst.update("gallery.edit" , vo);
	}

}//class




























