package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hospitalsystem.domain.Bill;
import za.ac.cput.hospitalsystem.domain.Patient;

import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
public class AppointmentResource extends ResourceSupport {

    private Long resid;
    private Patient patient;
    private int amount;
    private List<Bill> bill;

    private AppointmentResource() {

    }

    public AppointmentResource(Builder builder) {
        this.resid = builder.resid;
        this.patient = builder.patient;
        this.amount = builder.amount;
        this.bill = builder.bill;
    }

    public Long getResId() {
        return resid;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getAmount() {
        return amount;
    }

    public List<Bill> getBill() {
        return bill;
    }

    public static class Builder {
        private Long resid;
        private Patient patient;
        private int amount;
        private List<Bill> bill;

        public Builder(Patient patient) {
            this.patient = patient;
        }

        public Builder id(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder bill(List<Bill> bill) {
            this.bill = bill;
            return this;
        }

        public Builder copy(AppointmentResource appointment) {
            this.resid = appointment.resid;
            this.patient = appointment.patient;
            this.amount = appointment.amount;
            this.bill = appointment.bill;
            return this;
        }

        public AppointmentResource build() {
            return new AppointmentResource(this);
        }
    }

}
