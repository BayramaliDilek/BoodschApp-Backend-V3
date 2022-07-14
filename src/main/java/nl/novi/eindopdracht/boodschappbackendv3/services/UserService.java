package nl.novi.eindopdracht.boodschappbackendv3.services;


import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;


import java.util.*;


public interface UserService {

    Collection<User> getUsers();

    Optional<User> getUser(String username);

    String createUser(User user);

    void deleteUser(String username);

    void updateUser(String username, User user);

    boolean userExists(String username);

    Set<Authority> getAuthorities(String username);

    void addAuthority(String username, String authority);

    void removeAuthority(String username, String authority);

    void assignPersonToUser(Long id, String username);



}
