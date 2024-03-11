package jdbc.day03;

import java.util.List;
import java.util.Map;

public interface MemberDAO{  //인터페이스는 보안 등등을 위해 ㅅ ㅏ용
	
	//회원가입(insert) 메소드  //디비랑 소통
	int memberRegister(MemberDTO member); //얘는 목적이 인서트니까ㅏ 리턴타입이 인트

	//로그인처리(select) 메소드  로그인은 한 행이니까
	MemberDTO login(Map<String, String> paraMap);
	
	
	// 회원탈퇴하기(update) 메소드
	int memberDelete(int userseq);

	List<MemberDTO> showAllMember();
	

}
