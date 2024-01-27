//5

package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDao;
import kr.or.ddit.board.dao.JdbcBoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class JdbcBoardServiceImpl implements IJdbcBoardService {
	private IJdbcBoardDao dao;
	
	private static JdbcBoardServiceImpl service;
	
	private JdbcBoardServiceImpl() {
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance() {
		if(service == null) service = new JdbcBoardServiceImpl();
		return service;
	}
	
	
	

	@Override
	public int insertBoard(BoardVO boarVo) {
		return dao.insertBoard(boarVo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		// 조회수를 먼저 증가한 다음 게시글 정보를 가져온다.
		if(dao.updateBoardCount(boardNo)==0) { // 조회수 증가 작업시 실패하면
			return null;
		};
		
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		return dao.getSearchBoardList(title);
	}
	

	@Override
	public int updateBoardCount(int boardNo) {
		return dao.updateBoardCount(boardNo);
	}

}
