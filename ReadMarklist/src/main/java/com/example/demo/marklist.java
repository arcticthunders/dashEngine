package com.example.demo;

public class marklist {
    
	private int examid;
	private String student_id;
	private float mark;
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public marklist(int examid, String student_id, float mark) {
		super();
		this.examid = examid;
		this.student_id = student_id;
		this.mark = mark;
	}

	
	
}
