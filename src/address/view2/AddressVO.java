package address.view2;

import java.io.Serializable;

public class AddressVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private String telephone;
	private String gender;
	private String relationship;
	private String birthday;
	private String comments;
	private String registedate;
	private String command;
	private int id;
	// 주소록에 없는 컬럼 추가
	// 사용자가 선택한 메뉴 정보 담기
	// 입력 : insert, 수정 : update, 삭제 : delete
	// 상세보기 : select, 전체보기 : selectall
//	private Integer id;

	private AddressVO[] AddressVOS;

	public AddressVO() {
	}

	public AddressVO(int id, String name, String address, String telephone, String gender, String relationship, String birthday,
			String comments, String registedate) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.gender = gender;
		this.relationship = relationship;
		this.birthday = birthday;
		this.comments = comments;
		this.registedate = registedate;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public String getGender() {
		return this.gender;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public String getComments() {
		return this.comments;
	}

	public String getRegistedate() {
		return this.registedate;
	}

	public String getCommand() {
		return this.command;
	}

	public int getId() {
		return this.id;
	}

//	public Integer getId()           { return this.id; }
	public AddressVO[] getAddressVOS() {
		return this.AddressVOS;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setRegistedate(String registedate) {
		this.registedate = registedate;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAddressVOS(AddressVO[] AddressVO) {
		this.AddressVOS = AddressVO;
	}

	public static int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void removeRow(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setResult(int result) {
		// TODO Auto-generated method stub
		
	}



//	public void setId(Integer id) {
//		this.id = id;
//	}

}
