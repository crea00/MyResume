package com.project.myresume.profile.dto;

public class EduDto {
	private String id;
	private String place;
	private String major;
	private String edu_exp;
	private String start_date;
	private String end_date;
	private int num;
	
	public EduDto() {}

	public EduDto(String id, String place, String major, String edu_exp, String start_date, String end_date, int num) {
		super();
		this.id = id;
		this.place = place;
		this.major = major;
		this.edu_exp = edu_exp;
		this.start_date = start_date;
		this.end_date = end_date;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEdu_exp() {
		return edu_exp;
	}

	public void setEdu_exp(String edu_exp) {
		this.edu_exp = edu_exp;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	
}
