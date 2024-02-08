package my.day18.a.collection;

import java.util.ArrayList;
import java.util.List;

/*
	== ArrayList == 
	1. 출력시 저장된 순서대로 나온다.
	2. 중복된 데이터를 저장할 수 있다.
	3. 데이터를 읽어오는 속도는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
	4. 순차적으로 데이터를 추가/삭제하는 경우에는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
	5. 일반적인 데이터 추가/삭제는 데이터 중간 중간마다 발생하므로 이러한 경우에는 ArrayList 가 LinkedList 보다 상대적으로 느리다.
	6. 결과값은 ArrayList 를 사용하든지 LinkedList 를 사용하든지 동일한 결과값을 가진다.
	7. LinkedList 보다는 ArrayList 를 사용하도록 하자.
*/

public class ArrayList_main_2 {

	public static void main(String[] args) {
		
		// Member 클래스의 객체만을 저장할 수 있는 ArrayList 객체 mbrList 를 생성한다.
		List<Member> mbrList = new ArrayList<>();
		
		// Member 클래스의 객체 7개를 생성하여 mbrList 에 저장한다.
		mbrList.add(new Member("youjs","Qwer1234$","유재석","7209101"));
		mbrList.add(new Member("eom","Qwer1234$","엄정화","6808152"));
		mbrList.add(new Member("kanghd","Qwer1234$","강호동","7006151"));
		mbrList.add(new Member("leess","Qwer1234$","이순신","0010203"));
		mbrList.add(new Member("kimth","Qwer1234$","김태희","0105064"));
		mbrList.add(new Member("kangkc","Qwer1234$","강감찬","9812301"));
		mbrList.add(new Member("kimss","Qwer1234$","김순신","0203203"));
		//new Member("kimss","Qwer1234$","김순신","0203203");   //위랑 다름. 메모리공간에 올라가는 주소가 다름
		
		Member mem1 =  new Member("parksj","Qwer1234$","박서준","8803201");
		Member mem2 = mem1;  //이게 위랑 같은 것임.
		mem2.setName("이현우");//이름이 박서준에서 이현우 로 바뀜.  mem1과 mem2가 가리키는게 같음.
		
		mbrList.add(mem1);  //중복된 데이터를 저장할 수 있다.
		mbrList.add(mem2);  //중복된 데이터를 저장할 수 있다.

		// mbrList 에 저장된 회원들의 정보를 출력하도록 한다.
		for(int i=0; i<mbrList.size(); i++) {
			System.out.println(mbrList.get(i)); 
		}// end of for---------------------------------
		/*
		     === 유재석님의 회원정보 ===
		     1.아이디 : youjs
		     2.비밀번호 : Qwer1234$
		     3.성명 : 유재석
		     4.주민번호 : 7209101
		     5.성별 : 남
		     6.만나이 : 51
		     
		     === 엄정화님의 회원정보 ===
		     1.아이디 : eom
		     2.비밀번호 : Qwer1234$
		     3.성명 : 엄정화
		     4.주민번호 : 6808152
		     5.성별 : 여
		     6.만나이 : 55
		       
		     ......................  
		 */
		
		
		System.out.println("\n###################################\n");
		System.out.println("\n[퀴즈1] mbrList 에 저장되어진 모든 회원들중에 여자만 정보를 출력하세요 \n"); 
		
		for(Member mbr : mbrList) {
			if("여".equals(mbr.gender())) {
				
				
				System.out.println(mbr);
			}
		}
			
		
		
		
		System.out.println("\n[퀴즈2] mbrList 에 저장되어진 모든 회원들중에 성이 김씨인 회원만 정보를 출력하세요 \n");
		
		boolean is_existence = false;
/*		for(Member mbr : mbrList) {
			if(mbr.getName().startsWith("김")) {
				is_existence = true;
				System.out.println(mbr);
			}
		}
		if(!is_existence) {
			System.out.println("김씨는 없습니다.");
		}
*/
		
		//또는 스타트스위드 말고 인덱스오브 도 가능
		
		for(Member mbr : mbrList) {
			if(mbr.getName().indexOf("김") == 0) {  //맨 첨에 김 자가 나와야 하니까 == 0
				is_existence = true;
				System.out.println(mbr);
			}
		}
		if(!is_existence) {
			System.out.println("김씨는 없습니다.");
		}
		
		
		
		
		
		
		System.out.println("\n[퀴즈3] mbrList 에 저장되어진 모든 회원들중에 이름이 순신인 회원만 정보를 출력하세요 \n");
		
		is_existence = false;
		for(Member mbr : mbrList) {
			if(mbr.getName().endsWith("순신")) {
				is_existence = true;
				System.out.println(mbr);
			}
		}
		if(!is_existence) {
			System.out.println("이름이 순신인 사람은 없습니다.");
		}
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// *** ArrayList 타입인 mbrList 에 새로운 Member 객체 추가시
        //     특정 index(위치)에 들어가도록 할 수 있다. *** 
        
        System.out.println("\n ~~~ mbrList 에 새로운 Member 객체 추가하기 ~~~ \n"); 
		
        mbrList.add(new Member("seolh","Qwer1234$","설현","9910122"));
        // index 값이 없으면 mbrList 의 맨 뒤에 추가되어진다.
        
        System.out.println(mbrList.get(mbrList.size()-1));  //맨뒤에 이름 애 뽑아보기
		
        
        
        
        
        
        System.out.println("\n#############################################\n");
        
        mbrList.add(3, new Member("seokj","Qwer1234$","서강준","9901051"));
        //유재석(0) 엄정화(1) 강호동(2) 이순신(3)  으로 되어있었는데
        //						  서강준(3)	이순신(4)
        
        for(Member mbr : mbrList) {
        	System.out.println(mbr);
        
        }
		
        
        // **** ArrayList 타입인 mbrList 에 저장되어진 Member 객체 삭제하기 **** //
        System.out.println("\n **** ArrayList 타입인 mbrList 에 저장되어진 Member 객체 삭제하기 **** \n");

        System.out.println(">> 삭제하기 전 mbrList.size() => " + mbrList.size());
        
        Member deleted_mbr = mbrList.remove(3);  // mbrList.remove(삭제할 Member 객체의 인덱스 번호);
        System.out.println(deleted_mbr);
        /*
         	=== 서강준님의 회원정보 ===
			1.아이디 : seokj
			2.비밀번호 : Qwer1234$
			3.성명 : 서강준
			4.주민번호 : 9901051
			5.성별 : 남
			6.만나이 : -75세
         */
        
        System.out.println(">> 삭제한 후 mbrList.size() => " + mbrList.size());
        // >> 삭제한 후 mbrList.size() => 10
        
        
        System.out.println("\n####################################\n");

        for(Member mbr : mbrList) {
        	System.out.println(mbr);
        }        
        
        
        System.out.println("\n======================================\n");

        boolean is_deleted = mbrList.remove(mbrList.get(0));  // 유재석을 삭제하는 것임.  (제거해야 할 객체);  리턴타입은 불린
        System.out.println(is_deleted+"\n");
        
        for(Member mbr : mbrList) {
        	System.out.println(mbr);
        }
        
        
        System.out.println("\n======================================\n");

        System.out.println("\n[퀴즈4] mbrList에 저장된 회원들 중에 남자만 모두 삭제한 후 정보를 출력하세요\n");
        
/*      // == 여자만 출력
        List<Member> copy= new ArrayList<>(mbrList);
        
        for(Member mbr : copy) {
        	if("남".equals(mbr.gender())) {
        		mbrList.remove(mbr);
			}
        }
    	 for(Member mbr : mbrList) {
    	System.out.println(mbr);
        }
	}
*/
	
	
//==== 만약에 index 0번이 남자(남자1), index 1번이 남자(남자2), index 2번이 여자(여자1), index 3번이 남자(남자3), index 4번이 여자(여자2) 이라면 
        
        //틀림!!!!//
/*    for( int i=0; i<mbrList.size(); i++) {  //맨처음 사이즈가 5
    	if("남".equals(mbrList.get(i).gender())) {
    		mbrList.remove(i);
    		
    		 	remove 를 앞에서부터 한 경우. 건너뛰는 배열번호가 생김.
    		 	i 는 0부터 시작해서 1씩 증가한다.
    		 	인덱스 0번이 남자이므로 삭제되면서 memberlist 가 줄어든다. 남자1이 없어지면서
    		 	mbrList는
    		 	index 0번이 남자(남자2), index 1번이 여자(여자1), index 2번이 남자(남자3), index 3번이 여자(여자2)
    		 	
    		 	i는 1이 되어진다. 그럼 검사해야 할 대상이 (index 번호가 1번인 여자(여자1)을 검사 할 것이다. 
    		 	그래서 남자 2는 삭제되지 않고 남아있음. 
    	}
    }
*/     
        //올바른 답//
        for(int i=mbrList.size()-1; i>=0; i--) {
        	if("남".equals(mbrList.get(i).gender())) {
        		mbrList.remove(i);
        	}
        }
        
        for(Member mbr : mbrList) {
				System.out.println(mbr);
				
        }//end of for------------------------
        
        /* 	remove 를 뒤부터 한 경우. 건너뛰는 배열번호가 없음.
	 	i 가 4부터 시작해서 1씩 감소하면서 0까지 반복한다.
		맨처음에는 index 번호 4번인 것을 찾아서 남/여 검사한다.
		여자이므로 삭제 하지 않음.
		
		i가 3 일 때는 남자이므로 삭제한다.
		mbrList는
		index 0번이 남자(남자1), index 1번이 남자(남자2), index 2번이 여자(여자1), index 3번이 여자(여자2)
		
		i 가 2일 때 여자니까 삭제 안함
		index 0번이 남자(남자1), index 1번이 남자(남자2), index 2번이 여자(여자1), index 3번이 여자(여자2)
		
		i 가 1일 때 남자니까 삭제.
		index 0번이 남자(남자1), index 1번이 여자(여자1), index 2번이 여자(여자2)
		
		i 가 1일 때 남자니까 삭제.
		index 0번이 여자(여자1), index 1번이 여자(여자2)
	*/
		////////////////////////////////////////////////
        
				
				
        System.out.println(">> 현재 mbrList.size() => " +mbrList.size());
        // >> 현재 mbrList.size() => 3


        System.out.println("\n === mbrList 에 저장된 모든 객체 삭제하기 ===\n ");
        mbrList.clear();

        System.out.println(">> 삭제한 후 mbrList.size() => " +mbrList.size());
        // >> 현재 mbrList.size() => 0
    
        
	}// end of main()----------------------------------

}
