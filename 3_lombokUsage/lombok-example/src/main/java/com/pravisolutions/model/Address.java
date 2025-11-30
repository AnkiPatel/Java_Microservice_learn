package com.pravisolutions.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component// By default, scope is singleton
@Scope("prototype")
public class Address {
    public String address;

    public Address() {
        this.address = "Peninsula Prakruthi";
    }

    public Address(String addrStr) {
        this.address = addrStr;
    }

    public String getAddressValue() {
        return address;
    }

    public void setAddressValue(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.address;
    }
}
