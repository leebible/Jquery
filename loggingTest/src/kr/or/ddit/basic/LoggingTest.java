package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class LoggingTest {
	// Logger 클래스의 인스턴스 생성하기
	static Logger logger = Logger.getLogger(LoggingTest.class);
	public static void main(String[] args) {
		//로그 메시지 출력하기
		// 형식 ) Logger객체.로그레벨명(메시지);
		//		==>로그레벨명 : trace, debug, info, warn, error, fatal
		
		logger.trace("이것은 TRACE레벨의 로그메시지입니다.");
		logger.debug("DEBUG레벨의 로그메시지 출력");
		logger.info("이것은 log4j의 [INFO]레벨의 메시지 출력입니다.");
		logger.warn("[WARN]레벨은 경고에 사용되는 메시지 입니다.");
		logger.error("오류가 발생했을 때의 레벨의 [ERROR]레벨로 출력합니다.");
		logger.fatal("치명적인 오류의 레벨은 [FATAL]입니다.");
	}
}
