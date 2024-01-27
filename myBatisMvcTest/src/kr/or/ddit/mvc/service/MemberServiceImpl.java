package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	//1번
	private static MemberServiceImpl svc;

	// DAO 객체의 참조값이 저장될 변수 선언 
	private static IMemberDao dao;
	
	//2번
	private MemberServiceImpl() {
//		dao = new MemberDaoImpl(); //DAO 객체 생성
		dao = MemberDaoImpl.getInstance(); // DAO 객체 생성
	}
	
	//3번
	public static MemberServiceImpl getInstance() {
		if(svc==null) svc = new MemberServiceImpl();
		return svc;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

}
