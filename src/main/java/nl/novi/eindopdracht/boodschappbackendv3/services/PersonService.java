package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

import java.util.List;


public interface PersonService{


    List<Person> getPersons();

    Person getPerson(Long id);

    void createPerson(Person person);

    void deletePerson(Long personId);


}

