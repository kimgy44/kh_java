package com.base;
// Ctrl+s 누르면 저장과 동시에 javac Hello. java => Hello.class
// java Hello 엔터
// public 접근 제한자라고 한다.
// public > protected > friendly > private
// 접근제한자 public같은 예약어는 변수명으로 사용불가
// class는 클래스 선언시 사용하는 예약어임
public class Hello {
	// 선언부 - 변수 선언 및 초기화를 할 수 있다.
	// 변수와 메소드를 선언할 수 있다.
	// 변수 선언을 동시에 데이터를 담을 수 있다.
	// 변수타입 변수명 대입연산자 값
	int age = 25;
// 여기는 클래스 영역입니다.
// 클래스 안에는 변수와 메소드가 살고 있습니다.
// 메인 메소드가 있어야 exe 즉 실행 파일로 만들 수 있다.
// 코드가 많아도 가장 먼저 실행되는 곳이 main메소드 이다.
// entry point이다.
// 메소드와 변수를 구분하기
// 어떤 이름 뒤에 괄호가 있으면 메소드 이다.
// static영역에서는 non-static변수나 메소드는 사용이 불가하다.
	public static void main(String[] args) {
        System.out.println("Hello Java");
	}// end of main method - 기능, 처리, event

}// end of Hello - 사용자 정의 클래스 선언 및 구현이 끝나는 것
