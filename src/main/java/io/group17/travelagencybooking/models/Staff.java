package io.group17.travelagencybooking.models;

import jakarta.persistence.Entity;

@Entity
public class Staff extends User
{
    public Staff(String name, String contactNumber, String emailId) {
        super(name, contactNumber, emailId);
        setRole(UserType.STAFF);
    }
}