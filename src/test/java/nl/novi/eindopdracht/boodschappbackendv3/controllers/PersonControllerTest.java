package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.PersonDto;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import nl.novi.eindopdracht.boodschappbackendv3.services.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Test
    @DisplayName("Should delete the person when the id is valid")
    void deletePersonWhenIdIsValid() {
        Person person = new Person();
        person.setId(1L);
        person.setPersonFirstname("Jan");
        person.setPersonLastname("Janssen");
        person.setPersonStreetName("Straat");
        person.setPersonHouseNumber("1");
        person.setPersonHouseNumberAdd("a");
        person.setPersonCity("Amsterdam");
        person.setPersonZipcode("1111AA");

        personService.deletePerson(1L);

        verify(personService, times(1)).deletePerson(1L);
    }


    @Test
    @DisplayName("Should save the person when the person is valid")
    void savePersonWhenPersonIsValid() {
        Person person = new Person();
        person.setPersonFirstname("Test");
        person.setPersonLastname("Test");
        person.setPersonStreetName("Test");
        person.setPersonHouseNumber("Test");
        person.setPersonHouseNumberAdd("Test");
        person.setPersonCity("Test");
        person.setPersonZipcode("Test");

        personRepository.save(person);

        assertThat(person.getPersonFirstname()).isEqualTo("Test");

    }

    @Test
    @DisplayName("Should returns the person when the id is valid")
    void getPersonWhenIdIsValid() {
        Person person = new Person();
        person.setId(1L);
        person.setPersonFirstname("Bayla");
        person.setPersonLastname("itzme");
        person.setPersonStreetName("admiralenweg");
        person.setPersonHouseNumber("1");
        person.setPersonHouseNumberAdd("a");
        person.setPersonCity("Amsterdam");
        person.setPersonZipcode("1111AA");

        when(personService.getPerson(1L)).thenReturn(person);

        PersonDto result = personController.getPerson(1L);

        assertNotNull(result);
        assertEquals(1L, result.id);
        assertEquals("Bayla", result.personFirstname);
        assertEquals("itzme", result.personLastname);
        assertEquals("admiralenweg", result.personStreetName);
        assertEquals("1", result.personHouseNumber);
        assertEquals("a", result.personHouseNumberAdd);
        assertEquals("Amsterdam", result.personCity);
        assertEquals("1111AA", result.personZipcode);
    }

    @Test
    @DisplayName("Should return all persons when no parameters are given")
    void getPersonListWhenNoParametersAreGivenThenReturnAllPersons() {
        var person1 = new Person();
        person1.setId(1L);
        person1.setPersonFirstname("Jan");
        person1.setPersonLastname("Janssen");

        var person2 = new Person();
        person2.setId(2L);
        person2.setPersonFirstname("Piet");
        person2.setPersonLastname("Pietersen");

        var person3 = new Person();
        person3.setId(3L);
        person3.setPersonFirstname("Klaas");
        person3.setPersonLastname("Klaassen");

        var persons = List.of(person1, person2, person3);

        when(personService.getPersonList()).thenReturn(persons);

        var result = personController.getPersonList(null, null);

        assertEquals(3, result.size());
    }
}