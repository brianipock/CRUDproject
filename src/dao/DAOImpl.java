package dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import entities.Country;
import entities.Doctor;
import entities.Facility;
import entities.Procedure;

public class DAOImpl implements PlasticDAO {
//	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Procedure> procedures = new ArrayList<Procedure>();
	ArrayList<Country> countries = new ArrayList<Country>();
	ArrayList<Facility> facilities = new ArrayList<Facility>();
	ArrayList<Doctor> doctors = new ArrayList<Doctor>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init1() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream("/WEB-INF/procedure.txt");
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[0];
				Procedure p = new Procedure(name);
				procedures.add(p);
				System.out.println(p);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream("/WEB-INF/Country.csv");
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[0];
				System.out.println(tokens[0]);
				Country c = new Country(name);
				countries.add(c);
				System.out.println(c);
			}
			for(Procedure p: procedures){
				for(Country c: countries){
				p.addCountry(c);
				}
		
			}
			System.out.println("country size: " + procedures.get(0).getListOfCountries().size());
		} catch (Exception e) {
			System.err.println(e);
		}
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream("/WEB-INF/Facility.csv");
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[1];
				String address = tokens[2];
				Facility f = new Facility(name, address);
				facilities.add(f);
				System.out.println(f);
				Country c = null;
				if (tokens[0].equals("Kr")) {
					for (Country country : countries) {
						if (country.getName().equals("Korea")) {
							c = country;
						}
					}
					c.addFacility(f);
				}
				if (tokens[0].equals("Cr")) {
					for (Country country : countries) {
						if (country.getName().equals("Costa Rica")) {
							c = country;
						}
					}
					c.addFacility(f);
				}
				if (tokens[0].equals("Br")) {
					for (Country country : countries) {
						if (country.getName().equals("Brazil")) {
							c = country;
						}
					}
					c.addFacility(f);
				}
				if (tokens[0].equals("Sg")) {
					for (Country country : countries) {
						if (country.getName().equals("Singapore")) {
							c = country;
						}
					}
					c.addFacility(f);
				}
			}
			for(Procedure p: procedures){
				for(Facility f: facilities){
				p.addFacility(f);
				}
			}
			System.out.println("facility size: " + procedures.get(0).getFacilitesWhereProcedureIsDone().size());
		} catch (Exception e) {
			System.err.println(e);
		}

		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream("/WEB-INF/Doctor.csv");
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String fname = tokens[0];
				String lname = tokens[1];
				String gender = tokens[2];
				Doctor d = new Doctor(fname, lname, gender);
				System.out.println(d);
				doctors.add(d);
				System.out.println(d);
				Facility f = null;
				if (tokens[tokens.length - 1].equals("Jk")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("JK Plastic Surgery")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}
				if (tokens[tokens.length - 1].equals("Ban")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Banobagi")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}if (tokens[tokens.length - 1].equals("TL")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("TL Plastic Surgery")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}if (tokens[tokens.length - 1].equals("Raberg")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Clinica Raberg")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}if (tokens[tokens.length - 1].equals("PlasSurgCent")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("The Plastic Surgery Center Of Costa Rica")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}
				if (tokens[tokens.length - 1].equals("Vikara")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Vikara Klinik")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}if (tokens[tokens.length - 1].equals("Haroldo")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Haroldo Clinica")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}if (tokens[tokens.length - 1].equals("Dream")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Dream Plastic Surgery")) {
							f = facility;
						}
					}
					d.addFacility(f);;
				}
				if (tokens[tokens.length - 1].equals("Woffles")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Woffles Wu Aestetic Plastic Surgery")) {
							f = facility;
						}
					}
					d.addFacility(f);
				}if (tokens[tokens.length - 1].equals("CosSurgClin")) {
					for (Facility facility : facilities) {
						if (facility.getName().equals("Cosmetic Surgery Clinic")) {
							f = facility;
						}
					}
					d.addFacility(f);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	
	public ArrayList<Procedure> getProcedures() {
		// TODO Auto-generated method stub
		return procedures;
	}

//	@Override
//	public User addProceduresToUser(User a, Procedure p) {
//		// TODO Auto-generated method stub
//		return a.addToListofProcedures(p);
//	}
//
//	@Override
//	public User removeProcedureFromUser(User a, Procedure p) {
//		// TODO Auto-generated method stub
//		return a.removeFromListofProcedures(p);
//	}

	@Override
	public Procedure getProcedureByName(String name) {
		Procedure pro = new Procedure();
		System.out.println(name);
		for(Procedure p: procedures){
			System.out.println("names: " + p.getProcedureName());
			if(p.getProcedureName().equals(name)){
				pro = p;
				System.out.println(pro.getListOfCountries().size());
			}
		}
		return pro;
	}

	@Override
	public ArrayList<Country> getCountryByName() {
		// TODO Auto-generated method stub
		return countries;
	}

	@Override
	public ArrayList<Procedure> getListOfProcedures() {
		// TODO Auto-generated method stub
		return procedures;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	public ArrayList<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(ArrayList<Facility> facilities) {
		this.facilities = facilities;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void setProcedures(ArrayList<Procedure> procedures) {
		this.procedures = procedures;
	}

	public ArrayList<Country> getCountry() {
		// TODO Auto-generated method stub
		return countries;
	}

	@Override
	public Country getCountryByName(Country c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Doctor> removeDoctor(String name){
//		Doctor d = null;
		int index = 0;
		for (Doctor doc : doctors) {
			if((doc.getFname() + doc.getLname()).equals(name)){
				index = doctors.indexOf(doc);
			}
		}
		doctors.remove(index);
		return doctors;
	}
	@Override
	public ArrayList<Facility> removeFacility(String name){
//		Facility f = null;
		int index = 0;
		for (Facility facil : facilities) {
			if(facil.getName().equals(name)){
				index = facilities.indexOf(facil);
			}
		}
		facilities.remove(index);
		return facilities;
	}
	@Override
	public ArrayList<Country> removeCountry(String name){
//		Country c = null;
		int index = 0;
		for (Country coun : countries) {
			if(coun.getName().equals(name)){
				index = countries.indexOf(coun);
			}
		}
		countries.remove(index);
		return countries;
	}
	@Override
	public ArrayList<Procedure> removeProcedure(String name){
//		Procedure p = null;
		int index = 0;
		for (Procedure pro : procedures) {
			if(pro.getProcedureName().equals(name)){
				index = procedures.indexOf(pro);
			}
		}
		procedures.remove(index);
		return procedures;
	}
	
	@Override
	public ArrayList<Doctor> updateDoctor(Doctor doc, String name){
		int index = 0;
		for (Doctor doctor : doctors) {
			if((doctor.getFname() + doctor.getLname()).equals(name)){
				index = doctors.indexOf(doctor);
			}
		}
		doctors.set(index, doc);
		return doctors;
	}


//	@Override
//	public User removeProcedureFromUser(User a, Procedure p) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public User addProceduresToUser(User a, Procedure p) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public ArrayList<Procedure> updateProcedure(Procedure pro, String name) {
		int index = 0;
		for (Procedure procedure : procedures) {
			if(procedure.getProcedureName().equals(name)){
				index = procedures.indexOf(procedure);
			}
		}
		procedures.set(index, pro);
		return procedures;
	}


	@Override
	public ArrayList<Country> updateCountry(Country coun, String name) {
		int index = 0;
		for (Country country : countries) {
			if(country.getName().equals(name)){
				index = countries.indexOf(country);
			}
		}
		countries.set(index, coun);
		return countries;
	}

	@Override
	public ArrayList<Facility> updateFacility(Facility fac, String name) {
		int index = 0;
		for (Facility facility : facilities) {
			if(facility.getName().equals(name)){
				index = facilities.indexOf(facility);
			}
		}
		facilities.set(index, fac);
		return facilities;
	}
	@Override
	public ArrayList<Facility> addFacility(Facility fac) {
		facilities.add(fac);
		return facilities;
	}
	@Override
	public ArrayList<Procedure> addProcedure(Procedure pro) {
		procedures.add(pro);
		return procedures;
	}
	@Override
	public ArrayList<Country> addCountry(Country coun) {
		countries.add(coun);
		return countries;
	}
	@Override
	public ArrayList<Doctor> addDoctor(Doctor doc) {
		doctors.add(doc);
		return doctors;
	}
	
}
