package entities;

import java.util.ArrayList;

public class Country {
	private String name;
	private ArrayList<Facility> facilitesInCountry = new ArrayList<Facility>();
	public Country(){
		
	}
	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Facility> getFacilitesInCountry() {
		return facilitesInCountry;
	}

	public void setFacilitesInCountry(ArrayList<Facility> facilitesInCountry) {
		this.facilitesInCountry = facilitesInCountry;
	}
	
	public void addFacility(Facility facility){
		facilitesInCountry.add(facility);
		
	
	}

	
}
