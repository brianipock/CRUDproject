package entities;

import java.util.ArrayList;

public class Facility {
	private String name;
	private String address;
	private ArrayList <Doctor> doctorsInFacility = new ArrayList<Doctor>();
	public Facility(){
		
	}
	public Facility(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public  ArrayList<Doctor> addDoctor(ArrayList<Doctor> doctorsInFacility){
		
		
		return doctorsInFacility;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Doctor> getDoctorsInFacility() {
		return doctorsInFacility;
	}

	public void setDoctorsInFacility(ArrayList<Doctor> doctorsInFacility) {
		this.doctorsInFacility = doctorsInFacility;
	}


	
}
