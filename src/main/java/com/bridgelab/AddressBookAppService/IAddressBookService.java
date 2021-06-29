package com.blz.AddressBookApp.Service;

import java.util.List;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.Model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int personId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);

	void deleteAddressBookData(int personId);

	List<AddressBookData> getAddressByKeywordName(String keyword);
}