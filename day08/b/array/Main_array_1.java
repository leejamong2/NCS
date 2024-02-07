package my.day08.b.array;

public class Main_array_1 {

	public static void main(String[] args) {


		/*
        === 배열(array)이란 ? ===
          동일한 데이터타입을 가지는 여러개의 데이터를 저장할 수 있는 데이터 타입을 말한다.
          그리고 배열 또한 객체라는 것을 꼭 기억하도록 하자!!! (암깅) 
		*/
		
		
			//1. == 배열의 선언 ==
		int[] arr_subject;     
		//또는
		//int arr_subject[]; 
		
		
		
		
			//2. == 선언되어진 배열을 메모리에 크기할당을 해준다. ==
			arr_subject = new int[7];  //과목점수 7개를 메모리에 만들어냄.
			/*
			  	-----------------------------
			  	| 0 | 1 | 2 | 3 | 4 | 5 | 6 |
			  	-----------------------------
			  	위의 숫자는 배열의 인덱스(index)를 가리키는 번호로써 0부터 시작하여 1씩 증가한다.
			  	배열의 인덱스를 "배열의 방 번호" 라고 흔히 부른다.
			  	
			  	배열에 저장된 데이터를 표현할 때는 아래와 같이 배열명[인덱스번호]로 나타내다.
			  	arr_subject[0]
			  	arr_subject[1]
			  	arr_subject[2]
			  	arr_subject[3]
			  	arr_subject[4]
			  	arr_subject[5]
			  	arr_subject[6]
			  	arr_subject[7] ==> 존재하지 않으므로 오류!!
			  	
			  	배열로 선언된 벼수에는 자동적으로 초기값이 들어간다.
			  	정수는 0, 실수는 0.0, char 는 ' ', String 을 포함한 객체는 null 이 들어간다.(암깅)
			 */
			
			// == 배열의 크기(길이)는 배열명.length로 알아온다. == ()암기)
			System.out.println("배열 arr_subject의 길이(크기) : " + arr_subject.length);
			//배열 arr_subject의 길이(크기) : 7

			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			for(int i=0; i<arr_subject.length; i++) {
				int val = arr_subject[i];
				System.out.println("arr_subject["+i+"] => " + val);
			}//end of for-------------------------
			
			
		/*
			System.out.println("=====================================");
						
			for(int i=0, val=10; i<arr_subject.length; i++, val+=10) {
				arr_subject[i] = val;
				System.out.println("arr_subject["+i+"] => " + arr_subject[i]);
			}//end of for-------------------------
		*/

			
			
			
			
			//3. == 선어되어진 배열의 데이터값을 넣어주기 ==
			arr_subject[0] = 100; //국어점수
		  	arr_subject[1] = 90; //영어점수
		  	arr_subject[2] = 95; //수학점수
		  	arr_subject[3] = 70; //과학점수
		  	arr_subject[4] = 98; //사회점수
		  	arr_subject[5] = 100; //음악점수
		  	arr_subject[6] = 90; //미술점수
			
			
		  	System.out.println("=======================");
			
			for(int i=0; i<arr_subject.length; i++) {
				System.out.println("arr_subject["+i+"] => " + arr_subject[i]);
			}//end of for-------------------------

			
			
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			int sum = 0;
			for(int i=0; i<arr_subject.length; i++) {
				sum += arr_subject[i];
			}//end of for-------------------------
			System.out.println("총점 : " + sum);
			//총점 : 643
			
			//91.85714285714286 ==> 918.5734534  ==> 919 ==> 91.9
			double avg = Math.round((double)sum/arr_subject.length*10)/10.0;    //정수나누기 정수니까 정수가 나와 -> 실수까지 볼거야 (더블)붙여주기
			System.out.println("평균 : "+ avg);
			//평균 : 91.8571423425  -> 소수 첫쨋자리까지남기고 반올림할래 -> 91.9
			
			///////////////////////////////////////////////////
			
			System.out.println("\n==========================\n");
			
			/*
			  	위의 1. == 배열의 선언 ==
			  		2. == 선언되어진 배열을 메모리에 크기할당을 해준다. == 을
			  		각각따로 하지 않고 아래와 같이 동시에 할 수 있다.
			 */
			int[] arr_subject_2 = new int[7];
			
			//3. == 선어되어진 배열의 데이터값을 넣어주기 ==
			arr_subject_2[0] = 100; //국어점수
		  	arr_subject_2[1] = 90; //영어점수
		  	arr_subject_2[2] = 95; //수학점수
		  	arr_subject_2[3] = 70; //과학점수
		  	arr_subject_2[4] = 98; //사회점수
		  	arr_subject_2[5] = 100; //음악점수
		  	arr_subject_2[6] = 90; //미술점수
			
			
			
			for(int i=0; i<arr_subject_2.length; i++) {
				System.out.println("arr_subject_2["+i+"] => " + arr_subject_2[i]);
			}//end of for-------------------------

			
			System.out.println("\n~~~~~~~~~~\n");
			
			sum = 0;
			for(int i=0; i<arr_subject_2.length; i++) {
				sum += arr_subject_2[i];
			}//end of for-------------------------
			
			System.out.println("총점 : " + sum);
			//총점 : 643
			
			
			avg = Math.round((double)sum/arr_subject_2.length*10)/10.0;    //정수나누기 정수니까 정수가 나와 -> 실수까지 볼거야 (더블)붙여주기
			System.out.println("평균 : "+ avg);
			//평균 : 91.8571423425  -> 소수 첫쨋자리까지남기고 반올림할래 -> 91.9
			
			
			
			
			///////////////////////////////////////////////////

			System.out.println("\n==========================\n");

			/*
				위의 1. == 배열의 선언 ==
					2. == 선언되어진 배열을 메모리에 크기할당을 해준다. == 
					3. == 선어되어진 배열의 데이터값을 넣어주기 ==  을
					각각따로 하지 않고 아래와 같이 동시에 할 수 있다.
			 */
				int[] arr_subject_3 = new int[] {100,90,95,70,98,100,90};

			
				for(int i=0; i<arr_subject_3.length; i++) {
					System.out.println("arr_subject_3["+i+"] => " + arr_subject_3[i]);
				}//end of for-------------------------
	

				System.out.println("\n~~~~~~~~~~\n");

				sum = 0;
				for(int i=0; i<arr_subject_3.length; i++) {
					sum += arr_subject_3[i];
				}//end of for-------------------------

				System.out.println("총점 : " + sum);
				//총점 : 643


				avg = Math.round((double)sum/arr_subject_3.length*10)/10.0;    //정수나누기 정수니까 정수가 나와 -> 실수까지 볼거야 (더블)붙여주기
				System.out.println("평균 : "+ avg);
				//평균 : 91.8571423425  -> 소수 첫쨋자리까지남기고 반올림할래 -> 91.9
			
				
				///////////////////////////////////////////////////

				System.out.println("\n==========================\n");
				
				/*
				위의 1. == 배열의 선언 ==
					2. == 선언되어진 배열을 메모리에 크기할당을 해준다. == 
					3. == 선어되어진 배열의 데이터값을 넣어주기 ==  을
					각각따로 하지 않고 아래와 같이 동시에 할 수 있다.
					또한 new int[]은 생략 가능하다!!
				*/
				int[] arr_subject_4 = {100,90,95,70,98,100,90};
				
				
				for(int i=0; i<arr_subject_4.length; i++) {
				System.out.println("arr_subject_4["+i+"] => " + arr_subject_4[i]);
				}//end of for-------------------------
				
				
				System.out.println("\n~~~~~~~~~~\n");
				
				sum = 0;
				for(int i=0; i<arr_subject_4.length; i++) {
				sum += arr_subject_4[i];
				}//end of for-------------------------
				
				System.out.println("총점 : " + sum);
				//총점 : 643
				
				
				avg = Math.round((double)sum/arr_subject_4.length*10)/10.0;    //정수나누기 정수니까 정수가 나와 -> 실수까지 볼거야 (더블)붙여주기
				System.out.println("평균 : "+ avg);
				//평균 : 91.8571423425  -> 소수 첫쨋자리까지남기고 반올림할래 -> 91.9
				
	}//end of main()-----------------------------------

}
