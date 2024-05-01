package io.group17.travelagencybooking.models;

public class Customer extends User
{
    private UserType userType = UserType.CUSTOMER;
    public Customer(String name, String contactNumber, String emailId) {
        super(name, contactNumber, emailId);
    }
}
