package jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
		
	public static void main(String[] args) {
		// 물리적으로 떨어져 있는 오라클 서버와 연결통로를 만든다. (=채널을 확보한다) 
		// 메소드 호출로 객체생성 가능하다.
		// getConnection(URL, username, pw)
		Connection 			con = null;  // Interface - 단독으로 인스턴스 불가 A a = new A () 안됨!
		
		// 오라클 서버에 sql문을 전달할 때 사용함.
		PreparedStatement pstmt =  null;
		// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함
		ResultSet 			 rs = null;
		// 유저이름이 필요함. 유리님: yuri, tiger  이거를 받아야 인증(=로그인)받을 수 있음 
		String sql = "SELECT deptno, dname, loc FROM dept";
		// 예외처리해줘야한다. 왜? 동영상 다시 보기 
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야 함.
			// 있는 위치는 C:\\app\\user\\product\\11.1.0\\db_1\\jdbc\\lib 아래에 ojdbc6.jar안에 있어요
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.17.:1521:orcl11", "Scott", "tiger");
			// 파라미터로 받은 select문을 전달
			pstmt = con.prepareStatement(sql);
			// 전달 된 select문에 대한 처리를 요청하고 커서 받아내기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
			}
			System.out.println(con+"생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack메모리에 쌓인 에러 메시지에 대한 history정보 출력 해줌 
			e.printStackTrace();
		}
	
		
	}

}
