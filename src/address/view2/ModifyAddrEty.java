package address.view2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class ModifyAddrEty { // 수정하기
	// return int  - 1:등록 성공 0: 등록 실패
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;

	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공");

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE MKADDRTB ");
		sql.append(" SET  NAME = ? , ADDRESS = ? , TELEPHONE = ? , GENDER = ? ,  RELATIONSHIP = ? , BIRTHDAY = ?, COMMENTS = ?, REGISTEDATE = ?  ");
		sql.append("  WHERE NAME = ? "); //ID = ? ,
		int result = 0;
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
		
			pstmt.setInt(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getTelephone());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getRelationship());
			pstmt.setString(7, vo.getBirthday());
			pstmt.setString(8, vo.getComments());
			pstmt.setString(9, vo.getRegistedate());
		
			result = pstmt.executeUpdate();


			// * JOptionPane.showMessageDialog(this, "데이터가 수정 되었습니다.","Info",
			// * JOptionPane.INFORMATION_MESSAGE); addressVOSelectAll();// 새로고침 처리 메소드 } //
			// * 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다. }
			// */
			if (result == 1) {
				System.out.println(result + "건이 수정되었습니다.");
			//	JOptionPane.showMessageDialog(this, "데이터가 수정되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				vo.setResult(result);// 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
	
			}
		} catch (Exception e) {
			System.out.println("수정 오류 : " + e.getMessage());
			e.printStackTrace();

		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}

		return null;
		// return result;
	}


}
