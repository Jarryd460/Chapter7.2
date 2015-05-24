package za.ac.cput.hospitalsystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/05/24.
 */
public class BillResource extends ResourceSupport {

    private Long resid;
    private int amount;

    private BillResource() {

    }

    public BillResource(Builder builder) {
        this.resid = builder.resid;
        this.amount = builder.amount;
    }

    public Long getResId() {
        return resid;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder {
        private Long resid;
        private int amount;

        public Builder(int amount) {
            this.amount = amount;
        }

        public Builder id(Long resid) {

            this.resid = resid;
            return this;

        }

        public Builder bill(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(BillResource bill) {
            this.resid = bill.resid;
            this.amount = bill.amount;
            return this;
        }

        public BillResource build() {
            return new BillResource(this);
        }
    }

}
