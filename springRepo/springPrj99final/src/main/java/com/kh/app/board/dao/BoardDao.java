package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.file.FileVo;
import com.kh.app.common.page.PageVo;

@Repository
public class BoardDao {

	//	--목록조회
	public List<BoardVo> getBoardList(SqlSessionTemplate sst , PageVo pv, Map<String, String> searchMap) {
		int limit = pv.getBoardLimit();
		int offset = (pv.getCurrentPage()-1) * limit;
		RowBounds rb = new RowBounds(offset , limit);
		return sst.selectList("board.getBoardList" , searchMap , rb);
	}
	
	//	--작성하기
	public int write(SqlSessionTemplate sst , BoardVo vo) {
		return sst.insert("board.write" , vo);
	}
	
	//	--상세조회(조회수)
	public BoardVo getBoard(SqlSessionTemplate sst , String no) {
		return sst.selectOne("board.getBoard" , no);
	}
	
	//	--조회수
	public int increaseHit(SqlSessionTemplate sst , String no) {
		return sst.update("board.increaseHit" , no);
	}
	
	//	--수정하기(작성자만)
	public int updateBoard(SqlSessionTemplate sst , BoardVo vo) {
		return sst.update("board.updateBoard" , vo);
	}
	
	//	--삭제하기(작성자만)
	public int delete(SqlSessionTemplate sst , BoardVo vo) {
		return sst.update("board.delete" , vo);
	}
	
	//	--게시글 갯수 조회
	public int getCnt(SqlSessionTemplate sst, Map<String, String> searchMap) {
		return sst.selectOne("board.getCnt" , searchMap);
	}

	public List<Map<String, String>> getCategoryList(SqlSessionTemplate sst) {
		return sst.selectList("board.getCategoryList");
	}

	public int insertAttachment(SqlSessionTemplate sst, List<FileVo> fvoList) {
		return sst.insert("board.insertAttachment" , fvoList);
	}

	public List<FileVo> getAttachmentList(SqlSessionTemplate sst, String no) {
		return sst.selectList("board.getAttachmentList" , no);
	}

	public FileVo getAttachment(SqlSessionTemplate sst, String ano) {
		return sst.selectOne("board.getAttachment" , ano);
	}
	

}










