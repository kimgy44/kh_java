package com.day7;
// 한개 로우를 담을 수 있는 클래스 설계
// 여기에 사용된 변수들은 전역변수이다.
public class DeptVO {
	private int  deptno = 0;//부서번호
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	private String dname = null;//부서명
	private String loc = null;//지역
}
