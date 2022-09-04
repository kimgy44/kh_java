package ajdbc.member;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

public class ZipcodeSearch extends JFrame 
implements FocusListener, ActionListener, MouseListener{
   
   // 선언부
   JPanel jp_north = new JPanel();
   JTextField jtf_dong = new JTextField("동이름을 입력하세요", 20);
   JButton jbtn_search = new JButton("찾기");
   String zdos[] = {"전체", "서울", "경기"};
   JComboBox jcb = new JComboBox(zdos);
   String cols[] = {"우편번호","주소"}; //jtable에 들어갈 헤더의 1차 배열
   String data[][] = new String[0][2];
   DefaultTableModel dtm = new DefaultTableModel(data, cols);
   JTable            jtb = new JTable(dtm);
   Font          font = new Font("돋움체",Font.BOLD,18);
   JScrollPane      jsp = new JScrollPane(jtb);
   DBConnectionMgr  dbMgr = new DBConnectionMgr();
   Connection         con =  null;
   PreparedStatement pstmt =  null;
   ResultSet            rs = null;
   MemberShip 			ms = null;//이건인스턴스화를직접적으로하면절대안됨.복제본이만들어지기때문에
   // 생성자
   public ZipcodeSearch() {}
   public ZipcodeSearch(MemberShip ms) {//생성자를 파라미터로 가져와서 재사용하기 안그러면 널포인트입셉션~
	   this.ms = ms;//초기화
   }
   // 화면처리부 
   public void initDisplay() {
	   jtb.addMouseListener(this);//화면에대고 더블클릭하는 상황
       jtf_dong.addFocusListener(this);
       jtf_dong.addActionListener(this);
       jbtn_search.addActionListener(this);
       jp_north.setLayout(new BorderLayout());
       jp_north.add("West",jcb);
       jp_north.add("Center", jtf_dong);
       jp_north.add("East", jbtn_search);
       this.add("North", jp_north);
       this.add("Center",jsp);
       this.setTitle("우편번호 검색기");
       this.setSize(430,400);
       this.setVisible(true);
   }
   public void refreshData(String dong) {//입련된 동정보를 가지고 조회하는 부분을 처리하기//파라미터로 동정보받기
      StringBuilder sql = new StringBuilder();//쿼리문을 담을수 있는
      List<Map<String, Object>> zipList = new ArrayList<>();//자료구조 정의
      sql.append("select                           ");
      sql.append("      zipcode, address          ");
       sql.append("  from zipcode_t                 ");
       sql.append(" where dong like '%'||?||'%'" );
      try {
         con = dbMgr.getConnection();
         pstmt = con.prepareStatement(sql.toString());
         pstmt.setString(1,dong);
         rs = pstmt.executeQuery();
         Map<String, Object> rmap = null;//while문이 돌기전에 map에 대해서도 초기화의 선언 필요
         while(rs.next()) {//입력한 정보에 따라 n건이 조회될 수 있으니 반복문으로 처리
            rmap = new HashMap<>();//데이터가 존재하는 상황에서 hashmap/while문안에서 인스턴스화
            rmap.put("zipcode", rs.getString("zipcode"));//조회된 컬럼은 2개
            rmap.put("address", rs.getString("address"));//바차로 했기때문에 rs.getString
            zipList.add(rmap);//while문이 끝나기전에 map에담긴정보를 전체로우를 관리하고 있는 arraylist에 담기/파라미터는 맵에담긴정보로
         }
         // 조회된 결과를 DefaultTableModel에 매핑하기 
         for(int i=0;i<zipList.size();i++) {
            Map<String, Object> map = zipList.get(i);//바깥쪽리스트안에 내부적으로 컬럼을 가지로 있는 맵이 들어있는 유형임
            Vector<Object> oneRow = new Vector<>();//맵에서 꺼낸 정보를 벡터에 담기
            oneRow.add(0,map.get("zipcode"));//맵에있는값꺼내기
            oneRow.add(1,map.get("address"));
            dtm.addRow(oneRow);
         }
      } catch (SQLException se) {//쿼리문이 출력되는 내용이 확인하고 싶다면
         System.out.println(se.toString());
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBConnectionMgr.freeConnection(rs, pstmt, con);//사용한 자원 역순으로 반납
      }
   }
   // 메인 메소드 
   public static void main(String[] args) {
      ZipcodeSearch zc = new ZipcodeSearch();
      zc.initDisplay();
   }
   
   @Override
   public void focusGained(FocusEvent e) {
      if(e.getSource() == jtf_dong) {
         jtf_dong.setText("");
      }
   }

   @Override
   public void focusLost(FocusEvent e) {
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();//소스정보받기
      if(obj == jtf_dong || obj == jbtn_search) {
         String user = jtf_dong.getText(); // 역삼, 당산, ...//사용자가 입력한 동정보를  테스트필더에서 얻어오기에
         refreshData(user);//그유저정보가 파라미터로 넘어가면 
      }
	      
   }
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	if(e.getClickCount() == 2)
		System.out.println("더블 클릭 한거야?");
	int index[] = jtb.getSelectedRows();//선택했는지의유무
	if(index.length == 0) {//0이면선택을안했다는의미.리턴을호출해서마우스프레스라는이벤트를 탈출하도록
		JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하십시오.");
		return;
	}
	else {
		//사용자가 더블클릭한 로우의 우편번호 가져오기
		String zipcode = (String)dtm.getValueAt(index[0],0);
		//사용자가 더블클릭한 로우의 주소 가져오기
		String address = (String)dtm.getValueAt(index[0], 1);
		System.out.println(zipcode+","+address);
		ms.jtf_zipcode.setText(zipcode);
		ms.jtf_address.setText(address);
	}
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
}