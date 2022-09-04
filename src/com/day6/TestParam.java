package com.day6;
//ECMAScript6 -> class지원하게 됨
class Param{
	// 생성자가 전변에 대한 초기화를 대신 해줌
	int ival;// 전변 초기화 생략 가능 - 0
}
public class TestParam {
	void effectParam(Param p) {// call by reference 원본의 주번갖고 있음
		p = new Param(); // 복사본이 생성되고 그러니까 새로운 객체가 생성됨. 타입은 같지만 객체는 다르다.
		p.ival = 300; // 원본에 ival값이 -> 500 -> 300변경됨
		System.out.println("sub ival : "+p.ival); //300
	}
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		// 인스턴스화 진행 - 메모리에 로딩됨
		Param p = new Param();
		p.ival = 500; // 지변 p에 500초기화
		tp.effectParam(p); // 메인에서 출력전에 메소드호출이 먼저 일어남 
		System.out.println("main ival : " + p.ival); //300

	}

}
/*
 * 12번 : 나 자신에 대한 인스턴스화 이다.
 * 왜 인스턴스화를 했나요? - 15번의 effectParam메소드를 호출하기 위해서
 * 14번에서는 13번에서 인스턴스화 된 클래스의 전번인 ival변수에
 * 초기값이 0이 대신 500으로 덮어쓰기가 발생함
 * 아직은 출력하는 문장을 만나지 못함
 * 15번 effecrParam의 메소드를 경유ㅠ하게 되는데 이때 13번에서 정의된 객체의
 * 주소번지를 가지고 7번으로 진입합니다..
 * 7번의 지번 p와 13번 p의 주소번지는 같다 if(s==s1)
 * 따라서 8번의 ival변수의 300은 13번에서 만들어진 원본 클래스의 전변이 변경
 * 되는 것입니다.
*/