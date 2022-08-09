package nl.novi.eindopdracht.boodschappbackendv3.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("Should set the enabled to true")
    void setEnabledWhenEnabledIsTrue() {
        user.setEnabled(true);
        assertTrue(user.isEnabled());
    }

    @Test
    @DisplayName("Should set the enabled to false")
    void setEnabledWhenEnabledIsFalse() {
        user.setEnabled(false);
        assertFalse(user.isEnabled());
    }

    @Test
    @DisplayName("Should set the apikey")
    void setApikey() {
        user.setApikey("12345");
        assertEquals("12345", user.getApikey());
    }

    @Test
    @DisplayName("Should return the email of the user")
    void getEmailShouldReturnTheEmailOfTheUser() {
        user.setEmail("test@test.com");
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
    @DisplayName("Should set the email")
    void setEmail() {
        user.setEmail("test@test.com");
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
    @DisplayName("Should return the person when the person exists")
    void getPersonWhenPersonExists() {
        Person person = new Person();
        user.setPerson(person);
        assertEquals(person, user.getPerson());
    }

    @Test
    @DisplayName("Should return null when the person does not exist")
    void getPersonWhenPersonDoesNotExistThenReturnNull() {
        assertNull(user.getPerson());
    }

    @Test
    @DisplayName("Should set the person")
    void setPerson() {
        Person person = new Person();
        user.setPerson(person);
        assertEquals(person, user.getPerson());
    }

    @Test
    @DisplayName("Should return the authorities of the user")
    void getAuthoritiesShouldReturnAuthoritiesOfUser() {
        Authority authority = new Authority("username", "authority");
        user.addAuthority(authority);
        assertEquals(user.getAuthorities(), Set.of(authority));
    }

    @Test
    @DisplayName("Should add the authority to the authorities set")
    void addAuthorityShouldAddTheAuthorityToTheAuthoritiesSet() {
        Authority authority = new Authority("username", "authority");
        user.addAuthority(authority);
        assertTrue(user.getAuthorities().contains(authority));
    }

    @Test
    @DisplayName("Should remove the authority from the user")
    void removeAuthorityShouldRemovesTheAuthorityFromTheUser() {
        Authority authority = new Authority("username", "authority");
        user.addAuthority(authority);
        user.removeAuthority(authority);
        assertFalse(user.getAuthorities().contains(authority));
    }

    @Test
    @DisplayName("Should return the id of the user")
    void getIdShouldReturnTheIdOfTheUser() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    @DisplayName("Should set the id")
    void setId() {
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    @DisplayName("Should return the picture of the user")
    void getPictureShouldReturnThePictureOfTheUser() {
        FileUploadResponse picture = new FileUploadResponse();
        user.setPicture(picture);
        assertEquals(picture, user.getPicture());
    }

    @Test
    @DisplayName("Should set the picture")
    void setPicture() {
        FileUploadResponse picture = new FileUploadResponse();
        user.setPicture(picture);
        assertEquals(picture, user.getPicture());
    }
}