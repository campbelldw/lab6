package com.example.lab4;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
public class AddressBook  {
    @Id
    @GeneratedValue
    Integer id;
    @OneToMany(cascade= CascadeType.ALL)
    List<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null)
            buddies.add(buddy);
    }

    public BuddyInfo getBuddy(int i) {
        return buddies.get(i);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

}