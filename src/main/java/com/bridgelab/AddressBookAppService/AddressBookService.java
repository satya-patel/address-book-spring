package com.blz.AddressBookApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.Exception.AddressBookException;
import com.blz.AddressBookApp.Model.AddressBookData;
import com.blz.AddressBookApp.Repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	private AddressBookRepository addressBookRepository;

	private List<AddressBookData> addressBookList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		return addressBookList.stream().filter(list -> list.getAddressBookId() == personId).findFirst()
				.orElseThrow(() -> new AddressBookException("Record not present"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookDTO);
		addressBookList.add(addressBookData);
		log.debug("AddressBook data : "+addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(personId);
		addressBookData.setName(addressBookDTO.name);
		addressBookData.setAddress(addressBookDTO.address);
		addressBookList.set(personId - 1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int personId) {
		addressBookList.remove(personId - 1);
	}
}