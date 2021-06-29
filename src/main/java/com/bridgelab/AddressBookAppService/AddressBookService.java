package com.blz.AddressBookApp.Service;

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

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		return addressBookRepository.findById(personId).orElseThrow(
				() -> new AddressBookException("AddressBook with address id : " + personId + " does not exists "));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookDTO);
		log.debug("AddressBook data : " + addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(personId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int personId) {
		AddressBookData addressBookDataById = this.getAddressBookDataById(personId);
		addressBookRepository.delete(addressBookDataById);
	}

	@Override
	public List<AddressBookData> getAddressByKeywordName(String keyword) {
		return addressBookRepository.getAddressByKeywordName(keyword);
	}
}