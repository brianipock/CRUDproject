package dao;

import java.util.ArrayList;

import entities.Country;
import entities.Doctor;
import entities.Facility;
import entities.Procedure;

public interface PlasticDAO {
	public ArrayList<Procedure> getListOfProcedures();
	public Procedure getProcedureByName(String name);
	public Country getCountryByName(Country c);
//	public User removeProcedureFromUser(User a, Procedure p);
//	public User addProceduresToUser(User a, Procedure p);
	public ArrayList<Procedure> getProcedures();
	public ArrayList<Country> getCountry();
	public ArrayList<Facility> getFacilities();
	public ArrayList<Doctor> getDoctors();
	public ArrayList<Country> getCountryByName();
	public ArrayList<Doctor> removeDoctor(String name);
	public ArrayList<Country> removeCountry(String name);
	public ArrayList<Procedure> removeProcedure(String name);
	public ArrayList<Facility> removeFacility(String name);
	public ArrayList<Doctor> updateDoctor(Doctor doc, String name);
	public ArrayList<Procedure> updateProcedure(Procedure pro, String name);
	public ArrayList<Country> updateCountry(Country coun, String name);
	public ArrayList<Facility> updateFacility(Facility fac, String name);
	public ArrayList<Procedure> addProcedure(Procedure pro);
	public ArrayList<Doctor> addDoctor(Doctor doc);
	public ArrayList<Facility> addFacility(Facility facil);
	public ArrayList<Country> addCountry(Country coun);

}
