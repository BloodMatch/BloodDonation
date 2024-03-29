package web.models;

import java.util.ArrayList;
import java.util.List;


public class UserRegisterModel {
	
	private String rcin= "";
	private String remail = "";
	private String rfirstName = "";
	private String rlastName = "";
	private String rphone = "";
	private String rpassword = "";
	private String rcity = "";
	private String rbirthday = "";
	private String rgender = "";
	private String rgroup = "";
	private Long rzipCode;
	
	private String errorMsg = "";
	
	
	public String getRcin() {
		return rcin;
	}


	public void setRcin(String cin) {
		this.rcin = cin;
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


	public String getRgroup() {
		return rgroup;
	}


	public void setRgroup(String rgroup) {
		this.rgroup = rgroup;
	}

	public Long getRzipCode() {
		return rzipCode;
	}


	public void setRzipCode(Long rzipCode) {
		this.rzipCode = rzipCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
