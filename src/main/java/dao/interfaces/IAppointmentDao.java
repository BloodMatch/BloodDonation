package dao.interfaces;


import java.util.List;

import dao.entities.Analysis;
import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;

public interface IAppointmentDao extends IDao<Appointment> {
	
	public Appointment find(Analysis analysis);
	public List<Appointment> find(Donor donor);
	public List<Appointment> find(Center center);
}
