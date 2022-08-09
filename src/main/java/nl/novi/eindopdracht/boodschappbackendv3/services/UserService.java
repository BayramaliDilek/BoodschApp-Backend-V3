package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;

import java.util.*;

public interface UserService {

    Collection<User> getUsers();

    Optional<User> getUser(String username);

    String createUser(User user);

    void deleteUser(String username);

    boolean userExists(String username);

    void assignPersonToUser(Long id, String username);

    void assignPictureToUser(String fileName, String username);

}
