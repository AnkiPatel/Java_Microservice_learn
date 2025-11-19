package com.pravisolutions;

public class Address {

    private String address;

    public Address(String addrStr) {
        this.address = addrStr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }
}
