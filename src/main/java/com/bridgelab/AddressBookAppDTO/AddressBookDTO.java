package com.blz.AddressBookAppDTO;

public class AddressBookDTO {

	String name;
	String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressBookDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public AddressBookDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AddressBookDTO [name=" + name + ", address=" + address + "]";
	}
}
