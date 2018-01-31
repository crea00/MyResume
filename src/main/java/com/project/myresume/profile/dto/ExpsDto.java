package com.project.myresume.profile.dto;

public class ExpsDto {
	private String id;
	private String position;
	private String place;
	private String ex_exp;
	private String start_date;
	private String end_date;
	private int num;
	
	public ExpsDto() {}

	public ExpsDto(String id, String position, String place, String ex_exp, String start_date, String end_date,
			int num) {
		super();
		this.id = id;
		this.position = position;
		this.place = place;
		this.ex_exp = ex_exp;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEx_exp() {
		return ex_exp;
	}

	public void setEx_exp(String ex_exp) {
		this.ex_exp = ex_exp;
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
