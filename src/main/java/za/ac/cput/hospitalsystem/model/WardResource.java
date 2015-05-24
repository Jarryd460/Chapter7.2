package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hospitalsystem.domain.Patient;

import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
public class WardResource extends ResourceSupport {

    private Long resid;
    private int capacity;
    private List<Patient> patients;

    private WardResource() {

    }

    public WardResource(Builder builder) {
        this.resid = builder.resid;
        this.capacity = builder.capacity;
        this.patients = builder.patients;
    }

    public Long getResId() {
        return resid;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public static class Builder {
        private Long resid;
        private int capacity;
        private List<Patient> patients;

        public Builder(int capacity) {
            this.capacity = capacity;
        }

        public Builder id(Long resid) {
            this.resid = resid;
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

        public Builder copy(WardResource ward) {
            this.resid = ward.resid;
            this.capacity = ward.capacity;
            this.patients = ward.patients;
            return this;
        }

        public WardResource build() {
            return new WardResource(this);
        }
    }

}
