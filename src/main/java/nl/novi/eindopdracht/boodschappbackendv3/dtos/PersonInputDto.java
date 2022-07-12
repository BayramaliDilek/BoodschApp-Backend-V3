package nl.novi.eindopdracht.boodschappbackendv3.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

public class PersonInputDto {

    public Long id;
    public String firstname;
    public String lastname;
    public String streetName;
    public String houseNumber;
    public String houseNumberAdd;
    public String city;
    public String zipcode;
    public String radius;

    public Person toPerson() {

        var person = new Person();

        person.setId(id);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setStreetName(streetName);
        person.setHouseNumber(houseNumber);
        person.setHouseNumberAdd(houseNumberAdd);
        person.setCity(city);
        person.setZipcode(zipcode);
        person.setRadius(radius);

        return person;
    }
}
