package com.blz.AddressBookApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.AddressBookApp.Model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {

}
