package web.models;

import java.util.ArrayList;
import java.util.List;

import dao.entities.Donor;
import dao.entities.User;

public class DonorModel {

	private List<Donor> donors = new ArrayList<Donor>();

	public List<Donor> getDonors() {
		return this.donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}

	@Override
	public String toString() {
		return "UserModel [donors=" + donors + "]";
	}
	
		
}
