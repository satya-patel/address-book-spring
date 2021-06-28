package com.blz.AddressBookApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.Model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList=new ArrayList<AddressBookData>();
		addressBookList.add(new AddressBookData(1, new AddressBookDTO("Pallavi", "Btm")));
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		AddressBookData addressBookData=new AddressBookData(personId, new AddressBookDTO("Jiya", "JP Nagar"));
		return addressBookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData=new AddressBookData(3, addressBookDTO);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData=new AddressBookData(3,addressBookDTO);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int personId) {
		// TODO Auto-generated method stub
		
	}
}
