package com.day11;

import java.util.Scanner;

public class one {
		
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			System.out.println(str.length() + "글자입니다");
			if(str == "exit") {
				break;
			} 
				// length() : 문자열에 대한 글자 수 반환 메소드
		}	
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	
		

	}

