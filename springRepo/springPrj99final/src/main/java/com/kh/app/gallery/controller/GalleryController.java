package com.kh.app.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	private final GalleryService gs;
	
	@Autowired
	public GalleryController(GalleryService gs) {
		this.gs = gs;
	}

	//작성(화면)
	@GetMapping("write")
	public String write() {
		return "gallery/write";
	}
	
	//작성
	@PostMapping("write")
	public String write(GalleryVo vo) {
		return "redirect:/home";
	}
	
	//목록 조회
	@GetMapping("list")
	public String list() {
		return "gallery/list";
	}
	
	//상세 조회
	@GetMapping("detail")
	public String detail(String no) {
		return "gallery/detail";
	}
	
	//수정 (화면)
	@GetMapping("edit")
	public String edit() {
		return "gallery/edit";
	}
	
	//수정
	@PostMapping("edit")
	public String edit(GalleryVo vo) {
		return "redirect:/home";
	}
	
	//삭제
	@GetMapping("del")
	public String del(String no) {
		return "redirect:/home";
	}

}



