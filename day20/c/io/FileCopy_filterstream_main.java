package my.day20.c.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/*   
>>>>> BufferedInputStream 와 BufferedOutputStream <<<<<
   -- 1 byte 기반 스트림.
   -- 필터스트림(다른말로 보조스트림 이라고 부른다.)
   -- 단독으로 사용할 수 없고, 반드시 노드스트림에 장착되어 사용되는 것이다.
      마치 수영장에서 오리발처럼 보조기구로 사용한다.
      이것을 사용하면 오리발처럼 속도가 향상되므로 많이 사용한다.
           
   -- 읽어올 데이터를 매번 1 byte 마다 읽고,쓰고 한다라면 입.출력에 너무 많은 시간이 소요된다. 
      그래서 쓰는 작업없이 메모리 버퍼에 데이터를 한꺼번에 쭉~~ 읽기만 하여 모아두면
      그만큼 쓰는 작업이 없으므로 읽기 속도는 빨라질 것이다.
      그리고 나서 메모리 버퍼에 읽어서 모아두었던 내용을 한방에 쓰기를 하면 매번 1byte 씩 쓰는 것보다
      속도가 빨라진다.
           
    BufferedInputStream 와  BufferedOutputStream 의 기본 버퍼크기는 512 byte 이다.
    
    [예제]
    필터스트림(보조스트림)을 이용해서 파일로 부터 입력받고, 
    입력받은 그 내용을 파일에 출력해본다. 즉, 파일복사하기
       
    >>> 데이터소스 : 파일(FileInputStream --> 노드스트림)
                + 필터스트림(보조스트림)으로 BufferedInputStream 을 사용함.
    
    >>> 데이터목적지 : 파일(FileOutputStream --> 노드스트림)
                  + 필터스트림(보조스트림)으로  BufferedOutputStream 을 사용함.                                                 
      
 */   

// 원본 파일의 크기 6291383byte
/*
   ##################################################
   ##################################################
   ##################################################
   ############
   복사완료!!
      
   # 1개를 1mb(== 1024*1024 byte) 로 본다.  개발자 마음대로 크기정함    
 */

public class FileCopy_filterstream_main {

	public static void main(String[] args) {
		
		try {
			// 입력노드스트림 ==> 파일(FileInputStream)
			String src_fileName = "C:/NCS/iotestdata/_eclipse_다운로드매뉴얼및설치파일.zip";
			File src_file = new File(src_fileName);
			FileInputStream fist = new FileInputStream(src_file);
			
			
			// 입력노드스트림에 보조(필터)스트림(BufferedInputStream)을 장착한다.
			//BufferedInputStream bist = new BufferedInputStream(fist);  //(fist,)에서 크기를 안 넣으면 bist 의 버퍼크기는 512byte 가 됨  //오리발 달음.  어젠,ㄴ 읽고쓰고 했는데 이번거는 다 쌓아두고 한번에 읽고써서 빠르다.
			BufferedInputStream bist = new BufferedInputStream(fist, 1024*1024);  //bist 의 버퍼크기는 1mbyte로 함.
			// 노드스트림인 fist 에 필터스트림(보조스트림)을 장착함.
	        // bist 의 버퍼크기는 1024*1024 byte(== 1mb) 가 된다.
			
			
			
			
			
			
			// 출력노드스트림 ==> 파일(FileOutputStream)
			String target_fileName = "C:/NCS/iotestdata/_JDK11설치_매뉴얼_복사본";
			File target_file = new File(target_fileName);
			FileOutputStream fost = new FileOutputStream(target_file);
	
	
			// 출력노드스트림에 보조(필터)스트림(BufferedOutputStream)을 장착한다. (오리발)
			//BufferedOutputStream bost = new BufferedOutputStream(fost);  //(fost,)에서 크기를 안 넣으면 bost 의 버퍼크기는 512byte 가 됨  //오리발 달음.  어젠,ㄴ 읽고쓰고 했는데 이번거는 다 쌓아두고 한번에 읽고써서 빠르다.
			BufferedOutputStream bost = new BufferedOutputStream(fost, 1024*1024*2);  //bost 의 버퍼크기는 2mbyte로 함.
			// 노드스트림인 fost 에 필터스트림(보조스트림)을 장착함.
			// bost 의 버퍼크기는 1024*1024 byte(== 1mb) 가 된다.
			
			
			
			
			
			
			byte[] data_arr = new byte[1024*1024];  // 1024 byte == 1kb
			
			int input_length = 0;
			int totalByte = 0; //byte 수 누적용도
			int sharp_cnt = 0; // 샵 갯수
			
			long src_file_size = src_file.length();  //파일의 크기를 알려준다,
			System.out.println(">> 원본파일("+ src_fileName +") 크기 : "+ src_file_size+ "byte");
			
			long max_size = 1024*1024*10;  //10 mb
			
			if(src_file_size > max_size) {
				//원본 파일의 크기가 10mb 초과한 경우
				System.out.println(">> 원본 파일의 크기가 10mb 초과했으므로 복사할 수 없습니다. <<");
				
				//닫을 때는 보조(필터)스트림부터 먼저 닫고, 그 다음에 노드스트림을 닫는다.
				bist.close();
				fist.close();
				
				bost.close();
				fost.close();
				return; //메소드의 종료(지금은 main)
			}
		
		
			
				while( (input_length = bist.read(data_arr)) != -1 ) { //fist.read(data_arr)가 아니라 오리발 장착된 bist임. //쉐ㅐ보레 사진을 매번 1키로바이트만큼 -1이 나올때까지 읽을거야
				
					bost.write(data_arr, 0, input_length ); //파일에 쓰기
					bost.flush();
					
					totalByte += input_length;  //읽은 만큼 계속 쌓아준다.
					
					if(totalByte == 1024*1024) {  //1메가 가 되어지면 샵 갯수가 증가한다
						System.out.print("#");
						sharp_cnt++; // 샵 갯수
					}
					
					if(sharp_cnt % 50 == 0) {  //샵 갯수 50 되면 줄바꿈 해줄거야
						System.out.print("\n");
	
					}
				
					
				}//end of while-------------------------------
				
				//닫을 때는 보조(필터)스트림부터 먼저 닫고, 그 다음에 노드스트림을 닫는다.
				bist.close();
				fist.close();
				
				bost.close();
				fost.close();
				
				System.out.println("\n>> " + totalByte + "byte 씀 <<");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

		
	
		
	

	
		
		
	
