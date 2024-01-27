package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {

	//dao객체 선언
	private ILprodDao dao;
	//싱글톤 자신의 객체선언
	public static ILprodService service;
	
	//생성자 - 외부클래스에서 new로 생성 못하게 하기 위해
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getDao();
	}
	//자신의 객체 생성, 리턴
	public static ILprodService getService() {
		if(service==null) service = new LprodServiceImpl();
		return service;
	}
	@Override
	public List<LprodVO> selectLprod() {
		return dao.selectLprod();
	}

}
