package com.kh.app2.board.controller;

import com.kh.app2.board.service.BoardService;
import com.kh.app2.board.vo.BoardVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"http://localhost:3000"} ,
        methods = { RequestMethod.GET , RequestMethod.POST ,}
)
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
