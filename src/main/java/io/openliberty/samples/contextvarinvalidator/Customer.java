package io.openliberty.samples.contextvarinvalidator;

import javax.validation.constraints.NotNull;

public class Customer {
    @NotNull
    private String firstName;

    @ValidPhoneNumber
    private String mobileNumber;

    public Customer() {}

    public Customer(String firstName, String mobileNumber) {
        this.firstName = firstName;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Customer " + firstName + " " + mobileNumber;
    }
}