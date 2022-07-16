package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;


public class PersonInputDto {

    public Long id;
    public String personFirstname;
    public String personLastname;
    public String personStreetName;
    public String personHouseNumber;
    public String personHouseNumberAdd;
    public String personCity;
    public String personZipcode;
    public String personRadius;

    public Person toPerson() {

        var person = new Person();

        person.setId(id);
        person.setPersonFirstname(personFirstname);
        person.setPersonLastname(personLastname);
        person.setPersonStreetName(personStreetName);
        person.setPersonHouseNumber(personHouseNumber);
        person.setPersonHouseNumberAdd(personHouseNumberAdd);
        person.setPersonCity(personCity);
        person.setPersonZipcode(personZipcode);
        person.setPersonRadius(personRadius);

        return person;
    }
}
