package com.kh.app2.board.controller;

import com.kh.app2.board.service.BoardService;
import com.kh.app2.board.vo.BoardVo;
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

    @GetMapping("list")
    public List<BoardVo> list(){
        return bs.getBoardAll();
    }

}
