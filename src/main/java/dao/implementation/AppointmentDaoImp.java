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
	private final static Connection connection = DbConnection.getConnection();
	
	public Appointment insert(Appointment appointment) {
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO APPOINTMENT ( DONATIONTYPE, `TIME`, DONORID, CENTERID , state) VALUES (?,?,?,?,'Pending') ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, appointment.getDonationType());
			ps.setString(2, appointment.getTime());
			ps.setLong(3, appointment.getDonorId());
			ps.setLong(4, appointment.getCenterId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				appointment.setId(rs.getLong(1));
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
				return appointment;
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
				appointment.setDonor();
				appointment.setCenter();
				appointment.setAnalysis();
				appointments.add(appointment);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}
	
	public List<Appointment> findWhere(String col, String val) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM APPOINTMENT WHERE "+col+" = ? ORDER BY time");
			ps.setString(1, val);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setThis(rs);
				appointment.setDonor();
				appointment.setCenter();
				appointment.setAnalysis();
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
					("UPDATE APPOINTMENT SET STATE=?, DONATIONTYPE=?, `TIME`=?, SATISFACTION=?, COMMENT=? WHERE id=?");
			ps.setString(1, appointment.getState());
			ps.setString(2, appointment.getDonationType());
			ps.setString(3, appointment.getTime());
			ps.setInt(4, appointment.getSatisfaction());
			ps.setString(5, appointment.getComment());
			ps.setLong(6, appointment.getId());
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
	
	/*
	 * cancel appointment
	 * 
	 * */
	public Boolean cancelAppoint(Long appointmentId) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE APPOINTMENT SET STATE = 'Canceled' WHERE id=?");
			ps.setLong(1, appointmentId);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Last none expired appointment 
	 * */
	public Appointment lastAppointment(Long donorId) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM appointment WHERE donorId = ? AND state IN ('Pending', 'Booked', 'Arrived') AND `time` >= CURRENT_TIMESTAMP() ORDER BY `time` desc LIMIT 1");
			ps.setLong(1, donorId);
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()){ // 1 : one row affected
				Appointment appoint = new Appointment();
				appoint.setThis(rs);
				return appoint;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Last donation 
	 * */
	public Appointment lastDonation(Long donorId) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM appointment WHERE donorId = ? AND state='Fulfilled' ORDER BY `time` desc LIMIT 1");
			ps.setLong(1, donorId);
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()){ // 1 : one row affected
				Appointment appoint = new Appointment();
				appoint.setThis(rs);
				return appoint;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * List of centers that are able to welcome new donors
	 * */
	public List<Center> freeCenters(String date, String city) {
		List<Center> centers = new ArrayList<Center>();
		try {
			PreparedStatement ps = connection.prepareStatement
			("SELECT DISTINCT cnt.* FROM center cnt, appointment appoint WHERE cnt.id = appoint.CenterId AND cnt.city = ? AND Date(TIME) >= ? AND " + 
			"(	SELECT COUNT(*) as total FROM appointment WHERE DATE(TIME) = ?) <= 35 UNION SELECT * FROM center cen WHERE city = ? AND NOT EXISTS ( SELECT * FROM appointment WHERE cen.id = CenterId );");
			ps.setString(1, city);
			ps.setString(2, date);
			ps.setString(3, date);
			ps.setString(4, city);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Center  center = new Center();
				center.setThis(rs);
				centers.add(center);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return centers;
	}
	
	public Long duration(Appointment appoint) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DATEDIFF(CURRENT_TIMESTAMP(), `time`) AS duration FROM appointment WHERE donorId = ? AND state = ? ORDER BY `time` DESC LIMIT 1");
			ps.setLong(1, appoint.getDonorId());
			ps.setString(2, appoint.getState());
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()){ // 1 : one row affected
				return rs.getLong("duration");
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return new Long(0);
	}
	
	/*
	 * RELATIONSHIPS
	 * */

	public Appointment find(Analysis analysis) {
		
		return find(analysis.getAppointmentId());
	}

	public List<Appointment> find(Donor donor) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM APPOINTMENT where DonorId=? ORDER by time DESC ");
			ps.setLong(1, donor.getDonorId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setThis(rs);
				appointment.setDonor();
				appointment.setCenter();
				appointment.setAnalysis();
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
					("SELECT * FROM APPOINTMENT where CenterId=? ORDER by time DESC");
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
