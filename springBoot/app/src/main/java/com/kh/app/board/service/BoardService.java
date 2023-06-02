package com.kh.app.board.service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDao dao;
    public BoardService(BoardDao dao) {
        this.dao = dao;
    }

    public List<BoardVo> getBoardAll() {
        return dao.getBoardAll();
    }
}
