package io.group17.travelagencybooking.models;

public class Customer extends User
{
    public Customer() {
        super(name, contactNumber, emailId);
        setRole(UserType.CUSTOMER);
    }
}
