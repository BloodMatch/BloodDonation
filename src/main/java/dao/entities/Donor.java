package dao.entities;

import java.io.Serializable;
 

public class Donor extends User implements Serializable{
	
	protected String cin;
	protected String birthDay;
	protected String sexe;
	protected String bloodType;
	protected String ville;
	protected String image;
	
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donor(String firstName, String lastName, String email, String password, String phone,
			String cin, String birthDay, String sexe, String bloodType, String ville, String image) {
		super( firstName, lastName, email, password, phone, false, "Donor");
		this.cin = cin;
		this.birthDay = birthDay;
		this.sexe = sexe;
		this.bloodType = bloodType;
		this.ville = ville;
		this.image = image;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Donor [ cin=" + cin + ", birthDay=" + birthDay + ", sexe=" + sexe
				+ ", bloodType=" + bloodType + ", ville=" + ville + ", image=" + image + " >> "+ super.toString() +"]";
	}
	
}
