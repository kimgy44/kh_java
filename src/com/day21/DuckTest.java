package com.day21;
// 백앤드 - 자바+스프링 (객체주입, 의존성주입, 제어역전)
import com.day16.MallardDuck;
//메소드의 리턴타입으로 인스턴스화를 할 수 있다!!?!?!????????
public class DuckTest {
	MallardDuck myDuck = null; //전역변수로 선언한건 전역
	// 메소드를 통해서 객체를 주입 받을 수 있다.
	MallardDuck getInstance() {
		// 중급으로 가는 길 - 싱글톤 패턴 검색 - 도깨비 - 공유
		if(myDuck == null) {
			myDuck = new MallardDuck();
		}
		//return new MallardDuck();
		return myDuck;
	}
	void test() {
		getInstance().display();//NullPointException발생함 //11번이 실행이 안되었음.
	}
	public static void main(String[] args) {
		// inser here
		DuckTest dt = new DuckTest();
		dt.test();
	}

}
