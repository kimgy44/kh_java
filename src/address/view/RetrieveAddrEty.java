package address.view;  /// 2에 있었던 조회부분임 ~!!!!!!!!!!!!!!!

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class RetrieveAddrEty {// 조회(전체조회, 상세조회)
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;// 연결통로
	PreparedStatement pstmt = null;// DML구문 전달하고 오라클에게 요청
	ResultSet rs = null;// 조회경우 커서를 조작 필요

	/***************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회 SELECT id, name, address, DECODE(gender,'1','남','여')
	 * as "성별" , relationship, comments, registedate, birthday FROM mkaddrtb WHERE
	 * id = 5
	 * 
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음 //여기까지 view3
	 *         -------------------------------------------------------------- 회원 목록
	 *         보기 구현 - n건 조회 SELECT id, name, address, DECODE(gender,'1','남','여') as
	 *         "성별" , relationship, comments, registedate, birthday FROM mkaddrtb
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 ************************************/

	public AddressVO[] retrieve(AddressVO vo) { // 전체조회
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
		//DBConnectionMgr dbMgr = new DBConnectionMgr();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, gender   ");
		sql.append("   , relationship, comments, registedate, birthday  ");
		sql.append("FROM mkaddrtb    ");

		//List<Map<Object, String>> addressVO = new ArrayList<>();
		//AddressVO[] aArr = new AddressVO[1]; // 7로쓰면 값이 8줄이상이면 그뒤에 값을 못넣으니까 1줄만 가져올때만 쓰는게 좋다함
		AddressVO dvo = null;
		 
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			// pstmt.setString(1, addressVO);
			rs = pstmt.executeQuery();
			// adressVO = new ArrayList<>();
		//	Map<Object, String> mvo = null;
			
			int i = 0;
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				String gender = rs.getString("gender");
				String relationship = rs.getString("relationship");
				String birthday = rs.getString("birthday");
				String comments = rs.getString("comments");
				String registedate = rs.getString("registedate");
				
			
				AddressVO VO = new AddressVO(id, name, address, telephone,gender,relationship,birthday,comments,registedate);
				//aArr[i++] = VO;
				dvo = VO;
			}
			 	
				/*
				 * while(AddressVO.dtm.getRowCount() > 0) { // 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를
				 * 해결함 AddressVO.dtm.removeRow(0) ; String cols[] =
				 * {"이름","주소","전화번호","성별","관계","생년월일", "내용","수정일"}; String data[][] = new
				 * String[0][1];DefaultTableModel dtm = new DefaultTableModel(data,cols);
				 * 
				 * // 1ㅇ?????????????맞아?
				 * 
				 * }
				 */
			
				

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}


		return aArr;

	}

	
	
	public AddressVO[] retrieve() { // 상세조회
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, DECODE(gender,'1','남','여') * as gender  ");
		sql.append(", relationship, comments, registedate, birthday FROM mkaddrtb");
		sql.append(" WHERE  id = ? ");
		
		AddressVO aVO = null;
		
		try {
			
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			// pstmt.setString(1, addressVO);
			rs = pstmt.executeQuery();
			// adressVO = new ArrayList<>();
			Map<Object, String> mvo = null;
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String telephone = rs.getString("telephone");
			String gender = rs.getString("gender");
			String relationship = rs.getString("relationship");
			String birthday = rs.getString("birthday");
			String comments = rs.getString("comments");
			String registedate = rs.getString("registedate");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		
		return null;
	}
}
