package com.kh.app2.board.dao;

import com.kh.app2.board.mapper.BoardMapper;
import com.kh.app2.board.vo.BoardVo;
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
