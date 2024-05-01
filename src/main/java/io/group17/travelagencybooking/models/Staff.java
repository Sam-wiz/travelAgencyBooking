package io.group17.travelagencybooking.models;

public class Staff extends User
{
    private UserType userType = UserType.STAFF;
    public Staff(String name, String contactNumber, String emailId) {
        super(name, contactNumber, emailId);
    }
}
