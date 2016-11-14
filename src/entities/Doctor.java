package entities;

import java.util.ArrayList;

public class Doctor {
	private String fname;
	private String lname;
	private String gender;
	
	private ArrayList<Facility> facilityDoctorWorks = new ArrayList<Facility>();


	public Doctor(){
		
	}
	
	public Doctor(String fname, String lname, String gender) {
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
	}
	
	
	public void addFacility(Facility facilities){
		facilityDoctorWorks.add(facilities);
	}
	public String getName() {
		return fname + " " + lname;
	}
	


	public void setName(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}
}