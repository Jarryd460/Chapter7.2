package za.ac.cput.hospitalsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/13.
 */
@Embeddable
public class Address implements Serializable {

    private String address;
    private String city;
    private String zipCode;

    private Address() {

    }

    public Address(Builder builder) {
        this.address = builder.address;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public static class Builder {

        private String address;
        private String city;
        private String zipCode;

        public Builder(String address) {
            this.address = address;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder copy(Address address){
            this.address=address.address;
            this.city=address.city;
            this.zipCode = address.zipCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        return !(address != null ? !address.equals(address1.address) : address1.address != null);
    }

    @Override
    public int hashCode() {
        return address != null ? address.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
