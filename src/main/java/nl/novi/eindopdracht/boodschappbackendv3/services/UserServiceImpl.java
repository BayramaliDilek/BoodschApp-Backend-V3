package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.UsernameAlreadyExistException;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.UsernameNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.FileUploadRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.UserRepository;
import nl.novi.eindopdracht.boodschappbackendv3.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(User user) {

        if (userExists(user.getUsername())) {
            throw new UsernameAlreadyExistException("Username is al in gebuik!");
        }

        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        user.setEmail(user.getEmail());
        user.setApikey(randomString);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getAuthorities().clear();
        user.addAuthority(new Authority(user.getUsername(), "ROLE_USER"));
        user.setId((long) ((getUsers().size()) + 1));

        user.setPerson(personService.savePerson(new Person()));

        User newUser = userRepository.save(user);

        return newUser.getUsername();

    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(String username, User user) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user1 = userRepository.findById(username).get();


        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setPicture(user.getPicture());

        userRepository.save(user1);

    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));

        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public void assignPersonToUser(Long personId, String username) {
        var optionalUser = userRepository.findById(username);
        var optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var person = optionalPerson.get();
            user.setPerson(person);
            userRepository.save(user);
        }
    }


    public void assignPictureToUser(String fileName, String username) {

        var optionalUser = userRepository.findById(username);
        var optionalPicture = fileUploadRepository.findByFileName(fileName);

        if (optionalPicture.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var picture = optionalPicture.get();

            user.setPicture(picture);
            userRepository.save(user);

        } else {
            throw new RecordNotFoundException("een van de twee is niet gevonden");

        }


    }


}
