package web.models;

import dao.entities.Center;

public class CenterModel {
	private long id;
	private String code;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String city;
	private String address;
	private long ZIPCode;
	
	public CenterModel() {
		
	}
	
	public CenterModel(long id, String code, String name, String email, String phone1, String phone2, String city,
			String address, long zIPCode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.city = city;
		this.address = address;
		ZIPCode = zIPCode;
	}
	
	public CenterModel(Center center) {
		id = center.getId();
		code = center.getCode();
		name = center.getName();
		email = center.getEmail();
		phone1 = center .getPhone1(); phone2 = center.getPhone2();
		city = center.getCity();
		address = center.getAddress();
		ZIPCode = center.getZIPCode();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getZIPCode() {
		return ZIPCode;
	}

	public void setZIPCode(long zIPCode) {
		ZIPCode = zIPCode;
	}

	@Override
	public String toString() {
		return "CenterModel [id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", city=" + city + ", address=" + address + ", ZIPCode=" + ZIPCode + "]";
	}
	
	
}
