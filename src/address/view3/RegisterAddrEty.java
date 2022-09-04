package address.view3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import address.view2.AddressVO;
import address.view2.DBConnectionMgr;

public class RegisterAddrEty { //입력
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection 		  con = null;
	PreparedStatement pstmt = null;
	
	public AddressVO register(AddressVO vo) {
		System.out.println("RegisterAddrEty register 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO mkaddrtb ");
		sql.append(" (name, address, telephone, gender, relationship, ");
		sql.append("  birthday, comments, registedate, id) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'YYYY/MM/DD'), seq_mkaddrtb_id.nextval)");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;  //이거 넣는거 맞아!?!?!? ㅇㅇ 데이터 한건이 입력~
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getTelephone());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getRelationship());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getComments());
			pstmt.setString(8, vo.getRegistedate());
			if(pstmt.executeUpdate() < 1) {
				String msg = "데이터 입력에 실패했습니다.";
				System.out.println(msg);
			} else {
				System.out.println("데이터 입력에 성공했습니다.");
				//vo.setResult(1);
			}
		} catch(SQLException e) {
			String msg = "데이터 입력에 실패했습니다.";
			System.out.println(msg + "\r\n" + e); 
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}		
		  return vo;
	}

}
