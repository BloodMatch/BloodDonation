package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Analysis;
import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.interfaces.IAppointmentDao;

public class AppointmentDaoImp implements IAppointmentDao{
	private Connection connection = DbConnection.getConnection();

	public Appointment insert(Appointment appointment) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO APPOINTMENT( STATE, DATE, SATISFACTION, COMMENT, DONORCIN, CENTERID) VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, appointment.getState());
			ps.setString(2, appointment.getDate());
			ps.setLong(3, appointment.getSatisfaction());
			ps.setString(4, appointment.getComment());
			ps.setString(5, appointment.getDonorCin());
			ps.setLong(6, appointment.getCenterId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				appointment.setId(rs.getInt(1));
				return appointment;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Appointment find(long id) {
		Appointment appointment = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM APPOINTMENT WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				appointment = new Appointment();
				appointment.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}

	public List<Appointment> findAll() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM APPOINTMENT");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setThis(rs);
				appointments.add(appointment);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	public Appointment update(Appointment appointment) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE APPOINTMENT SET STATE=?, DATE=?, SATISFACTION=?, COMMENT=? WHERE id=?");
			ps.setString(1, appointment.getState());
			ps.setString(2, appointment.getDate());
			ps.setLong(3, appointment.getSatisfaction());
			ps.setString(4, appointment.getComment());
			ps.setLong(5, appointment.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return appointment;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM APPOINTMENT WHERE id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Appointment find(Analysis analysis) {
		return this.find(analysis.getAppointmentId());
	}

	public List<Appointment> find(Donor donor) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM APPOINTMENT WHERE DonorId=?");
			ps.setLong(1, donor.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setThis(rs);
				appointments.add(appointment);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	public List<Appointment> find(Center center) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM APPOINTMENT WHERE CenterId=?");
			ps.setLong(1, center.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setThis(rs);
				appointments.add(appointment);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

}