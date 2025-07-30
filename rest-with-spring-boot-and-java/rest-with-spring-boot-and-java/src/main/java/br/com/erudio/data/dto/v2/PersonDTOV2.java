package br.com.erudio.data.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String gender;

    public PersonDTOV2() {}

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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
        if (!(o instanceof PersonDTOV2)) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return getId().equals(that.getId()) && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getBirthDay().equals(that.getBirthDay()) && getAddress().equals(that.getAddress()) && getGender().equals(that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthDay(), getAddress(), getGender());
    }
}
