package web.models;

public class DonorModel {
	
	protected Long id;
	protected String cin;
	protected String birthDay;
	protected String gender;
	protected String group;
	protected String city;
	protected long zipCode;
	protected String image;
	
	public DonorModel () {
		
	}
	
	public DonorModel(Long id, String cin, String birthDay, String gender, String group, String city, long zipCode,
			String image) {
		super();
		this.id = id;
		this.cin = cin;
		this.birthDay = birthDay;
		this.gender = gender;
		this.group = group;
		this.city = city;
		this.zipCode = zipCode;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "DonorModel [id=" + id + ", cin=" + cin + ", birthDay=" + birthDay + ", gender=" + gender + ", group="
				+ group + ", city=" + city + ", zipCode=" + zipCode + ", image=" + image + "]";
	}
		
}
