package za.ac.cput.hospitalsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Patient patient;
    private int amount;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="bill_id")
    private List<Bill> bill;

    private Appointment() {

    }

    public Appointment(Builder builder) {
        this.id = builder.id;
        this.patient = builder.patient;
        this.amount = builder.amount;
        this.bill = builder.bill;
    }

    public Long getId() {
        return id;
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
        private Long id;
        private Patient patient;
        private int amount;
        private List<Bill> bill;

        public Builder(Patient patient) {
            this.patient = patient;
        }

        public Builder id(Long id) {
            this.id = id;
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

        public Builder copy(Appointment appointment) {
            this.id = appointment.id;
            this.patient = appointment.patient;
            this.amount = appointment.amount;
            this.bill = appointment.bill;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment appointment = (Appointment) o;

        return !(id != null ? !id.equals(appointment.id) : appointment.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", amount=" + amount +
                ", bill=" + bill +
                '}';
    }
}
