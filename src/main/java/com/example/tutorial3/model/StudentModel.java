package com.example.tutorial3.model;

public class StudentModel {
	private String name;
	private String npm;
	private double gpa;
	
	public StudentModel (String npm, String name, double gpa) {
		this.npm = npm;
		this.name = name;
		this.gpa = gpa;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setNpm (String npm) {
		this.npm = npm;
	}

	public void setGpa (double gpa) {
		this.gpa = gpa;
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getNpm () {
		return this.npm;
	}
	
	public double getGpa () {
		return this.gpa;
	}
}
