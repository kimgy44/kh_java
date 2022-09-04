package ajdbc.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oracle.vo.DeptVO;

public class DeptController {
	DeptVO gdVO = null;
	private final String _DEL = "delete";
	private final String _INS = "insert";
	private final String _UPD = "update";
	private final String _SEL = "select";
	DeptDao deptDao = null;
	DeptView deptView = null;
	public DeptController() {}
	public DeptController(DeptView deptView) {
		this.deptView = deptView;
		deptDao = new DeptDao(deptView);
	}
	public DeptController(DeptVO pdVO) {
		this.gdVO = pdVO;
	}
	public DeptVO send(DeptVO pdVO) {
		DeptVO rdVO = new DeptVO();  //이걸로 적게되면 아래에 return pdVO;가 아닌 return rdVO;////DeptVO rdVO = null;            //이걸로 적게되면 return pdVO;
		// delete | insert | update | select
				String command = pdVO.getCommand();
				int result = 0;
				// 너 삭제할거야?
				if(_DEL.equals(command)) {
					result = deptDao.deptDelete(pdVO.getDeptno());
					if(result == 1) rdVO.setResult(result);			
				}
				// 부서 정보 등록할거니?
				else if(_INS.equals(command)) {
					result = deptDao.deptInsert(pdVO);
					if(result == 1) rdVO.setResult(result);			
				}
				// 부서 정보 수정 누른거야?
				else if(_UPD.equals(command)) {
					result = deptDao.deptUpdate(pdVO);
					if(result == 1) rdVO.setResult(result);
				}
				// 부서 정보 상세보기 원해?
				else if(_SEL.equals(command)) {
					rdVO = deptDao.deptSelectDetail(pdVO.getDeptno());
				}
				return rdVO;
			}
			public List<Map<String,Object>> deptSelectAll(){
				List<Map<String,Object>> deptList = new ArrayList<>();
				deptList = deptDao.deptSelectAll();
				return deptList;
			}
		}