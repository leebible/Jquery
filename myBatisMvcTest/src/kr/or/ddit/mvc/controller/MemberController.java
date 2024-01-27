package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	// Service 객체의 참조값이 저장될 변수 선언
	private IMemberService service;
	private Scanner sc;

	// 생성자
	public MemberController() {
		sc = new Scanner(System.in);
		// Servcie 객체 생성
//		service = new MemberServiceImpl();
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().startMember();
	}

	// 시작 메서드
	private void startMember() {
		System.out.println();
		System.out.println("================================");
		System.out.println("	MyBatis용 회원관리 프로그램");
		System.out.println("================================");
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 추가
				insertMember();
				break;
			case 2: // 삭제
				deleteMember();
				break;
			case 3: // 수정
				updateMember();
				break;
			case 4: // 수정(부분)
				updateMember2();
				break;
			case 5: // 전체 출력
				displayAllMember();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");

			}
		}
	}

	// 회원 정보 수정 ==> 원하는 컬럼만 수정
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요. ");
		int count = 0;
		String memId = null;

		do {
			System.out.print("회원 ID >>");
			memId = sc.next();
			count = service.getMemberCount(memId);

			if (count == 0) {
				System.out.println(memId + "은(는) 등록이 되지 않은 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		} while (count == 0);

		int fieldNum;
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updateTitle = null; // 수정할 내용의 제목이 저장될 변수
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택해주세요.");
			System.out.println("1. 비밀번호");
			System.out.println("2. 회원이름");
			System.out.println("3. 전화번호");
			System.out.println("4. 회원주소");
			System.out.print("선택 >>");

			fieldNum = sc.nextInt();
			switch (fieldNum) {
			case 1:
				updateField = "mem_pass";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "mem_name";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "mem_tel";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "mem_addr";
				updateTitle = "회원주소";
				break;
			default:
				System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요.");
			}
		} while (fieldNum < 1 || fieldNum > 4);
		sc.nextLine();// 입력 버퍼 비우기
		System.out.println();
		System.out.println("새로운" + updateTitle + " >> ");
		String updateData = sc.nextLine();

		// 수정 작업에 사용할 데이터를 Map에 추가한다.
		// key 정보 ==> 회원ID(memberID), 수정할 컬럼명(fieldName), 수정할 데이터(data)
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("memberID", memId);
		pMap.put("fieldName", updateField);
		pMap.put("data", updateData);

		int cnt = service.updateMember2(pMap);

		if(cnt>0) {
			System.out.println(memId+"의 update 작업 성공!");
		}else {
			System.out.println(memId+"의 update 작업 실패~");
		}

	}
			
		

	//전체 회원 목록 출력
	private void displayAllMember() {
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println(" 회원ID  비밀번호     회원이름     전화번호                   회원주소");
		System.out.println("------------------------------------------------------");
		
		List<MemberVO> memList = service.getAllMember();
		if(memList==null || memList.size()==0) {
			System.out.println("   등록된 회원 목록이 하나도 없습니다.");
		}else {
			for(MemberVO memVo : memList) {
				String id = memVo.getMem_id();
				String pass = memVo.getMem_pass();
				String name = memVo.getMem_name();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();
				System.out.println(id + "\t" + pass  + "\t" + name  + "\t" + tel  + "\t" + addr);
			}
		}
		System.out.println("----------------------------------------------------");
	}

	//회원 정보를 수정하는 메서드 ==> 전체항목 수정
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요. ");
		int count = 0;
		String memId = null;
		
		do {
			System.out.print("회원 ID >>");
			memId = sc.next();
			count = service.getMemberCount(memId);
			
			if(count==0) {
				System.out.println(memId + "은(는) 등록이 되지 않은 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		}while(count==0);
		
		System.out.print("비밀번호 >>");
		String newmemPass = sc.next();
		
		
		System.out.print("회원이름 >>");
		String newmemName = sc.next();
		
		
		System.out.print("전화번호 >>");
		String newmemTel = sc.next();
		
		sc.nextLine(); //입력 버퍼 비우기
		System.out.print("회원주소 >>");
		String newmemAddr = sc.next();
		
		// 입력이 완료되면 입력한 자료들을 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newmemPass);
		memVo.setMem_name(newmemName);
		memVo.setMem_tel(newmemTel);
		memVo.setMem_addr(newmemAddr);

		// service의 insert메서드를 호출해서 처리한다.
		int cnt = service.updateMember(memVo);
		
		if(cnt>0) {
			System.out.println(memId+"의 update 작업 성공!");
		}else {
			System.out.println(memId+"의 update 작업 실패~");
		}
		
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요. ");
		int count = 0;
		String memId = null;
		do {
			System.out.print("회원 ID >>");
			memId = sc.next();
			count = service.getMemberCount(memId);
			
			if(count==0) {
				System.out.println(memId + "은(는) 등록이 되지 않은 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		}while(count==0);
		
		// service의 insert메서드를 호출해서 처리한다.
		int cnt = service.deleteMember(memId);
		if(cnt>0) {
			System.out.println(memId+"의 delete 작업 성공!");
		}else {
			System.out.println(memId+"의 delete 작업 실패~");
		}
	}

	// insert
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count = 0;
		String memId = null; // 회원ID가 저장될 변수
		do {
			System.out.print("회원 ID >>");
			memId = sc.next();
			
			count = service.getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		}while(count>0);
		//-------------------------
		
		System.out.print("비밀번호 >>");
		String memPass = sc.next();
		
		
		System.out.print("회원이름 >>");
		String memName = sc.next();
		
		
		System.out.print("전화번호 >>");
		String memTel = sc.next();
		
		sc.nextLine(); //입력 버퍼 비우기
		System.out.print("회원주소 >>");
		String memAddr = sc.next();
		
		// 입력이 완료되면 입력한 자료들을 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);

		// service의 insert메서드를 호출해서 처리한다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println(memId+"의 insert 작업 성공!");
		}else {
			System.out.println(memId+"의 insert 작업 실패~");
		}
	}

	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("**********************************************");
		System.out.println("\t\t회원관리 프로그램");
		System.out.println("**********************************************");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정(전체)");
		System.out.println("4. 자료 수정(부분)");
		System.out.println("5. 전체 자료 출력"); // ==> 원하는 항목만 수정하기
		System.out.println("0. 작업 끝");
		System.out.println("----------------------------------------------");
		System.out.print("작업하실 번호를 입력해주세요 >>");
		return sc.nextInt();
	}
}
