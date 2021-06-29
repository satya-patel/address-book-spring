package com.blz.AddressBookApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.AddressBookApp.DTO.AddressBookDTO;
import com.blz.AddressBookApp.DTO.ResponseDTO;
import com.blz.AddressBookApp.Model.AddressBookData;
import com.blz.AddressBookApp.Service.IAddressBookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	@GetMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookData = null;
		addressBookData = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success !!!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{personId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.getAddressBookDataById(personId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call for id Successful:", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/name/{keyword}")
	public ResponseEntity<ResponseDTO> getEmployeesByKeywordName(@PathVariable("keyword") String keyword) {
		List<AddressBookData> addressBookData = addressBookService.getAddressByKeywordName(keyword);
		ResponseDTO responseDTO = new ResponseDTO("Get call for the name successful: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		log.debug("AddressBook Dto " + addressBookDTO.toString());
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfully:", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
			@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated  Address Book Data Successfully:", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
		addressBookService.deleteAddressBookData(personId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + personId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}