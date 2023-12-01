package com.example.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public int insertBoard(BoardVO vo) {
        return boardDAO.insertBoard(vo);
    }

    @Override
    public int deleteBoard(int seq) {
        return boardDAO.deleteBoard(seq);
    }

    @Override
    public int updateBoard(BoardVO vo) {
        return boardDAO.updateBoard(vo);
    }

    @Override
    public BoardVO getBoard(int seq) {
        return boardDAO.getBoard(seq);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }

}
