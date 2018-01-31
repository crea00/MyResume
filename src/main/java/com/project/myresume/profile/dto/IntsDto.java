package com.project.myresume.profile.dto;

//관심사 dao
public class IntsDto {
	private String id;// 아이디
	private String ints_nm;// 관심사
	private String ints_exp; // 관심사 설명
	private int num;

	public IntsDto() {
		// TODO Auto-generated constructor stub
	}

	public IntsDto(String id, String ints_nm, String ints_exp, int num) {
		super();
		this.id = id;
		this.ints_nm = ints_nm;
		this.ints_exp = ints_exp;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInts_nm() {
		return ints_nm;
	}

	public void setInts_nm(String ints_nm) {
		this.ints_nm = ints_nm;
	}

	public String getInts_exp() {
		return ints_exp;
	}

	public void setInts_exp(String ints_exp) {
		this.ints_exp = ints_exp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
}
