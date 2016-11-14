package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.PlasticDAO;
import entities.Country;
import entities.Doctor;
import entities.Facility;
import entities.Procedure;

@Controller
public class PlasticController {
	@Autowired
	private PlasticDAO plasticDAO;

	public ModelAndView getName() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	
	@RequestMapping("plastic.do")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		ArrayList<Procedure> procedures = plasticDAO.getListOfProcedures();
		mv.addObject("procedures", procedures);
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getListOfProcedures.do")
	public ModelAndView getListOfProcedures(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("procedures", plasticDAO.getProcedures());
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getProcedureByName.do")
	public ModelAndView getProcedureByName(@RequestParam("name") String name){
		System.out.println(name);
		ModelAndView mv = new ModelAndView();
		Procedure p = plasticDAO.getProcedureByName(name);
		System.out.println(p.getProcedureName());
		mv.addObject("procedure", p);
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getProcedures.do")
	public ModelAndView getProcedures(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("procedures", plasticDAO.getProcedures());
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getCountries.do")
	public ModelAndView getCountries(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("countries", plasticDAO.getCountry());
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getFacilities.do")
	public ModelAndView getFacilities(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("facilities", plasticDAO.getFacilities());
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("getDoctors.do")
	public ModelAndView getDoctors(){
		ModelAndView mv = new ModelAndView();
		System.out.println(plasticDAO.getDoctors().size());
		mv.addObject("doctors", plasticDAO.getDoctors());
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	///// remove
	@RequestMapping("removeDoctor.do")
	public ModelAndView removeDoctor(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		System.out.println(plasticDAO.getDoctors().size());
		mv.addObject("doctors", plasticDAO.removeDoctor(name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("removeFacility.do")
	public ModelAndView removeFacility(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		System.out.println(plasticDAO.getDoctors().size());
		mv.addObject("doctors", plasticDAO.removeFacility(name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("removeCountry.do")
	public ModelAndView removeCountry(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		System.out.println(plasticDAO.getDoctors().size());
		mv.addObject("doctors", plasticDAO.removeCountry(name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("removeProcedure.do")
	public ModelAndView removeProcedure(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		System.out.println(plasticDAO.getDoctors().size());
		mv.addObject("procedures", plasticDAO.removeProcedure(name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	///// update
	@RequestMapping("updateDoctor.do")
	public ModelAndView updateDoctor(@RequestParam("name") String name, Doctor doc){
		ModelAndView mv = new ModelAndView();
		mv.addObject("doctors", plasticDAO.updateDoctor(doc, name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	@RequestMapping("goToDoctorForm.do")
	public ModelAndView goToDoctorForm(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		mv.addObject("doctorName", name);
		mv.setViewName("updateDoctor.jsp");
		return mv;
	}
	@RequestMapping("updateFacility.do")
	public ModelAndView updateFacility(@RequestParam("name") String name, Facility fac){
		ModelAndView mv = new ModelAndView();
		mv.addObject("facilities", plasticDAO.updateFacility(fac, name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	@RequestMapping("goToFacilityForm.do")
	public ModelAndView goToFacilityForm(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		mv.addObject("facilityName", name);
		mv.setViewName("updateFacility.jsp");
		return mv;
	}
	@RequestMapping("updateCountry.do")
	public ModelAndView updateCountry(@RequestParam("name") String name, Country coun){
		ModelAndView mv = new ModelAndView();
		mv.addObject("countries", plasticDAO.updateCountry(coun, name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	@RequestMapping("goToCountryForm.do")
	public ModelAndView goToCountryForm(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		mv.addObject("countryName", name);
		mv.setViewName("updateCountry.jsp");
		return mv;
	}
	@RequestMapping("updateProcedure.do")
	public ModelAndView updateProcedure(@RequestParam("procedureName") String name, Procedure pro){
		ModelAndView mv = new ModelAndView();
		mv.addObject("procedures", plasticDAO.updateProcedure(pro, name));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	
	@RequestMapping("goToProcedureForm.do")
	public ModelAndView goToProcedureForm(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		mv.addObject("procedureName", name);
		mv.setViewName("updateProcedure.jsp");
		return mv;
	}
	@RequestMapping("addProcedure.do")
	public ModelAndView addProcedure(Procedure pro){
		ModelAndView mv = new ModelAndView();
		mv.addObject("procedures", plasticDAO.addProcedure(pro));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("goToAddProcedureForm.do")
	public ModelAndView goToAddProcedureForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addProcedure.jsp");
		return mv;
	}
	@RequestMapping("addCountry.do")
	public ModelAndView addCountry(Country coun){
		ModelAndView mv = new ModelAndView();
		mv.addObject("countries", plasticDAO.addCountry(coun));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("goToAddCountryForm.do")
	public ModelAndView goToAddCountryForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCountry.jsp");
		return mv;
	}
	@RequestMapping("addFacility.do")
	public ModelAndView addFacility(Facility facil){
		ModelAndView mv = new ModelAndView();
		mv.addObject("facilities", plasticDAO.addFacility(facil));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("goToAddFacilityForm.do")
	public ModelAndView goToAddFacilityForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addFacility.jsp");
		return mv;
	}
	@RequestMapping("addDoctor.do")
	public ModelAndView addDoctor(Doctor doc){
		ModelAndView mv = new ModelAndView();
		mv.addObject("doctors", plasticDAO.addDoctor(doc));
		mv.setViewName("procedure.jsp");
		return mv;
	}
	@RequestMapping("goToAddDoctorForm.do")
	public ModelAndView goToAddDoctorForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDoctor.jsp");
		return mv;
	}
	
//	@RequestMapping("plastic.do")
//	public ModelAndView getCountry(@RequestParam("name") Country name){
//		ModelAndView mv = new ModelAndView();
//		Country countryData = plasticDAO.getCountryByName(name);
//		mv.addObject("country", countryData);
//		mv.setViewName("procedure.jsp");
//		return mv;
//	}
//	@RequestMapping(path= "plastic.do")
//	public ModelAndView addProceduresToUser(@RequestParam("proceduer") User user, Procedure procedure){
//		ModelAndView mv = new ModelAndView();
//		User addProcedure = plasticDAO.addProceduresToUser(user, procedure);
//		mv.addObject("procedure", addProcedure);
//		mv.setViewName("procedure.jsp");
//		return mv;
//	}
//	@RequestMapping("plastic.do")
//	public ModelAndView removeProcedureFromUser(@RequestParam("name")  User user, Procedure procedure){
//		ModelAndView mv = new ModelAndView();
//		User removeProcedure = plasticDAO.removeProcedureFromUser(user, procedure);;
//		mv.addObject("procedure", removeProcedure);
//		mv.setViewName("procedure.jsp");
//		return mv;
//	}
	@RequestMapping("getCountryByName.do")
	public ModelAndView getCountryByName(@RequestParam("name") Country name){
		ModelAndView mv = new ModelAndView();
		Country countryData = plasticDAO.getCountryByName(name);
		mv.addObject("country", countryData);
		mv.setViewName("procedure.jsp");
		return mv;
	}
}
