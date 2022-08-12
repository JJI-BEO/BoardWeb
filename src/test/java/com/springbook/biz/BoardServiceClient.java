package com.springbook.biz;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); // 싱글톤 패턴임
		
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		BoardVO vo = new BoardVO();

		//insert
		vo.setSeq(99);
		
		vo.setTitle("신규제목");
		vo.setWriter("신규고길동");
		vo.setContent("신규내용");
		boardService.insertBoard(vo);

		//update
//		System.out.println("업데이트 전");
//		vo.setTitle("수정제목");
//		vo.setWriter("고길동");
//		vo.setContent("수정내용");
//		vo.setSeq(3);
		
		//------------입력값 받아서 수정
//		int seq = 0;
//		String title = "";
//		String content = "";
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("수정할 글 번호 입력: ");
//		seq = sc.nextInt();
//		System.out.println("수정할 글 제목 입력: ");
//		title = sc.nextLine();
//		System.out.println("수정할 글 내용 입력: ");
//		content = sc.nextLine();
//		
//		vo.setSeq(seq);
//		vo.setTitle(title);
//		vo.setContent(content);
		
//		boardService.updateBoard(vo);
//		System.out.println("업데이트됨?");
		
		 //조회 + 카운트 
//		vo.setSeq(1);
//		int seq = 0;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("조회할 글 번호 입력: ");
//		seq = sc.nextInt();
//		vo.setSeq(seq);
//	    BoardVO vo2 = boardService.getBoard(vo);
//	    System.out.println("상세 조회  : " + vo.getSeq() + "번");
//	    System.out.println("내용  : " + vo2);
		
		//전체조회
//		List<BoardVO> list = boardService.getBoardList();
//	      for(BoardVO list2 : list) {
//	         System.out.println(list2);
//	      }
	      
        //삭제
//		vo.setSeq(3);
//		int seq = 0;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("삭제할 글 번호 입력: ");
//		seq = sc.nextInt();
//		vo.setSeq(seq);
//	    boardService.deleteBoard(vo);
//	    System.out.println("삭제되었냐");
	      
	   
	    
		container.close();
	}

}
