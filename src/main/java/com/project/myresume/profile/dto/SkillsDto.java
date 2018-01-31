package com.project.myresume.profile.dto;

//기술 dto
public class SkillsDto {
	private String id;// 사용자 아이디
	private String skill_nm;// 기술명
	private String skill_exp;// 기술설명
	private int num;

	public SkillsDto() {
		// TODO Auto-generated constructor stub
	}

	public SkillsDto(String id, String skill_nm, String skill_exp, int num) {
		super();
		this.id = id;
		this.skill_nm = skill_nm;
		this.skill_exp = skill_exp;
		this.num = num;
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

	public String getSkill_exp() {
		return skill_exp;
	}

	public void setSkill_exp(String skill_exp) {
		this.skill_exp = skill_exp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
