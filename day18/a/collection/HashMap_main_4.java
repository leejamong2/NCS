package my.day18.a.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
=== Map 계열 ===
1. HashMap 과 Hashtable 이 있다.
2. Map 계열은 List 계열(Vector, ArrayList, LinkedList)처럼 index 가 사용되어 저장되는 것이 아니라, 
   Map 계열은 key값과 value값을 쌍으로 사용하여 저장하는데  
   데이터 저장시 사용되는 메소드는 put(String key, Object value)메소드를 사용한다.
   이때 key값은 반드시 고유한 값을 가져야 하고, value값은 중복된 값이 와도 괜찮다.
3. Map 계열에 저장된 key값들은 순서와는 상관없이 저장된다.  
4. Map 계열에 저장된 value값을 추출하려면 key를 이용해서 가져오는데 
   value 값의 추출은 get(String key) 메소드를 사용한다. 
*/

public class HashMap_main_4 {

	public static void main(String[] args) {
		
	/*	
		HashMap <Integer, Member> mbr_map = new HashMap<Integer,Member>();
		
		mbr_map.put(4574, new Member("youjs","Qwer1234$","유재석","7209101"));
		mbr_map.put(543, new Member("eom","Qwer1234$","엄정화","6808152"));
		mbr_map.put(875, new Member("kanghd","Qwer1234$","강호동","7006151"));
		
		System.out.println(mbr_map.get(543).toString());
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println(mbr_map.get(543));
	*/
		
	//	HashMap <String, Member> mbr_map = new HashMap<String,Member>(); 
	//	또는	
	//	Map <String, Member> mbr_map = new HashMap<String,Member>(); 
		
	//	또는	
	//	HashMap <String, Member> mbr_map = new HashMap<>();  //JDK 8 이후부터 가능함. 뒤<>만 생략가능함
	//	또는	
		Map<String, Member> mbr_map = new HashMap<>();  //많이 쓰는 방식.
		
		mbr_map.put("youjs", new Member("youjs","Qwer1234$","유재석","7209101"));
		mbr_map.put("eom", new Member("eom","Qwer1234$","엄정화","6808152"));
		mbr_map.put("kanghd", new Member("kanghd","Qwer1234$","강호동","7006151"));
		mbr_map.put("leess",new Member("leess","Qwer1234$","이순신","0010203"));
		mbr_map.put("kimth", new Member("kimth","Qwer1234$","김태희","0105064"));
		mbr_map.put("kangkc", new Member("kangkc","Qwer1234$","강감찬","9812301"));
		mbr_map.put("kimss", new Member("kimss","Qwer1234$","김순신","0203203"));
		
		System.out.println(mbr_map.get("kangkc")); //강감찬
		
		mbr_map.put("kangkc", new Member("kangkc","Abcd0070$","강기춘","0112303"));
		// Key 값이 중복되면 Value 값을 덮어씌운다.
		
		System.out.println(mbr_map.get("kangkc")); //강기춘  
		
		Member mem1 =  new Member("parksj","Qwer1234$","박서준","8803201");
		Member mem2 = mem1;
		mem2.setName("이현우");
		
		mbr_map.put("mem1", mem1); //key 값이 다르면 value값은 중복된 값이 들어와도 괜찮다.
		mbr_map.put("mem2", mem2); //key 값이 다르면 value값은 중복된 값이 들어와도 괜찮다.
		
		System.out.println(mbr_map.get("mem1")); //이현우
		System.out.println(mbr_map.get("mem2")); //이현우
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// == mbr_map에 저장되어진 모든 key들을 읽어오는 첫번째 방법 == // 
		Set<String> key_set = mbr_map.keySet();
		
		for(String key : key_set) {
			System.out.println(key);
		}//end of for--------------------------------
		/*
		 	eom
			youjs
			kimth
			kangkc
			kanghd
			kimss
			leess
			mem2
			mem1
		 */
		
		System.out.println("== mbr_map 에 저장되어진 모든 Member 객체의 정보를 출력해주는 첫번째 방법 ==");
		
		for(String key : key_set) {
			System.out.println(mbr_map.get(key));
		}//end of for-------------------
		
		System.out.println("== [퀴즈] mbr_map 에 아래와 같이 새로운 회원을 가입하시는데 아이디가 중복이라면 '아이디가 이미 사용중입니다.' 라는 메시지를 출력해주고 아이디가 중복이 아니라면 mbr_map 에 저장하도록 하세요..");
		
		
		
		// >> 미련한 방법 <<< //
		String userid = "leess";
		boolean is_existence_key = false;
		
		mbr_map.keySet();
		
		Set<String> keySets = mbr_map.keySet();
		
		for(String key : keySets ) {
			if(userid.equals(key)) {
				is_existence_key = true;
			}
		}//end of for----------------------
				
		
		if(!is_existence_key) {
			mbr_map.put(userid, new Member("kimss","aBcd0080$","이수성","0203203"));
			System.out.println("\n >> 회원가입 성공 <<");
			
		}
		else {
			System.out.println(userid+"이 아이디는 이미 사용중입니다. 회원가입 실패");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		// >>> 스마트한 방법 <<< //
		userid = "leess";
		if(mbr_map.get(userid) == null) {
			mbr_map.put(userid, new Member("kimss","aBcd0080$","이수성","0203203"));
			System.out.println("\n >> 회원가입 성공 <<");
		}
		else {
			System.out.println(userid+"이 아이디는 이미 사용중입니다. 회원가입 실패");
		}
		
		
		// === mbr_map 에 저장되어진 모든 key들을 읽어오는 두번째 방법 === //
	      
	    System.out.println("\n=== mbr_map 에 저장되어진 모든 key들을 읽어오는 두번째 방법 ===\n");
	    
	    Set<String>key_set2 = mbr_map.keySet();
		
		Iterator<String> iterator = key_set2.iterator();
		// Iterator 는 저장소가 아니라 Collection 에 저장되어진 요소(Element)를 읽어오는 용도로 쓰이는 것이다.
		
		while(iterator.hasNext()) {
		 /*
            itrator.hasNext() 는
            itrator 에서 현재 itrator 가 가지고 있는 여러 String 데이터중 
            하나를 끄집어내서 존재하는지를 알아보는 것이다.
            존재하면 true, 존재하지 않으면 false 리턴해준다.
            그러므로 현재는 키의 개수가 9개 이므로 9번 반복을 할 것이다.     
         */
			String key = iterator.next();
			/*
            	실제로 키값인 String 값을 itrator 에서 끄집어 낸다.
            	!!!! 그러면 끄집어 낸 String 값은 더 이상 itrator 에는 남아 있지 않게 된다.!!!!  
			*/
			System.out.println(key);
		}//end of while-----------------------
		
		
		
		System.out.println("\n~~~~~~~~~~~또 한번 더 \n");
		
		while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key);
			}//end of while-----------------------
		
		
		
		System.out.println("\n~~~~~~~~~~~다시 처음부터 해본다 \n");
				
		iterator = key_set2.iterator();
		
		while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key);
			}//end of while-----------------------
				
				
		System.out.println("\n== mbr_map 에 저장되어진 모든 Member 객체의 정보를 출력해주는 두번째 방법 ==\n");
		
		Set<String> key_set3 = mbr_map.keySet();
		
		Iterator<String> itr = key_set3.iterator();
		
		while(itr.hasNext()) {
		/*	String key = itr.next();
			System.out.println(mbr_map.get(key));
		*/
			//또는
		System.out.println(mbr_map.get(itr.next()));
		}//end of while-----------------------
		
		
		
		System.out.println("\n>> mbr_map 에서 key값이 leess 인 Member 를 삭제하기 ==\n");
		
		Member delete_mbr = mbr_map.remove("leess");
		
		System.out.println("=== 삭제된 회원정보===");
		System.out.println(delete_mbr);
		
		System.out.println("=== 남은 회원 회원정보===");
		
		for(String key : key_set) {
			System.out.println(mbr_map.get(key));
		}
		
		
		System.out.println("\n>> mbr_map 에서 모든 Member 객체를 삭제하기 ==\n");
		
		mbr_map.clear();
		for(String key : key_set) {
			System.out.println(mbr_map.get(key));
		}
		
		//mbr_map 의 크기
		System.out.println(mbr_map.size());  //0
		System.out.println(mbr_map.isEmpty());  //true
		
		
		
		
	}//end of main---------------------------

}
