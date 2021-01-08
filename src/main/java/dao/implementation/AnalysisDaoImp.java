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
import dao.interfaces.IAnalysisDao;

public class AnalysisDaoImp implements IAnalysisDao{
	private Connection connection = DbConnection.getConnection();

	public Analysis insert(Analysis analysis) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO ANALYSIS( CODE, DATE, RESULTS, COMMENT, APPOINTMENTID) VALUES(?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, analysis.getCode());
			ps.setString(2, analysis.getDate());
			ps.setString(3, analysis.getResults());
			ps.setString(4, analysis.getComment());
			ps.setLong(5, analysis.getAppointmentId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				analysis.setId(rs.getInt(1));
				return analysis;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Analysis find(long id) {
		Analysis analysis = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM ANALYSIS WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				analysis = new Analysis();
				analysis.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return analysis;
	}

	public List<Analysis> findAll() {
		List<Analysis> analysiss = new ArrayList<Analysis>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ANALYSIS");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Analysis analysis = new Analysis();
				analysis.setThis(rs);
				analysiss.add(analysis);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return analysiss;
	}

	public Analysis update(Analysis analysis) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE ANALYSIS SET CODE=?, DATE=?, RESULTS=?, COMMENT=? ,APPOINTMENTID=? WHERE id=?");
			ps.setLong(1, analysis.getCode());
			ps.setString(2, analysis.getDate());
			ps.setString(3, analysis.getResults());
			ps.setString(4, analysis.getComment());
			ps.setLong(5, analysis.getAppointmentId());
			ps.setLong(6, analysis.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return analysis;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM ANALYSIS WHERE id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Analysis find(Appointment appointment) {
		Analysis analysis = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM ANALYSIS WHERE id AppointmentId = ?");
			ps.setLong(1, appointment.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				analysis = new Analysis();
				analysis.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return analysis;
	}

}
