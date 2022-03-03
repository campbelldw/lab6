package com.example.lab4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ThymeController {
    private final AddressBookRepository addressBookRepository;

    // The first page!
    // go to http://localhost:8080/main after running
    @GetMapping("/main")
    public String setUp(Model model){
        model.addAttribute("addressbook", new AddressBook());
        return "main";
    }

    @PostMapping("/main")
    public String createAddressBook(@ModelAttribute AddressBook book, Model model){
        addressBookRepository.save(book);
        model.addAttribute("id", book.getId());
        model.addAttribute("buddies", book.getBuddies());
        model.addAttribute("buddyinfo", new BuddyInfo());
        return "book";
    }


    // In your browser (1 is the id of the book I used)
    // http://localhost:8080/addressBook/1
    @GetMapping("/addressBook/{id}")
    public String getBook(@PathVariable Integer id, Model model){
        AddressBook book = addressBookRepository.findById(id).orElse((null));
        if (book != null){
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddies());
            model.addAttribute("buddyinfo", new BuddyInfo());
        }
        return "book";
    }

    // Creates a buddy info through the thymeleaf form
    @PostMapping("/addressBook/{id}")
    public String addBuddyInfo(@PathVariable Integer id, @ModelAttribute BuddyInfo buddy, Model model){
        AddressBook book = addressBookRepository.findById(id).orElse((null));
        if (book != null){
            book.addBuddy(buddy);
            addressBookRepository.save(book);
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddies());
            model.addAttribute("buddyinfo", new BuddyInfo());
        }
        return "book";
    }


}
