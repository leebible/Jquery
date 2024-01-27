package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService {

	//dao객체 선언
	private IBuyerDao dao;
	//싱글톤 자신의 객체선언
	public static IBuyerService service;
	
	//생성자 - 외부클래스에서 new로 생성 못하게 하기 위해
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getDao();
	}
	//자신의 객체 생성, 리턴
	public static IBuyerService getService() {
		if(service==null) service = new BuyerServiceImpl();
		return service;
	}
	@Override
	public List<BuyerVO> selectByName() {
		return dao.selectByName();
	}
	@Override
	public BuyerVO selectById(String buyer_id) {
		return dao.selectById(buyer_id);
	}


}
