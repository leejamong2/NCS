package my.day08.a.spaceDelete;

public class Main_space_delete {

	public static void main(String[] args) {
	

		String str = "  korea   seou l 쌍용 강북 교육센터 ";
		System.out.println("시작"+str+"끝");
		//시작  korea   seou l 쌍용 강북 교육센터 끝
		
		System.out.println("\n~~~~~~~~~~~~~~for~~~~~~~~~~~~~~\n");
		
		String str_result_for = "";
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != ' ') {
				str_result_for += str.charAt(i);
			}
		}//end od for---------------------
		
		System.out.println("시작"+str_result_for+"끝") ;
		//시작koreaseoul쌍용강북교육센터끝
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~while~~~~~~~~~~~~~~\n");
		
		String str_result_while = "";
		
		//String str = "  korea   seou l 쌍용 강북 교육센터 ";
		//     index =  01234...                     맨 마지막은 글자길이 -1
		int i =0;
		while(i<str.length()) {  //글자 길이까지돌릴거
			if(str.charAt(i) != ' ') {   //str.charAt(i) i에 인덱스 넘버 0부터 글자길이까지 넣어서 검사를 할건데 공백이 아니라면  밑에공식처럼 쌓겟다.
				str_result_while += str.charAt(i);  
			}
			i++;  //인덱스 넘버가 01234...계속 증가해야되니까. 근데 while() 조건문에 적은것처럼 글자 길이 넘어가면 false가 되니까 끝내겠다는 말
			
		}//end of while----------------------
		
		System.out.println("시작"+str_result_while+"끝") ;
		//시작koreaseoul쌍용강북교육센터끝
		
		
		
		
		
		
		
	System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	String str_result_dowhile= "";
	
	i=0;
	do {
		if(str.charAt(i) != ' '){
			str_result_dowhile += str.charAt(i); 
		}
		i++;  //마지막까지 증가가 되어진다면 글자길이랑 똑같아질것임 그때 멈ㅊ줘줘야되지
	} while (!(i == str.length()));
	
	
		System.out.println("시작"+str_result_dowhile+"끝") ;
		
		
		
	}//end of main()---------------------------

}
