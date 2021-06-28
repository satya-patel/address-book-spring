package com.blz.AddressBookApp.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

@ToString
public class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is Invalid")
	@NotEmpty(message = "Name cannot be null ")
	public String name;

	@Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "Address is Invalid")
	@NotEmpty(message = "Address cannot be null")
	public String address;

	@Pattern(regexp ="^[9][1][ ][6-9][0-9]{9}$", message = "PhoneNo is Invalid")
	@NotEmpty(message = "PhoneNo cannot be null")
	public String phoneNumber;

	public String city;

	public String state;

	public String zipcode;

}