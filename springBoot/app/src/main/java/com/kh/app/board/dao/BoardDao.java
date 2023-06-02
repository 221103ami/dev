package com.kh.app.board.dao;

import com.kh.app.board.mapper.BoardMapper;
import com.kh.app.board.vo.BoardVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    private final BoardMapper mapper;
    public BoardDao(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public List<BoardVo> getBoardAll() {
        return mapper.getBoardAll();
    }

}
