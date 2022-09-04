package address.view4;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ModifyAddrEty {
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;

	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공:" + vo);
		AddressVO rVO = new AddressVO();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mkaddrtb  ");
		sql.append("   SET name = ?  ");
		sql.append("      ,address = ?");
		sql.append("      ,gender = ? ");
		sql.append(" WHERE id =?      ");
		int id = vo.getId();
		int result = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, vo.getId());
			result = pstmt.executeUpdate();
			rVO.setResult(result);
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql.toString());
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		} finally {
			// DB연동에서 사용한 자원 반납하기
			dbMgr.freeConnection(pstmt, con);
		}
		return rVO;
	}//////////// end of modify

	public AddressVO myBatisModify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공:" + vo);
		AddressVO rVO = new AddressVO();
		// 물리적으로 떨어져 있는 오라클 서버에 커넥션을 연결할때
		SqlSessionFactory sqlMapper = null;
		String resource = "address/view4/MapperConfig.xml";
		// 쿼리문을 가지고 오라클서버 요청하기
		SqlSession sqlSes = null;
		int result = 0;
		Reader reader = null;
		//List<Map<String, Object>> addressList = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			result = sqlSes.update("updateAddress", vo);
			
			reader.close();
			sqlSes.commit();
			
			System.out.println("myBatisModify : " + vo);
			
			rVO.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		}
		// return null;   <== 이부분에 절대로 이거가 들어가면 안됨 
		return rVO;
	}

}
