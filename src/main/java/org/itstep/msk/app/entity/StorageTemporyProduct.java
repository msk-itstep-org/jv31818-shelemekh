package org.itstep.msk.app.entity;

import javax.validation.constraints.NotNull;

public class StorageTemporyProduct {
	
private String address;
	
	private String phone;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public StorageTemporyProduct(String address, String phone) {
		super();
		this.address = address;
		this.phone = phone;
	}

	
	
	

}
