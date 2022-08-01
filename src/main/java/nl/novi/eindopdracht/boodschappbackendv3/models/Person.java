package nl.novi.eindopdracht.boodschappbackendv3.models;


import javax.persistence.*;
import java.util.List;


@Entity
public class Person {

    @GeneratedValue
    @Id
    Long id;
    String personFirstname;
    String personLastname;
    String personStreetName;
    String personHouseNumber;
    String personHouseNumberAdd;
    String personCity;
    String personZipcode;
    String personRadius;

    @OneToOne(mappedBy = "person")
    User user;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonFirstname() {
        return personFirstname;
    }

    public void setPersonFirstname(String firstname) {
        this.personFirstname = firstname;
    }

    public String getPersonLastname() {
        return personLastname;
    }

    public void setPersonLastname(String lastname) {
        this.personLastname = lastname;
    }

    public String getPersonStreetName() {
        return personStreetName;
    }

    public void setPersonStreetName(String streetName) {
        this.personStreetName = streetName;
    }

    public String getPersonHouseNumber() {
        return personHouseNumber;
    }

    public void setPersonHouseNumber(String houseNumber) {
        this.personHouseNumber = houseNumber;
    }

    public String getPersonHouseNumberAdd() {
        return personHouseNumberAdd;
    }

    public void setPersonHouseNumberAdd(String houseNumberAdd) {
        this.personHouseNumberAdd = houseNumberAdd;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String city) {
        this.personCity = city;
    }

    public String getPersonZipcode() {
        return personZipcode;
    }

    public void setPersonZipcode(String zipcode) {
        this.personZipcode = zipcode;
    }


    public String getPersonRadius() {
        return personRadius;
    }

    public void setPersonRadius(String radius) {
        this.personRadius = radius;
    }

    public String getEmail() {
        return null;
    }


}
