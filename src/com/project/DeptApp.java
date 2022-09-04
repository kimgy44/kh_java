package com.project;

import address.step1.AddressBook;

//getDeptno List() : List(Map(String, Object))


public class DeptApp {
	class List {
		
		class Map {
	
	
		}
	}
	
	//try-catch는 서버에 접속하기 위해서
	//만약 아이피를 바꾸면 연결이 안되기에 try catch
	// 오라클 서버에 접속하기 위해서 아이피,포트,초림,0517 
/*
 * 제조사에 접근하기 위해서  class.forName(    ); <-작성해야해    ( )는 메소드이다. 문장이 끝나고 ;
 * 클래스 이름이 필요함  class.forName( oracle.jdbc.driver...oracledriver ...폴더이름..   );
 * 위에를 통해서 제조사를 알게되었다 => 벤더!
 * 그다음에 커넥션이 있어야함 <연결통로> <인터페이스>     너와나의 연결고리
 * Connection con = (클래스이름)DriverManger.(변수아니면 메소드의 소유주)getConnection( url, 포트 , 아이디.비번)
 * 채널을 확보했으니 전력을 보낸다.
 * PreparedStatment (변수)pstmt = con.(메소드)prepardStatment(selet ~ from dept까지...어디로? 오라클 서버를 );
 * 왜보내? 찾아줄래? 부서번호, 부서이름, 지역을 찾아달라
 * 그다음에 너가 찾은 거(오라클이 처리해준거) 내놔봐 
 * ResultSet rs = pstmt.executeQuery();
 * 오라클에 살고있는 커서를 컨트롤해준다.
 * 
 * executeQuery : 오라클 너~ 이 select문을 처리해줄래? 
 * 
 * 4개니까 반복문 while/ ㄴㅐ안에 boolean
 * while(rs.next())        <- true가 있으면 로우가 있다/false이면 로우가 없다.
 * 
 * 와일문 안에서는 map을 4번 인스턴스화 해야함...로우가 1-10,2-20,3-30,4-40
 * 그런데 인스턴스화할때마다 list에 넣어야해
 * 
 * list.add(rmap부서번호, 부서이름, 지역)   //add를 몇번해? 4번 왜? 로우가 4개니까...
 */
	try {
		class.forName(oracle.jdbc.driver.OracleDriver ); //애를 통해서 제조사를 알 수 있다.

		catch
	}
	Connection con = DriverManger.getConnection( url, 유저, 비번)
	// url : ip,포트,orcl
			
    PreparedStatment pstmt = con.prepardStatment(selet ~ from dept까지...어디로? 오라클 서버를 );



	ResultSet rs = pstmt.executeQuery(); //오라클 너~ 이 select문좀 처리해줄래?
		while (rs.next()) // 와일문 안에서는 map을 인스턴스화를 해야해. 4번! 왜? 로우가 몇개야? 
//인스턴스화할때마다 어디에 넣어야해? list! 
//맵은 와일문 안에서 인스턴스화..... 왱? 4번...10.20.30.40 - 오버라이드! 후~날라가기전에 list에 add하자 뭐를?한개 로우를!어딨어? map을

//list
	 list.add(rmap)
	public AddressVO register(AddressVO) {
		
	}
	public static void main(String[] args) {
		
	}
}
