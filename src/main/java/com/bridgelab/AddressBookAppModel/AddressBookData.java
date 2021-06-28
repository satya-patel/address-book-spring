package com.blz.AddressBookApp.Model;

import com.blz.AddressBookApp.DTO.AddressBookDTO;

import lombok.Data;

@Data
public class AddressBookData {

	private int addressBookId;
	private String name;
	private String address;
	public String phoneNumber;
	public String city;
	public String state;
	public String zipCode;

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		this.addressBookId = addressBookId;
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
		this.phoneNumber = addressBookDTO.phoneNumber;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zipCode = addressBookDTO.zipCode;
	}
}