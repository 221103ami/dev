package com.kh.app.gallery.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.common.file.FileUploader;
import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;
import com.kh.app.member.vo.MemberVo;

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
	public String write(@SessionAttribute(required = false) MemberVo loginMember) {
		//로그인 상태 체크
		if(loginMember == null) {
			throw new IllegalStateException("로그인 하고 오세요");
		}
		return "gallery/write";
	}
	
	//작성
	@PostMapping("write")
	public String write(HttpServletRequest req, MultipartFile f, GalleryVo vo , @SessionAttribute MemberVo loginMember) {
		//로그인 상태 체크
		if(loginMember == null) {
			throw new IllegalStateException("로그인 하고 오세요");
		}
		String path = req.getServletContext().getRealPath("/resources/upload/gallery/");
		String changeName = FileUploader.upload(f, path);
		
		String writerNo = loginMember.getNo();
		String originName = f.getOriginalFilename();
		
		vo.setWriterNo(writerNo);
		vo.setOriginName(originName);
		vo.setChangeName(changeName);
		
		//서비스
		int result = gs.write(vo);
		
		if(result != 1) {
			throw new IllegalStateException("갤러리 작성 실패");
		}
		
		//결과
		return "redirect:/gallery/list";
	}
	
	//목록 조회
	@GetMapping("list")
	public String list(Model model) {
		List<GalleryVo> voList = gs.getGalleryList();
		model.addAttribute("voList", voList);
		return "gallery/list";
	}
	
	//상세 조회
	@GetMapping("detail/{no}")
	public String detail(@PathVariable String no , Model model) {
		
		GalleryVo vo = gs.getGallery(no);
		
		model.addAttribute("vo" , vo);
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
	@GetMapping("del/{no}/{fname}")
	public String del(HttpServletRequest req , @PathVariable String no , @PathVariable(name = "fname") String str) {
		
		File f = new File(req.getServletContext().getRealPath("/resources/upload/gallery/") + str);
		f.delete();
		
		int result = gs.del(no);
		
		if(result != 1) {
			new IllegalStateException("갤럴 ㅣ삭제 싪패 ... ");
		}
		
		return "redirect:/gallery/list";
	}

}












