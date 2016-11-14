package entities;

import java.util.ArrayList;

public class Procedure {
	private String procedureName;
	private ArrayList<Facility> facilitesWhereProcedureIsDone = new ArrayList<Facility>();
	private ArrayList<Country> listOfCountries = new ArrayList<Country>();
	
	public Procedure(){
		
	}
	
	public Procedure(String procedurename) {
		this.procedureName = procedurename;
	}

	public void addCountry(Country c){
		listOfCountries.add(c);
	}
	
	public void addFacility(Facility f){
		
		facilitesWhereProcedureIsDone.add(f);
	}
	
	
	public String getProcedureName() {
		return procedureName;
	}


	public void setProcedureName(String procedurename) {
		this.procedureName = procedurename;
	}

	public ArrayList<Facility> getFacilitesWhereProcedureIsDone() {
		return facilitesWhereProcedureIsDone;
	}

	public void setFacilitesWhereProcedureIsDone(ArrayList<Facility> facilitesWhereProcedureIsDone) {
		this.facilitesWhereProcedureIsDone = facilitesWhereProcedureIsDone;
	}

	public ArrayList<Country> getListOfCountries() {
		return listOfCountries;
	}

	public void setListOfCountries(ArrayList<Country> listOfCountries) {
		this.listOfCountries = listOfCountries;
	}


	
	
}
