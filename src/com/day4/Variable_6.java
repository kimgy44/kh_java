package com.day4;

public class Variable_6 {
	// 전역변수는 초기화를 생략할 수 있다. // int i; 생략가능
	int i;
	// 지역변수는 초기화를 생략하면 안돼나???  //- 13번 , 16번 생략하면 안돼!
	// int의 디폴트 값은 0이다
	void methodA(int i) {// 100이 복사됨
		//insert here i = 10
		System.out.println(i);
	}
	public static void main(String[] args) {
		int i;// 변수 선언 // 지역변수 - 메인메소드 안에서 선언한 변수는 지역변수
		i = 10;// 변수의 초기화
		// 지변 i는 다른 메소드에서도 유지가 되나요?
		Variable_6 v6 = new Variable_6();
		i = 100;
		v6.methodA(v6.i);//콜론뒤에 리턴타입//리턴타입이 보이드   //v6넣은건 전역변수로 접근한 것임
	}

}
