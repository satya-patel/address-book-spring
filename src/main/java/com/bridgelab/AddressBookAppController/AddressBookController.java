package com.blz.AddressBookAppController;

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

import com.blz.AddressBookAppDTO.AddressBookDTO;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

	@GetMapping("/get")
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success !!!", HttpStatus.OK);
	}

	@GetMapping("/get/{personId}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("personId") int personId) {
		return new ResponseEntity<String>("Get Call Success for id: " + personId, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Created Address Book data for: " + addressBookDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{personId}")
	public ResponseEntity<String> updateAddressBookData(@PathVariable("personId") int personId,
			@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated Address Book Data for: " + personId + "\n" + addressBookDTO,
				HttpStatus.OK);
	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId) {
		return new ResponseEntity<String>("Delete Call Success for id: " + personId, HttpStatus.OK);
	}
}