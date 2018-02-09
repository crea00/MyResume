package com.project.myresume.search.dto;

public class SearchDto {
	private String id;//아이디
	private String skill_nm;//기술명
	private String major;//교육, 전공
	private int num;
	private String keyword;//검색어
	private String search_param;
	private String exp;
	
	public SearchDto() {
		// TODO Auto-generated constructor stub
	}

	public SearchDto(String id, String skill_nm, String major, int num, String keyword, String search_param,
			String exp) {
		super();
		this.id = id;
		this.skill_nm = skill_nm;
		this.major = major;
		this.num = num;
		this.keyword = keyword;
		this.search_param = search_param;
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSkill_nm() {
		return skill_nm;
	}

	public void setSkill_nm(String skill_nm) {
		this.skill_nm = skill_nm;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearch_param() {
		return search_param;
	}

	public void setSearch_param(String search_param) {
		this.search_param = search_param;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

}
