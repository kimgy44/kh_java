package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import address.view2.DBConnectionMgr;

public class ModifyAddrEty {

	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공");
		

		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Connection con = null;
		PreparedStatement pstmt = null;
		//Object rs = null;
		
		StringBuilder sql = new StringBuilder();
		//"UPDATE MKADDRTB ID = ?, REALTIONSHIP = ? WHERE CODE = ?";	
		sql.append("UPDATE MKADDRTB SET ");
		sql.append("name = ?      ");
		sql.append("where name = ? ");
		int result = 0;
		
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 1;
			Map<String, Object> rmap = null;
			//pstmt.setString(2, getName());		
			pstmt.setString(i++, vo.getName());
			pstmt.setString(i++, vo.getAddress());
			pstmt.setString(i++, vo.getTelephone());
			pstmt.setString(i++, vo.getGender());
			pstmt.setString(i++, vo.getRelationship());
			pstmt.setString(i++, vo.getBirthday());
			pstmt.setString(i++, vo.getComments());
			int cnt = pstmt.executeUpdate();	
			System.out.println(cnt + "건이 실행되었습니다.");
			/*
			 * if(result == 1) { JOptionPane.showMessageDialog(addressVO, "데이터가 수정 되었습니다.",
			 * "Info", JOptionPane.INFORMATION_MESSAGE); addressVOSelectAll();// 새로고침 처리 메소드
			 * 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다. }
			 */		
		} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
		}finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		//return vo;

		
		return null;
	}

}
