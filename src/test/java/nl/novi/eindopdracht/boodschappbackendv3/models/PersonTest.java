package nl.novi.eindopdracht.boodschappbackendv3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    @DisplayName("Should set the zipcode")
    void setPersonZipcodeShouldSetTheZipcode() {
        Person person = new Person();
        person.setPersonZipcode("1234");
        assertEquals("1234", person.getPersonZipcode());
    }

    @Test
    @DisplayName("Should return the zipcode of the person")
    void getPersonZipcodeShouldReturnTheZipcodeOfThePerson() {
        Person person = new Person();
        person.setPersonZipcode("1234");
        assertEquals("1234", person.getPersonZipcode());
    }

    @Test
    @DisplayName("Should set the city")
    void setPersonCityShouldSetTheCity() {
        Person person = new Person();
        person.setPersonCity("Gent");
        assertEquals("Gent", person.getPersonCity());
    }

    @Test
    @DisplayName("Should return the city of the person")
    void getPersonCityShouldReturnTheCityOfThePerson() {
        Person person = new Person();
        person.setPersonCity("Gent");
        assertEquals("Gent", person.getPersonCity());
    }

    @Test
    @DisplayName("Should set the personHouseNumberAdd")
    void setPersonHouseNumberAdd() {
        Person person = new Person();
        person.setPersonHouseNumberAdd("A");
        assertEquals("A", person.getPersonHouseNumberAdd());
    }

    @Test
    @DisplayName("Should return the personHouseNumberAdd")
    void getPersonHouseNumberAddShouldReturnThePersonHouseNumberAdd() {
        Person person = new Person();
        person.setPersonHouseNumberAdd("A");
        assertEquals("A", person.getPersonHouseNumberAdd());
    }

    @Test
    @DisplayName("Should set the personHouseNumber")
    void setPersonHouseNumber() {
        Person person = new Person();
        person.setPersonHouseNumber("1");
        assertEquals("1", person.getPersonHouseNumber());
    }

    @Test
    @DisplayName("Should return the person house number")
    void getPersonHouseNumberShouldReturnThePersonHouseNumber() {
        Person person = new Person();
        person.setPersonHouseNumber("1");
        assertEquals("1", person.getPersonHouseNumber());
    }

    @Test
    @DisplayName("Should set the personStreetName")
    void setPersonStreetName() {
        Person person = new Person();
        person.setPersonStreetName("test");
        assertEquals("test", person.getPersonStreetName());
    }

    @Test
    @DisplayName("Should return the person street name")
    void getPersonStreetNameShouldReturnThePersonStreetName() {
        Person person = new Person();
        person.setPersonStreetName("TestStreet");
        assertEquals("TestStreet", person.getPersonStreetName());
    }

    @Test
    @DisplayName("Should set the lastname")
    void setPersonLastnameShouldSetTheLastname() {
        Person person = new Person();
        person.setPersonLastname("test");
        assertEquals("test", person.getPersonLastname());
    }

    @Test
    @DisplayName("Should return the person lastname")
    void getPersonLastnameShouldReturnThePersonLastname() {
        Person person = new Person();
        person.setPersonLastname("Test");
        assertEquals("Test", person.getPersonLastname());
    }

    @Test
    @DisplayName("Should set the firstname")
    void setPersonFirstnameShouldSetTheFirstname() {
        Person person = new Person();
        person.setPersonFirstname("John");
        assertEquals("John", person.getPersonFirstname());
    }

    @Test
    @DisplayName("Should return the person firstname")
    void getPersonFirstnameShouldReturnThePersonFirstname() {
        Person person = new Person();
        person.setPersonFirstname("John");
        assertEquals("John", person.getPersonFirstname());
    }

    @Test
    @DisplayName("Should set the id")
    void setIdShouldSetTheId() {
        Person person = new Person();
        person.setId(1L);
        assertEquals(1L, person.getId());
    }

    @Test
    @DisplayName("Should return the id of the person")
    void getIdShouldReturnTheIdOfThePerson() {
        Person person = new Person();
        person.setId(1L);
        assertEquals(1L, person.getId());
    }
}