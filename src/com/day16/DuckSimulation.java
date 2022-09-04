package com.day16;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new MallardDuck();
		// MallardDuck은 FlyBehavior의 구현체 클래스가 아니다.
		// MallardDuck은 fly메소드를 직접 오버라이딩 하지 않는다.
		myDuck.performFly();
		myDuck.display();
		myDuck = null;
		myDuck = new RubberDuck();
		myDuck.display();
		myDuck.performFly();
		WoodDuck herDuck = new WoodDuck();//6번은 상위클래스, 이거는 하위 클래스
		herDuck.display();
		herDuck.performFly();
		herDuck = (WoodDuck)myDuck;//컨벤션을 지키지 않았다. 오른쪽에 있는 타입이 왼쪽에 있는 타입보다 작아야해//그러므로 강제형변화해줘야해
		herDuck.display();
		//myDuck = herDuck;
		
	}

}
