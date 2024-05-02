package io.group17.travelagencybooking.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    private String Name;
    private String contactNumber;
    private String emailId;
    private UserType role;
    public User() {
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public User(String name, String contactNumber, String emailId) {
        Name = name;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

}
