package com.example.lab4;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
}
