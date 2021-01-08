package dao.entities;

public class Donor extends User{
	
	private final static String myRole = "donor";
	
	private Long donorID;
	private String CIN = "";
	private String city = "";
	private String birthday = "";
	private String gender = "";
	private int bloodid;
	
	public Donor(String firstName, String lastName, String email, String password, String phone, Boolean active) {
		super(firstName, lastName, email, password, phone, active, myRole);
	}

	public Donor() {
		super();
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMyRole() {
		return myRole;
	}


	public Long getDonorID() {
		return donorID;
	}

	public void setDonorID(Long donorID) {
		this.donorID = donorID;
	}

	public int getBloodid() {
		return bloodid;
	}

	public void setBloodid(int bloodid) {
		this.bloodid = bloodid;
	}

	@Override
	public String toString() {
		return "Donor [donorID=" + donorID + ", CIN=" + CIN + ", city=" + city + ", birthday=" + birthday + ", gender="
				+ gender + ", bloodid=" + bloodid + "]";
	}
	
	
	
}
