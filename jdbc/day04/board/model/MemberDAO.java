package jdbc.day04.board.model;

import java.util.List;
import java.util.Map;

import jdbc.day04.board.domain.MemberDTO;

public interface MemberDAO {

	//회원가입(insert) 메소드  //디비랑 소통
	int memberRegister(MemberDTO member); //얘는 목적이 인서트니까ㅏ 리턴타입이 인트

	//로그인처리(select) 메소드
	MemberDTO login(Map<String, String> paraMap);

	// 모든회원을 조회 (select)해주는 메소드
	List<MemberDTO> showAllMember(String sortChoice);

	
}
