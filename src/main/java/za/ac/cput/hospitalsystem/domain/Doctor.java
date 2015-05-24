package za.ac.cput.hospitalsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="doctor_id")
    private List<Appointment> appointments;

    private Doctor() {

    }

    public Doctor(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.specialization = builder.specialization;
        this.appointments = builder.appointments;
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

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String specialization;
        private List<Appointment> appointments;

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

        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder appointments(List<Appointment> appointments) {
            this.appointments = appointments;
            return this;
        }

        public Builder copy(Doctor doctor) {
            this.id = doctor.id;
            this.firstName = doctor.firstName;
            this.lastName = doctor.lastName;
            this.specialization = doctor.specialization;
            this.appointments = doctor.appointments;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        return !(id != null ? !id.equals(doctor.id) : doctor.id != null);
    }


    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointments=" + appointments +
                '}';
    }

}
