package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	//dao 객체
	private IProdDao dao;
	
	//싱글톤객체
	private static IProdService service;
	
	//생성자 - dao 객체 얻기
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	
	//자신의 객체를 생성 리턴
	public static IProdService getService() {
		if(service==null) service = new ProdServiceImpl();
		
		return service;
	}
	
	
	@Override
	public List<ProdVO> selectByLgu(String lprod_gu) {
		return dao.selectByLgu(lprod_gu);
	}

	@Override
	public ProdVO selectById(String prod_id) {
		return dao.selectById(prod_id);
	}
	

}
