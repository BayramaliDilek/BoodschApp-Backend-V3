package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

public class PersonDto {

    public Long id;
    public String personFirstname;
    public String personLastname;
    public String personStreetName;
    public String personHouseNumber;
    public String personHouseNumberAdd;
    public String personCity;
    public String personZipcode;
    public String personRadius;


    public static PersonDto fromPerson(Person person) {
        if (person == null) return null;

        var dto = new PersonDto();

        dto.id = person.getId();

        dto.personFirstname = person.getPersonFirstname();

        dto.personLastname = person.getPersonLastname();

        dto.personStreetName = person.getPersonStreetName();

        dto.personHouseNumber = person.getPersonHouseNumber();

        dto.personHouseNumberAdd = person.getPersonHouseNumberAdd();

        dto.personCity = person.getPersonCity();

        dto.personZipcode = person.getPersonZipcode();

        dto.personRadius = person.getPersonRadius();

        return dto;
    }
}
