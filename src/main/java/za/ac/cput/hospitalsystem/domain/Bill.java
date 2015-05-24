package za.ac.cput.hospitalsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;

    private Bill() {

    }

    public Bill(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
    }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder {
        private Long id;
        private int amount;

        public Builder(int amount) {
            this.amount = amount;
        }

        public Builder id(Long id) {

            this.id = id;
            return this;

        }

        public Builder bill(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(Bill bill) {
            this.id = bill.id;
            this.amount = bill.amount;
            return this;
        }

        public Bill build() {
            return new Bill(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;

        Bill bill = (Bill) o;

        return !(id != null ? !id.equals(bill.id) : bill.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
