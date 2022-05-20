package com.cg.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="doctor")

public class Doctor {


	private int doctorid;
	private String doctorname;
	private String doctoraddress;
	private String doctorspec;
	
	//super class
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterized class
	public Doctor(int doctorid, String doctorname, String doctoraddress, String doctorspec) {
		super();
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctoraddress = doctoraddress;
		this.doctorspec = doctorspec;
	}
	
	//getter and setter
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDoctoraddress() {
		return doctoraddress;
	}
	public void setDoctoraddress(String doctoraddress) {
		this.doctoraddress = doctoraddress;
	}
	public String getDoctorspec() {
		return doctorspec;
	}
	public void setDoctorspec(String doctorspec) {
		this.doctorspec = doctorspec;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", doctorname=" + doctorname + ", doctoraddress=" + doctoraddress
				+ ", doctorspec=" + doctorspec + "]";
	}
	
	
	
	
}
