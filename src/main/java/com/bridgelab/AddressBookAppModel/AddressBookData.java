package com.blz.AddressBookApp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blz.AddressBookApp.DTO.AddressBookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address_book")
@NoArgsConstructor
public class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressbook_id")
	private int addressBookId;
	private String name;
	private String address;
	public String phoneNumber;
	public String city;
	public String state;
	public String zipCode;

	public AddressBookData(AddressBookDTO addressBookDTO) {
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