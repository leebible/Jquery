package kr.or.ddit.lprod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

import kr.or.ddit.util.DBUtil3;

public class LprodDaoImpl implements ILprodDao {
	//싱글톤 자신의 객체
	private static ILprodDao dao;
	
	public LprodDaoImpl() {
	}
	
	//db연결되는 객체들
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//자신의 객체를 생성하고 리턴하는 메서드
	public static ILprodDao getDao() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<LprodVO> selectLprod() {
		List<LprodVO> list = new ArrayList<LprodVO>();
		String sql = "select * from lprod";
		
		try{
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LprodVO vo = new LprodVO();
				vo.setLPROD_ID(rs.getInt("lprod_id"));
				vo.setLPROD_GU(rs.getString("lprod_gu"));
				vo.setLPROD_NM(rs.getString("lprod_nm"));
				
				list.add(vo);	
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}

}
