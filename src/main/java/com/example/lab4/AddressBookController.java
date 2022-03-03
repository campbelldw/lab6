package com.example.lab4;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;

    // Post request
    // http://localhost:8080/addressBook
    @PostMapping("/addressBook")
    public AddressBook createBook(){
        AddressBook book = new AddressBook();
        return addressBookRepository.save(book);
    }

    @GetMapping("/getBook/{id}")
    public AddressBook getBook(@PathVariable Integer id){
        return addressBookRepository.findById(id).orElse(null);
    }


    // Post request (1 is the id of the book I used)
    // http://localhost:8080/addBuddy/1
    // Body JSON
    // {
    //    "name": "Campbell",
    //    "number": "555-555-555"
    // }
    @PostMapping(value="/addBuddy/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public AddressBook addBuddy(@PathVariable Integer id, @RequestBody BuddyInfo buddy){
        AddressBook book = addressBookRepository.findById(id).orElse(null);
        if (book != null){
            book.addBuddy(buddy);
            return addressBookRepository.save(book);
        }
        return null;
    }


    // Delete request (1 is the id of the book I used)
    // http://localhost:8080/removeBuddy/1
    // Body JSON
    // {
    //    "id": "2"
    //    "name": "Campbell",
    //    "number": "555-555-555"
    // }
    @DeleteMapping(value="/removeBuddy/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public AddressBook removeBuddy(@PathVariable Integer id, @RequestBody BuddyInfo buddy){
        AddressBook book = addressBookRepository.findById(id).orElse(null);
        if (book != null){
            book.removeBuddy(buddy);
            return addressBookRepository.save(book);
        }
        return null;
    }


}
