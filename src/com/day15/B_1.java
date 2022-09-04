package com.day15;

import javax.swing.JDialog;

public class B_1 extends JDialog {
	public B_1 () {
		System.out.println("B 디폴트 생성자 호출 성공:전변초기화:선언시 초기화 생략가능");
		initDisplay();
	}
	// 화면을 그려주는 메소드 구현
	public void initDisplay() {
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(true);
	}
}
