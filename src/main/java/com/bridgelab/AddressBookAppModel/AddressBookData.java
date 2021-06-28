package com.blz.AddressBookApp.Model;

import com.blz.AddressBookApp.DTO.AddressBookDTO;

public class AddressBookData {

	private int addressBookId;
	private String name;
	private String address;

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		super();
		this.addressBookId = addressBookId;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
	}

	public AddressBookData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getaddressBookId() {
		return addressBookId;
	}

	public void setaddressBookId(int addressBookId) {
		this.addressBookId = addressBookId;
	}

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
}