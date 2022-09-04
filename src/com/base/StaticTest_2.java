package com.base;

public class StaticTest_2 {
		int age = 30;// =기호는 대입연산자라고 읽는다
		static int birth_year = 2000;
		public static void main(String[] args) {
			// 아래 코드를 어떻게 바꾸면 8번 라인에서 4번 라인에 선언된 변수의 값 30을 출력할 수 있을까요?
			StaticTest_2 st = new StaticTest_2();
			System.out.println(st.age);//30을 기대했지만 실제로는 20이 출력된다
		}// end of main
}////// end of StaticTest