package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hospitalsystem.domain.Address;
import za.ac.cput.hospitalsystem.domain.Contact;
import za.ac.cput.hospitalsystem.domain.Doctor;
import za.ac.cput.hospitalsystem.domain.Ward;

import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
public class HospitalResource extends ResourceSupport {

    private Long resid;
    private String name;
    private Address address;
    private Contact contact;
    private List<Ward> wards;
    private List<Doctor> doctors;

    private HospitalResource() {

    }

    public HospitalResource(Builder builder) {
        this.resid = builder.resid;
        this.name = builder.name;
        this.address = builder.address;
        this.contact = builder.contact;
        this.wards = builder.wards;
        this.doctors = builder.doctors;
    }

    public Long getResId() {
        return resid;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public static class Builder {
        private Long resid;
        private String name;
        private Address address;
        private Contact contact;
        private List<Ward> wards;
        private List<Doctor> doctors;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder wards(List<Ward> wards) {
            this.wards = wards;
            return this;
        }

        public Builder doctors(List<Doctor> doctors) {
            this.doctors = doctors;
            return this;
        }

        public Builder copy(HospitalResource hospital) {
            this.resid = hospital.resid;
            this.name = hospital.name;
            this.address = hospital.address;
            this.contact = hospital.contact;
            this.wards = hospital.wards;
            this.doctors = hospital.doctors;
            return this;
        }

        public HospitalResource build() {
            return new HospitalResource(this);
        }

    }

}
