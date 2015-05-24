package za.ac.cput.hospitalsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Sex sex;
    private int age;
    private String contactNumber;
    private String address;

    private Patient() {

    }

    public Patient(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.sex = builder.sex;
        this.age = builder.age;
        this.contactNumber = builder.contactNumber;
        this.address = builder.address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private Sex sex;
        private int age;
        private String contactNumber;
        private String address;

        public Builder(String firstName) {
            this.firstName = firstName;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }


        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder copy(Patient patient) {
            this.id = patient.id;
            this.firstName = patient.firstName;
            this.lastName = patient.lastName;
            this.sex = patient.sex;
            this.age = patient.age;
            this.contactNumber = patient.contactNumber;
            this.address = patient.address;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        return !(id != null ? !id.equals(patient.id) : patient.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", contactNumber=" + contactNumber +
                ", address='" + address + '\'' +
                '}';
    }

}
