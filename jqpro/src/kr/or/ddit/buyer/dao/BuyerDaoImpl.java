package kr.or.ddit.buyer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.config.MybatisUtil;
import kr.or.ddit.util.DBUtil3;

public class BuyerDaoImpl implements IBuyerDao {
	private static IBuyerDao dao;
	
	//db 접근 실행 설정
	public BuyerDaoImpl() {
	}
	private Connection conn = null;
	//DBUtil3.getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글톤 생성 - 리턴
	public static IBuyerDao getDao() {
		if(dao==null) dao = new BuyerDaoImpl();
		return dao;
	}


	@Override
	public List<BuyerVO> selectByName() {
		SqlSession session = null;
		List<BuyerVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("buyer.selectByName");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}


	@Override
	public BuyerVO selectById(String buyer_id) {
		SqlSession session = null; 
		BuyerVO vo = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo= session.selectOne("buyer.selectById",buyer_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();//select는 commit을 반드시 안해도 된다. commit-close순서바뀌면안됨
			session.close();
		}
		return vo;
	}

}
