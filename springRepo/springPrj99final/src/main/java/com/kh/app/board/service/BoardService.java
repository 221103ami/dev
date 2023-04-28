package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.file.FileVo;
import com.kh.app.common.page.PageVo;

@Service
@Transactional
public class BoardService {
	
	private final BoardDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public BoardService(BoardDao dao , SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}
	
	// 목록조회
	public List<BoardVo> getBoardList(PageVo pv, Map<String, String> searchMap) {
		return dao.getBoardList(sst, pv , searchMap);
	}
	
	/**
	 * BOARD 에 insert
	 * ATTACHMENT 에 changeNameList 의 값들을 insert (BOARD 기본키 참조)
	 * 
	 * @param 게시글 관련 데이터
	 * @param 파일업로드 이후 저장된 파일명 리스트
	 * @return Board테이블 및 Attachment 테이블 에 insert 한 결과
	 */
	// 작성하기
	public int write(BoardVo vo, List<FileVo> fvoList) throws Exception {
		int boardResult = dao.write(sst, vo);
		if(boardResult != 1) {
			throw new Exception();
		}
		return dao.insertAttachment(sst , fvoList);
	}
	
	// 상세조회 (조회수)
	public BoardVo getBoard(String no) throws Exception {
		int result = dao.increaseHit(sst, no);
		if(result != 1) {
			throw new Exception();
		}
		BoardVo bvo = dao.getBoard(sst, no);
		List<FileVo> fileList = dao.getAttachmentList(sst , no);
		bvo.setAttList(fileList);
		return bvo;
	}
	
	// 수정하기 (작성자 본인만)
	public int updateBoard(BoardVo vo) {
		return dao.updateBoard(sst, vo);
	}
	
	// 삭제하기 (작성자 본인만)
	public int delete(BoardVo vo) {
		return dao.delete(sst, vo);
	}
	
	// 게시글 갯수 조회
	public int getCnt(Map<String, String> searchMap) {
		return dao.getCnt(sst , searchMap);
	}

	public List<Map<String, String>> getCategoryList() {
		return dao.getCategoryList(sst);
	}

}


















