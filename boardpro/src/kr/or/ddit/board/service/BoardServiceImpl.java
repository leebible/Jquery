package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public class BoardServiceImpl implements IBoardService {
	//dao객체 선언
	private IBoardDao dao;
	//싱글톤 자신의 객체 선언
	public static IBoardService service;
	//생성자 - 외부클래스에서 new로 생성 못하게 하기 위해
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	//자신의 객체생성, 리턴
	public static IBoardService getService() {
		if(service==null) service = new BoardServiceImpl();
		return service;
	}
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		return dao.getTotalCount(map);
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		return null;
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

}
