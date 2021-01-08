package web.models;

import java.util.ArrayList;
import java.util.List;

import dao.entities.Blood;

public class UserRegisterModel {
	
	private String CIN = "";
	private String remail = "";
	private String rfirstName = "";
	private String rlastName = "";
	private String rphone = "";
	private String rpassword = "";
	private String rcity = "";
	private String rbirthday = "";
	private String rgender = "";
	private Integer rbloodType;
	private List<Blood> bloods = new ArrayList<Blood>();
	
	
	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public String getRemail() {
		return remail;
	}


	public void setRemail(String remail) {
		this.remail = remail;
	}


	public String getRfirstName() {
		return rfirstName;
	}


	public void setRfirstName(String rfirstName) {
		this.rfirstName = rfirstName;
	}


	public String getRlastName() {
		return rlastName;
	}


	public void setRlastName(String rlastName) {
		this.rlastName = rlastName;
	}


	public String getRphone() {
		return rphone;
	}


	public void setRphone(String rphone) {
		this.rphone = rphone;
	}


	public String getRpassword() {
		return rpassword;
	}


	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}


	public String getRcity() {
		return rcity;
	}


	public void setRcity(String rcity) {
		this.rcity = rcity;
	}


	public String getRbirthday() {
		return rbirthday;
	}


	public void setRbirthday(String rbirthday) {
		this.rbirthday = rbirthday;
	}




	public String getRgender() {
		return rgender;
	}


	public void setRgender(String rgender) {
		this.rgender = rgender;
	}


	public Integer getRbloodType() {
		return rbloodType;
	}


	public void setRbloodType(Integer rbloodType) {
		this.rbloodType = rbloodType;
	}


	@Override
	public String toString() {
		return "UserRegisterModel [CIN=" + CIN + ", Remail=" + remail + ", RfirstName=" + rfirstName + ", RlastName="
				+ rlastName + ", Rphone=" + rphone + ", Rpassword=" + rpassword + ", Rcity=" + rcity + ", Rbirthday="
				+ rbirthday + ", Rgender=" + rgender + ", RbloodType=" + rbloodType + "]";
	}


	public List<Blood> getBloods() {
		return bloods;
	}


	public void setBloods(List<Blood> bloods) {
		this.bloods = bloods;
	}
}
