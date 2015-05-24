package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hospitalsystem.domain.Appointment;

import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
public class DoctorResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private String specialization;
    private List<Appointment> appointments;

    private DoctorResource() {

    }

    public DoctorResource(Builder builder) {
        this.resid = builder.resid;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.specialization = builder.specialization;
        this.appointments = builder.appointments;
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

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public static class Builder {
        private Long resid;
        private String firstName;
        private String lastName;
        private String specialization;
        private List<Appointment> appointments;

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

        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder appointments(List<Appointment> appointments) {
            this.appointments = appointments;
            return this;
        }

        public Builder copy(DoctorResource doctor) {
            this.resid = doctor.resid;
            this.firstName = doctor.firstName;
            this.lastName = doctor.lastName;
            this.specialization = doctor.specialization;
            this.appointments = doctor.appointments;
            return this;
        }

        public DoctorResource build() {
            return new DoctorResource(this);
        }
    }

}
