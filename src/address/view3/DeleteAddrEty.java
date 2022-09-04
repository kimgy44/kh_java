package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;

import address.view2.DBConnectionMgr;

public class DeleteAddrEty {

	public AddressVO delete(AddressVO vo) {
		System.out.println("DeleteAddrEty delete 호출 성공");

		// DB연동
		Connection con = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr dbMgr = new DBConnectionMgr();

		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM MKADDRTB WHERE id =?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getId());
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("데이터가 삭제되었습니다.");
				//JOptionPane.showMessageDialog(this, "데이터가 삭제되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				// 삭제된 후에 화면 갱신처리하기 - 동기화 처리 진행됨
				// 입력, 수정, 삭제에서 반복적으로 호출 될 수 있다.
				// List<VO>, List<Map>	
				return vo; // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
			}
		
		} catch (Exception e) {
			System.out.println("삭제 오류 : " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			DBConnectionMgr.freeConnection(pstmt, con);
			//DBUtils.close(con,pstmt);
		}
	//	Vector<AddressVO> addressvo = new Vector<>();
		return null;
	}

}
