package io.group17.travelagencybooking.models;

public class Customer extends User
{
    public Customer(String name, String contactNumber, String emailId) {
        super(name, contactNumber, emailId);
        setRole(UserType.CUSTOMER);
    }

    public void setId(Long id) {
    }
}
