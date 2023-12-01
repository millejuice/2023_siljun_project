package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardDAO boardDAO;

    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }
}
