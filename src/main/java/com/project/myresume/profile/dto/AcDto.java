package com.project.myresume.profile.dto;

//수상및 자격증 dto
public class AcDto {
	private String id;// 사용자 아이디
	private String ac_nm;// 관심사
	private String ac_exp;// 관심사 설명
	private String ac_date;// 취득일
	private int num; 

	public AcDto() {
		// TODO Auto-generated constructor stub
	}

	public AcDto(String id, String ac_nm, String ac_exp, String ac_date, int num) {
		super();
		this.id = id;
		this.ac_nm = ac_nm;
		this.ac_exp = ac_exp;
		this.ac_date = ac_date;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAc_nm() {
		return ac_nm;
	}

	public void setAc_nm(String ac_nm) {
		this.ac_nm = ac_nm;
	}

	public String getAc_exp() {
		return ac_exp;
	}

	public void setAc_exp(String ac_exp) {
		this.ac_exp = ac_exp;
	}

	public String getAc_date() {
		return ac_date;
	}

	public void setAc_date(String ac_date) {
		this.ac_date = ac_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	

}
