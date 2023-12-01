package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/board/list")
    public String boardList(Model model) {
        List<BoardVO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "board/list";
    }
}
