package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.implementation.AnalysisDaoImp;
import dao.implementation.AppointmentDaoImp;
import dao.implementation.CenterDaoImp;
import dao.implementation.DonorDaoImp;
import dao.interfaces.IAnalysisDao;
import dao.interfaces.IAppointmentDao;
import dao.interfaces.ICenterDao;
import dao.interfaces.IDonorDao;
import dao.interfaces.IEntity;

public class Appointment implements Serializable, IEntity<Appointment>{
	
	private Long id;
	private String state;
	private String donationType;
	private String time;
	private int satisfaction;
	private String comment;
	private long CenterId;
	private long DonorId;
	
	// Associations
	private Donor donor;
	private Center center;
	private Analysis analysis; 

	// Dao
	private static IAppointmentDao appointDao = new AppointmentDaoImp();
	private static ICenterDao centerDao = new CenterDaoImp();
	private static IDonorDao donorDao = new DonorDaoImp();
	private static IAnalysisDao analysisDao = new AnalysisDaoImp();

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment( String state, String donationType, String time, int satisfaction, String comment, long DonorId, long CenterId) {
		super();
		this.state = state;
		this.donationType = donationType;
		this.time = time;
		this.satisfaction = satisfaction;
		this.comment = comment;
		this.DonorId = DonorId;
		this.CenterId = CenterId;
	}
	
	public void setThis(Appointment appointment){
		this.id = appointment.getId();
		this.state = appointment.getState();
		this.donationType = appointment.getDonationType();
		this.time = appointment.getTime();
		this.satisfaction = appointment.getSatisfaction();
		this.comment = appointment.getComment();
		this.DonorId = appointment.getDonorId();
		this.CenterId = appointment.getCenterId();
	}

	public void setThis(HttpServletRequest request){
		this.id = Long.parseLong(request.getParameter("id"));
		this.state = request.getParameter("state");
		this.state = request.getParameter("donationType");
		this.time = request.getParameter("time");
		this.satisfaction = Integer.parseInt( request.getParameter("satisfaction"));
		this.comment = request.getParameter("comment");
		this.DonorId = Long.parseLong( request.getParameter("DonorId"));
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.state = rs.getString("state");
			this.donationType = rs.getString("donationType");
			this.time = rs.getString("time");
			this.satisfaction = rs.getInt("satisfaction");
			this.comment = rs.getString("comment");
			this.DonorId = rs.getLong("DonorId");
			this.CenterId = rs.getLong("CenterId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getDonorId() {
		return DonorId;
	}

	public void setDonorId(long DonorId) {
		this.DonorId = DonorId;
	}
	
	public long getCenterId() {
		return CenterId;
	}

	public void setCenterId(long CenterId) {
		this.CenterId = CenterId;
	}
	
	
	public Donor getDonor(){
		return donor;
	}
	
	public void setDonor() {
		this.donor = donorDao.find(this);
	}
	
	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Center getCenter(){
		return center;
	}

	public void setCenter() {
		this.center = centerDao.find(this);
	}
	
	public void setCenter(Center center) {
		this.center = center;
	}
	
	public Analysis getAnalysis(){
		return analysis;
	}

	public void setAnalysis() {
		this.analysis = analysisDao.find(this);
	}
	
	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}
	
	/*
	 * CRUD OPPERATIONS
	 * */
	
	@Override
	public Appointment save() {
		try {
			return appointDao.update(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Appointment add() {
		try {
			return appointDao.insert(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove() {
		try {
			return appointDao.delete(this.id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Appointment find(Long id) {
		try{
			return appointDao.find(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Appointment create(String donationType, String date, Long centerId, Long donorId) {
		Appointment ap = new Appointment();
		ap.setDonationType(donationType);
		ap.setTime(date);
		ap.setCenterId(centerId);
		ap.setDonorId(donorId);
		return ap;
	}

	/* Business */
	public static List<Center> availableCenters(String date, String city){
		return appointDao.freeCenters(date, city);
	}
	
	public  Boolean cancelAppoint() {
		return appointDao.cancelAppoint(this.id);
	}
	
	public static Appointment lastAppointment(Long donorId) {
		return appointDao.lastAppointment(donorId);
	}
	
	public static Appointment lastDonation(Long donorId) {
		return appointDao.lastDonation(donorId);
	}
	

	/* Relationships */
	public Donor donor() {
		this.donor = donorDao.find(this);
		return this.donor;
	}
	
	public Center center() {
		this.center = centerDao.find(this);
		return this.center;
	}
	
}
