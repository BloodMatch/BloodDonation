package web.models;

import java.util.ArrayList;
import java.util.List;

import dao.entities.Blood;

public class BloodModel {

	private List<Blood> bloods = new ArrayList<Blood>();

	public List<Blood> getBloods() {
		return this.bloods;
	}

	public void setBloods(List<Blood> bloods) {
		this.bloods = bloods;
	}

	@Override
	public String toString() {
		return "BloodModel [bloods=" + bloods + "]";
	}
	
		
}
