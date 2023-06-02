package com.kh.app2.board.mapper;

import com.kh.app2.board.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM BOARD")
    List<BoardVo> getBoardAll();
}
