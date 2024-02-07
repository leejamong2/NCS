package my.day09.a.twodimension_array;

public class Main_twodimension_array_1 {

	public static void main(String[] args) {
		

		// === 1차원 배열 === //
		int[] subject_arr = new int[5];  //1행 5열
		/*
		 	      ---------------------
  		 	값 ==> | 0 | 0 | 0 | 0 | 0 |
  		 			---------------------
 			index=> 0   1   2   3   4
		 */
			subject_arr[0] = 100;
			subject_arr[1] = 90;
			subject_arr[2] = 95;
			subject_arr[3] = 80;
			subject_arr[4] = 88;
		
		
		// === 2차원 배열 === //
		int[][] point_arr = new int[4][3];  //4행 3열
		/*
			        -------------
		 	값 ==>   | 0 | 0 | 0 |
		 			------------
		 			| 0 | 0 | 0 |
		 			------------
		 			| 0 | 0 | 0 |
		 			------------
		 			| 0 | 0 | 0 |
		 			------------

			index=> 
			        -----------------------------
			        | [0][0] | [0][1] | [0][2] |
			        | [1][0] | [1][1] | [1][2] |
			        | [2][0] | [2][1] | [2][2] |
			        | [3][0] | [3][1] | [3][2] |
			        -----------------------------
			         
		 */
			
		point_arr[0][0] = 10;
		point_arr[0][1] = 20;
		point_arr[0][2] = 30;
		
		point_arr[1][0] = 40;
		point_arr[1][1] = 50;
		point_arr[1][2] = 60;

		point_arr[2][0] = 70;
		point_arr[2][1] = 80;
		point_arr[2][2] = 90;
		
		point_arr[3][0] = 100;
		point_arr[3][1] = 100;
		point_arr[3][2] = 100;
		
		System.out.println("point_arr.length : " + point_arr.length);
		//point_arr.length : 4
		//2차원배열명.length 은 행의 길이가 나온다
		
		System.out.println("point_arr[0].length : " + point_arr[0].length);
		//point_arr.length : 3
		//2차원배열명[행의인덱스].length 은 그 행에 존재하는 열의 길이(크기)

		System.out.println("point_arr[1].length : " + point_arr[1].length);
		//point_arr.length : 3
		//2차원배열명[행의인덱스].length 은 그 행에 존재하는 열의 길이(크기)
		
		System.out.println("point_arr[2].length : " + point_arr[2].length);
		//point_arr.length : 3
		//2차원배열명[행의인덱스].length 은 그 행에 존재하는 열의 길이(크기)
			
		
		System.out.println("point_arr[3].length : " + point_arr[3].length);
		//point_arr.length : 3
		//2차원배열명[행의인덱스].length 은 그 행에 존재하는 열의 길이(크기)
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<point_arr.length; i++) {//행
			
			for(int j=0; j<point_arr[i].length; j++) { //열
				String add = (j<point_arr[i].length-1)?"," : "\n";
				System.out.printf("%3d%s", point_arr[i][j], add);   //%3칸 %
			}//end of for--------------------------------
			
			
		}//end of for------------------------------
		
		/*
		 		10, 20, 30    //세개를 잡아서 오른쪽배열
		 		40, 50, 60
		 		70, 80, 90
		 		100,100,100
		 */
		System.out.println("\n=========성적결과============\n");
							//국어영어수학
		int[][] jumsu_arr = {{90,80,70},  //이순신
							 {80,85,76},  //엄정화
							 {80,85,76},  //홍길동
							 {85,70,90},  //공유
							 {60,80,50}}; //아이유
		
		int[] total_arr = new int[jumsu_arr.length]; 
		//총점을 저장시켜주는 배열공간. 내 총점 말고 다른사람것도 저장하기 위해서. [5]5행
		
		String[] result_arr = new String[jumsu_arr.length];
		//각 학생별 등수를 제외한 국어, 영어, 수학,총점,평균,학점까지 성적결과를 저장시켜두는 곳.
		
		
				
		
		System.out.println("---------------------------");
		System.out.println("국어\t영어\t수학\t총점\t평균\t학점\t등수");
		System.out.println("---------------------------");
		
		for(int i=0; i<jumsu_arr.length; i++) {
			
			String result = "";
			int sum = 0;
			
			for(int j=0; j<jumsu_arr[i].length; j++) {
				result += jumsu_arr[i][j] + "\t";
				sum += jumsu_arr[i][j]; //총점
				
			}//end of for--------------------------------
			
		
			
			
			
			
		
			double avg = Math.round((double)sum/jumsu_arr[i].length * 10)/10.0;
			
			
			char grade = ' ';
			int count = 0;
			
			
			
			
		
			switch ((int)avg/10) {  //() 에는 정수 인트 바이트 쇼트, 차 , 스트링타입만 올 수 있음.  avg는 실수라 스위치()에 못들어옴.  int로 바꿔주면됨.
				case 10: 
				case 9:
					grade = 'A';
					break;
					
				case 8: 
					grade = 'B';
					break;
					
				case 7: 
					grade = 'C';
					break;
					
				case 6: 
					grade = 'D';
					break;
					
				default:
					grade = 'F';
					break;
					
					
			}//end of switch---------------------------------------
			int kor = 0;
			int eng = 0;
			int math = 0;
			
			result += sum + "\t" + avg + "\t" +grade +"\t";  //sum 내 총점만 나오고 다른사람껀 아직 안나옴.
		 //System.out.println(result);
			
			result_arr[i] = result;  //등수를 뺀 나머지.
			// 각 학생별 국어,영어,수학,총점,평균,등급 까지 결과만을 구해서 배열 result_arr 에 저장시켜 둔다.(등수뺌)
			
			total_arr[i] = sum; //각 학생별 총점을 구해서 배열 토탈어레이에 저장시켜준다.
			
			
			
		}//end of for--------------------------------
		
		
		
		
		//>>> 등수를 구해서 성적결과를 출력하기 <<<
		for(int i=0; i<total_arr.length; i++) {  //위에서 배열길이 5로 다 정해줬으니까 아무거나 써도됨
			
			int rank = 1;
			for(int j=0; j<total_arr.length; j++) {
				
				if(i!=j && total_arr[i]< total_arr[j]){   // total_arr[i]가 내총점    j가 남의 총점
					rank++;
				}
			}
				
				System.out.println(result_arr[i] + rank);
				
				
		}//end of for--------------------------------
			
		System.out.println("\n---------------------------------------\n");
		
		
			int[] arr_subject_total = new int[jumsu_arr[0].length];
			//각 과목별 총점을 저장시켜두는곳
			
			for(int i=0; i<arr_subject_total.length; i++) {  //arr_subject_total.length를 3으로 생각해야지 
				
			
				for(int j=0; j<jumsu_arr.length; j++)  {//점수 어레이가 학생수니까 5  
				arr_subject_total[i] += jumsu_arr[j][i]; 
				
				}
			}//end of for--------------------------------
		
			String str_subject_total = "",  str_subject_avg = "";
			for(int i=0; i<arr_subject_total.length; i++) {
				str_subject_total += arr_subject_total[i] + "\t";
				str_subject_avg += Math.round((double)arr_subject_total[i]/jumsu_arr.length * 10)/10.0 + "\t";
				
			}//end of for--------------------------------
			
			System.out.println(str_subject_total);
			System.out.println(str_subject_avg);
			
			
		/*
		 		--------------------------
		 		국어 영어 수학 총점    평균   학점  등수
		 		---------------------------
		 		90  80 70  240   80.0
		 		80  85 76  241   80.3
		 		80  85 76  241   80.3
		 		85  70 90  245   81.7
		 		60  80 50  190   63.3
		 		--------------------------------
		 		395     400    362
		 		79.0   80.0   72.4
		 */
		
		
		System.out.println("\n##########################\n");
		
		System.out.println(">>배열 arr_subject_total 에 저장된 값을 꺼내오는 첫번째 방법<<");
		for(int i=0; i<arr_subject_total.length; i++) {
			System.out.println(arr_subject_total[i]);
		}//end of for------------------------------
		
		System.out.println("\n>>배열 arr_subject_total 에 저장된 값을 꺼내오는 두번째 방법<<");
		//아래의 for문을   확장for문   또는 개선된for문   이라고 한다.
		for( int subject_total : arr_subject_total) {
			//반복의 횟수는 arr_subject_total 배열의 길이 만큼 한다.
			//int subject_total  = arr_subject_total[0];
			//int subject_total  = arr_subject_total[1];
			//int subject_total  = arr_subject_total[2];
			System.out.println(subject_total);
			
		}//end of for----------------------
		
		
		
		
		
		
		
		
	}//end of main()----------------------------------------

}
