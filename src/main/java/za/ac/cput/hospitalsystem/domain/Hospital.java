package za.ac.cput.hospitalsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Hospital implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Contact contact;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id")
    private List<Ward> wards;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id")
    private List<Doctor> doctors;

    private Hospital() {

    }

    public Hospital(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.contact = builder.contact;
        this.wards = builder.wards;
        this.doctors = builder.doctors;
    }

    public Long getId() {
        return id;
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
        private Long id;
        private String name;
        private Address address;
        private Contact contact;
        private List<Ward> wards;
        private List<Doctor> doctors;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long id) {
            this.id = id;
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

        public Builder copy(Hospital hospital) {
            this.id = hospital.id;
            this.name = hospital.name;
            this.address = hospital.address;
            this.contact = hospital.contact;
            this.wards = hospital.wards;
            this.doctors = hospital.doctors;
            return this;
        }

        public Hospital build() {
            return new Hospital(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;

        Hospital hospital = (Hospital) o;

        return !(id != null ? !id.equals(hospital.id) : hospital.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                ", wards=" + wards +
                ", doctors=" + doctors +
                '}';
    }
}
