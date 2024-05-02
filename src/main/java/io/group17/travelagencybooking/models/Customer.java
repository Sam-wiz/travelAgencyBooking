package io.group17.travelagencybooking.models;

public class Customer extends User
{
    public Customer(String name, String contactNumber, String emailId) {
        super(name, contactNumber, emailId);
    }

    public void setId(Long id) {
    }
}
