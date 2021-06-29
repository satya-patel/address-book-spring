package com.blz.AddressBookApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.AddressBookApp.Model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
	
	@Query(value = "select * from address_book, where name LIKE %:keyword%", nativeQuery = true)
	List<AddressBookData> getAddressByKeywordName(String keyword);

}