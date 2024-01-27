//2 
package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IJdbcBoardDao {

	
	
	/**
	 * BoardVO객체에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard(BoardVO boarVo);
	
	
	/**
	 * 하나의 BoardVO객체에 저장된 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param boardVo DB에 update할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 DB에서 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(int boardNo);
	
	
	/**
	 * JDBC_BOARD 테이블의 전체 데이터를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return BoardVO객체를 저장하고 있는 List객체
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보
	 * 
	 * @param boardNo 가져올 게시글 번호
	 * @return 게시글 번호에 맞는 자료가 있으면 해당 게시글 정보를 갖는 BoardVO객체,
	 * 			게시글 번호에 맞는 자료가 없으면 null
	 */
	public BoardVO getBoard(int boardNo);
	
	/**
	 * 게시글의 제목을 매개변수로 받아서 해당 제목을 포함하는 게시글을 검색하는 메서드
	 * 
	 * @param title 검색할 게시글의 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BoardVO> getSearchBoardList(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateBoardCount(int boardNo);
	
	
}
