package com.project.myresume.users.dto;

public class UsersDto {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone_no;
	private String is_admin;
	private String regdate;
	
	// FileDto 내용
	private int num;				
	private String orgFileName;		// 원본 파일명
	private String saveFileName;	// 저장된 파일명
	private long fileSize;			// 파일의 크기 byte는 큰 숫자일 수 있으므로
	
	public UsersDto(){	}

	public UsersDto(String id, String password, String name, String email, String phone_no, String is_admin, String regdate,
			int num, String orgFileName, String saveFileName, long fileSize) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.is_admin = is_admin;
		this.regdate = regdate;
		this.num = num;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.fileSize = fileSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	
}
