package com.day10;

public class X {

	public static void main(String[] args) {
		// 이떄 true는 논리연산자가 아니다.
		String s1 = new String("true");
		boolean isOK = false;
//		if(조건식- true or false) {
//		if(true) {
//		if(1==1) {1과 1은 같니? 결과는 true
//		if(s1) {                  //이자리에 s1은 불가능, 불린언타입이 아니기때문에
		if(isOK) {                // false이니까 가능하다
			// 12번에 조건이 참이 아니면 실행기회를 갖지 못한다.
			System.out.println("참이다");
		}else
			System.out.println("거짓이다");          // 거짓이다 출력
	}

}
