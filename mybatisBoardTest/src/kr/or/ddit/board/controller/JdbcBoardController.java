//6
package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.IJdbcBoardService;
import kr.or.ddit.board.service.JdbcBoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class JdbcBoardController {
	private Scanner sc;
	private IJdbcBoardService service;
	
	public JdbcBoardController() {
		sc = new Scanner(System.in);
		service = JdbcBoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new JdbcBoardController().boardStart();
	}

	
	//시작 메서드
	private void boardStart() {
		String title = null;
		while(true) {
			
			int choice = displayMenu(title);
			switch(choice) {
			case 1 ://새글 작성
				insertBoard();
				title = null;
				break;
			case 2 ://게시글 보기
				viewBoard();
				title = null;
				break;
			case 3 : //검색
				title = searchBoard();
				break;
			case 0 : //작업종료
				System.out.println("게시판 프로그램 종료.");
				return;
			default :
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
				
			}
		}
		
	}

	
	//게시글을 검색할 제목을 입력 받아서 반환하는 메서드
	private String searchBoard() {
		sc.nextLine(); //버퍼비우기
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.print("- 검색할 제목 입력 :");
		String title = sc.nextLine();
		return title;
	}
	
	//게시글 내용을 보여주는 메서드
	private void viewBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >>");
		int num = sc.nextInt();
		
		BoardVO bvo = service.getBoard(num);
		
		if(bvo==null) {
			System.out.println(num + "번의 게시글이 존재하지 않습니다.");
			return;
		}
		System.out.println();
		System.out.println(num + "번 글 내용");
		System.out.println("------------------------------------------------------------");
		System.out.println("제     목 :" + bvo.getBoard_title());
		System.out.println("작 성 자 :" + bvo.getBoard_writer());
		System.out.println("내     용 :" + bvo.getBoard_content());
		System.out.println("작 성 일 :" + bvo.getBoard_date());
		System.out.println("조 회 수 :" + bvo.getBoard_cnt());
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >>");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1: //수정
				updateBoard(num);
				break;
			case 2: //삭제
				deleteBoard(num);
				break;
			case 3: //리스트로 가기
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
		}
	}
	
	//게시글을 삭제하는 메서드
	private void deleteBoard(int num) {
		System.out.println();
		int cnt = service.deleteBoard(num);
		
		if(cnt>0) {
			System.out.println(num+"번호 글의 삭제가 완료되었습니다.");
		}else {
			System.out.println(num+"번호 글의 삭제에 실패하였습니다.");
		}
		System.out.println();
		
		
	}

	//게시글을 수정하는 메서드
	private void updateBoard(int num) {
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		
		sc.nextLine(); //입력 버퍼 비우기
		System.out.print("- 제   목 :");
		String newtitle = sc.nextLine();
		
		System.out.print("- 내   용 :");
		String newcontent = sc.nextLine();
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(newtitle);
		bvo.setBoard_content(newcontent);
		bvo.setBoard_no(num);
		int cnt = service.updateBoard(bvo);
		
		if(cnt>0) {
			System.out.println(num+"번호 글의 수정 작업이 완료되었습니다.");
		}else {
			System.out.println(num+"번호 글의 수정 작업에 실패하였습니다.");
		}
	}

	// 새 글을 작성하는 메서드
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		
		sc.nextLine(); //입력 버퍼 비우기
		System.out.print("- 제     목 :");
		String title = sc.nextLine();
		
		System.out.print("- 작 성 자 :");
		String writer = sc.nextLine();
		
		System.out.print("- 내     용 :");
		String content = sc.nextLine();
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_writer(writer);
		bvo.setBoard_content(content);
		
		int cnt = service.insertBoard(bvo);
		
		if(cnt>0) {
			System.out.println("새 글이 추가 되었습니다.");
		}else {
			System.out.println("새 글 추가에 실패하였습니다.");
		}
	}
	
	
	

	//게시판 목록을 보여주고 메뉴를 나타내며 사용자가 입력한 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu(String title) {
		List<BoardVO> boardList = null;
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println(" No	        제 목            작성자 	조회수   ");
		System.out.println("-------------------------------------------------------------");
		if(title==null || title.isEmpty()) {
			boardList = service.getAllBoardList();
		}else {
			boardList = service.getSearchBoardList(title);
		}
		
		if(boardList==null || boardList.size()==0) {
			System.out.println("    출력할 게시글이 하나도 없습니다.");
		}else {
			for(BoardVO bvo : boardList) {
				System.out.println(bvo.getBoard_no() + "\t"
						+ bvo.getBoard_title() + "\t"
						+ bvo.getBoard_writer() + "\t"
						+ bvo.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택 >>");
		return sc.nextInt();
	}
}

	