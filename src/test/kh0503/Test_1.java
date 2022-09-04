package test.kh0503;

import java.util.Scanner;

public class Test_1 {
	String exit = null;  //public Test() {}// 생략이 가능함 - 단 생성자 하나도 선언된게 없을 때만...
	public void count() {
		Scanner sc = new Scanner(System.in);//UI (User Interface:View계층-화면단, 앞단)없이도
		while(true) {//365 매일 그리고 계속 실행된다. - 메모리(RAM:휘발성-오라클-Table 구조 : MemberVO)에 계속 쌓인다
			System.out.print("문자열을 입력해 주세요 : ");// 힌트
			String str = sc.nextLine();//nextLine의 리턴타입이 void라면 대입연산자를 써서 받을 수 없다. - 메소드의 재사용성
			if(str.equals(str)) {//사용자가 도스창에 exit이라는 문자열을 입력하면. 그래서 같니? equals @abcd1234 == "exit"
				break;
			}else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}///// end of while
		System.out.println("프로그램을 종료합니다.");
	}///////// end of count
/* JVM 실행 순서
 * 25-26[인스턴스화]-27[메소드 호출]-7-8[사용자가 콘솔에 입력한 값 입력받기]-9[while:반복문, 괄호안이 false이면 실행불가]
 * 10-11[입력문자 저장됨]-12[입력문자가 exit과 같은 문자열인지 비교]-13[12번 조건이 참이면 실행됨:break호출하면 while문 탈출함]	
 * 14[사용자가 입력한 문자열이 exit이 아닐때 실행됨]-15-17-18
 */
	public static void main(String[] args) {
		Test t = new Test(); // 디폴트생성자 호출이 동시에 일어남 - 생략가능하다
		t.count();
	}

}