package com.example.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
   @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertBoard(BoardVO vo) {
        String sql = "insert into board (title, writer, content, category) values ('"
                + vo.getTitle() + "', '"
                + vo.getWriter() + "', '"
                + vo.getContent() + "', '"
                + vo.getCategory() + "')";
        return jdbcTemplate.update(sql);
    }

   public List<BoardVO> getBoardList(){
//       쿼리 문 생성, 쿼리 다룰 때는 RowMapper를 사용한다.
         String sql = "select * from board order by seq desc";
         List<BoardVO> list = new ArrayList<BoardVO>();
         list = jdbcTemplate.query(sql, new RowMapper<BoardVO>() {
             @Override
             public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                 BoardVO one = new BoardVO();
                    one.setSeq(rs.getInt("seq"));
                    one.setTitle(rs.getString("title"));
                    one.setWriter(rs.getString("writer"));
                    one.setContent(rs.getString("content"));
                    one.setCategory(rs.getString("category"));
                    one.setCreate_date(rs.getDate("create_date"));
                    return one;
             }
         });
         return list;
   }

    public BoardVO getBoard(int seq) {
        String sql = "select * from board where seq=" + seq;
        return jdbcTemplate.query(sql, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO one = new BoardVO();
                one.setSeq(rs.getInt("seq"));
                one.setTitle(rs.getString("title"));
                one.setWriter(rs.getString("writer"));
                one.setContent(rs.getString("content"));
                one.setCnt(rs.getInt("cnt"));
                one.setCategory(rs.getString("category"));
                one.setCreate_date(rs.getDate("create_date"));
                return one;
            }
        }).get(0);
    }

   //삭제
   public int deleteBoard(int seq){
       String sql = "delete from board where seq = " + seq;
       return jdbcTemplate.update(sql);
   }

    public int updateBoard(BoardVO vo) {
        String sql = "update board set title='" + vo.getTitle() + "', "
                + "writer='" + vo.getWriter() + "', "
                + "content='" + vo.getContent() + "', "
                + "category='" + vo.getCategory() + "' where seq=" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }
}
