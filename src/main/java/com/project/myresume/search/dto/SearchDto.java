package com.project.myresume.search.dto;

public class SearchDto {
	private String id;//아이디
	private String skill_nm;//기술명
	private String major;//교육, 전공
	private int num;
	private String keyword;//검색어
	private String search_param;
	private String exp;
	
	//페이징 처리 고려 
	private int startRowNum;
	private int endRowNum;
	//이전글 다음글의 글번호
	private int prevNum;
	private int nextNum;
	
	
	public SearchDto() {
		// TODO Auto-generated constructor stub
	}


	public SearchDto(String id, String skill_nm, String major, int num, String keyword, String search_param, String exp,
			int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.id = id;
		this.skill_nm = skill_nm;
		this.major = major;
		this.num = num;
		this.keyword = keyword;
		this.search_param = search_param;
		this.exp = exp;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
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


	public int getStartRowNum() {
		return startRowNum;
	}


	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}


	public int getEndRowNum() {
		return endRowNum;
	}


	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}


	public int getPrevNum() {
		return prevNum;
	}


	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}


	public int getNextNum() {
		return nextNum;
	}


	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}


}
