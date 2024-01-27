package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.config.MybatisUtil;

public class BoardDaoImpl implements IBoardDao {
	
	private static IBoardDao dao;

	public BoardDaoImpl() {
	}
	//싱글톤 생성 - 리턴
	public static IBoardDao getDao() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	//db접근 실행 설정
	private Connection conn = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		SqlSession session = null;
		List<BoardVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("board.selectByPage", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	
	
	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.insert("board.insertBoard",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}
	
	

	@Override
	public int updateBoard(BoardVO vo) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("board.udpateBoard",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.delete("board.deleteBoard",num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("board.getTotalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		return null;
	}

	@Override
	public int updateHit(int num) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("board.updateHit",num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

}
