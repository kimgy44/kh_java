package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DeptManager extends JFrame implements ActionListener {
	public final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final String __URL = "jdbc:oracle:thin:@192.168.40.36:1521:orcl11";
	public final String _USER = "scott";
	public final String _PW = "tiger";
	Connection 			con = null;  // Interface - 단독으로 인스턴스 불가 A a = new A () 안됨!
	// 오라클 서버에 sql문을 전달할 때 사용함.
	PreparedStatement pstmt =  null;
	// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함
	ResultSet 			 rs = null;
	// 유저이름이 필요함. 유리님: yuri, tiger  이거를 받아야 인증(=로그인)받을 수 있음 
	String sql = "SELECT deptno, dname, loc FROM dept";
	JButton jbtn_select = new JButton("조회");
	// 화면을 그리는
	public DeptManager() {
		// 이벤트 처리를 담당하는 핸들러 클래스의 주소번지
		// 내안에 actionPerformed 메소드가 재정의 되어있다면 this
		jbtn_select.addActionListener(this);
		initDisplay();
	}
	public List<Map<String,Object>> getDeptList() {
		 List<Map<String,Object>> deptList = null;
		 try {
				// 오라클 제조사가 제공하는 드라이버 클래스가 있어야 함.
				// 있는 위치는 C:\\app\\user\\product\\11.1.0\\db_1\\jdbc\\lib 아래에 ojdbc6.jar안에 있어요
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.36:1521:orcl11", "Scott", "tiger");
				// 파라미터로 받은 select문을 전달
				pstmt = con.prepareStatement(sql);
				// 전달 된 select문에 대한 처리를 요청하고 커서 받아내기
				rs = pstmt.executeQuery();
				deptList = new ArrayList<>();
				Map<String,Object> rmap = null;
				while(rs.next()) {
					rmap = new HashMap<>();
					rmap.put("deptno",  rs.getInt("deptno"));
					rmap.put("dname",  rs.getString("dname"));
					rmap.put("loc",  rs.getString("loc"));
					deptList.add(rmap);
				}
				while(rs.next()) {
					System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
				}
				System.out.println(con+"생성 되었나요?");
			} catch (Exception e) {
				System.out.println("오라클 서버와 연결 통로 확보 실패");
				// stack메모리에 쌓인 에러 메시지에 대한 history정보 출력 해줌 
				e.printStackTrace();
			}
		 	return deptList;
	}
	
	public void initDisplay() {
		this.add("North", jbtn_select);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DeptManager();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn_select) {
			List<Map<String,Object>> deptList = getDeptList();
			for (int i=0; i<deptList.size(); i++ ) {
				Map<String,Object> rmap = deptList.get(i);
				System.out.println(rmap.get("deptno"));
			}
		}
		
		
	}

}
