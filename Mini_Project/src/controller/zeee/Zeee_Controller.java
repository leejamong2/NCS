package controller.zeee;

import java.util.List;

import domain.CompanyDto;
import jdbc.day04.board.domain.MemberDTO;

public class Zeee_Controller {
	
	ZeeeDAO zdao = new ZeeeDAO_imple();
		
	private void showAllComp(CompanyDto cdto) {
		
		List<MemberDTO> memberList = mdao.showAllMember(sortChoice);
		
		
	}
}