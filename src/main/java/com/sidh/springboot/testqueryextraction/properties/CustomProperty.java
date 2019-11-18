package com.sidh.springboot.testqueryextraction.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("custom")
public class CustomProperty {
    private String property;
    private String what;
    private String context;
    private Address address;

    public class Address {
        private String country;
        private String state;
        int pincode;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPincode() {
            return pincode;
        }

        public void setPincode(int pincode) {
            this.pincode = pincode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", state='" + state + '\'' +
                    ", pincode=" + pincode +
                    '}';
        }
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomProperty{" +
                "property='" + property + '\'' +
                ", what='" + what + '\'' +
                ", context='" + context + '\'' +
                ", address=" + address +
                '}';
    }
}
