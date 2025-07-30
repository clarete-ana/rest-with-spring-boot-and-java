package br.com.erudio.data.dto.v1;

import br.com.erudio.model.Person;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable{

        private static final long serialVersionUID = 1L;
        private Long id;
        private String firstName;
        private String lastName;
        private String address;
        private String gender;

        public PersonDTO() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof br.com.erudio.model.Person)) return false;
            br.com.erudio.model.Person person = (br.com.erudio.model.Person) o;
            return getId().equals(person.getId()) && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getAddress().equals(person.getAddress()) && getGender().equals(person.getGender());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
        }
}


