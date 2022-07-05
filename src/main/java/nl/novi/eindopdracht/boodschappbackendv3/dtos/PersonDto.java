package nl.novi.eindopdracht.boodschappbackendv3.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

import javax.persistence.Id;

public class PersonDto {

    @Id
    public Long id;

    public String firstname;
    public String lastname;
    public String streetName;
    public String houseNumber;
    public String houseNumberAdd;
    public String city;
    public String zipcode;
    public String radius;


    public static PersonDto fromPerson(Person person) {

        var dto = new PersonDto();

        dto.id = person.getId();

        dto.firstname = person.getFirstname();

        dto.lastname = person.getLastname();

        dto.streetName = person.getStreetName();

        dto.houseNumber = person.getHouseNumber();

        dto.houseNumberAdd = person.getHouseNumberAdd();

        dto.city = person.getCity();

        dto.zipcode = person.getZipcode();

        dto.radius = person.getRadius();

        return dto;
    }

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
}
