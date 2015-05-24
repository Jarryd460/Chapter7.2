package za.ac.cput.hospitalsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/13.
 */
@Embeddable
public class Contact implements Serializable {

    private String telephoneNumber;
    private String email;
    private String faxNumber;

    private Contact() {

    }

    public Contact(Builder builder) {
        this.telephoneNumber = builder.telephoneNumber;
        this.email = builder.email;
        this.faxNumber = builder.faxNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public static class Builder {

        private String telephoneNumber;
        private String email;
        private String faxNumber;

        public Builder(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder faxNumber(String faxNumber) {
            this.faxNumber = faxNumber;
            return this;
        }

        public Builder copy(Contact contact){
            this.telephoneNumber=contact.telephoneNumber;
            this.email=contact.email;
            this.faxNumber = contact.faxNumber;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        return !(telephoneNumber != null ? !telephoneNumber.equals(contact.telephoneNumber) : contact.telephoneNumber != null);
    }

    @Override
    public int hashCode() {
        return telephoneNumber != null ? telephoneNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                '}';
    }
}
