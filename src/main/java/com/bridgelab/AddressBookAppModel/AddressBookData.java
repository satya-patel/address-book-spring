package com.blz.AddressBookApp.Model;

import com.blz.AddressBookApp.DTO.AddressBookDTO;

import lombok.Data;

@Data
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
}