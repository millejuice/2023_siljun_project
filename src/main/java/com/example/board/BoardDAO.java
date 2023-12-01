package com.example.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
   @Autowired
    JdbcTemplate jdbcTemplate;
   public List<BoardVO> getBoardList(){
//       쿼리 문 생성, 쿼리 다룰 때는 RowMapper를 사용한다.
         String sql = "select * from BOARD order by seq desc";
         List<BoardVO> list = new ArrayList<BoardVO>();
         list = jdbcTemplate.query(sql, new RowMapper<BoardVO>() {
             @Override
             public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                 BoardVO one = new BoardVO();
                    one.setSeq(rs.getInt("seq"));
                    one.setTitle(rs.getString("title"));
                    one.setWriter(rs.getString("writer"));
                    return one;
             }
         });
         return list;
   }

}
