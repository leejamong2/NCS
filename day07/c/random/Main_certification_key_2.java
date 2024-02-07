package my.day07.c.random;

import java.util.Random;

import my.util.MyUtil;

public class Main_certification_key_2 {
	
	public static void main(String[] args) {
		
		
		// === 소문자3개와 숫자4개로 이루어진 랜덤한 인증키 만들기 === //
		// 예> asa9040   txa2356
		
		Random rnd = new Random();
		//처음 얼마부터 마지막 얼마까지 랜덤한 정수
		// ==> rndom.nextInt(마지막수 - 처음수+1) + 처음수;
		
//		String certification_key = "";
		
		System.out.println("인증키 : "+ MyUtil.certification_key());
			
		}//end of for--------------------------
}
		
		
		
		
		
		
//		
//		
//		
//		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//	
//		// === 소문자3개와 숫자4개로 이루어진 랜덤한 인증키 만들기 === //
//		
//		
//		
//		String certification_key = "";
//		
//
//		
//		System.out.println("인증키 : "+ MyUtil.certification_key());  ////스태틱메소드에 리턴타입은 스트링타입 이어야함
//		
//		}//end of main()---------------------------------------
//		
//		}		return certification_key
//}
