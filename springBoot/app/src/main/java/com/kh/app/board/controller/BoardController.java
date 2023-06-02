package com.kh.app.board.controller;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {
    private final BoardService bs;
    public BoardController(BoardService bs) {
        this.bs = bs;
    }

    @GetMapping(value = "list")
    public List<BoardVo> getBoardAll(){
        return bs.getBoardAll();
    }

}
