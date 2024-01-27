//4

package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.util.MybatisUtil;
import kr.or.ddit.board.vo.BoardVO;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	//싱글톤 생성
	
	//1번
	private static JdbcBoardDaoImpl dao;
	//2번 생성자
	private JdbcBoardDaoImpl() {
	}
	//3번
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0; //반환값이 저장될 변수
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.insert("board.insertBoard", boardVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		
		return cnt; //리턴값을 제일 처음에 먼저 작성해주는게 좋다.(깜빡할 확률이 높아서)
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("board.updateBoard", boardVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.delete("board.deleteBoard", boardNo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = null;
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			
			boardList = session.selectList("board.getAllBoardList");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return boardList;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO boardVo = new BoardVO();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			boardVo = session.selectOne("board.getBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return boardVo;
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		List<BoardVO> boardList = null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			boardList = session.selectList("board.getSearchBoardList", title);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return boardList;
	}

	@Override
	public int updateBoardCount(int boardNo) {
		int cnt = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.update("updateBoardCount", boardNo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

}
