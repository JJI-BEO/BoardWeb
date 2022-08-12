package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//스프링 컨테이너 등록
@Repository
public class BoardDAOSpring {
	
	
	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;
	
	//insert,update,delete -> update()
	//select -> 
	//결과값이 숫자일때  -------> queryForInt(), 
	//결과값이 1개일떄 -------> queryForObject(), 
	//결과값이 여러개일때  -------> query()
	
	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content) "
			+ "VALUES((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
//	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)"
//	         + "VALUES(?,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, writer=?, content=? where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_CNT = "update board set cnt = cnt+1 where seq=?";
	
		//글 등록
		public void insertBoard(BoardVO vo) {
			System.out.println("===>SpringDAO board Insert");
//			jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter() ,vo.getContent());
			jdbcTemplate.update(BOARD_INSERT,vo.getSeq(),vo.getTitle(),vo.getWriter() ,vo.getContent());
		}; 
		//글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===>SpringDAO board update");
			jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getWriter() ,vo.getContent(), vo.getSeq());
		}; 
		//글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===>SpringDAO board delete");
			jdbcTemplate.update(BOARD_DELETE,vo.getSeq());

		}; 
		//글 하나 상세조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===>SpringDAO board getBoard");
			
			Object[] args = {vo.getSeq()};			
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
			
		}; 
		//전체 조회
		public List<BoardVO> getBoardList(){
			System.out.println("===>SpringDAO board BoardList");
			
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
			
		};
	
}
