package nl.novi.eindopdracht.boodschappbackendv3.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

import javax.persistence.Id;

public class PersonDto {

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
        if (person == null) return null;

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
}
