package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    @DisplayName("Should return the list of persons when the personFirstname is found")
    void findPersonListByPersonFirstnameWhenPersonFirstnameIsFoundThenReturnTheListOfPersons() {

        Person person1 = new Person();
        person1.setPersonFirstname("Jan");
        person1.setPersonLastname("Janssen");

        Person person2 = new Person();
        person2.setPersonFirstname("Jan");
        person2.setPersonLastname("Janssen");

        List<Person> personList = Arrays.asList(person1, person2);

        when(personRepository.findByPersonFirstnameContainingIgnoreCase("Jan"))
                .thenReturn(personList);

        List<Person> result = personService.findPersonListByPersonFirstname("Jan");

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Should throw an exception when the personFirstname is not found")
    void findPersonListByPersonFirstnameWhenPersonFirstnameIsNotFoundThenThrowException() {

        String personFirstname = "test";
        when(personRepository.findByPersonFirstnameContainingIgnoreCase(personFirstname))
                .thenReturn(Arrays.asList());

        assertThrows(
                RecordNotFoundException.class,
                () -> personService.findPersonListByPersonFirstname(personFirstname));

        verify(personRepository, times(1))
                .findByPersonFirstnameContainingIgnoreCase(personFirstname);
    }

    @Test
    @DisplayName("Should returns all persons")
    void getPersonListShouldReturnsAllPersons() {

        Person person1 = new Person();
        Person person2 = new Person();
        List<Person> personList = Arrays.asList(person1, person2);

        when(personRepository.findAll()).thenReturn(personList);

        List<Person> result = personService.getPersonList();

        assertEquals(2, result.size());
        verify(personRepository, times(1)).findAll();
    }
}