package dao.interfaces;


import java.util.List;

import dao.entities.Analysis;
import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;

public interface IAppointmentDao extends IDao<Appointment> {
	/*
	 * Relationships
	 * */
	public Appointment find(Analysis analysis);
	public List<Appointment> find(Donor donor);
	public List<Appointment> find(Center center);
	public List<Appointment> findWhere(String col, String val);
	
	/*
	 * Business
	 * */
	
	// Get free centers (less then 35 passion per day)
	public List<Center> freeCenters(String date, String city);
	
	// Get last valid proposed scheduled Appointment 
	public Appointment lastAppointment(Long donorId);
	
	// Get last Fulfilled donation
	public Appointment lastDonation(Long donorId);
	
	// cancel Appointment
	public Boolean cancelAppoint(Long appointmentId);
	
	// Difference between lastDaonation date and currentDate   
	public Long duration(Appointment appoint);
}
