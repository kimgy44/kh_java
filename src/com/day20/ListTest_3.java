package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_3 {

	public static void main(String[] args) {
		List nameList = new ArrayList();
		nameList.add("나신입");
		System.out.println("size : "+nameList.size());//0->1(10라인이있어서)
		String name = (String)nameList.get(0);
		System.out.println(name);// 나 신입    ////이걸내가 안했네
		//제네릭을 추가한 인스턴스화의 경우 타입체크 필요없은
		List<String> nameList2 = new ArrayList<>();
		nameList2.add("나초보");
		// 제네릭에서 String타입을 명시하였으므로 캐스팅연산자가 필요없다.
		String name2 = (String)nameList2.get(0);//////
		// insert here
		System.out.println(name2);// 나 신입    ////이걸내가 안했네
		
	}

}
