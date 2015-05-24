package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hospitalsystem.domain.Sex;

/**
 * Created by student on 2015/05/24.
 */
public class PatientResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private Sex sex;
    private int age;
    private String contactNumber;
    private String address;

    private PatientResource() {

    }

    public PatientResource(Builder builder) {
        this.resid = builder.resid;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.sex = builder.sex;
        this.age = builder.age;
        this.contactNumber = builder.contactNumber;
        this.address = builder.address;
    }

    public Long getResId() {
        return resid;
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

        private Long resid;
        private String firstName;
        private String lastName;
        private Sex sex;
        private int age;
        private String contactNumber;
        private String address;

        public Builder(String firstName) {
            this.firstName = firstName;
        }

        public Builder id(Long resid) {
            this.resid = resid;
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

        public Builder copy(PatientResource patient) {
            this.resid = patient.resid;
            this.firstName = patient.firstName;
            this.lastName = patient.lastName;
            this.sex = patient.sex;
            this.age = patient.age;
            this.contactNumber = patient.contactNumber;
            this.address = patient.address;
            return this;
        }

        public PatientResource build() {
            return new PatientResource(this);
        }
    }

}
