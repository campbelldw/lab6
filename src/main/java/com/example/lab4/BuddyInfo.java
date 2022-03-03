package com.example.lab4;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class BuddyInfo {

    @Id
    @GeneratedValue
    Integer id;
    private String name;
    private String number;

    public BuddyInfo(){
        this.name = "Johnny Cage";
        this.number = "555-555-5555";
    }

    public BuddyInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " #" + number;
    }

    public static BuddyInfo importBuddy(String buddy) {
        String[] newBuddy = buddy.split("#");
        return new BuddyInfo (newBuddy[0], newBuddy[1]);
    }

}
