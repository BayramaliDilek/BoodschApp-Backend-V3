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

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("Should save the person when the person is not taken")
    void savePersonWhenPersonIsNotTaken() {

        Person person = new Person();
        person.setPersonFirstname("test");
        person.setPersonLastname("test");
        person.setPersonStreetName("test");
        person.setPersonHouseNumber("test");
        person.setPersonHouseNumberAdd("test");
        person.setPersonCity("test");
        person.setPersonZipcode("test");

        when(personRepository.save(person)).thenReturn(person);

        Person savedPerson = personService.savePerson(person);

        assertEquals(person, savedPerson);
    }

    @Test
    @DisplayName("Should update the person when the person exists")
    void updatePersonWhenPersonExists() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setPersonFirstname("test");
        person1.setPersonLastname("test");
        person1.setPersonStreetName("test");
        person1.setPersonHouseNumber("test");
        person1.setPersonHouseNumberAdd("test");
        person1.setPersonCity("test");
        person1.setPersonZipcode("test");
        when(personRepository.findById(1L)).thenReturn(java.util.Optional.of(person1));

        person1.setPersonFirstname("Bayla");
        personService.updatePerson(1L, person1);

        verify(personRepository).save(person1);

        assertThat(person1.getId()).isEqualTo(1);
        assertThat(person1.getPersonFirstname()).isEqualTo("Bayla");

    }

    @Test
    @DisplayName("Should throw an exception when the person does not exist")
    void updatePersonWhenPersonDoesNotExistThenThrowException() {
        Long id = 1L;
        Person person = new Person();

        assertThrows(RecordNotFoundException.class, () -> personService.updatePerson(id, person));

        verify(personRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Should delete the person when the person exists")
    void deletePersonWhenPersonExists() {
        Person person = new Person();
        person.setId(1L);
        person.setPersonFirstname("test");
        person.setPersonLastname("test");
        person.setPersonStreetName("test");
        person.setPersonHouseNumber("test");
        person.setPersonHouseNumberAdd("test");
        person.setPersonCity("test");
        person.setPersonZipcode("test");

        when(personRepository.existsById(1L)).thenReturn(true);

        personService.deletePerson(1L);

        verify(personRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw an exception when the person does not exist")
    void deletePersonWhenPersonDoesNotExistThenThrowsException() {
        Long id = 1L;
        when(personRepository.existsById(id)).thenReturn(false);

        assertThrows(IllegalStateException.class, () -> personService.deletePerson(id));

        verify(personRepository, times(1)).existsById(id);
    }

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
    @DisplayName("Should return all persons")
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