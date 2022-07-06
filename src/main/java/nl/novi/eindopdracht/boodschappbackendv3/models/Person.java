package nl.novi.eindopdracht.boodschappbackendv3.models;


import javax.persistence.*;


@Entity
@Table(name = "persons")
public class Person {

    @GeneratedValue
    @Id
    Long id;
    String firstname;
    String lastname;
    String streetName;
    String houseNumber;
    String houseNumberAdd;
    String city;
    String zipcode;
    String radius;

    @OneToOne(mappedBy = "person")
    User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAdd() {
        return houseNumberAdd;
    }

    public void setHouseNumberAdd(String houseNumberAdd) {
        this.houseNumberAdd = houseNumberAdd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getEmail() {
        return null;
    }
}
