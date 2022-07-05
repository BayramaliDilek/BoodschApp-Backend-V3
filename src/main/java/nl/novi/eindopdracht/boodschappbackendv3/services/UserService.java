package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.UserDto;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.UsernameAlreadyExistException;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.UsernameNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.UserRepository;
import nl.novi.eindopdracht.boodschappbackendv3.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {


    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }


    public String createUser(UserDto userDto) {

        if (userExists(userDto.getUsername())) {
            throw new UsernameAlreadyExistException("Username is al in gebuik!");

        }

        userDto.setEmail(userDto.getEmail());

        String randomString = RandomStringGenerator.generateAlphaNumeric(20);

        userDto.setApikey(randomString);

        User newUser = userRepository.save(toUser(userDto));

        return newUser.getUsername();
    }


    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
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

    public static UserDto fromUser(User user) {

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.authorities = user.getAuthorities();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.enabled = user.isEnabled();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setApikey(userDto.getApikey());
        user.setEnabled(userDto.getEnabled());
        user.setEmail(userDto.getEmail());

        return user;
    }

}
