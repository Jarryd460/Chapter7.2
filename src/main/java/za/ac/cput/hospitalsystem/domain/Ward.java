package za.ac.cput.hospitalsystem.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
@Entity
public class Ward implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int capacity;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="ward_id")
    private List<Patient> patients;

    private Ward() {

    }

    public Ward(Builder builder) {
        this.id = builder.id;
        this.capacity = builder.capacity;
        this.patients = builder.patients;
    }

    public Long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public static class Builder {
        private Long id;
        private int capacity;
        private List<Patient> patients;

        public Builder(int capacity) {
            this.capacity = capacity;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder patients(List<Patient> patients) {
            this.patients = patients;
            return this;
        }

        public Builder copy(Ward ward) {
            this.id = ward.id;
            this.capacity = ward.capacity;
            this.patients = ward.patients;
            return this;
        }

        public Ward build() {
            return new Ward(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ward)) return false;

        Ward ward = (Ward) o;

        return !(id != null ? !id.equals(ward.id) : ward.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", patients=" + patients +
                '}';
    }
}
