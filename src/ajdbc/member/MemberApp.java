package ajdbc.member;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;
import ajdbc.zipcode.ZipCodeSearchApp;

// JFrame jf = new JFrame();
// jf.setTitle("자바실습")
// JFrame jf = new JFrame("자바실습");
public class MemberApp extends JFrame implements ActionListener, MouseListener {
	JPanel        jp_north = new JPanel(); //속지1장
	JButton jbtn_sel = new JButton("조회"); //버튼4개
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	String cols[] = {"번호", "아이디", "이름", "주소"};//JTable에 들어갈 헤더부분을 1차배열로
	String data[][] = new String[0][4];//JTable 헤더부분이 아닌 바디부분에 들어올 것을 2차배열로 /전체 컬럼이 4개니까
	DefaultTableModel dtm = new DefaultTableModel(data,cols);//생성자를 통해서 초기화할수 있다.
	JTable		      jtb = new JTable(dtm);
	Font		      font = new Font("돋움체", Font.BOLD, 18);
	JScrollPane		  jsp  = new JScrollPane(jtb); //내용이 많아지면 스크롤을 받아야하니까
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null; // 연결 통로
	PreparedStatement pstmt = null; // DML 구문 전달하고 오라클에게 요청
	ResultSet rs = null; // 조회 경우 커서를 조작 필요
	MemberShip		  ms	= new MemberShip(this);//컨트롤하고 눌렀을때 멤버십생성자로 가게되고! 화면이 동시에 열리게됨!!!!!생성자안에서 이닛디스플레이를 하고 있으니까 메소드가호출되는위치를 바꾸자 아니면 셋비져블컨트롤
	public MemberApp() {
		// 이벤트 소스와 이벤트 처리 클래스를 매핑
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		initDisplay();
		refreshData();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_ins) {//ins눌렀을떄 다른화면불러오게!!!!
			ms.initDisplay();//멤버십의 인스턴스변수ms를 붙여서 멤버십의 화면이 ins 눌렀을때 멤버십의화면이 불러오게끔
		}
		else if(obj == jbtn_sel) {
			refreshData();
		}

	}
	public void refreshData() {//조회했을때 보여지는 
		
		List<Map<String,Object>> memList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_pw			");
	    sql.append("  ,mem_name, mem_zipcode, mem_address   ");
	    sql.append("  FROM member                           ");
	    sql.append("  ORDER BY mem_no desc                  ");
	    try {
			// insert here
	    	con = dbMgr.getConnection(); //쓰기위해서는 위에 인스턴스화
			pstmt = con.prepareStatement(sql.toString()); //타입을 맞춰야하기에 투스트링
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				rmap.put("mem_address", rs.getString("mem_address"));
				memList.add(rmap);
			}
			// insert here
			// 기존에 조회된 결과 즉 목록 삭제하기
			while (dtm.getRowCount() > 0) { //조회를 계속해서 눌렀을때 연달아나오지않게!!!!!
				// 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함
				dtm.removeRow(0);
			}
			//System.out.println(memList);
			// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
			Iterator<Map<String,Object>> iter = memList.iterator();
			Object keys[] = null;
			while(iter.hasNext()) {
				Map<String,Object> data = iter.next();
				keys = data.keySet().toArray();//키값꺼내는건 수업했던거 찾아서 쓰기!!!!!!!@!!@
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[0]));
				oneRow.add(data.get(keys[3]));
				dtm.addRow(oneRow);
			}
		} catch(SQLException se) {
			System.out.println("[[query]]"+sql.toString());
			System.out.println(se.toString());//
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		} 
	}
	public void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));//이걸 적어야 왼쪽부터 조회,입력,수정,삭제가 붙음!!!!!!!!!!
		jbtn_sel.setBackground(new Color(158,9,9));//배경색
		jbtn_sel.setForeground(new Color(212,212,212));//글자색
		jp_north.add(jbtn_sel);
		jbtn_ins.setBackground(new Color(7,84,170));
		jbtn_ins.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_ins);
		jbtn_upd.setBackground(new Color(19,99,57));
		jbtn_upd.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_upd);
		jbtn_del.setBackground(new Color(54,54,54));
		jbtn_del.setForeground(new Color(212,212,212));
		jp_north.add(jbtn_del);
		this.add("North",jp_north);//이걸 안적어서 화면에 조회,입력,수정,삭제가 안보였음!!!!!!!!!!!!!!!!!!!!!!
		this.add("Center", jsp);
		this.setTitle("회원관리시스템 Ver1.0");
		this.setSize(600, 400);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	public static void main(String[] args) {
		new MemberApp();

	}

}
