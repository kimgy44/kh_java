package com.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 자바자료구조 - 랜덤하게 쓰기가 된다.
 * List보다 읽기와 쓰기가 빠르다.
 * List구조는 index로 접근하다.
 * 그리고 순차적이다.(정력 - 2차 가공이 필요하다. - 속도가 느리다.)
 * 1조건가 넘는 메시지를 서버가 매초마다 밀어낸다.
 * Map은 빈자리가 있으면 넣는다.
 * Map은 중복값도 담을 수 있다.
 * 
 * 프론트앤드 진로 - 배열 - React수업
 */
public class MapTest_2 extends Object{

	public static void main(String[] args) {
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("mem_id", "tomato");//래퍼타입..원시형타입을 클래스급으로 바꿔줌..변수와 메소드를 가질수 있다.
		pmap.put("mem_pw", "111");
		pmap.put("mem_name", "토마토");
		//Set<String> set = pmap.keySet(); //바로밑에 한번에 담음
		//메소드 호출의 리턴값으로 객체를 주입(생성)받을 수 있다.
		Object keys[] = pmap.keySet().toArray(); // nice, good
		//전체를 찍을거니까 개선된 for문
		for(Object key:keys) {
			System.out.println(key+", "+pmap.get(key));
			
		}
		//내가한거 망함
		//Map<String, Object> armap = new HashMap<>();
		//arrmap.put("one", valueArr[0]);
		//arrmap.put("one", [0]);
	}

}
