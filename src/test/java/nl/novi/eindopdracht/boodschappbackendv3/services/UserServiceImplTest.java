package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.FileUploadRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private FileUploadRepository fileUploadRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    @DisplayName("Should assign the person to the user when the person and user exist")
    void assignPersonToUserWhenPersonAndUserExist() {
        Person person = new Person();
        person.setId(1L);
        person.setPersonFirstname("Jan");
        person.setPersonLastname("Janssen");

        User user = new User();
        user.setUsername("JanJanssen");
        user.setPassword("password");

        when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));

        userService.assignPersonToUser(person.getId(), user.getUsername());

        assertEquals(person, user.getPerson());
    }
}