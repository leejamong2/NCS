package jdbc.day04.singletonPattern;

public class NoSingletonNumber {
	
	private int cnt = 0; //인스턴스변수
	
	//==기본생성자==
	//public  NoSingletonNumber () {} 이 생략됨
	
	public int getNextNumber() {
		return ++cnt;
	}

}
